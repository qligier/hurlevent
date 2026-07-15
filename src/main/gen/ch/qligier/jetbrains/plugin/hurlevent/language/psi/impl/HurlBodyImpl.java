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

public class HurlBodyImpl extends ASTWrapperPsiElement implements HurlBody {

  public HurlBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlBase64Body getBase64Body() {
    return findChildByClass(HurlBase64Body.class);
  }

  @Override
  @Nullable
  public HurlFileBody getFileBody() {
    return findChildByClass(HurlFileBody.class);
  }

  @Override
  @Nullable
  public HurlHexBody getHexBody() {
    return findChildByClass(HurlHexBody.class);
  }

  @Override
  @Nullable
  public HurlJsonBody getJsonBody() {
    return findChildByClass(HurlJsonBody.class);
  }

  @Override
  @Nullable
  public HurlMultilineStringBody getMultilineStringBody() {
    return findChildByClass(HurlMultilineStringBody.class);
  }

  @Override
  @Nullable
  public HurlRawBody getRawBody() {
    return findChildByClass(HurlRawBody.class);
  }

  @Override
  @Nullable
  public HurlXmlBody getXmlBody() {
    return findChildByClass(HurlXmlBody.class);
  }

}
