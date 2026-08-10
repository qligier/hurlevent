/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase

/**
 * Common PSI impl superclass for every `*_filter_keyword` rule (see the `[FILTER_LIST]` rules in Hurl.bnf), applied
 * via the `mixin(".*_filter_keyword")` pattern in the grammar. Each filter (`count`, `dateFormat`, ...) has its own
 * dedicated one-token `*_filter_keyword` rule wrapping just its `KW_*` token, separate from the `*_filter` rule that
 * also carries any arguments — so this mixin, and the reference below, apply only to the keyword itself.
 */
abstract class HurlFilterMixin(
    node: ASTNode,
) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference = HurlFilterSelfReference(this)

    /** Resolves to the filter keyword element itself; its range covers the whole element, i.e. just the keyword. */
    private class HurlFilterSelfReference(
        element: PsiElement,
    ) : PsiReferenceBase<PsiElement>(element, TextRange(0, element.textLength)) {
        override fun resolve(): PsiElement = element
    }
}
