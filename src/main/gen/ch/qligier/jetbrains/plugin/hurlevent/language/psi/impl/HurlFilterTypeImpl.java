// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlElementTypes.*;
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.*;

public class HurlFilterTypeImpl extends HurlPsiImplUtil implements HurlFilterType {

  public HurlFilterTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilterType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTBase32DecodeFilter() {
    return findChildByType(T_BASE32_DECODE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTBase32Filter() {
    return findChildByType(T_BASE32_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTBase64DecodeFilter() {
    return findChildByType(T_BASE64_DECODE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTBase64Filter() {
    return findChildByType(T_BASE64_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTCountFilter() {
    return findChildByType(T_COUNT_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTHtmlDecodeFilter() {
    return findChildByType(T_HTML_DECODE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTHtmlEncodeFilter() {
    return findChildByType(T_HTML_ENCODE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTJoinFilter() {
    return findChildByType(T_JOIN_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTLtrimCharsFilter() {
    return findChildByType(T_LTRIM_CHARS_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTLtrimFilter() {
    return findChildByType(T_LTRIM_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTMd5Filter() {
    return findChildByType(T_MD5_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTReplaceFilter() {
    return findChildByType(T_REPLACE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTRtrimCharsFilter() {
    return findChildByType(T_RTRIM_CHARS_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTRtrimFilter() {
    return findChildByType(T_RTRIM_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTSha1Filter() {
    return findChildByType(T_SHA1_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTSha256Filter() {
    return findChildByType(T_SHA256_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTSha512Filter() {
    return findChildByType(T_SHA512_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTSplitFilter() {
    return findChildByType(T_SPLIT_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTTrimCharsFilter() {
    return findChildByType(T_TRIM_CHARS_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTTrimFilter() {
    return findChildByType(T_TRIM_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTUrlDecodeFilter() {
    return findChildByType(T_URL_DECODE_FILTER);
  }

  @Override
  @Nullable
  public PsiElement getTUrlEncodeFilter() {
    return findChildByType(T_URL_ENCODE_FILTER);
  }

}
