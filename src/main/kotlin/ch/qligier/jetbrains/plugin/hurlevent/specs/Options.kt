/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.specs

/**
 * The types of value accepted by the options of the `[Options]` section.
 *
 * Every type but [VERBOSITY] and [VARIABLE] also accepts a template (`{{name}}`) as its whole value.
 *
 * @property expected What the option expects, for error messages.
 * @property pattern The literal values accepted by the type (the full text of the value must match).
 */
enum class OptionValueType(
    val expected: String,
    private val pattern: Regex,
    private val acceptsTemplate: Boolean = true,
) {
    /**
     * `true` or `false`.
     */
    BOOLEAN("true or false", Regex("true|false")),

    /**
     * Any string (including file names, which the parser doesn't restrict beyond the string syntax).
     */
    STRING("a string", Regex("(?s).*")),

    /**
     * A count: a natural, or `-1` for unlimited.
     */
    COUNT("an integer greater than or equal to -1", Regex("-1|\\d+")),

    /**
     * A natural integer.
     */
    NATURAL("a non-negative integer", Regex("\\d+")),

    /**
     * A natural integer with an optional unit.
     */
    DURATION("a duration (an integer with an optional unit: ms, s, m or h)", Regex("\\d+(ms|s|m|h)?")),

    /**
     * The log verbosity.
     */
    VERBOSITY("one of brief, verbose or debug", Regex("brief|verbose|debug"), acceptsTemplate = false),

    /**
     * A variable definition: `name=value`. Only the name is checked, as the value can be any string.
     */
    VARIABLE("a variable definition (name=value)", Regex("([\\p{L}\\p{N}_-]+)\\s*=.*"), acceptsTemplate = false);

    /**
     * Checks that [text], which is the whole value of an option, is valid for this type.
     *
     * @return `null` if the value is valid, otherwise the reason why it's not.
     */
    fun validate(text: String): String? {
        if (acceptsTemplate && TEMPLATE.matches(text)) {
            return null
        }
        val match = pattern.matchEntire(text) ?: return "expected $expected"
        if (this == VARIABLE) {
            val name = match.groupValues[1]
            if (name in RESERVED_VARIABLE_NAMES) {
                return "the variable name '$name' conflicts with a function, use a different name"
            }
        }
        return null
    }

    private companion object {
        private val TEMPLATE = Regex("\\{\\{(?:(?!}}).)*}}")

        // Names that would conflict with a Hurl function
        private val RESERVED_VARIABLE_NAMES = setOf("getEnv", "newDate", "newUuid")
    }
}

/**
 * The type of the value of every option of the `[Options]` section.
 *
 * @see [Hurl option parser](https://github.com/Orange-OpenSource/hurl/blob/8.1.0/packages/hurl_core/src/parser/option.rs)
 * @see [Hurl grammar](https://github.com/Orange-OpenSource/hurl/blob/8.1.0/docs/spec/grammar/hurl.grammar)
 */
object Options {
    val VALUE_TYPES: Map<String, OptionValueType> = mapOf(
        "aws-sigv4" to OptionValueType.STRING,
        "cacert" to OptionValueType.STRING,
        "cert" to OptionValueType.STRING,
        "compressed" to OptionValueType.BOOLEAN,
        "connect-timeout" to OptionValueType.DURATION,
        "connect-to" to OptionValueType.STRING,
        "delay" to OptionValueType.DURATION,
        "digest" to OptionValueType.BOOLEAN,
        "fail-with-body" to OptionValueType.BOOLEAN,
        "header" to OptionValueType.STRING,
        "http1.0" to OptionValueType.BOOLEAN,
        "http1.1" to OptionValueType.BOOLEAN,
        "http2" to OptionValueType.BOOLEAN,
        "http2-prior-knowledge" to OptionValueType.BOOLEAN,
        "http3" to OptionValueType.BOOLEAN,
        "insecure" to OptionValueType.BOOLEAN,
        "ipv4" to OptionValueType.BOOLEAN,
        "ipv6" to OptionValueType.BOOLEAN,
        "key" to OptionValueType.STRING,
        "limit-rate" to OptionValueType.NATURAL,
        "location" to OptionValueType.BOOLEAN,
        "location-trusted" to OptionValueType.BOOLEAN,
        "max-redirs" to OptionValueType.COUNT,
        "max-time" to OptionValueType.DURATION,
        "negotiate" to OptionValueType.BOOLEAN,
        "netrc" to OptionValueType.BOOLEAN,
        "netrc-file" to OptionValueType.STRING,
        "netrc-optional" to OptionValueType.BOOLEAN,
        "no-header" to OptionValueType.STRING,
        "no-jsonpath-coercion" to OptionValueType.BOOLEAN,
        "ntlm" to OptionValueType.BOOLEAN,
        "output" to OptionValueType.STRING,
        "path-as-is" to OptionValueType.BOOLEAN,
        "pinnedpubkey" to OptionValueType.STRING,
        "proxy" to OptionValueType.STRING,
        "repeat" to OptionValueType.COUNT,
        "resolve" to OptionValueType.STRING,
        "retry" to OptionValueType.COUNT,
        "retry-interval" to OptionValueType.DURATION,
        "skip" to OptionValueType.BOOLEAN,
        "tls-max" to OptionValueType.STRING,
        "tls-min" to OptionValueType.STRING,
        "unix-socket" to OptionValueType.STRING,
        "user" to OptionValueType.STRING,
        "variable" to OptionValueType.VARIABLE,
        "variables-file" to OptionValueType.STRING,
        "verbose" to OptionValueType.BOOLEAN,
        "verbosity" to OptionValueType.VERBOSITY,
        "very-verbose" to OptionValueType.BOOLEAN,
    )
}
