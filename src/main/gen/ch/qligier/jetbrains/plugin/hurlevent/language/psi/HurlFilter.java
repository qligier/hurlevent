// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlFilter extends PsiElement {

  @Nullable
  HurlFilterArg getFilterArg();

  @NotNull
  HurlFilterType getFilterType();

  @NotNull
  HurlSpace getSpace();

}
