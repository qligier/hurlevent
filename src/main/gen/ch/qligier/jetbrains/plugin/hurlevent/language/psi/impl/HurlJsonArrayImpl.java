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

public class HurlJsonArrayImpl extends HurlPsiImplUtil implements HurlJsonArray {

  public HurlJsonArrayImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitJsonArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlJsonValue> getJsonValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlJsonValue.class);
  }

  @Override
  @NotNull
  public PsiElement getTLbracket() {
    return findNotNullChildByType(T_LBRACKET);
  }

  @Override
  @NotNull
  public PsiElement getTRbracket() {
    return findNotNullChildByType(T_RBRACKET);
  }

}
