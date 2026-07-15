// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlQuery extends PsiElement {

  @Nullable
  HurlBodyQuery getBodyQuery();

  @Nullable
  HurlBytesQuery getBytesQuery();

  @Nullable
  HurlCertificateQuery getCertificateQuery();

  @Nullable
  HurlCookieQuery getCookieQuery();

  @Nullable
  HurlDurationQuery getDurationQuery();

  @Nullable
  HurlHeaderQuery getHeaderQuery();

  @Nullable
  HurlJsonpathQuery getJsonpathQuery();

  @Nullable
  HurlMd5Query getMd5Query();

  @Nullable
  HurlRegexQuery getRegexQuery();

  @Nullable
  HurlSha256Query getSha256Query();

  @Nullable
  HurlStatusQuery getStatusQuery();

  @Nullable
  HurlUrlQuery getUrlQuery();

  @Nullable
  HurlVariableQuery getVariableQuery();

  @Nullable
  HurlXpathQuery getXpathQuery();

}
