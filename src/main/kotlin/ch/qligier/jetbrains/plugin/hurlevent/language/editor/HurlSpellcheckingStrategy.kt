/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy
import com.intellij.spellchecker.tokenizer.Tokenizer

/**
 * Provides indication to the IDE where and how to spellcheck the content of a Hurl file.
 *
 * @see [Spell Checking](https://plugins.jetbrains.com/docs/intellij/spell-checking.html)
 * @see [Spell Checking](https://plugins.jetbrains.com/docs/intellij/spell-checking-strategy.html)
 **/
internal class HurlSpellcheckingStrategy :
    SpellcheckingStrategy(),
    DumbAware {
    override fun getTokenizer(element: PsiElement): Tokenizer<*> {
        val tokenType = element.node?.elementType

        return when (tokenType) {
            HurlTypes.COMMENT,
            HurlTypes.QUOTED_STRING,
            HurlTypes.MULTILINE_STRING_CONTENT,
            -> TEXT_TOKENIZER

            else -> EMPTY_TOKENIZER
        }
    }
}
