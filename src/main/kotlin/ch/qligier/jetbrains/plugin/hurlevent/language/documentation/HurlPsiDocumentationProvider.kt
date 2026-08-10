/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.specs.Filters
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.diagnostic.trace
import com.intellij.openapi.project.DumbAware
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.documentation.PsiDocumentationTargetProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

/**
 * Documentation Target provider for Hurl, using the Documentation Target API (2023.1+).
 *
 * This API is recommended by JetBrains for all new documentation providers. It is only ever consulted for an
 * element that IntelliJ already resolved as a documentation target through some other means (a reference, a
 * declaration, …).
 * @see [Documentation](https://plugins.jetbrains.com/docs/intellij/documentation.html)
 **/
internal class HurlPsiDocumentationProvider : PsiDocumentationTargetProvider, DumbAware {
    private val logger = Logger.getInstance(HurlPsiDocumentationProvider::class.java)

    override fun documentationTarget(
        element: PsiElement,
        originalElement: PsiElement?,
    ): DocumentationTarget? {
        logger.trace { "Providing documentation for element: ${element.text} of type: ${element.elementType}" }
        // `element` is resolved via HurlFilterMixin's self-reference, so it's the composite `*_filter` PSI node
        // (e.g. HurlCountFilterImpl), not the bare KW_* leaf token directly; the keyword itself is its first child.
        // Still check `element.elementType` first so a bare leaf token is also recognized, defensively.
        val keywordType =
            element.elementType?.takeIf { it in HurlTokenSets.FILTER_KEYWORDS }
                ?: element.firstChild?.elementType?.takeIf { it in HurlTokenSets.FILTER_KEYWORDS }
                ?: return null
        val filter = Filters.getFilters().find { it.elementType == keywordType } ?: return null
        return HurlFilterDocumentationTarget(element, filter)
    }
}
