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

public class HurlRequestImpl extends HurlPsiImplUtil implements HurlRequest {

  public HurlRequestImpl(ASTNode node) {
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
  public List<HurlHeader> getHeaderList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlHeader.class);
  }

  @Override
  @NotNull
  public List<HurlLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlLineBreak.class);
  }

  @Override
  @NotNull
  public HurlMethod getMethod() {
    return findNotNullChildByClass(HurlMethod.class);
  }

  @Override
  @NotNull
  public List<HurlRequestSection> getRequestSectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlRequestSection.class);
  }

  @Override
  @Nullable
  public HurlSpace getSpace() {
    return findChildByClass(HurlSpace.class);
  }

  @Override
  @Nullable
  public HurlUrl getUrl() {
    return findChildByClass(HurlUrl.class);
  }

}
