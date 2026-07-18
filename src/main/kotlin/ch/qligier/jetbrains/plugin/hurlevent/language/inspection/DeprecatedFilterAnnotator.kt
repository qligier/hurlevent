package ch.qligier.jetbrains.plugin.hurlevent.language.inspection

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlFormatFilter
import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.codeInspection.util.IntentionFamilyName
import com.intellij.codeInspection.util.IntentionName
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

/**
 * Mark the usage of deprecated filters in the code, and provides a quick fix to replace them with the new filter.
 * Currently, only the 'format' filter is deprecated and should be replaced with 'dateFormat'.
 */
internal class DeprecatedFilterAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        if (element is HurlFormatFilter) {
            holder
                .newAnnotation(HighlightSeverity.WEAK_WARNING, "Deprecated filter")
                .range(element.firstChild)
                .tooltip("Deprecated filter, use 'dateFormat' instead")
                .withFix(ReplaceFormatFilterQuickFix(element.firstChild))
                .create()
        }
    }
}

internal class ReplaceFormatFilterQuickFix(
    private val element: PsiElement,
) : BaseIntentionAction(),
    DumbAware {
    override fun isAvailable(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ): Boolean = editor?.document != null

    override fun invoke(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ) {
        editor?.document?.replaceString(
            element.textRange.startOffset,
            element.textRange.endOffset,
            "dateFormat",
        )
    }

    override fun getText(): @IntentionName String = "Replace with 'dateFormat'"

    override fun getFamilyName(): @IntentionFamilyName String = "Replace deprecated filter"
}
