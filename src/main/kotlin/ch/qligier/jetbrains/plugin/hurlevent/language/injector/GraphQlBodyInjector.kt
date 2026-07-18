/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.injector

import com.intellij.lang.jsgraphql.GraphQLLanguage

internal class GraphQlBodyInjector : AbstractFencedBodyInjector() {
    override val languages =
        mapOf(
            "graphql" to GraphQLLanguage.INSTANCE,
        )
}
