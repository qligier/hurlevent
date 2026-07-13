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

public class HurlTemplateExpressionImpl extends HurlPsiImplUtil implements HurlTemplateExpression {

  public HurlTemplateExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitTemplateExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlFilter> getFilterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlFilter.class);
  }

  @Override
  @NotNull
  public List<HurlTemplateVariable> getTemplateVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlTemplateVariable.class);
  }

  @Override
  @Nullable
  public PsiElement getTTemplateEnd() {
    return findChildByType(T_TEMPLATE_END);
  }

  @Override
  @NotNull
  public PsiElement getTTemplateStart() {
    return findNotNullChildByType(T_TEMPLATE_START);
  }

}
