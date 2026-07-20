package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlQuotedStringValue
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import org.jetbrains.annotations.Unmodifiable

abstract class AbstractFirstArgumentQuotedStringInjector(
    private val parentPredicate: (PsiElement) -> Boolean,
    private val language: Language,
) : MultiHostInjector,
    DumbAware {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar,
        context: PsiElement,
    ) {
        if (context is HurlQuotedStringValue &&
            parentPredicate.invoke(context.parent) &&
            elementIsParentFirstArgument(context)
        ) {
            val text = context.node.text
            // We need to exclude the quotes at the beginning and end of the regex string value
            val range = TextRange(1, text.length - 1)
            registrar
                .startInjecting(language)
                .addPlace(null, null, context as PsiLanguageInjectionHost, range)
                .doneInjecting()
        }
    }

    override fun elementsToInjectIn(): @Unmodifiable List<Class<out PsiElement>> = listOf(HurlQuotedStringValue::class.java)

    /**
     * Verify if the given element is the first argument (third child) of its parent.
     * The first child is the filter/query name.
     * The second child is a whitespace.
     */
    private fun elementIsParentFirstArgument(element: PsiElement): Boolean {
        val parent = element.parent ?: return false
        val thirdChild = parent.firstChild?.nextSibling?.nextSibling ?: return false
        return thirdChild == element
    }
}
