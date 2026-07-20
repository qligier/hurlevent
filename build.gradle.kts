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

        // Plugin Dependencies
        bundledPlugin("com.intellij.modules.json")
        bundledPlugin("com.intellij.jsonpath")
        bundledPlugin("XPathView")
        bundledModule("intellij.spellchecker")
        // GraphQL versions: https://plugins.jetbrains.com/plugin/8097-graphql/versions/stable/1102341
        plugin("com.intellij.lang.jsgraphql:253.28294.51")
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
    withType<Test> {
        reports {
            html.required.set(true)
            junitXml.required.set(true)
        }
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        dependsOn("generateLexer", "generateParser")
    }

    withType<JavaCompile> {
        dependsOn("generateLexer", "generateParser")
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            // Supported build number ranges and IntelliJ Platform versions
            // https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
            // To depend on the TextMate bundle API, the plugin must start build from 241
            sinceBuild = "242"

            // Do not set `untilBuild` here but in the Marketplace directly.
            // This allows changing its value without re-publishing the plugin.
            // https://platform.jetbrains.com/t/why-cant-i-set-an-until-build-value-greater-than-251/1840
            // untilBuild = "253.*"

            // Notable Changes and Features:
            // - https://plugins.jetbrains.com/docs/intellij/api-notable-list-2026.html
            // - https://plugins.jetbrains.com/docs/intellij/api-notable-list-2025.html
            // - https://plugins.jetbrains.com/docs/intellij/api-notable-list-2024.html

            // Incompatible Changes:
            // - https://plugins.jetbrains.com/docs/intellij/api-changes-list-2026.html
            // - https://plugins.jetbrains.com/docs/intellij/api-changes-list-2025.html
            // - https://plugins.jetbrains.com/docs/intellij/api-changes-list-2024.html
        }
    }

    pluginVerification {
        ides {
            // The 'verifyPlugin' task is configured to test each minor version of IDEs in the configured
            // compatibility range, which can be a lot of versions.
            // Let's reduce that to the first and last versions only, to speed up the verification process and reduce
            // the storage used by the downloaded IDEs. This is especially important for GitHub actions, which have
            // limited resources.
            // https://github.com/JetBrains/intellij-platform-plugin-template/issues/462#issuecomment-4172769399
            create(
                ProductReleasesValueSource().map {
                    listOf(it.first(), it.last()).distinct()
                },
            )
            // In the future, we'll be able to reuse the current IDE: create(current())
        }
    }
}
