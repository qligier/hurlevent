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

public class HurlQueryTypeImpl extends HurlPsiImplUtil implements HurlQueryType {

  public HurlQueryTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitQueryType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTBodyQuery() {
    return findChildByType(T_BODY_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTBytesQuery() {
    return findChildByType(T_BYTES_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTCertificateQuery() {
    return findChildByType(T_CERTIFICATE_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTCookieQuery() {
    return findChildByType(T_COOKIE_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTDurationQuery() {
    return findChildByType(T_DURATION_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTHeaderQuery() {
    return findChildByType(T_HEADER_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTJsonpathQuery() {
    return findChildByType(T_JSONPATH_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTRegexQuery() {
    return findChildByType(T_REGEX_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTSslQuery() {
    return findChildByType(T_SSL_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTStatusQuery() {
    return findChildByType(T_STATUS_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTUrlQuery() {
    return findChildByType(T_URL_QUERY);
  }

  @Override
  @Nullable
  public PsiElement getTXpathQuery() {
    return findChildByType(T_XPATH_QUERY);
  }

}
