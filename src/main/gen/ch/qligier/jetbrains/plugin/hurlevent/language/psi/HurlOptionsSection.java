// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlOptionsSection extends PsiElement {

  @NotNull
  List<HurlLineBreak> getLineBreakList();

  @NotNull
  List<HurlOption> getOptionList();

  @NotNull
  PsiElement getTOptionsSection();

}
