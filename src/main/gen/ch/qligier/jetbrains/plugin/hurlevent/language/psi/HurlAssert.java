// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlAssert extends PsiElement {

  @NotNull
  List<HurlFilter> getFilterList();

  @NotNull
  List<HurlLineBreak> getLineBreakList();

  @Nullable
  HurlPredicate getPredicate();

  @NotNull
  HurlQuery getQuery();

  @Nullable
  HurlSpace getSpace();

}
