/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlQuotedStringValue
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.jetbrains.annotations.Unmodifiable
import kotlin.reflect.KClass

/**
 * An injector specialized in injecting a specific language into quoted string values of a specific parent type.
 * This works for XPath and JSONPath queries.
 **/
abstract class AbstractQuotedStringQueryInjector<T : PsiElement>(
    private val language: Language,
    private val parentType: KClass<in T>,
) : MultiHostInjector,
    DumbAware {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement,
    ) {
        if (context is HurlQuotedStringValue && parentType.isInstance(context.parent)) {
            val body = context.node.text
            // Remove the surrounding quotes from the string value to get the actual content
            val rangeStart = body.indexOf('"') + 1
            val rangeEnd = body.lastIndexOf('"')

            registrar
                .startInjecting(language)
                .addPlace(null, null, context, TextRange(rangeStart, rangeEnd))
                .doneInjecting()
        }
    }

    override fun elementsToInjectIn(): @Unmodifiable List<Class<out PsiElement>> = listOf(HurlQuotedStringValue::class.java)
}
