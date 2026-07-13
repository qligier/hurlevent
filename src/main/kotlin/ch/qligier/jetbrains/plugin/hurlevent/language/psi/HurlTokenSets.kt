/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.psi

import com.intellij.psi.tree.TokenSet

object HurlTokenSets {
    val COMMENTS = TokenSet.create(HurlElementTypes.T_COMMENT)
    val WHITESPACES = TokenSet.create(HurlElementTypes.T_SPACE, HurlElementTypes.T_LINE_BREAK)
}
