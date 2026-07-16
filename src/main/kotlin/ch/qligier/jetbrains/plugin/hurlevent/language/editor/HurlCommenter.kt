/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.editor

import com.intellij.lang.Commenter

/**
 * Defines the support for "Comment with Line Comment" in the Hurl language.
 *
 * @see [Comment Code](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html.comment-code)
 * @see [Commenter](https://plugins.jetbrains.com/docs/intellij/commenter.html)
 */
internal class HurlCommenter : Commenter {
    override fun getLineCommentPrefix(): String = "#"

    override fun getBlockCommentPrefix(): String? = null

    override fun getBlockCommentSuffix(): String? = null

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null
}
