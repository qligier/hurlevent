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

public class HurlFilenameParamImpl extends HurlPsiImplUtil implements HurlFilenameParam {

  public HurlFilenameParamImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilenameParam(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlFilenameValue getFilenameValue() {
    return findChildByClass(HurlFilenameValue.class);
  }

  @Override
  @NotNull
  public HurlKeyString getKeyString() {
    return findNotNullChildByClass(HurlKeyString.class);
  }

  @Override
  @NotNull
  public List<HurlLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlLineBreak.class);
  }

  @Override
  @NotNull
  public PsiElement getTColon() {
    return findNotNullChildByType(T_COLON);
  }

}
