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

public class HurlPredicateTypeImpl extends HurlPsiImplUtil implements HurlPredicateType {

  public HurlPredicateTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitPredicateType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTContainsPredicate() {
    return findChildByType(T_CONTAINS_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTEndsWithPredicate() {
    return findChildByType(T_ENDS_WITH_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTEqualsPredicate() {
    return findChildByType(T_EQUALS_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTExistsPredicate() {
    return findChildByType(T_EXISTS_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTGreaterThanPredicate() {
    return findChildByType(T_GREATER_THAN_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTGtePredicate() {
    return findChildByType(T_GTE_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIncludesPredicate() {
    return findChildByType(T_INCLUDES_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsBooleanPredicate() {
    return findChildByType(T_IS_BOOLEAN_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsCollectionPredicate() {
    return findChildByType(T_IS_COLLECTION_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsEmptyPredicate() {
    return findChildByType(T_IS_EMPTY_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsFloatPredicate() {
    return findChildByType(T_IS_FLOAT_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsIntegerPredicate() {
    return findChildByType(T_IS_INTEGER_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsNullPredicate() {
    return findChildByType(T_IS_NULL_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTIsStringPredicate() {
    return findChildByType(T_IS_STRING_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTLessThanPredicate() {
    return findChildByType(T_LESS_THAN_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTLtePredicate() {
    return findChildByType(T_LTE_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTMatchesPredicate() {
    return findChildByType(T_MATCHES_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTNotEqualsPredicate() {
    return findChildByType(T_NOT_EQUALS_PREDICATE);
  }

  @Override
  @Nullable
  public PsiElement getTStartsWithPredicate() {
    return findChildByType(T_STARTS_WITH_PREDICATE);
  }

}
