package ch.qligier.jetbrains.plugin.hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.specs.Filters
import ch.qligier.jetbrains.plugin.hurlevent.specs.HurlFilter
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import org.jetbrains.annotations.Nls

internal class HurlFilterDocumentationProvider :
    AbstractDocumentationProvider(),
    DumbAware {
    override fun generateDoc(
        element: PsiElement?,
        originalElement: PsiElement?,
    ): @Nls String? {
        val filter = element.findFilter()
        filter?.let {
            return buildString {
                append(DocumentationMarkup.DEFINITION_START)
                append("Filter: ${filter.name}")
                append(DocumentationMarkup.DEFINITION_END)
                append(DocumentationMarkup.CONTENT_START)
                append(filter.description)
                append(DocumentationMarkup.CONTENT_END)
            }
        }
        return null
    }

    override fun generateHoverDoc(
        element: PsiElement,
        originalElement: PsiElement?,
    ): @Nls String = "Filter: ${element.text}"

    override fun getUrlFor(
        element: PsiElement,
        originalElement: PsiElement?,
    ): List<String>? =
        element.findFilter()?.let {
            listOf(it.documentationUrl)
        }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): @Nls String? =
        element.findFilter()?.let { "Filter: ${it.name}" }

    // Filter keywords are plain leaf tokens with no PsiReference, so without this override,
    // DocumentationManager.findTargetElementAndContext() never resolves a target element for them
    // (it only falls back to the element under the caret when that element sits inside a comment),
    // and "View | Quick Documentation" has nothing to show. This tells the platform that the
    // element under the caret is a valid documentation target whenever it's a filter keyword.
    override fun getCustomDocumentationElement(
        editor: Editor,
        file: PsiFile,
        contextElement: PsiElement?,
        targetOffset: Int,
    ): PsiElement? = contextElement.takeIf { it.findFilter() != null }

    private fun PsiElement?.findFilter(): HurlFilter? {
        val elementType = this.elementType ?: return null
        if (elementType in HurlTokenSets.FILTER_KEYWORDS) {
            return Filters.getFilters().find { it.elementType == elementType }
        }
        return null
    }
}
