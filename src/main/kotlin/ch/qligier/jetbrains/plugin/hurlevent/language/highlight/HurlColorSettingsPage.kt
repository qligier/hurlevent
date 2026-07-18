/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.hurlevent.language.highlight

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.NlsContexts
import org.jetbrains.annotations.NonNls
import javax.swing.Icon

/**
 * The page that allows users to customize the colors used for syntax highlighting in Hurl files.
 *
 * @see [Color Settings](https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#color-settings)
 * @see [Syntax Highlighter and Color Settings Page](https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html)
 **/
internal class HurlColorSettingsPage :
    ColorSettingsPage,
    DumbAware {
    companion object {
        private val ATTRIBUTES_DESCRIPTORS =
            arrayOf(
                AttributesDescriptor("Method", HurlSyntaxHighlighter.METHOD),
                AttributesDescriptor("HTTP version", HurlSyntaxHighlighter.HTTP_VERSION),
                AttributesDescriptor("Status code", HurlSyntaxHighlighter.STATUS_CODE),
                AttributesDescriptor("Section", HurlSyntaxHighlighter.SECTION),
                AttributesDescriptor("Comment", HurlSyntaxHighlighter.COMMENT),
                AttributesDescriptor("URL", HurlSyntaxHighlighter.URL),
            )
    }

    override fun getIcon(): Icon = Icons.HURL_ICON

    override fun getHighlighter(): SyntaxHighlighter = HurlSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getColorDescriptors(): Array<out ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): @NlsContexts.ConfigurableName String = "Hurl"

    override fun getAttributeDescriptors(): Array<out AttributesDescriptor> = ATTRIBUTES_DESCRIPTORS

    override fun getDemoText(): @NonNls String =
        """
# This is a comment
GET http://localhost:8080/api/users
Content-Type: application/json
[QueryStringParams]
page: 1
limit: 10

HTTP 200
[Captures]
token: header "Authorization"
user_id: jsonpath "${'$'}.users[0].id"

[Asserts]
status == 200
header "Content-Type" contains "json"
jsonpath "${'$'}.users" count == 10
body contains "success"

# Create a new user
POST http://localhost:8080/api/users
Content-Type: application/json
[Options]
retry: 3
verbose: true
{
  "name": "John",
  "email": "john@example.com",
  "active": true,
  "age": 30
}

HTTP 201
[Asserts]
jsonpath "${'$'}.id" isInteger
jsonpath "${'$'}.name" == "John"
jsonpath "${'$'}.email" startsWith "john"
jsonpath "${'$'}.active" == true
jsonpath "${'$'}.age" >= 18

# Using variables
GET http://localhost:8080/api/users/{{user_id}}

HTTP 200
[Asserts]
jsonpath "${'$'}.id" == {{user_id}}

# Multiline body
POST http://localhost:8080/api/graphql
```graphql
{
  users {
    id
    name
  }
}
```

HTTP 200
"""
}
