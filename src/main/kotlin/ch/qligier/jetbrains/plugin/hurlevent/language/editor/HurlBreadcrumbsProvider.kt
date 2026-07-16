/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import ch.qligier.jetbrains.plugin.hurlevent.language.HurlLanguage
import ch.qligier.jetbrains.plugin.hurlevent.language.parser.HurlElementSets
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.lang.Language
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider

/**
 * Implements a custom Breadcrumb for Hurl files.
 *
 * @see [Breadcrumbs](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#reader-mode)
 **/
class HurlBreadcrumbsProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<out Language> = arrayOf(HurlLanguage)

    override fun acceptElement(element: PsiElement): Boolean {
        val type = element.node?.elementType ?: return false
        return type == HurlTypes.ENTRY ||
            type == HurlTypes.REQUEST ||
            type == HurlTypes.RESPONSE ||
            type in HurlElementSets.SECTIONS
    }

    /**
     * When adding a new element to the breadcrumbs, also update the `acceptElement` method to include the new element type.
     */
    override fun getElementInfo(element: PsiElement): @NlsSafe String {
        val type = element.node?.elementType ?: return ""
        return when (type) {
            HurlTypes.ENTRY -> {
                element.text.takeNOfFirstLine(50) ?: "Entry"
            }

            HurlTypes.REQUEST -> {
                "Request"
            }

            HurlTypes.RESPONSE -> {
                "Response"
            }

            /*in HurlElementSets.SECTIONS -> {
                val sectionToken = element.children.firstOrNull { it.node?.elementType in HurlTokenSets.SECTIONS }
                sectionToken?.text ?: type.sectionTypeToHumanDisplay()
            }*/

            else -> {
                element.text.take(30)
            }
        }
    }

    private fun String.takeNOfFirstLine(n: Int): String? =
        this
            .lineSequence()
            .firstOrNull()
            ?.trim()
            ?.take(n)

    private fun IElementType.sectionTypeToHumanDisplay(): String =
        this
            .toString()
            .removeSuffix("_SECTION")
            .replace('_', ' ')
            .lowercase()
            .replaceFirstChar { it.uppercase() }
}
