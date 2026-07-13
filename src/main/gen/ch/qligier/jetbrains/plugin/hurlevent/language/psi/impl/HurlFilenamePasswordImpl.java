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

public class HurlFilenamePasswordImpl extends HurlPsiImplUtil implements HurlFilenamePassword {

  public HurlFilenamePasswordImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilenamePassword(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HurlFilename getFilename() {
    return findNotNullChildByClass(HurlFilename.class);
  }

  @Override
  @Nullable
  public HurlStringLiteral getStringLiteral() {
    return findChildByClass(HurlStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getTColon() {
    return findChildByType(T_COLON);
  }

}
