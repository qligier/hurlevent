/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package hurlevent.language

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class InspectionAnnotatorTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String = "src/test/testData/inspection"

    fun testDuplicateQuerySection() {
        myFixture.configureByFile("DuplicateQuerySection.hurl")
        myFixture.checkHighlighting(true, true, true)
    }

    fun testDeprecatedFilter() {
        myFixture.configureByFile("DeprecatedFilter.hurl")
        myFixture.checkHighlighting(true, true, true)
    }

    fun testUnknownFilter() {
        myFixture.configureByFile("UnknownFilter.hurl")
        myFixture.checkHighlighting(true, true, true)
    }
}
