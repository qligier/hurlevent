// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlRequest extends PsiElement {

  @Nullable
  HurlBody getBody();

  @NotNull
  List<HurlHeader> getHeaderList();

  @NotNull
  List<HurlLineBreak> getLineBreakList();

  @NotNull
  HurlMethod getMethod();

  @NotNull
  List<HurlRequestSection> getRequestSectionList();

  @Nullable
  HurlSpace getSpace();

  @Nullable
  HurlUrl getUrl();

}
