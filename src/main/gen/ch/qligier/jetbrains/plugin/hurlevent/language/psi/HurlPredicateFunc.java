// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlPredicateFunc extends PsiElement {

  @Nullable
  HurlContainsPredicate getContainsPredicate();

  @Nullable
  HurlEndsWithPredicate getEndsWithPredicate();

  @Nullable
  HurlEqualsPredicate getEqualsPredicate();

  @Nullable
  HurlExistsPredicate getExistsPredicate();

  @Nullable
  HurlGreaterThanOrEqualsPredicate getGreaterThanOrEqualsPredicate();

  @Nullable
  HurlGreaterThanPredicate getGreaterThanPredicate();

  @Nullable
  HurlIncludesPredicate getIncludesPredicate();

  @Nullable
  HurlIsBooleanPredicate getIsBooleanPredicate();

  @Nullable
  HurlIsCollectionPredicate getIsCollectionPredicate();

  @Nullable
  HurlIsDatePredicate getIsDatePredicate();

  @Nullable
  HurlIsEmptyPredicate getIsEmptyPredicate();

  @Nullable
  HurlIsFloatPredicate getIsFloatPredicate();

  @Nullable
  HurlIsIntegerPredicate getIsIntegerPredicate();

  @Nullable
  HurlIsIsoDatePredicate getIsIsoDatePredicate();

  @Nullable
  HurlIsNumberPredicate getIsNumberPredicate();

  @Nullable
  HurlIsStringPredicate getIsStringPredicate();

  @Nullable
  HurlLessThanOrEqualsPredicate getLessThanOrEqualsPredicate();

  @Nullable
  HurlLessThanPredicate getLessThanPredicate();

  @Nullable
  HurlMatchesPredicate getMatchesPredicate();

  @Nullable
  HurlNotEqualsPredicate getNotEqualsPredicate();

  @Nullable
  HurlOperatorPredicate getOperatorPredicate();

  @Nullable
  HurlStartsWithPredicate getStartsWithPredicate();

}
