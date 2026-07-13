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

public class HurlCaptureImpl extends HurlPsiImplUtil implements HurlCapture {

  public HurlCaptureImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitCapture(this);
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
  public HurlKeyString getKeyString() {
    return findNotNullChildByClass(HurlKeyString.class);
  }

  @Override
  @NotNull
  public List<HurlLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlLineBreak.class);
  }

  @Override
  @Nullable
  public HurlQuery getQuery() {
    return findChildByClass(HurlQuery.class);
  }

  @Override
  @Nullable
  public HurlSpace getSpace() {
    return findChildByClass(HurlSpace.class);
  }

  @Override
  @Nullable
  public PsiElement getTColon() {
    return findChildByType(T_COLON);
  }

  @Override
  @Nullable
  public PsiElement getTRedactKeyword() {
    return findChildByType(T_REDACT_KEYWORD);
  }

}
