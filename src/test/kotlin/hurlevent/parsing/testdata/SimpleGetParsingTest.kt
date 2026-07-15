/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.parsing.testdata

import ch.qligier.jetbrains.plugin.hurlevent.language.parser.HurlParserDefinition
import com.intellij.testFramework.ParsingTestCase

class SimpleGetParsingTest : ParsingTestCase("", "hurl", HurlParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/testData"

    override fun includeRanges(): Boolean = true

    fun testSimpleGet() = doTest(true)
}
