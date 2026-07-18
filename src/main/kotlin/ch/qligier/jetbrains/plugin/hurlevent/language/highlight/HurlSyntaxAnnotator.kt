/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.highlight

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

/**
 * Provides additional syntax information through annotations.
 *
 * @see [Annotator](https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#annotator)
 **/
internal class HurlSyntaxAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        val elementType = element.node?.elementType ?: return
        when (elementType) {
            HurlTypes.URL -> {
                /*holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(HurlSyntaxHighlighter.URL)
                    .create()*/
            }
        }
    }
}
