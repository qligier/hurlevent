/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlJsonpathFilter
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlJsonpathQuery
import com.intellij.jsonpath.JsonPathLanguage

internal class JsonPathInjector :
    AbstractFirstArgumentQuotedStringInjector(
        parentPredicate = { parent ->
            parent is HurlJsonpathFilter || parent is HurlJsonpathQuery
        },
        JsonPathLanguage.INSTANCE,
    )
