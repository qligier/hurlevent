package ch.qligier.jetbrains.plugin.hurlevent.language.action

import ch.qligier.jetbrains.plugin.hurlevent.common.Icons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NlsContexts
import com.intellij.psi.PsiDirectory
import org.jetbrains.annotations.NonNls

class CreateHurlFileAction :
    CreateFileFromTemplateAction(
        "Hurl File",
        "Create a new Hurl file",
        Icons.HURL_ICON,
    ),
    DumbAware {
    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder,
    ) {
        // `hurl_file` is the name of the template file defined in `resources/fileTemplates/internal/`.
        builder
            .setTitle("New Hurl File")
            .addKind("Hurl file", Icons.HURL_ICON, "hurl_file")
    }

    override fun getActionName(
        directory: PsiDirectory?,
        newName: @NonNls String,
        templateName: @NonNls String?,
    ): @NlsContexts.Command String = "Create Hurl file '$newName'"
}
