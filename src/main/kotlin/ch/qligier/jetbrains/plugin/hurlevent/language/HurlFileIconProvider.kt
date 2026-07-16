/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * Provides custom icons for files supported by this plugin.
 * Only Hurl files are implemented here.
 *
 * @see [Customizing Existing Icons](https://plugins.jetbrains.com/docs/intellij/ui-faq.html#customizing-existing-icons)]
 */
class HurlFileIconProvider : FileIconProvider {
    /**
     * Provides a custom icon for the given virtual file, or {@code null} it there is no icon to provide.
     *
     * @param file    The target file.
     * @param flags   Some flags.
     * @param project The project.
     * @return an icon to override the default one or {@code null}.
     */
    override fun getIcon(
        file: VirtualFile,
        flags: Int,
        project: Project?,
    ): Icon? =
        when (file.extension) {
            "hurl" -> Icons.HURL_ICON
            else -> null
        }
}
