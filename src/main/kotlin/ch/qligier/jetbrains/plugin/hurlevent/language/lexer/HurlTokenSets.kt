/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.lexer

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes
import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet

/**
 * Sets of tokens grouped by their purpose.
 * They're used by the parser definition and the syntax highlighter to identify and handle specific types of tokens.
 */
object HurlTokenSets {
    // [SECTION_LIST]
    @JvmField val SECTIONS =
        TokenSet.create(
            HurlTypes.SECTION_ASSERTS,
            HurlTypes.SECTION_BASIC_AUTH,
            HurlTypes.SECTION_CAPTURES,
            HurlTypes.SECTION_COOKIES,
            HurlTypes.SECTION_FORM,
            HurlTypes.SECTION_MULTIPART,
            HurlTypes.SECTION_OPTIONS,
            HurlTypes.SECTION_QUERY,
        )

    // [QUERY_LIST]
    @JvmField val QUERY_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_BODY,
            HurlTypes.KW_BYTES,
            HurlTypes.KW_CERTIFICATE,
            HurlTypes.KW_COOKIE,
            HurlTypes.KW_DURATION,
            HurlTypes.KW_HEADER,
            HurlTypes.KW_IP,
            HurlTypes.KW_JSONPATH,
            HurlTypes.KW_MD5,
            HurlTypes.KW_RAWBYTES,
            HurlTypes.KW_REDIRECTS,
            HurlTypes.KW_REGEX,
            HurlTypes.KW_SHA256,
            HurlTypes.KW_STATUS,
            HurlTypes.KW_URL,
            HurlTypes.KW_VARIABLE,
            HurlTypes.KW_XPATH,
        )

    // [PREDICATE_LIST]
    @JvmField val PREDICATE_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_CONTAINS,
            HurlTypes.KW_ENDS_WITH,
            HurlTypes.KW_EQUALS,
            HurlTypes.KW_EXISTS,
            HurlTypes.KW_GREATER_THAN,
            HurlTypes.KW_GREATER_THAN_OR_EQUALS,
            HurlTypes.KW_INCLUDES,
            HurlTypes.KW_IS_BOOLEAN,
            HurlTypes.KW_IS_COLLECTION,
            HurlTypes.KW_IS_DATE,
            HurlTypes.KW_IS_EMPTY,
            HurlTypes.KW_IS_FLOAT,
            HurlTypes.KW_IS_INTEGER,
            HurlTypes.KW_IS_IPV4,
            HurlTypes.KW_IS_IPV6,
            HurlTypes.KW_IS_ISO_DATE,
            HurlTypes.KW_IS_LIST,
            HurlTypes.KW_IS_NUMBER,
            HurlTypes.KW_IS_OBJECT,
            HurlTypes.KW_IS_STRING,
            HurlTypes.KW_IS_UUID,
            HurlTypes.KW_LESS_THAN,
            HurlTypes.KW_LESS_THAN_OR_EQUALS,
            HurlTypes.KW_MATCHES,
            HurlTypes.KW_NOT,
            HurlTypes.KW_NOT_EQUALS,
            HurlTypes.KW_STARTS_WITH,
        )

    // [FILTER_LIST]
    @JvmField val FILTER_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_BASE64_DECODE,
            HurlTypes.KW_BASE64_ENCODE,
            HurlTypes.KW_BASE64_URL_SAFE_DECODE,
            HurlTypes.KW_BASE64_URL_SAFE_ENCODE,
            HurlTypes.KW_CHARSET_DECODE,
            HurlTypes.KW_COUNT,
            HurlTypes.KW_DATE_FORMAT,
            HurlTypes.KW_DAYS_AFTER_NOW,
            HurlTypes.KW_DAYS_BEFORE_NOW,
            HurlTypes.KW_FIRST,
            HurlTypes.KW_FORMAT,
            HurlTypes.KW_HTML_ESCAPE,
            HurlTypes.KW_HTML_UNESCAPE,
            HurlTypes.KW_JSONPATH,
            HurlTypes.KW_LAST,
            HurlTypes.KW_LOCATION,
            HurlTypes.KW_NTH,
            HurlTypes.KW_REGEX,
            HurlTypes.KW_REPLACE,
            HurlTypes.KW_REPLACE_REGEX,
            HurlTypes.KW_SPLIT,
            HurlTypes.KW_TO_DATE,
            HurlTypes.KW_TO_FLOAT,
            HurlTypes.KW_TO_HEX,
            HurlTypes.KW_TO_INT,
            HurlTypes.KW_TO_STRING,
            HurlTypes.KW_URL_ENCODE,
            HurlTypes.KW_URL_DECODE,
            HurlTypes.KW_URL_QUERY_PARAM,
            HurlTypes.KW_UTF8_DECODE,
            HurlTypes.KW_UTF8_ENCODE,
            HurlTypes.KW_XPATH,
        )

    @JvmField val STRINGS =
        TokenSet.create(
            HurlTypes.QUOTED_STRING,
            HurlTypes.BACKTICK_STRING,
        )

    @JvmField val COMMENTS = TokenSet.create(HurlTypes.COMMENT)

    @JvmField val WHITESPACES = TokenSet.create(TokenType.WHITE_SPACE)
}
