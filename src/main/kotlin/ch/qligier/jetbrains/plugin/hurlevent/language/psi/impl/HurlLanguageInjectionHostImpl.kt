/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.impl.source.tree.LeafElement

abstract class HurlLanguageInjectionHostImpl(
    node: ASTNode,
) : ASTWrapperPsiElement(node),
    PsiLanguageInjectionHost {
    override fun isValidHost(): Boolean = true

    override fun updateText(text: String): PsiLanguageInjectionHost? {
        val newLeaf = node.firstChildNode as? LeafElement ?: return null
        return newLeaf.replaceWithText(text).psi as? PsiLanguageInjectionHost
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return object : LiteralTextEscaper<HurlLanguageInjectionHostImpl>(this) {
            override fun decode(
                rangeInsideHost: TextRange,
                outChars: StringBuilder,
            ): Boolean {
                outChars.append(myHost.getText(), rangeInsideHost.startOffset, rangeInsideHost.endOffset)
                return true
            }

            override fun getOffsetInHost(
                offsetInDecoded: Int,
                rangeInsideHost: TextRange,
            ): Int {
                var offset: Int = rangeInsideHost.startOffset + offsetInDecoded
                if (offset < rangeInsideHost.startOffset) {
                    offset = rangeInsideHost.startOffset
                } else if (offset > rangeInsideHost.endOffset) {
                    offset = rangeInsideHost.endOffset
                }
                return offset
            }

            override fun isOneLine(): Boolean = false
        }
    }
}
