/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlJsonBody
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlXmlBody
import com.intellij.json.JsonLanguage
import com.intellij.lang.xml.XMLLanguage

/**
 * Instructs the IDE to handle some parts of a Hurl file as other languages.
 *
 * @see [Language Injection](https://plugins.jetbrains.com/docs/intellij/language-injection.html)
 **/
internal class JsonInjector : AbstractSimpleInjector<HurlJsonBody>(JsonLanguage.INSTANCE, HurlJsonBody::class)

internal class XmlInjector : AbstractSimpleInjector<HurlXmlBody>(XMLLanguage.INSTANCE, HurlXmlBody::class)
