/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

import org.jetbrains.intellij.platform.gradle.TestFrameworkType

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.changelog")
    java
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea("2025.3")
        testFramework(TestFrameworkType.Platform)
    }
}

sourceSets {
    main {
        java.srcDirs("src/main/gen", "src/main/kotlin")
    }
}
