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

public class HurlQueryStringParamsSectionImpl extends HurlPsiImplUtil implements HurlQueryStringParamsSection {

  public HurlQueryStringParamsSectionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitQueryStringParamsSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlKeyValue> getKeyValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlKeyValue.class);
  }

  @Override
  @NotNull
  public List<HurlLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlLineBreak.class);
  }

  @Override
  @NotNull
  public PsiElement getTQueryStringParamsSection() {
    return findNotNullChildByType(T_QUERY_STRING_PARAMS_SECTION);
  }

}
