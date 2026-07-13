/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

open class HurlPsiImplUtil(node: ASTNode) : ASTWrapperPsiElement(node) {
    protected fun <T : PsiElement> findChildByClass(childType: Class<T>): T? =
        PsiTreeUtil.getChildOfType(this, childType)

    protected fun <T : PsiElement> findNotNullChildByClass(childType: Class<T>): T =
        findChildByClass(childType)
            ?: throw IllegalStateException(
                "Required child ${childType.simpleName} was not found in ${javaClass.simpleName}",
            )
}
