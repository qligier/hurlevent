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

public class HurlEntryImpl extends HurlPsiImplUtil implements HurlEntry {

  public HurlEntryImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitEntry(this);
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
  public HurlRequest getRequest() {
    return findNotNullChildByClass(HurlRequest.class);
  }

  @Override
  @Nullable
  public HurlResponse getResponse() {
    return findChildByClass(HurlResponse.class);
  }

}
