/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.documentation

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import ch.qligier.jetbrains.plugin.hurlevent.specs.HurlFilter
import com.intellij.model.Pointer
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.NlsContexts
import com.intellij.platform.backend.documentation.DocumentationResult
import com.intellij.platform.backend.documentation.DocumentationTarget
import com.intellij.platform.backend.presentation.TargetPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.SmartPointerManager

/**
 *
 * Note: Some parts are marked @ApiStatus.Experimental but this is the official
 * recommended approach
 */
internal class HurlFilterDocumentationTarget(
    private val element: PsiElement,
    private val filter: HurlFilter,
) : DocumentationTarget {
    private val LOG = Logger.getInstance(HurlFilterDocumentationTarget::class.java)

    override fun createPointer(): Pointer<out DocumentationTarget> =
        Pointer {
            val elementPointer =
                SmartPointerManager
                    .getInstance(element.project)
                    .createSmartPsiElementPointer(element)
            elementPointer.element?.let {
                HurlFilterDocumentationTarget(it, filter)
            }
        }

    override fun computePresentation(): TargetPresentation =
        TargetPresentation
            .builder(filter.name)
            .icon(Icons.HURL_ICON)
            .presentation()

    override fun computeDocumentation(): DocumentationResult {
        LOG.info("Computing documentation for filter: ${filter.name} at element: ${element.text}")
        return DocumentationResult.documentation(
            """
            <b>${filter.name}</b><br/>
            ${filter.description}<br/>
            <a href="${filter.documentationUrl}">Documentation</a>
            """.trimIndent(),
        )
    }

    override fun computeDocumentationHint(): @NlsContexts.HintText String? {
        LOG.info("Computing documentation hint for filter: ${filter.name} at element: ${element.text}")
        return null
    }
}
