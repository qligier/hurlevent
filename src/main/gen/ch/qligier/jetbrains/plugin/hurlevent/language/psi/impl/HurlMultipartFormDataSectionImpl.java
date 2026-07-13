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

public class HurlMultipartFormDataSectionImpl extends HurlPsiImplUtil implements HurlMultipartFormDataSection {

  public HurlMultipartFormDataSectionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitMultipartFormDataSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlLineBreak.class);
  }

  @Override
  @NotNull
  public List<HurlMultipartFormDataParam> getMultipartFormDataParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlMultipartFormDataParam.class);
  }

  @Override
  @NotNull
  public PsiElement getTMultipartFormDataSection() {
    return findNotNullChildByType(T_MULTIPART_FORM_DATA_SECTION);
  }

}
