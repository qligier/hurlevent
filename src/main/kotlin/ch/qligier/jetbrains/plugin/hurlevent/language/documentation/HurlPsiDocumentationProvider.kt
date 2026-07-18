/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.specs.Filters
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.DumbAware
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.documentation.PsiDocumentationTargetProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

/**
 * Documentation Target for Hurl Filters using the new Documentation Target API (2023.1+).
 *
 * This API is recommended by JetBrains for all new documentation providers.
 * @see [Documentation](https://plugins.jetbrains.com/docs/intellij/documentation.html)
 **/
internal class HurlPsiDocumentationProvider : PsiDocumentationTargetProvider {
    private val LOG = Logger.getInstance(HurlPsiDocumentationProvider::class.java)

    init {
        LOG.info("HurlDocumentationProvider initialized")
    }

    override fun documentationTarget(
        element: PsiElement,
        originalElement: PsiElement?,
    ): DocumentationTarget? {
        LOG.info("Providing documentation for element: ${element.text} of type: ${element.elementType}")
        val elementType = element.elementType ?: return null
        if (elementType in HurlTokenSets.FILTER_KEYWORDS) {
            val filter = Filters.getFilters().find { it.elementType == elementType }
            return filter?.let {
                HurlFilterDocumentationTarget(element, it)
            }
        }
        return null
    }
}
