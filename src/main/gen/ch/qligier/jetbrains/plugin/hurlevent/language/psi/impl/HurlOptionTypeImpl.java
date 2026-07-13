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

public class HurlOptionTypeImpl extends HurlPsiImplUtil implements HurlOptionType {

  public HurlOptionTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitOptionType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlAwsSigv4Option getAwsSigv4Option() {
    return findChildByClass(HurlAwsSigv4Option.class);
  }

  @Override
  @Nullable
  public HurlCacertOption getCacertOption() {
    return findChildByClass(HurlCacertOption.class);
  }

  @Override
  @Nullable
  public HurlCertOption getCertOption() {
    return findChildByClass(HurlCertOption.class);
  }

  @Override
  @Nullable
  public HurlCompressedOption getCompressedOption() {
    return findChildByClass(HurlCompressedOption.class);
  }

  @Override
  @Nullable
  public HurlConnectTimeoutOption getConnectTimeoutOption() {
    return findChildByClass(HurlConnectTimeoutOption.class);
  }

  @Override
  @Nullable
  public HurlConnectToOption getConnectToOption() {
    return findChildByClass(HurlConnectToOption.class);
  }

  @Override
  @Nullable
  public HurlDelayOption getDelayOption() {
    return findChildByClass(HurlDelayOption.class);
  }

  @Override
  @Nullable
  public HurlHeaderOption getHeaderOption() {
    return findChildByClass(HurlHeaderOption.class);
  }

  @Override
  @Nullable
  public HurlHttp10Option getHttp10Option() {
    return findChildByClass(HurlHttp10Option.class);
  }

  @Override
  @Nullable
  public HurlHttp11Option getHttp11Option() {
    return findChildByClass(HurlHttp11Option.class);
  }

  @Override
  @Nullable
  public HurlHttp2Option getHttp2Option() {
    return findChildByClass(HurlHttp2Option.class);
  }

  @Override
  @Nullable
  public HurlHttp3Option getHttp3Option() {
    return findChildByClass(HurlHttp3Option.class);
  }

  @Override
  @Nullable
  public HurlInsecureOption getInsecureOption() {
    return findChildByClass(HurlInsecureOption.class);
  }

  @Override
  @Nullable
  public HurlIpv4Option getIpv4Option() {
    return findChildByClass(HurlIpv4Option.class);
  }

  @Override
  @Nullable
  public HurlIpv6Option getIpv6Option() {
    return findChildByClass(HurlIpv6Option.class);
  }

  @Override
  @Nullable
  public HurlKeyOption getKeyOption() {
    return findChildByClass(HurlKeyOption.class);
  }

  @Override
  @Nullable
  public HurlLimitRateOption getLimitRateOption() {
    return findChildByClass(HurlLimitRateOption.class);
  }

  @Override
  @Nullable
  public HurlLocationOption getLocationOption() {
    return findChildByClass(HurlLocationOption.class);
  }

  @Override
  @Nullable
  public HurlLocationTrustedOption getLocationTrustedOption() {
    return findChildByClass(HurlLocationTrustedOption.class);
  }

  @Override
  @Nullable
  public HurlMaxRedirsOption getMaxRedirsOption() {
    return findChildByClass(HurlMaxRedirsOption.class);
  }

  @Override
  @Nullable
  public HurlMaxTimeOption getMaxTimeOption() {
    return findChildByClass(HurlMaxTimeOption.class);
  }

  @Override
  @Nullable
  public HurlNetrcFileOption getNetrcFileOption() {
    return findChildByClass(HurlNetrcFileOption.class);
  }

  @Override
  @Nullable
  public HurlNetrcOption getNetrcOption() {
    return findChildByClass(HurlNetrcOption.class);
  }

  @Override
  @Nullable
  public HurlNetrcOptionalOption getNetrcOptionalOption() {
    return findChildByClass(HurlNetrcOptionalOption.class);
  }

  @Override
  @Nullable
  public HurlOutputOption getOutputOption() {
    return findChildByClass(HurlOutputOption.class);
  }

  @Override
  @Nullable
  public HurlPathAsIsOption getPathAsIsOption() {
    return findChildByClass(HurlPathAsIsOption.class);
  }

  @Override
  @Nullable
  public HurlPinnedpubkeyOption getPinnedpubkeyOption() {
    return findChildByClass(HurlPinnedpubkeyOption.class);
  }

  @Override
  @Nullable
  public HurlProxyOption getProxyOption() {
    return findChildByClass(HurlProxyOption.class);
  }

  @Override
  @Nullable
  public HurlRepeatOption getRepeatOption() {
    return findChildByClass(HurlRepeatOption.class);
  }

  @Override
  @Nullable
  public HurlResolveOption getResolveOption() {
    return findChildByClass(HurlResolveOption.class);
  }

  @Override
  @Nullable
  public HurlRetryIntervalOption getRetryIntervalOption() {
    return findChildByClass(HurlRetryIntervalOption.class);
  }

  @Override
  @Nullable
  public HurlRetryOption getRetryOption() {
    return findChildByClass(HurlRetryOption.class);
  }

  @Override
  @Nullable
  public HurlSkipOption getSkipOption() {
    return findChildByClass(HurlSkipOption.class);
  }

  @Override
  @Nullable
  public HurlUnixSocketOption getUnixSocketOption() {
    return findChildByClass(HurlUnixSocketOption.class);
  }

  @Override
  @Nullable
  public HurlUserOption getUserOption() {
    return findChildByClass(HurlUserOption.class);
  }

  @Override
  @Nullable
  public HurlVariableOption getVariableOption() {
    return findChildByClass(HurlVariableOption.class);
  }

  @Override
  @Nullable
  public HurlVerboseOption getVerboseOption() {
    return findChildByClass(HurlVerboseOption.class);
  }

  @Override
  @Nullable
  public HurlVeryVerboseOption getVeryVerboseOption() {
    return findChildByClass(HurlVeryVerboseOption.class);
  }

}
