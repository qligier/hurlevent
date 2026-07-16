/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenSets
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

/**
 * Allows to "fold" certain parts of the Hurl file.
 *
 * @see [Folding Builder](https://plugins.jetbrains.com/docs/intellij/folding-builder.html)
 * @see [Code Folding](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#code-folding)
 **/
internal class HurlFoldingBuilder :
    FoldingBuilderEx(),
    DumbAware {
    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean,
    ): Array<out FoldingDescriptor?> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        collectFoldRegions(root, descriptors, document)
        return descriptors.toTypedArray()
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false

    override fun getPlaceholderText(node: ASTNode): String =
        when {
            node.elementType == HurlTypes.ENTRY -> "…"
            node.elementType == HurlTypes.JSON_BODY -> "{…}"
            node.elementType == HurlTypes.MULTILINE_STRING_BODY -> "```…```"
            HurlTokenSets.SECTIONS.contains(node.elementType) -> node.text.substringBefore("\n") + "…"
            else -> "…"
        }

    private fun collectFoldRegions(
        element: PsiElement,
        descriptors: MutableList<FoldingDescriptor>,
        document: Document,
    ) {
        val node = element.node ?: return
        val elementType = node.elementType

        // Fold entries (request + response blocks)
        if (elementType.toString() == "ENTRY") {
            val range = element.textRange
            if (range.length > 1 && spanMultipleLines(range, document)) {
                val firstLine = document.getLineNumber(range.startOffset)
                val lineEnd = document.getLineEndOffset(firstLine)
                if (lineEnd < range.endOffset) {
                    descriptors.add(FoldingDescriptor(node, TextRange(lineEnd, range.endOffset)))
                }
            }
        }

        // Fold sections
        if (HurlTokenSets.SECTIONS.contains(elementType)) {
            val parent = element.parent
            if (parent != null) {
                val range = parent.textRange
                if (range.length > 1 && spanMultipleLines(range, document)) {
                    descriptors.add(FoldingDescriptor(parent.node, range))
                }
            }
        }

        // Fold multiline strings
        if (elementType == HurlTypes.MULTILINE_STRING_OPEN) {
            val parent = element.parent
            if (parent != null) {
                val range = parent.textRange
                if (range.length > 6) {
                    descriptors.add(FoldingDescriptor(parent.node, range))
                }
            }
        }

        // Fold JSON bodies
        if (elementType == HurlTypes.LBRACE) {
            val parent = element.parent
            if (parent != null && parent.node.elementType.toString() == "JSON_BODY") {
                val range = parent.textRange
                if (range.length > 2 && spanMultipleLines(range, document)) {
                    descriptors.add(FoldingDescriptor(parent.node, range))
                }
            }
        }

        for (child in element.children) {
            collectFoldRegions(child, descriptors, document)
        }
    }

    private fun spanMultipleLines(
        range: TextRange,
        document: Document,
    ): Boolean = document.getLineNumber(range.startOffset) < document.getLineNumber(range.endOffset)
}
