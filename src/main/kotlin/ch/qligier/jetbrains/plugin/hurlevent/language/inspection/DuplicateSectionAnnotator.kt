/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.inspection

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

/**
 * Warn about duplicated sections in a Hurl entry.
 * This might happen because some headers have two different names:
 *  - Query and QueryStringParams
 *  - Form and FormParams
 *  - Multipart and MultipartFormData
 */
internal class DuplicateSectionAnnotator :
    Annotator,
    DumbAware {
    companion object {
        private val SECTION_TYPES =
            setOf(
                HurlAssertsSection::class,
                HurlBasicAuthSection::class,
                HurlCapturesSection::class,
                HurlCookiesSection::class,
                HurlFormSection::class,
                HurlMultipartSection::class,
                HurlOptionsSection::class,
                HurlQuerySection::class,
            )
    }

    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        if (element is HurlEntry) {
            SECTION_TYPES.forEach { sectionType ->
                val sections = PsiTreeUtil.findChildrenOfType(element, sectionType.java)
                if (sections.size > 1) {
                    val firstSectionName =
                        sections
                            .first()
                            .firstChild.node.text
                    sections.drop(1).forEach { sectionElement ->
                        holder
                            .newAnnotation(
                                HighlightSeverity.WARNING,
                                "Duplicate section: $firstSectionName",
                            ).range(sectionElement.firstChild)
                            .tooltip("The section '$firstSectionName' is already defined in this entry")
                            .create()
                    }
                }
            }
        }
    }
}
