/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.highlight

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlLexerAdapter
import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType

class HurlSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val METHOD = createTextAttributesKey("HURL_METHOD", DefaultLanguageHighlighterColors.KEYWORD)
        val HTTP_VERSION = createTextAttributesKey("HURL_HTTP_VERSION", DefaultLanguageHighlighterColors.KEYWORD)
        val STATUS_CODE = createTextAttributesKey("HURL_STATUS_CODE", DefaultLanguageHighlighterColors.NUMBER)
        val SECTION = createTextAttributesKey("HURL_SECTION", DefaultLanguageHighlighterColors.METADATA)
        val COMMENT = createTextAttributesKey("HURL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    }

    override fun getHighlightingLexer() = HurlLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
        return when {
            HurlTokenSets.METHODS.contains(tokenType) -> arrayOf(METHOD)
            tokenType == HurlTypes.HTTP_VERSION -> arrayOf(HTTP_VERSION)
            tokenType == HurlTypes.STATUS_CODE -> arrayOf(STATUS_CODE)
            HurlTokenSets.SECTIONS.contains(tokenType) -> arrayOf(SECTION)
            tokenType == HurlTypes.COMMENT -> arrayOf(COMMENT)
            else -> emptyArray<TextAttributesKey>()
        }
    }
}

class HurlSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter = HurlSyntaxHighlighter()
}
