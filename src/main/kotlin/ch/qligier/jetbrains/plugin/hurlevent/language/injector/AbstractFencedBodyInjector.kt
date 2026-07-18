/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlMultilineStringBody
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.jetbrains.annotations.Unmodifiable

/**
 * Hurlevent
 *
 * @author Quentin Ligier
 * @see [Language Injection](https://plugins.jetbrains.com/docs/intellij/language-injection.html)
 **/
abstract class AbstractFencedBodyInjector :
    MultiHostInjector,
    DumbAware {
    abstract val languages: Map<String, Language>

    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement,
    ) {
        if (context is HurlMultilineStringBody) {
            val body = context.node.text
            val languageIdentifier = body.substringAfter("```").substringBefore("\n").trim()
            val language = languages[languageIdentifier] ?: return

            val rangeStart = body.indexOf(languageIdentifier) + languageIdentifier.length + 1
            val rangeEnd = body.lastIndexOf("```")

            registrar
                .startInjecting(language)
                .addPlace(null, null, context, TextRange(rangeStart, rangeEnd))
                .doneInjecting()
        }
    }

    override fun elementsToInjectIn(): @Unmodifiable List<Class<out PsiElement>> = listOf(HurlMultilineStringBody::class.java)
}
