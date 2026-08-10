/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

/**
 * PSI impl superclass for the `template_variable` rule (see Hurl.bnf), i.e. the `name` part of a `{{name}}`
 * template.
 *
 * Resolves to the closest preceding `[Captures]` entry declaring a variable with the same name, if any — captures
 * are the only variable source Hurl files declare themselves; variables can also come from `--variable`,
 * `[Options] variable:`, the environment, or a `.env`/`variables.env` file, none of which have a PSI declaration to
 * resolve to, so a template variable referencing one of those simply doesn't resolve. This still lets "Go to
 * Declaration", "Find Usages", and rename work for capture-declared variables, and — like
 * [ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl.HurlFilterMixin] — gives IntelliJ's target-element
 * resolution a real reference to work with wherever one *can* be found.
 */
abstract class HurlTemplateVariableMixin(
    node: ASTNode,
) : ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference = HurlTemplateVariableReference(this)

    private class HurlTemplateVariableReference(
        element: PsiElement,
    ) : PsiReferenceBase<PsiElement>(element, TextRange(0, element.textLength)) {
        override fun resolve(): PsiElement? {
            val name = element.text
            val file = element.containingFile ?: return null
            val startOffset = element.textRange.startOffset
            return PsiTreeUtil
                .collectElements(file) { it.elementType == HurlTypes.CAPTURE_KEY_STRING }
                .filter { it.textRange.endOffset <= startOffset && it.text == name }
                .maxByOrNull { it.textRange.startOffset }
        }
    }
}
