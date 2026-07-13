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

public class HurlFilenameValueImpl extends HurlPsiImplUtil implements HurlFilenameValue {

  public HurlFilenameValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitFilenameValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlFilename getFilename() {
    return findChildByClass(HurlFilename.class);
  }

  @Override
  @Nullable
  public HurlStringPart getStringPart() {
    return findChildByClass(HurlStringPart.class);
  }

  @Override
  @Nullable
  public PsiElement getTComma() {
    return findChildByType(T_COMMA);
  }

  @Override
  @NotNull
  public PsiElement getTFileKeyword() {
    return findNotNullChildByType(T_FILE_KEYWORD);
  }

}
