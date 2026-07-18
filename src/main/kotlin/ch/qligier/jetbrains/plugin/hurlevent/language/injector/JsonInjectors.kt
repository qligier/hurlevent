/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlJsonBody
import com.intellij.json.JsonLanguage

internal class JsonBodyInjector : AbstractSimpleInjector<HurlJsonBody>(JsonLanguage.INSTANCE, HurlJsonBody::class)

internal class JsonFencedBodyInjector : AbstractFencedBodyInjector() {
    override val languages =
        mapOf(
            "json" to JsonLanguage.INSTANCE,
            "jsonc" to JsonLanguage.INSTANCE,
            "json5" to JsonLanguage.INSTANCE,
        )
}
