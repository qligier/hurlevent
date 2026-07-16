/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.parser

import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes

/**
 * Sets of elements grouped by their purpose.
 *
 * @author Quentin Ligier
 **/
object HurlElementSets {
    val SECTIONS =
        setOf(
            HurlTypes.ASSERTS_SECTION,
            HurlTypes.BASIC_AUTH_SECTION,
            HurlTypes.CAPTURES_SECTION,
            HurlTypes.COOKIES_SECTION,
            HurlTypes.FORM_PARAMS_SECTION,
            HurlTypes.MULTIPART_FORM_DATA_SECTION,
            HurlTypes.OPTIONS_SECTION,
            HurlTypes.QUERY_STRING_PARAMS_SECTION,
            HurlTypes.REQUEST_SECTION,
            HurlTypes.RESPONSE_SECTION,
        )
}
