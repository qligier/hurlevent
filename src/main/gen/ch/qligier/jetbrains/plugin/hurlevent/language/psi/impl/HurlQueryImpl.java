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

public class HurlQueryImpl extends HurlPsiImplUtil implements HurlQuery {

  public HurlQueryImpl(ASTNode node) {
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
  public HurlQueryTarget getQueryTarget() {
    return findChildByClass(HurlQueryTarget.class);
  }

  @Override
  @NotNull
  public HurlQueryType getQueryType() {
    return findNotNullChildByClass(HurlQueryType.class);
  }

}
