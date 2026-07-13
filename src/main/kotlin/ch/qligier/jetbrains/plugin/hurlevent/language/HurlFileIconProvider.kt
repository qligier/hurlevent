/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class HurlFileIconProvider : FileIconProvider {
    override fun getIcon(
        file: VirtualFile,
        flags: Int,
        project: Project?
    ): Icon? {
        return when (file.extension) {
            "hurl" -> Icons.HURL_ICON
            else -> null
        }
    }
}
