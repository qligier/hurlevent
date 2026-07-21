package ch.qligier.jetbrains.plugin.hurlevent.language.inspection

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlEntry
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement

/**
 * Warn about duplicated sections in a Hurl entry.
 * This might happen because some headers have two different names:
 *  - Query and QueryStringParams
 *  - Form and FormParams
 *  - Multipart and MultipartFormData
 */
class DuplicateSectionAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        if (element is HurlEntry) {
            // TODO
        }
    }
}
