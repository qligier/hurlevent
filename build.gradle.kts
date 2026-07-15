/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.intellij.platform.gradle.tasks.GenerateLexerTask
import org.jetbrains.intellij.platform.gradle.tasks.GenerateParserTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform.grammarkit")
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

tasks.named<GenerateLexerTask>("generateLexer") {
    sourceFile.set(file("src/main/kotlin/ch/qligier/jetbrains/plugin/hurlevent/language/lexer/Hurl.flex"))
    targetRootOutputDir.set(file("src/main/gen/ch/qligier/jetbrains/plugin/hurlevent/language/lexer"))
    purgeOldFiles.set(true)
}

tasks.named<GenerateParserTask>("generateParser") {
    sourceFile.set(file("src/main/kotlin/ch/qligier/jetbrains/plugin/hurlevent/language/parser/Hurl.bnf"))
    targetRootOutputDir.set(file("src/main/gen"))
    // Despite being deprecated, the pathToParser and pathToPsiRoot properties are still required for the purging not
    // to also delete the generated lexer :(
    pathToParser.set("ch/qligier/jetbrains/plugin/hurlevent/language/parser/HurlParser.java")
    pathToPsiRoot.set("ch/qligier/jetbrains/plugin/hurlevent/language/psi")
    purgeOldFiles.set(true)
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        dependsOn("generateLexer", "generateParser")
    }

    withType<JavaCompile> {
        dependsOn("generateLexer", "generateParser")
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}
