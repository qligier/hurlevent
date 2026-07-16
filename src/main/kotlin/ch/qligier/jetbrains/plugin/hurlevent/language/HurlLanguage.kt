/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language

import com.intellij.lang.Language
import com.intellij.openapi.util.NlsSafe

/**
 * The Hurl language definition for the IntelliJ Platform.
 * @see [Language and File Type](https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html)
 **/
object HurlLanguage : Language("hurl") {
    private fun readResolve(): Any = HurlLanguage

    override fun getDisplayName(): @NlsSafe String = "Hurl"
}
