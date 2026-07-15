// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.*;

public class HurlAssertsSectionImpl extends ASTWrapperPsiElement implements HurlAssertsSection {

  public HurlAssertsSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitAssertsSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlAssertList getAssertList() {
    return findChildByClass(HurlAssertList.class);
  }

}
