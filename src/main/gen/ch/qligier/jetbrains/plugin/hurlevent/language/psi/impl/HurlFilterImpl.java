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

public class HurlFilterImpl extends HurlPsiImplUtil implements HurlFilter {

  public HurlFilterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilter(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlFilterArg getFilterArg() {
    return findChildByClass(HurlFilterArg.class);
  }

  @Override
  @NotNull
  public HurlFilterType getFilterType() {
    return findNotNullChildByClass(HurlFilterType.class);
  }

  @Override
  @NotNull
  public HurlSpace getSpace() {
    return findNotNullChildByClass(HurlSpace.class);
  }

}
