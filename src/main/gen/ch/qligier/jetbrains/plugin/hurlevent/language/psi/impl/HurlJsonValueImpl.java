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

public class HurlJsonValueImpl extends HurlPsiImplUtil implements HurlJsonValue {

  public HurlJsonValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitJsonValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlJsonArray getJsonArray() {
    return findChildByClass(HurlJsonArray.class);
  }

  @Override
  @Nullable
  public HurlJsonNumber getJsonNumber() {
    return findChildByClass(HurlJsonNumber.class);
  }

  @Override
  @Nullable
  public HurlJsonObject getJsonObject() {
    return findChildByClass(HurlJsonObject.class);
  }

  @Override
  @Nullable
  public HurlJsonString getJsonString() {
    return findChildByClass(HurlJsonString.class);
  }

  @Override
  @Nullable
  public PsiElement getTBoolean() {
    return findChildByType(T_BOOLEAN);
  }

  @Override
  @Nullable
  public PsiElement getTNull() {
    return findChildByType(T_NULL);
  }

}
