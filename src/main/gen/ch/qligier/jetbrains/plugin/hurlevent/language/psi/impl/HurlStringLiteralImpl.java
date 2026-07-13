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

public class HurlStringLiteralImpl extends HurlPsiImplUtil implements HurlStringLiteral {

  public HurlStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitStringLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlTemplateExpression> getTemplateExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlTemplateExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getTStringEnd() {
    return findNotNullChildByType(T_STRING_END);
  }

  @Override
  @NotNull
  public PsiElement getTStringStart() {
    return findNotNullChildByType(T_STRING_START);
  }

}
