/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import ch.qligier.jetbrains.plugin.hurlevent.language.HurlLanguage
import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.language.parser.HurlElementSets
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlElementType
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.lang.Language
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider

/**
 * Implements a custom Breadcrumb for Hurl files.
 *
 * @see [Breadcrumbs](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#reader-mode)
 **/
internal class HurlBreadcrumbsProvider :
    BreadcrumbsProvider,
    DumbAware {
    override fun getLanguages(): Array<out Language> = arrayOf(HurlLanguage)

    override fun acceptElement(element: PsiElement): Boolean {
        val type = element.node?.elementType ?: return false
        return type == HurlTypes.ENTRY ||
            type == HurlTypes.REQUEST ||
            type == HurlTypes.RESPONSE ||
            type in HurlElementSets.MARKED_SECTIONS ||
            type == HurlTypes.KEY_VALUE_PAIR ||
            type == HurlTypes.OPTION_ENTRY ||
            type == HurlTypes.CAPTURE_ENTRY ||
            type == HurlTypes.HEADER
    }

    /**
     * When adding a new element to the breadcrumbs, also update the `acceptElement` method to include the new element type.
     */
    override fun getElementInfo(element: PsiElement): @NlsSafe String {
        val type = element.node?.elementType as? HurlElementType ?: return ""
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

            in HurlElementSets.MARKED_SECTIONS -> {
                breadcrumbSection(element, type)
            }

            HurlTypes.KEY_VALUE_PAIR -> {
                getTextOfChildOfType(element, HurlTypes.KV_KEY)
            }

            HurlTypes.OPTION_ENTRY -> {
                getTextOfChildOfType(element, HurlTypes.OPTION_KEY)
            }

            HurlTypes.CAPTURE_ENTRY -> {
                getTextOfChildOfType(element, HurlTypes.CAPTURE_KEY_STRING)
            }

            HurlTypes.HEADER -> {
                getTextOfChildOfType(element, HurlTypes.HEADER_KEY)
            }

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

    private fun breadcrumbSection(
        element: PsiElement,
        type: HurlElementType,
    ): String {
        val sectionToken = element.children.firstOrNull { it.node?.elementType in HurlTokenSets.SECTIONS }
        val sectionName =
            sectionToken?.text ?: type.humanName
                .removeSuffix("_SECTION")
                .replace('_', ' ')
                .lowercase()
                .replaceFirstChar { it.uppercase() }
        return sectionName
    }

    private fun getTextOfChildOfType(
        element: PsiElement,
        type: IElementType,
    ): String {
        val child = element.node.findChildByType(type)
        return child?.text?.takeNOfFirstLine(30) ?: ""
    }
}
