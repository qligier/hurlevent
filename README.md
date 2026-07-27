# Hurlevent

Hurlevent (\yʁ.lə.vɑ̃ \\) is a plugin for JetBrains IDEs that adds language support for
[Hurl](https://hurl.dev/), the plain-text file format for running and testing HTTP requests. It turns `.hurl` files
into a first-class language in the IDE, with syntax highlighting, code navigation, inspections, and embedded language
support for request bodies and query expressions.

<p align="center">

![GitHub](https://img.shields.io/github/license/qligier/hurlevent?style=flat-square)
[![Plugin version](https://img.shields.io/jetbrains/plugin/v/ch.qligier.jetbrains.plugin.hurlevent.svg)](https://plugins.jetbrains.com/plugin/XXX)
![Downloads](https://img.shields.io/jetbrains/plugin/d/ch.qligier.jetbrains.plugin.hurlevent.svg)
![GitHub last commit](https://img.shields.io/github/last-commit/qligier/hurlevent?style=flat-square)
![JDK 21](https://img.shields.io/badge/JDK-21-blue?style=flat-square)
![Hurl 8.0.1](https://img.shields.io/badge/Specifications-Hurl_8.0.1-red?style=flat-square)
</p>

## Features

Hurlevent registers a dedicated file type for `.hurl` files (with a light/dark icon) and builds on a full lexer and
parser generated from the Hurl grammar.

### Editing

- **Syntax highlighting** with a dedicated, customizable color scheme (*Settings | Editor | Color Scheme | Hurl*)
  covering methods, HTTP versions, status codes, sections, URLs, predicates, filters, queries, template variables,
  capture names, header names, and comments
- **Code folding**, **brace matching**, and **line commenting**
- **Structure view** and **breadcrumbs** to navigate requests and their sections
- **Spell checking** in comments and strings
- **Quick documentation** for filters, linked to the official Hurl reference
- A **New Hurl File** action in the *New* menu

### Inspections

- Warnings for **deprecated filters**
- Warnings for **unknown charsets**
- Detection of **duplicate sections**

### Embedded language support

Request/response bodies and query expressions are highlighted and validated using the IDE's native language engines
through [language injection](https://plugins.jetbrains.com/docs/intellij/language-injection.html):

- **JSON** and **XML** bodies, both raw and inside ` ```json ` / ` ```xml ` fenced blocks
- **GraphQL** bodies — requires the [GraphQL](https://plugins.jetbrains.com/plugin/8097-graphql) plugin
- **JSONPath** and **XPath** query expressions — require the bundled JSONPath and XPathView plugins
- **Regular expressions** in string values

The language grammar targets the Hurl 8.0.1 specification.

## Compatibility

- JetBrains IDEs based on IntelliJ Platform 2024.2 or later (build `242+`)
- Built and tested against 2025.3
- Building the plugin from source requires JDK 21

## Screenshot

To be added.

## Building

This project uses the [IntelliJ Platform Gradle Plugin](https://github.com/JetBrains/intellij-platform-gradle-plugin).
The lexer (`Hurl.flex`) and parser (`Hurl.bnf`) are generated with GrammarKit as part of the build.

| Task | Description |
| --- | --- |
| `./gradlew build` | Build the plugin and run the checks |
| `./gradlew runIde` | Launch a development IDE with the plugin installed |
| `./gradlew verifyPlugin` | Run the plugin compatibility verifier |

## Other plugins

There were two previous plugins that are no longer maintained, and this plugin is a continuation of their work:
- https://github.com/cwoskoski/hurlex (Apache 2.0)
- https://github.com/jazzytomato/intellij-hurl-plugin (Apache 2.0)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

It builds upon the [Hurlex](https://github.com/cwoskoski/hurlex) plugin, which is licensed under the
[Apache License 2.0](https://github.com/cwoskoski/hurlex/blob/main/LICENSE).

### Notice

This plugin uses icons that are derived from the Hurl logo.
