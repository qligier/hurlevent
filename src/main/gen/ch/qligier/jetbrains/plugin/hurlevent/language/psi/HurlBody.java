// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlBody extends PsiElement {

  @Nullable
  HurlBase64Body getBase64Body();

  @Nullable
  HurlFileBody getFileBody();

  @Nullable
  HurlHexBody getHexBody();

  @Nullable
  HurlJsonBody getJsonBody();

  @Nullable
  HurlMultilineStringBody getMultilineStringBody();

  @Nullable
  HurlRawBody getRawBody();

  @Nullable
  HurlXmlBody getXmlBody();

}
