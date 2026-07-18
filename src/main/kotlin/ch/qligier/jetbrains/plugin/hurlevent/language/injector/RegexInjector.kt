/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlRegexQuery
import org.intellij.lang.regexp.RegExpLanguage

internal class RegexInjector : AbstractSimpleInjector<HurlRegexQuery>(RegExpLanguage.INSTANCE, HurlRegexQuery::class)
