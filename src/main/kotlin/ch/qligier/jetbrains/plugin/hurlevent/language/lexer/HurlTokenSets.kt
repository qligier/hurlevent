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
    @JvmField val METHODS =
        TokenSet.create(
            HurlTypes.GET,
            HurlTypes.POST,
            HurlTypes.PUT,
            HurlTypes.DELETE,
            HurlTypes.PATCH,
            HurlTypes.HEAD,
            HurlTypes.OPTIONS,
            HurlTypes.CONNECT,
            HurlTypes.TRACE,
            HurlTypes.LINK,
            HurlTypes.UNLINK,
            HurlTypes.PURGE,
            HurlTypes.LOCK,
            HurlTypes.UNLOCK,
            HurlTypes.PROPFIND,
            HurlTypes.PROPPATCH,
            HurlTypes.COPY,
            HurlTypes.MOVE,
            HurlTypes.MKCOL,
            HurlTypes.REPORT,
            HurlTypes.SEARCH,
        )

    @JvmField val SECTIONS =
        TokenSet.create(
            HurlTypes.SECTION_QUERY_STRING_PARAMS,
            HurlTypes.SECTION_FORM_PARAMS,
            HurlTypes.SECTION_MULTIPART_FORM_DATA,
            HurlTypes.SECTION_COOKIES,
            HurlTypes.SECTION_BASIC_AUTH,
            HurlTypes.SECTION_OPTIONS,
            HurlTypes.SECTION_CAPTURES,
            HurlTypes.SECTION_ASSERTS,
        )

    @JvmField val QUERY_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_STATUS,
            HurlTypes.KW_URL,
            HurlTypes.KW_HEADER,
            HurlTypes.KW_COOKIE,
            HurlTypes.KW_BODY,
            HurlTypes.KW_XPATH,
            HurlTypes.KW_JSONPATH,
            HurlTypes.KW_REGEX,
            HurlTypes.KW_VARIABLE,
            HurlTypes.KW_DURATION,
            HurlTypes.KW_SHA256,
            HurlTypes.KW_MD5,
            HurlTypes.KW_BYTES,
            HurlTypes.KW_CERTIFICATE,
        )

    @JvmField val PREDICATE_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_EQUALS,
            HurlTypes.KW_NOT_EQUALS,
            HurlTypes.KW_GREATER_THAN,
            HurlTypes.KW_GREATER_THAN_OR_EQUALS,
            HurlTypes.KW_LESS_THAN,
            HurlTypes.KW_LESS_THAN_OR_EQUALS,
            HurlTypes.KW_STARTS_WITH,
            HurlTypes.KW_ENDS_WITH,
            HurlTypes.KW_CONTAINS,
            HurlTypes.KW_INCLUDES,
            HurlTypes.KW_MATCHES,
            HurlTypes.KW_EXISTS,
            HurlTypes.KW_IS_EMPTY,
            HurlTypes.KW_IS_NUMBER,
            HurlTypes.KW_IS_STRING,
            HurlTypes.KW_IS_BOOLEAN,
            HurlTypes.KW_IS_COLLECTION,
            HurlTypes.KW_IS_DATE,
            HurlTypes.KW_IS_ISO_DATE,
            HurlTypes.KW_IS_FLOAT,
            HurlTypes.KW_IS_INTEGER,
            HurlTypes.KW_NOT,
        )

    @JvmField val FILTER_KEYWORDS =
        TokenSet.create(
            HurlTypes.KW_COUNT,
            HurlTypes.KW_NTH,
            HurlTypes.KW_REPLACE,
            HurlTypes.KW_SPLIT,
            HurlTypes.KW_TO_DATE,
            HurlTypes.KW_TO_FLOAT,
            HurlTypes.KW_TO_INT,
            HurlTypes.KW_DECODE,
            HurlTypes.KW_FORMAT,
            HurlTypes.KW_HTML_ESCAPE,
            HurlTypes.KW_HTML_UNESCAPE,
            HurlTypes.KW_URL_ENCODE,
            HurlTypes.KW_URL_DECODE,
        )

    @JvmField val STRINGS =
        TokenSet.create(
            HurlTypes.QUOTED_STRING,
            HurlTypes.BACKTICK_STRING,
        )

    @JvmField val COMMENTS = TokenSet.create(HurlTypes.COMMENT)

    @JvmField val WHITESPACES = TokenSet.create(TokenType.WHITE_SPACE)
}
