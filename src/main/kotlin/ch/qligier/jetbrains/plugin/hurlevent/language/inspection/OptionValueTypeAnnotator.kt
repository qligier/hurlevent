/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.inspection

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlOptionEntry
import ch.qligier.jetbrains.plugin.hurlevent.specs.Options
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

/**
 * Report the values of the `[Options]` section that don't match the type expected by the option, for example
 * `compressed: yes` or `retry-interval: 1.5s`.
 *
 * The options that accept any string, and the unknown options, are not checked.
 */
internal class OptionValueTypeAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        if (element !is HurlOptionEntry) {
            return
        }
        val key = element.optionKey.text
        val type = Options.VALUE_TYPES[key] ?: return
        val value = element.optionValue ?: return
        type.validate(value.text)?.let { reason ->
            holder
                .newAnnotation(HighlightSeverity.ERROR, "Invalid value for option '$key': $reason")
                .range(value)
                .create()
        }
    }
}
