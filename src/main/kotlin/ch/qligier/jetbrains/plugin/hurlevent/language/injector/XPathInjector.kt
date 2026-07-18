/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlXpathQuery
import org.intellij.lang.xpath.XPath2Language

internal class XPathInjector :
    AbstractQuotedStringQueryInjector<HurlXpathQuery>(
        XPath2Language.findInstance(XPath2Language::class.java),
        HurlXpathQuery::class,
    )
