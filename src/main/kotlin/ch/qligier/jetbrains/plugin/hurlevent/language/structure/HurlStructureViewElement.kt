/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.structure

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import ch.qligier.jetbrains.plugin.hurlevent.language.HurlFile
import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.platform.backend.navigation.NavigationRequest
import com.intellij.pom.Navigatable
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

/**
 * Customizes the structure view for Hurl files.
 *
 * @see [Structure View Factory](https://plugins.jetbrains.com/docs/intellij/structure-view-factory.html)
 **/
class HurlStructureViewElement(
    private val element: NavigatablePsiElement,
) : StructureViewTreeElement,
    SortableTreeElement,
    Navigatable by element {
    override fun getValue(): Any = element

    override fun getPresentation(): ItemPresentation {
        if (element is HurlFile) {
            return PresentationData(element.name, null, Icons.HURL_ICON, null)
        }

        val node = element.node
        val elementType = node?.elementType?.toString()

        /*if (elementType == "ENTRY" || elementType == "REQUEST") {
            val text = getEntryLabel(element)
            return PresentationData(text, null, HurlIcons.RUN, null)
        }*/

        if (elementType == "RESPONSE") {
            val text = getResponseLabel(element)
            return PresentationData(text, null, null, null)
        }

        // Section nodes
        if (HurlTokenSets.SECTIONS.contains(node?.elementType)) {
            return PresentationData(node?.text ?: "Section", null, null, null)
        }

        val parent = element.parent?.node
        if (parent != null && parent.elementType.toString().endsWith("_SECTION")) {
            val sectionNode = parent.findChildByType(HurlTokenSets.SECTIONS)
            val sectionName = sectionNode?.text ?: parent.elementType.toString()
            return PresentationData(sectionName, null, null, null)
        }

        return PresentationData(element.text?.take(40) ?: "", null, null, null)
    }

    override fun getChildren(): Array<out TreeElement> {
        if (element is HurlFile) {
            return element.children
                .filter { it.node?.elementType?.toString() == "ENTRY" }
                .map { HurlStructureViewElement(it as NavigatablePsiElement) }
                .toTypedArray()
        }

        val elementType = element.node?.elementType?.toString()
        if (elementType == "ENTRY") {
            val children = mutableListOf<TreeElement>()
            for (child in element.children) {
                val childType = child.node?.elementType?.toString()
                if (childType == "REQUEST" || childType == "RESPONSE") {
                    children.add(HurlStructureViewElement(child as NavigatablePsiElement))
                }
            }
            return children.toTypedArray()
        }

        if (elementType == "REQUEST" || elementType == "RESPONSE") {
            return element.children
                .filter {
                    it.node
                        ?.elementType
                        ?.toString()
                        ?.endsWith("_SECTION") == true
                }.map { HurlStructureViewElement(it as NavigatablePsiElement) }
                .toTypedArray()
        }

        return emptyArray()
    }

    override fun getAlphaSortKey(): String = presentation.presentableText ?: ""

    private fun getEntryLabel(element: PsiElement): String {
        val text = element.text ?: return "Request"
        val firstLine = text.lineSequence().firstOrNull()?.trim() ?: return "Request"
        return firstLine.take(60)
    }

    private fun getResponseLabel(element: PsiElement): String {
        val text = element.text ?: return "Response"
        val firstLine = text.lineSequence().firstOrNull()?.trim() ?: return "Response"
        return firstLine.take(60)
    }

    override fun navigationRequest(): NavigationRequest? = element.navigationRequest()

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean = element.canNavigate()

    override fun canNavigateToSource(): Boolean = element.canNavigateToSource()
}
