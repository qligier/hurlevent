/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

/**
 * Implements brace matching for the Hurl language.
 *
 * @see [Brace Matching](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#brace-matching)
 **/
internal class HurlBraceMatcher :
    PairedBraceMatcher,
    DumbAware {
    override fun getPairs(): Array<out BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(
        lbraceType: IElementType,
        contextType: IElementType?,
    ): Boolean = true

    override fun getCodeConstructStart(
        file: PsiFile?,
        openingBraceOffset: Int,
    ): Int = openingBraceOffset

    companion object {
        private val PAIRS =
            arrayOf(
                BracePair(HurlTypes.LBRACE, HurlTypes.RBRACE, true),
                BracePair(HurlTypes.LBRACKET, HurlTypes.RBRACKET, true),
                BracePair(HurlTypes.LBRACE2, HurlTypes.RBRACE2, false),
                BracePair(HurlTypes.MULTILINE_STRING_OPEN, HurlTypes.MULTILINE_STRING_CLOSE, false),
                BracePair(HurlTypes.LPAREN, HurlTypes.RPAREN, false),
            )
    }
}
