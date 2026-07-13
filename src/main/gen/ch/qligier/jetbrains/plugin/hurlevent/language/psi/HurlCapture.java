// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlCapture extends PsiElement {

  @NotNull
  List<HurlFilter> getFilterList();

  @NotNull
  HurlKeyString getKeyString();

  @NotNull
  List<HurlLineBreak> getLineBreakList();

  @Nullable
  HurlQuery getQuery();

  @Nullable
  HurlSpace getSpace();

  @Nullable
  PsiElement getTColon();

  @Nullable
  PsiElement getTRedactKeyword();

}
