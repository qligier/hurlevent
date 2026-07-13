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

public class HurlDurationOptionImpl extends HurlPsiImplUtil implements HurlDurationOption {

  public HurlDurationOptionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitDurationOption(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTDurationM() {
    return findChildByType(T_DURATION_M);
  }

  @Override
  @Nullable
  public PsiElement getTDurationMs() {
    return findChildByType(T_DURATION_MS);
  }

  @Override
  @Nullable
  public PsiElement getTDurationS() {
    return findChildByType(T_DURATION_S);
  }

  @Override
  @Nullable
  public PsiElement getTIdentifier() {
    return findChildByType(T_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getTIntegerLiteral() {
    return findChildByType(T_INTEGER_LITERAL);
  }

}
