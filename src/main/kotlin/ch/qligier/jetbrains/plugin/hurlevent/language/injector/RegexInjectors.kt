/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.*
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import org.intellij.lang.regexp.RegExpLanguage
import org.jetbrains.annotations.Unmodifiable

/**
 * This injects the RegExp language into the HurlRegexStringValue PSI element (e.g. `/regex/`).
 */
internal class RegexStringValueInjector :
    MultiHostInjector,
    DumbAware {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement,
    ) {
        if (context is HurlRegexStringValue) {
            val text = context.node.text
            // We need to exclude the slashes at the beginning and end of the regex string value
            val range = TextRange(1, text.length - 1)
            registrar
                .startInjecting(RegExpLanguage.INSTANCE)
                .addPlace(null, null, context as PsiLanguageInjectionHost, range)
                .doneInjecting()
        }
    }

    override fun elementsToInjectIn(): @Unmodifiable List<Class<out PsiElement>> = listOf(HurlRegexStringValue::class.java)
}

/**
 * This injects the RegExp language into the HurlQuotedStringValue PSI element (e.g. `"regex"`).
 */
internal class RegexQuotedStringValueInjector :
    AbstractFirstArgumentQuotedStringInjector(
        { parent ->
            parent is HurlRegexQuery ||
                parent is HurlRegexFilter ||
                parent is HurlReplaceRegexFilter
        },
        RegExpLanguage.INSTANCE,
    )
