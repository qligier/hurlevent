/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.language.parsing.testdata

import ch.qligier.jetbrains.plugin.hurlevent.language.parser.HurlParserDefinition
import com.intellij.testFramework.ParsingTestCase

/**
 * Test class for the parser of the Hurl language.
 * It works by parsing the content of a file and comparing the resulting PSI tree with the expected output.
 * It uses the method names (after removing the "test" prefix) to determine the name of the file to parse.
 * For example, the method `testSimpleGet` will parse the file `SimpleGet.hurl` and compare the resulting PSI tree with
 * the expected output in `SimpleGet.txt`.
 */
class ParsingTests : ParsingTestCase("", "hurl", HurlParserDefinition()) {
    // The directory in which the test data files are located.
    override fun getTestDataPath(): String = "src/test/testData"

    override fun includeRanges(): Boolean = true

    // Parses the SimpleGet.hurl file and compares its PSI tree to SimpleGet.txt
    fun testSimpleGet() = doTest(true)

    // Parses the Filters.hurl file and compares its PSI tree to Filters.txt
    fun testFilters() = doTest(true)

    // Parses the EntrySeparators.hurl file and compares its PSI tree to EntrySeparators.txt
    fun testEntrySeparators() = doTest(true)
}
