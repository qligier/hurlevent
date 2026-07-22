/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlXpathFilter
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlXpathQuery
import org.intellij.lang.xpath.XPath2Language

/**
 * We inject XPath2 language into the query and filter of the same name.
 */
internal class XPathInjector :
    AbstractFirstArgumentQuotedStringInjector(
        { parent ->
            parent is HurlXpathQuery || parent is HurlXpathFilter
        },
        XPath2Language.findInstance(XPath2Language::class.java),
    )
