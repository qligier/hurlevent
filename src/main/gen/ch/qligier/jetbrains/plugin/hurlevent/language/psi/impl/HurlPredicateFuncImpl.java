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

public class HurlPredicateFuncImpl extends ASTWrapperPsiElement implements HurlPredicateFunc {

  public HurlPredicateFuncImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitPredicateFunc(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlContainsPredicate getContainsPredicate() {
    return findChildByClass(HurlContainsPredicate.class);
  }

  @Override
  @Nullable
  public HurlEndsWithPredicate getEndsWithPredicate() {
    return findChildByClass(HurlEndsWithPredicate.class);
  }

  @Override
  @Nullable
  public HurlEqualsPredicate getEqualsPredicate() {
    return findChildByClass(HurlEqualsPredicate.class);
  }

  @Override
  @Nullable
  public HurlExistsPredicate getExistsPredicate() {
    return findChildByClass(HurlExistsPredicate.class);
  }

  @Override
  @Nullable
  public HurlGreaterThanOrEqualsPredicate getGreaterThanOrEqualsPredicate() {
    return findChildByClass(HurlGreaterThanOrEqualsPredicate.class);
  }

  @Override
  @Nullable
  public HurlGreaterThanPredicate getGreaterThanPredicate() {
    return findChildByClass(HurlGreaterThanPredicate.class);
  }

  @Override
  @Nullable
  public HurlIncludesPredicate getIncludesPredicate() {
    return findChildByClass(HurlIncludesPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsBooleanPredicate getIsBooleanPredicate() {
    return findChildByClass(HurlIsBooleanPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsCollectionPredicate getIsCollectionPredicate() {
    return findChildByClass(HurlIsCollectionPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsDatePredicate getIsDatePredicate() {
    return findChildByClass(HurlIsDatePredicate.class);
  }

  @Override
  @Nullable
  public HurlIsEmptyPredicate getIsEmptyPredicate() {
    return findChildByClass(HurlIsEmptyPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsFloatPredicate getIsFloatPredicate() {
    return findChildByClass(HurlIsFloatPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsIntegerPredicate getIsIntegerPredicate() {
    return findChildByClass(HurlIsIntegerPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsIsoDatePredicate getIsIsoDatePredicate() {
    return findChildByClass(HurlIsIsoDatePredicate.class);
  }

  @Override
  @Nullable
  public HurlIsNumberPredicate getIsNumberPredicate() {
    return findChildByClass(HurlIsNumberPredicate.class);
  }

  @Override
  @Nullable
  public HurlIsStringPredicate getIsStringPredicate() {
    return findChildByClass(HurlIsStringPredicate.class);
  }

  @Override
  @Nullable
  public HurlLessThanOrEqualsPredicate getLessThanOrEqualsPredicate() {
    return findChildByClass(HurlLessThanOrEqualsPredicate.class);
  }

  @Override
  @Nullable
  public HurlLessThanPredicate getLessThanPredicate() {
    return findChildByClass(HurlLessThanPredicate.class);
  }

  @Override
  @Nullable
  public HurlMatchesPredicate getMatchesPredicate() {
    return findChildByClass(HurlMatchesPredicate.class);
  }

  @Override
  @Nullable
  public HurlNotEqualsPredicate getNotEqualsPredicate() {
    return findChildByClass(HurlNotEqualsPredicate.class);
  }

  @Override
  @Nullable
  public HurlOperatorPredicate getOperatorPredicate() {
    return findChildByClass(HurlOperatorPredicate.class);
  }

  @Override
  @Nullable
  public HurlStartsWithPredicate getStartsWithPredicate() {
    return findChildByClass(HurlStartsWithPredicate.class);
  }

}
