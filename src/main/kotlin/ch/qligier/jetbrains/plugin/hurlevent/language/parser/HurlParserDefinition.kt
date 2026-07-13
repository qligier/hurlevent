/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.parser

import ch.qligier.jetbrains.plugin.hurlevent.language.HurlFile
import ch.qligier.jetbrains.plugin.hurlevent.language.HurlLanguage
import ch.qligier.jetbrains.plugin.hurlevent.language.HurlLexerAdapter
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlElementTypes
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTokenSets
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class HurlParserDefinition : ParserDefinition {
    companion object {
        val FILE: IFileElementType = IFileElementType(HurlLanguage)
    }

    override fun createLexer(project: Project?): Lexer = HurlLexerAdapter()

    override fun createParser(project: Project?): PsiParser = HurlParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = HurlTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun getWhitespaceTokens(): TokenSet = HurlTokenSets.WHITESPACES

    override fun createElement(node: ASTNode?): PsiElement = HurlElementTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = HurlFile(viewProvider)
}
