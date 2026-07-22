/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.highlight

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlLexerAdapter
import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes.*
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType

/**
 * Syntax highlighter for Hurl files.
 *
 * @see [Syntax Highlighter and Color Settings Page](https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html)
 * @see [Syntax and Error Highlighting](https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html)
 */
internal class HurlSyntaxHighlighter :
    SyntaxHighlighterBase(),
    DumbAware {
    companion object {
        val TAK_METHOD = createTextAttributesKey("HURL_METHOD", DefaultLanguageHighlighterColors.KEYWORD)
        val TAK_HTTP_VERSION = createTextAttributesKey("HURL_HTTP_VERSION", DefaultLanguageHighlighterColors.KEYWORD)
        val TAK_STATUS_CODE = createTextAttributesKey("HURL_STATUS_CODE", DefaultLanguageHighlighterColors.NUMBER)
        val TAK_SECTION = createTextAttributesKey("HURL_SECTION", DefaultLanguageHighlighterColors.METADATA)
        val TAK_COMMENT = createTextAttributesKey("HURL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val TAK_URL = createTextAttributesKey("HURL_URL", DefaultLanguageHighlighterColors.STRING)
        val TAK_PREDICATE = createTextAttributesKey("HURL_PREDICATE", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val TAK_FILTER = createTextAttributesKey("HURL_FILTER", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val TAK_QUERY = createTextAttributesKey("HURL_QUERY", DefaultLanguageHighlighterColors.FUNCTION_CALL)
        val TAK_NUMBER = createTextAttributesKey("HURL_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val TAK_TEMPLATE_VARIABLE =
            createTextAttributesKey("HURL_TEMPLATE_VARIABLE", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
        val TAK_CAPTURE_NAME =
            createTextAttributesKey("HURL_CAPTURE_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
        val TAK_HEADER_NAME = createTextAttributesKey("HURL_HEADER_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
    }

    override fun getHighlightingLexer() = HurlLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> =
        when (tokenType) {
            HTTP_METHOD -> arrayOf(TAK_METHOD)
            HTTP_VERSION -> arrayOf(TAK_HTTP_VERSION)
            STATUS_CODE -> arrayOf(TAK_STATUS_CODE)
            COMMENT -> arrayOf(TAK_COMMENT)
            URL_VALUE -> arrayOf(TAK_URL)
            INT_NUMBER, FLOAT_NUMBER -> arrayOf(TAK_NUMBER)
            TEMPLATE_VAR -> arrayOf(TAK_TEMPLATE_VARIABLE)
            CAPTURE_KEY_STRING -> arrayOf(TAK_CAPTURE_NAME)
            HEADER_KEY -> arrayOf(TAK_HEADER_NAME)
            in HurlTokenSets.SECTIONS -> arrayOf(TAK_SECTION)
            in HurlTokenSets.PREDICATE_KEYWORDS -> arrayOf(TAK_PREDICATE)
            in HurlTokenSets.FILTER_KEYWORDS -> arrayOf(TAK_FILTER)
            in HurlTokenSets.QUERY_KEYWORDS -> arrayOf(TAK_QUERY)
            else -> emptyArray<TextAttributesKey>()
        }
}

internal class HurlSyntaxHighlighterFactory :
    SyntaxHighlighterFactory(),
    DumbAware {
    override fun getSyntaxHighlighter(
        project: Project?,
        virtualFile: VirtualFile?,
    ): SyntaxHighlighter = HurlSyntaxHighlighter()
}
