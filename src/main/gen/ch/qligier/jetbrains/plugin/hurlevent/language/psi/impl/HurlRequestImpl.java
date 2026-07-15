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

public class HurlRequestImpl extends ASTWrapperPsiElement implements HurlRequest {

  public HurlRequestImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitRequest(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlBody getBody() {
    return findChildByClass(HurlBody.class);
  }

  @Override
  @NotNull
  public HurlRequestLine getRequestLine() {
    return findNotNullChildByClass(HurlRequestLine.class);
  }

  @Override
  @NotNull
  public List<HurlRequestSection> getRequestSectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlRequestSection.class);
  }

}
