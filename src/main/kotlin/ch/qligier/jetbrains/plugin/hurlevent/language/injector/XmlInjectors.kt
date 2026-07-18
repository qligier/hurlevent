/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlXmlBody
import com.intellij.lang.xml.XMLLanguage

internal class XmlBodyInjector : AbstractSimpleInjector<HurlXmlBody>(XMLLanguage.INSTANCE, HurlXmlBody::class)

internal class XmlFencedBodyInjector : AbstractFencedBodyInjector() {
    override val languages =
        mapOf(
            "xml" to XMLLanguage.INSTANCE,
        )
}
