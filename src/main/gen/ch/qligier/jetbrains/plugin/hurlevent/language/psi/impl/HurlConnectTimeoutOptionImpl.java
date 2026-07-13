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

public class HurlConnectTimeoutOptionImpl extends HurlPsiImplUtil implements HurlConnectTimeoutOption {

  public HurlConnectTimeoutOptionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitConnectTimeoutOption(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HurlDurationOption getDurationOption() {
    return findNotNullChildByClass(HurlDurationOption.class);
  }

  @Override
  @NotNull
  public PsiElement getTColon() {
    return findNotNullChildByType(T_COLON);
  }

  @Override
  @NotNull
  public PsiElement getTConnectTimeoutOption() {
    return findNotNullChildByType(T_CONNECT_TIMEOUT_OPTION);
  }

}
