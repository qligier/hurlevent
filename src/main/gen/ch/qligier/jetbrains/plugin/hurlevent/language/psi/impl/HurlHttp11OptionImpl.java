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

public class HurlHttp11OptionImpl extends HurlPsiImplUtil implements HurlHttp11Option {

  public HurlHttp11OptionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitHttp11Option(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HurlBooleanOption getBooleanOption() {
    return findNotNullChildByClass(HurlBooleanOption.class);
  }

  @Override
  @NotNull
  public PsiElement getTColon() {
    return findNotNullChildByType(T_COLON);
  }

  @Override
  @NotNull
  public PsiElement getTHttp11Option() {
    return findNotNullChildByType(T_HTTP11_OPTION);
  }

}
