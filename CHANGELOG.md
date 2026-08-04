<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Hurlevent

## [Unreleased]

### Fixed

- XML body without fenced block was not parsed correctly, resulting in a syntax error

## [0.1.0] - 2026-07-27

### Added

- Dedicated file type for `.hurl` files, with a light/dark file icon
- Lexer and parser for the Hurl 8.0.1 grammar
- Syntax highlighting with a customizable color scheme (*Settings | Editor | Color Scheme | Hurl*)
- Code folding, brace matching, and line commenting
- Structure view and breadcrumbs to navigate requests and their sections
- Spell checking in comments and strings
- Quick documentation for filters, linked to the official Hurl reference
- *New Hurl File* action in the *New* menu
- Inspection: warning for deprecated filters
- Inspection: warning for unknown charsets
- Inspection: detection of duplicate sections
- Language injection for JSON and XML bodies
- Language injection for GraphQL bodies (requires the GraphQL plugin)
- Language injection for JSONPath and XPath query expressions (require the bundled JSONPath and XPathView plugins)
- Language injection for regular expressions in string values

[0.1.0]: https://github.com/olivierlacan/keep-a-changelog/releases/tag/v0.1.0
