package ch.qligier.jetbrains.plugin.hurlevent.language.inspection

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlCharsetDecodeFilter
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlDecodeFilter
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlQuotedStringValue
import ch.qligier.jetbrains.plugin.hurlevent.specs.Charsets.SUPPORTED_CHARSETS
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

internal class UnknownCharsetAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        if (element is HurlQuotedStringValue &&
            (element.parent is HurlDecodeFilter || element.parent is HurlCharsetDecodeFilter)
        ) {
            val charsetName = element.text.removeSurrounding("\"")
            if (charsetName !in SUPPORTED_CHARSETS) {
                holder
                    .newAnnotation(HighlightSeverity.ERROR, "Unknown charset: $charsetName")
                    .range(element)
                    .create()
            }
        }
    }
}
