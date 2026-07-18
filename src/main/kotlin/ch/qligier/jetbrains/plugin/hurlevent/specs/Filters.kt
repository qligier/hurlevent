/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.specs

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.psi.tree.IElementType

/**
 * Definitions of the filters supported by Hurl.
 * This provides a common list of filters that can be used for documentation, validation, and other purposes.
 * @see [Filters](https://hurl.dev/docs/filters.html)
 **/
object Filters {
    const val DOCUMENTATION_URL = "https://hurl.dev/docs/filters.html"

    fun getFilters(): Set<HurlFilter> =
        setOf(
            HurlFilter(
                "base64Decode",
                "Decodes a Base64 encoded string into bytes.",
                "base64decode",
                HurlTypes.KW_BASE64_DECODE,
            ),
            HurlFilter(
                "base64Encode",
                "Encodes bytes into Base64 encoded string.",
                "base64encode",
                HurlTypes.KW_BASE64_ENCODE,
            ),
            HurlFilter(
                "base64UrlSafeDecode",
                "Decodes a Base64 encoded string into bytes (using Base64 URL safe encoding).",
                "base64urlsafedecode",
                HurlTypes.KW_BASE64_URL_SAFE_DECODE,
            ),
            HurlFilter(
                "base64UrlSafeEncode",
                "Encodes bytes into Base64 encoded string (using Base64 URL safe encoding).",
                "base64urlsafeencode",
                HurlTypes.KW_BASE64_URL_SAFE_ENCODE,
            ),
            HurlFilter(
                "charsetDecode",
                "Decodes bytes to string using a charset encoding. Encoding labels are defined in Encoding Standard.",
                "charsetdecode",
                HurlTypes.KW_CHARSET_DECODE,
            ),
            HurlFilter("count", "Counts the number of items in a collection.", "count", HurlTypes.KW_COUNT),
            HurlFilter(
                "dateFormat",
                "Formats a date to a string given a specification format.",
                "dateformat",
                HurlTypes.KW_DATE_FORMAT,
            ),
            HurlFilter(
                "daysAfterNow",
                "Returns the number of days between now and a date in the future.",
                "daysafternow",
                HurlTypes.KW_DAYS_AFTER_NOW,
            ),
            HurlFilter(
                "daysBeforeNow",
                "Returns the number of days between now and a date in the past.",
                "daysbeforenow",
                HurlTypes.KW_DAYS_BEFORE_NOW,
            ),
            HurlFilter("first", "Returns the first element from a collection.", "first", HurlTypes.KW_FIRST),
            HurlFilter("format", "Deprecated, use 'dateFormat' instead.", "format", HurlTypes.KW_FORMAT),
            HurlFilter(
                "htmlEscape",
                "Converts the characters &, < and > to HTML-safe sequence.",
                "htmlescape",
                HurlTypes.KW_HTML_ESCAPE,
            ),
            HurlFilter(
                "htmlUnescape",
                "Converts all named and numeric character references (e.g. &gt;, &#62;, &#x3e;) to the corresponding Unicode characters.",
                "htmlunescape",
                HurlTypes.KW_HTML_UNESCAPE,
            ),
            HurlFilter("jsonpath", "Evaluates a JSONPath expression.", "jsonpath", HurlTypes.KW_JSONPATH),
            HurlFilter("last", "Returns the last element from a collection.", "last", HurlTypes.KW_LAST),
            HurlFilter(
                "location",
                "Returns the target URL location of a redirection; the returned URL is always absolute, contrary to the Location header from which it’s originated that can be absolute or relative.",
                "location",
                HurlTypes.KW_LOCATION,
            ),
            HurlFilter(
                "nth",
                "Returns the element from a collection at a zero-based index, accepts negative indices for indexing from the end of the collection.",
                "nth",
                HurlTypes.KW_NTH,
            ),
            HurlFilter(
                "regex",
                "Extracts regex capture group. Pattern must have at least one capture group.",
                "regex",
                HurlTypes.KW_REGEX,
            ),
            HurlFilter(
                "replace",
                "Replaces all occurrences of old string with new string.",
                "replace",
                HurlTypes.KW_REPLACE,
            ),
            HurlFilter(
                "replaceRegex",
                "Replaces all occurrences of a pattern with new string.",
                "replaceregex",
                HurlTypes.KW_REPLACE_REGEX,
            ),
            HurlFilter(
                "split",
                "Splits to a list of strings around occurrences of the specified delimiter.",
                "split",
                HurlTypes.KW_SPLIT,
            ),
            HurlFilter(
                "toDate",
                "Converts a string to a date given a specification format.",
                "todate",
                HurlTypes.KW_TO_DATE,
            ),
            HurlFilter("toFloat", "Converts value to float number.", "tofloat", HurlTypes.KW_TO_FLOAT),
            HurlFilter("toHex", "Converts bytes to hexadecimal string.", "tohex", HurlTypes.KW_TO_HEX),
            HurlFilter("toInt", "Converts value to integer number.", "toint", HurlTypes.KW_TO_INT),
            HurlFilter("toString", "Converts value to string.", "tostring", HurlTypes.KW_TO_STRING),
            HurlFilter(
                "urlDecode",
                "Replaces %xx escapes with their single-character equivalent.",
                "urldecode",
                HurlTypes.KW_URL_DECODE,
            ),
            HurlFilter(
                "urlEncode",
                "Percent-encodes all the characters which are not included in unreserved chars (see RFC3986) except forward slash (/).",
                "urlencode",
                HurlTypes.KW_URL_ENCODE,
            ),
            HurlFilter(
                "urlQueryParam",
                "Returns the value of a query parameter in a URL.",
                "urlqueryparam",
                HurlTypes.KW_URL_QUERY_PARAM,
            ),
            HurlFilter(
                "utf8Decode",
                "Decodes bytes to string using UTF-8 encoding.",
                "utf8decode",
                HurlTypes.KW_UTF8_DECODE,
            ),
            HurlFilter(
                "utf8Encode",
                "Encodes a string to bytes using UTF-8 encoding.",
                "utf8encode",
                HurlTypes.KW_UTF8_ENCODE,
            ),
            HurlFilter("xpath", "Evaluates an XPath expression.", "xpath", HurlTypes.KW_XPATH),
        )
}

data class HurlFilter(
    val name: String,
    val description: String,
    val documentationUrlAnchor: String,
    val elementType: IElementType,
) {
    val documentationUrl: String
        get() = "${Filters.DOCUMENTATION_URL}#$documentationUrlAnchor"
}
