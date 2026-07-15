// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlFilter extends PsiElement {

  @Nullable
  HurlCountFilter getCountFilter();

  @Nullable
  HurlDecodeFilter getDecodeFilter();

  @Nullable
  HurlFormatFilter getFormatFilter();

  @Nullable
  HurlHtmlEscapeFilter getHtmlEscapeFilter();

  @Nullable
  HurlHtmlUnescapeFilter getHtmlUnescapeFilter();

  @Nullable
  HurlNthFilter getNthFilter();

  @Nullable
  HurlReplaceFilter getReplaceFilter();

  @Nullable
  HurlSplitFilter getSplitFilter();

  @Nullable
  HurlToDateFilter getToDateFilter();

  @Nullable
  HurlToFloatFilter getToFloatFilter();

  @Nullable
  HurlToIntFilter getToIntFilter();

  @Nullable
  HurlUrlDecodeFilter getUrlDecodeFilter();

  @Nullable
  HurlUrlEncodeFilter getUrlEncodeFilter();

}
