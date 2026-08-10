/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.language.psi

import com.intellij.testFramework.fixtures.BasePlatformTestCase

/**
 * Regression test for [ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl.HurlTemplateVariableMixin]: a
 * `{{name}}` template usage should resolve to the closest `[Captures]` entry declaring `name` *before* it in the
 * file (Hurl runs entries sequentially, so a capture only exists for entries after it), and simply not resolve
 * (rather than error) when no such capture exists.
 */
class HurlTemplateVariableReferenceTest : BasePlatformTestCase() {
    fun testResolvesToMatchingCapture() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/a
            HTTP 200
            [Captures]
            token: jsonpath "${'$'}.token"

            GET https://example.org/b?token={{to<caret>ken}}
            HTTP 200
            """.trimIndent(),
        )

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)
        assertNotNull("A {{token}} usage should have a reference", reference)
        val resolved = reference!!.resolve()
        assertNotNull("The reference should resolve to the capture declaring it", resolved)
        assertEquals("token", resolved!!.text)
    }

    fun testDoesNotResolveWithoutMatchingCapture() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/b?token={{unkno<caret>wn}}
            HTTP 200
            """.trimIndent(),
        )

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)
        assertNotNull("A {{unknown}} usage should still have a reference", reference)
        assertNull("But it shouldn't resolve to anything without a matching capture", reference!!.resolve())
    }

    fun testDoesNotResolveToALaterCapture() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/a?token={{to<caret>ken}}
            HTTP 200

            GET https://example.org/b
            HTTP 200
            [Captures]
            token: jsonpath "${'$'}.token"
            """.trimIndent(),
        )

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)
        assertNotNull("A {{token}} usage should have a reference", reference)
        assertNull(
            "It shouldn't resolve to a capture that only appears later in the file",
            reference!!.resolve(),
        )
    }

    fun testResolvesToTheClosestPrecedingCapture() {
        myFixture.configureByText(
            "test.hurl",
            """
            GET https://example.org/a
            HTTP 200
            [Captures]
            token: jsonpath "${'$'}.tokenA"

            GET https://example.org/b
            HTTP 200
            [Captures]
            token: jsonpath "${'$'}.tokenB"

            GET https://example.org/c?token={{to<caret>ken}}
            HTTP 200
            """.trimIndent(),
        )

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)
        assertNotNull("A {{token}} usage should have a reference", reference)
        val resolved = reference!!.resolve()
        assertNotNull("The reference should resolve to a capture declaring it", resolved)
        // The closest preceding "token" capture is the one for $.tokenB, not $.tokenA.
        val captureEntryText = resolved!!.parent.text
        assertTrue(
            "Should resolve to the closer capture (\$.tokenB), not the further one (\$.tokenA): $captureEntryText",
            captureEntryText.contains("tokenB"),
        )
    }
}
