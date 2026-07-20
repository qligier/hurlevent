package ch.qligier.jetbrains.plugin.hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.specs.Filters
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.jetbrains.annotations.Nls

class HurlFilterDocumentationProvider :
    AbstractDocumentationProvider(),
    DumbAware {
    override fun generateDoc(
        element: PsiElement?,
        originalElement: PsiElement?,
    ): @Nls String? {
        val elementType = element.elementType ?: return null
        if (elementType in HurlTokenSets.FILTER_KEYWORDS) {
            val filter = Filters.getFilters().find { it.elementType == elementType }
            return filter?.let {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("Filter: ${filter.name}")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append(filter.description)
                    append("<br/>")
                    append("<a href=\"${filter.documentationUrl}\">Documentation</a>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
        }
        return null
    }

    override fun generateHoverDoc(
        element: PsiElement,
        originalElement: PsiElement?,
    ): @Nls String = "Filter: ${element.text}"
}
