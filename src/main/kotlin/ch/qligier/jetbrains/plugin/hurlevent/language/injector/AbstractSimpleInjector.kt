/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import org.jetbrains.annotations.Unmodifiable
import kotlin.reflect.KClass

/**
 * An abstract implementation of a simple injector that only takes a PSI element type and a language to inject.
 * It is used to avoid boilerplate code in the injector classes.
 *
 * @author Quentin Ligier
 **/
abstract class AbstractSimpleInjector<T : PsiElement>(
    private val language: Language,
    private val elementType: KClass<T>,
) : MultiHostInjector,
    DumbAware {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement,
    ) {
        // Verify if context is of type T:

        if (elementType.isInstance(context)) {
            registrar
                .startInjecting(language)
                .addPlace(null, null, context as PsiLanguageInjectionHost, TextRange.allOf(context.node.text))
                .doneInjecting()
        }
    }

    override fun elementsToInjectIn(): @Unmodifiable List<Class<out PsiElement>> = listOf(elementType.java)
}
