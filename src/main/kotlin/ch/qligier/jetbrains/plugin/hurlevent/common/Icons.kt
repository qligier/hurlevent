/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.common

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * The icons used by this plugin.
 *
 * @author Quentin Ligier
 * @see [Working with Icons and Images](https://plugins.jetbrains.com/docs/intellij/work-with-icons-and-images.html)
 * @see [Icons](https://jetbrains.design/intellij/principles/icons/)
 * @see [Icons list](https://jetbrains.design/intellij/resources/icons_list/)
 * @see [IntelliJ Icon Generator](https://bjansen.github.io/intellij-icon-generator/)
 * @see [IntelliJ Platform Icons](https://intellij-icons.jetbrains.design)
 */
object Icons {
    val HURL_ICON: Icon = loadIcon("hurl.svg")

    // Utility function to load icons from the resources
    private fun loadIcon(path: String): Icon = IconLoader.getIcon("icons/$path", Icons::class.java)
}
