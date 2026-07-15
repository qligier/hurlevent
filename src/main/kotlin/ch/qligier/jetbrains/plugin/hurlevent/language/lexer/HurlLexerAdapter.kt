/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.lexer

import com.intellij.lexer.FlexAdapter

class HurlLexerAdapter : FlexAdapter(HurlLexer(null))
