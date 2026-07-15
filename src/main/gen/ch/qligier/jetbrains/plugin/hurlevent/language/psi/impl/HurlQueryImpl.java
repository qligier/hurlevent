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

public class HurlQueryImpl extends ASTWrapperPsiElement implements HurlQuery {

  public HurlQueryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitQuery(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlBodyQuery getBodyQuery() {
    return findChildByClass(HurlBodyQuery.class);
  }

  @Override
  @Nullable
  public HurlBytesQuery getBytesQuery() {
    return findChildByClass(HurlBytesQuery.class);
  }

  @Override
  @Nullable
  public HurlCertificateQuery getCertificateQuery() {
    return findChildByClass(HurlCertificateQuery.class);
  }

  @Override
  @Nullable
  public HurlCookieQuery getCookieQuery() {
    return findChildByClass(HurlCookieQuery.class);
  }

  @Override
  @Nullable
  public HurlDurationQuery getDurationQuery() {
    return findChildByClass(HurlDurationQuery.class);
  }

  @Override
  @Nullable
  public HurlHeaderQuery getHeaderQuery() {
    return findChildByClass(HurlHeaderQuery.class);
  }

  @Override
  @Nullable
  public HurlJsonpathQuery getJsonpathQuery() {
    return findChildByClass(HurlJsonpathQuery.class);
  }

  @Override
  @Nullable
  public HurlMd5Query getMd5Query() {
    return findChildByClass(HurlMd5Query.class);
  }

  @Override
  @Nullable
  public HurlRegexQuery getRegexQuery() {
    return findChildByClass(HurlRegexQuery.class);
  }

  @Override
  @Nullable
  public HurlSha256Query getSha256Query() {
    return findChildByClass(HurlSha256Query.class);
  }

  @Override
  @Nullable
  public HurlStatusQuery getStatusQuery() {
    return findChildByClass(HurlStatusQuery.class);
  }

  @Override
  @Nullable
  public HurlUrlQuery getUrlQuery() {
    return findChildByClass(HurlUrlQuery.class);
  }

  @Override
  @Nullable
  public HurlVariableQuery getVariableQuery() {
    return findChildByClass(HurlVariableQuery.class);
  }

  @Override
  @Nullable
  public HurlXpathQuery getXpathQuery() {
    return findChildByClass(HurlXpathQuery.class);
  }

}
