/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class HurlFile(
    viewProvider: FileViewProvider,
) : PsiFileBase(viewProvider, HurlLanguage) {
    override fun getFileType(): FileType = HurlFileType

    override fun toString(): String = "Hurl file"
}

object HurlFileType : LanguageFileType(HurlLanguage) {
    override fun getName(): String = "Hurl file"

    override fun getDescription(): String = "Hurl HTTP testing file"

    override fun getDefaultExtension(): String = "hurl"

    override fun getIcon(): Icon = Icons.HURL_ICON
}
