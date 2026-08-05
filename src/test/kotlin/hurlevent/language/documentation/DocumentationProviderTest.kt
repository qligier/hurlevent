/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.language.documentation

import com.intellij.codeInsight.documentation.DocumentationManager
import com.intellij.testFramework.fixtures.BasePlatformTestCase

/**
 * Regression test for [ch.qligier.jetbrains.plugin.hurlevent.language.documentation.HurlFilterDocumentationProvider].
 *
 * Filter keywords are plain leaf tokens with no PsiReference, so [DocumentationManager.findTargetElement] (the same
 * lookup "View | Quick Documentation" relies on) can only resolve one as a documentation target if the provider
 * implements `getCustomDocumentationElement`. This test exercises that exact lookup path end-to-end, rather than
 * calling `generateDoc` directly, since that step is precisely what was broken.
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

        val docManager = DocumentationManager.getInstance(project)
        val targetElement = docManager.findTargetElement(myFixture.editor, myFixture.file)
        assertNotNull("Quick Documentation should find a target element for a filter keyword", targetElement)

        val provider = DocumentationManager.getProviderFromElement(targetElement)
        val doc = provider.generateDoc(targetElement, targetElement)
        assertNotNull("Quick Documentation should generate content for a filter keyword", doc)
        assertTrue(doc!!.contains("Filter: count"))
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
