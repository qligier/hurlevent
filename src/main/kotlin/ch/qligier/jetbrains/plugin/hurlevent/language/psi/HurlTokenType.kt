/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi

import ch.qligier.jetbrains.plugin.hurlevent.language.HurlLanguage
import com.intellij.psi.tree.IElementType

class HurlTokenType(
    debugName: String,
) : IElementType(debugName, HurlLanguage) {
    override fun toString(): String = "HurlTokenType.${super.toString()}"
}
