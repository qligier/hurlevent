/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.language.documentation.HurlPsiDocumentationProvider
import com.intellij.codeInsight.documentation.DocumentationManager
import com.intellij.platform.backend.documentation.DocumentationData
import com.intellij.testFramework.fixtures.BasePlatformTestCase

/**
 * Regression test for the Hurl filter documentation provider.
 *
 * Filter keywords (e.g. `count`) are plain leaf tokens with no declaration to navigate to, so
 * [DocumentationManager.findTargetElement] (the same lookup "View | Quick Documentation" relies on) can only resolve
 * one as a documentation target because [ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl.HurlFilterMixin]
 * gives every `*_filter` PSI element a self-resolving `PsiReference`. Without it, [HurlPsiDocumentationProvider]
 * would never even be consulted, since it's only asked about elements that were already resolved. So this test
 * exercises both halves: target resolution via the reference, then content rendering via the provider.
 */
class DocumentationProviderTest : BasePlatformTestCase() {
    fun testQuickDocumentationAvailableForFilterKeyword() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/a
            HTTP 200
            [Asserts]
            jsonpath "${'$'}.id" co<caret>unt == 1
            """.trimIndent(),
        )

        // Step 1: HurlFilterMixin's self-resolving reference must let DocumentationManager resolve the keyword as a
        // target at all.
        val docManager = DocumentationManager.getInstance(project)
        val targetElement = docManager.findTargetElement(myFixture.editor, myFixture.file)
        assertNotNull("Quick Documentation should find a target element for a filter keyword", targetElement)

        // Step 2: the new-API provider then renders the actual content for that resolved target.
        val target = HurlPsiDocumentationProvider().documentationTarget(targetElement!!, targetElement)
        assertNotNull("HurlPsiDocumentationProvider should produce a target for a filter keyword", target)
        val documentation = target!!.computeDocumentation() as? DocumentationData
        assertNotNull("HurlFilterDocumentationTarget should render HTML documentation", documentation)
        assertTrue(documentation!!.html.contains("count"))
    }

    fun testQuickDocumentationUnavailableAwayFromFilterKeyword() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/<caret>a
            HTTP 200
            """.trimIndent(),
        )

        val docManager = DocumentationManager.getInstance(project)
        val targetElement = docManager.findTargetElement(myFixture.editor, myFixture.file)
        assertNull(
            "Quick Documentation shouldn't claim a target outside of a filter keyword",
            targetElement,
        )
    }
}
