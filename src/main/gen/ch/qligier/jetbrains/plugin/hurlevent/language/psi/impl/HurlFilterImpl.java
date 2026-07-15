// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.*;

public class HurlFilterImpl extends ASTWrapperPsiElement implements HurlFilter {

  public HurlFilterImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilter(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlCountFilter getCountFilter() {
    return findChildByClass(HurlCountFilter.class);
  }

  @Override
  @Nullable
  public HurlDecodeFilter getDecodeFilter() {
    return findChildByClass(HurlDecodeFilter.class);
  }

  @Override
  @Nullable
  public HurlFormatFilter getFormatFilter() {
    return findChildByClass(HurlFormatFilter.class);
  }

  @Override
  @Nullable
  public HurlHtmlEscapeFilter getHtmlEscapeFilter() {
    return findChildByClass(HurlHtmlEscapeFilter.class);
  }

  @Override
  @Nullable
  public HurlHtmlUnescapeFilter getHtmlUnescapeFilter() {
    return findChildByClass(HurlHtmlUnescapeFilter.class);
  }

  @Override
  @Nullable
  public HurlNthFilter getNthFilter() {
    return findChildByClass(HurlNthFilter.class);
  }

  @Override
  @Nullable
  public HurlReplaceFilter getReplaceFilter() {
    return findChildByClass(HurlReplaceFilter.class);
  }

  @Override
  @Nullable
  public HurlSplitFilter getSplitFilter() {
    return findChildByClass(HurlSplitFilter.class);
  }

  @Override
  @Nullable
  public HurlToDateFilter getToDateFilter() {
    return findChildByClass(HurlToDateFilter.class);
  }

  @Override
  @Nullable
  public HurlToFloatFilter getToFloatFilter() {
    return findChildByClass(HurlToFloatFilter.class);
  }

  @Override
  @Nullable
  public HurlToIntFilter getToIntFilter() {
    return findChildByClass(HurlToIntFilter.class);
  }

  @Override
  @Nullable
  public HurlUrlDecodeFilter getUrlDecodeFilter() {
    return findChildByClass(HurlUrlDecodeFilter.class);
  }

  @Override
  @Nullable
  public HurlUrlEncodeFilter getUrlEncodeFilter() {
    return findChildByClass(HurlUrlEncodeFilter.class);
  }

}
