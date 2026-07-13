package ch.qligier.jetbrains.plugin.hurlevent.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlElementTypes;

%%

%class HurlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%caseless
%state IN_MULTILINE_STRING
%state IN_EXPR

// Line terminators
LineTerminator = \r|\n|\r\n|\u2028|\u2029|\u0085
WhiteSpace = [ \t\f]+

// Numbers and strings
Digit = [0-9]
HexDigit = [0-9a-fA-F]
Integer = {Digit}+
Float = {Digit}+ "." {Digit}+ ([eE][+-]? {Digit}+)?
HexByte = {HexDigit}{HexDigit}

// Identifiers and keywords
Identifier = [a-zA-Z_][a-zA-Z0-9_-]*

// HTTP
Method = GET|HEAD|POST|PUT|DELETE|CONNECT|OPTIONS|TRACE|PATCH|PRI|QUERY
HttpVersion = HTTP\/1\.0|HTTP\/1\.1|HTTP\/2|HTTP

// Paths and filenames
FileChars = [^ \t\r\n:;,]+
PathChars = [^ \t\r\n]+

// JSON-like patterns
JsonStart = \{
JsonEnd = \}
JsonBracketStart = \[
JsonBracketEnd = \]

// Template expressions - balanced braces
TemplateStart = \{\{
TemplateEnd = \}\}
TemplateExprStart = \{\{#
TemplateExprEnd = \}\}

// Section headers
SectionHeader = \[[^\]]+\]

// Comments
Comment = (#[^\r\n]*)

// String content handling
StringContent = [^\"\\]+
StringEnd = \"
StringStart = \"

%%

<YYINITIAL> {
  // HTTP
  {Method}                                 { return HurlElementTypes.T_METHOD; }
  {HttpVersion}                            { return HurlElementTypes.T_HTTP_VERSION; }

  // Section headers
  \[BasicAuth\]                            { return HurlElementTypes.T_BASIC_AUTH_SECTION; }
  \[QueryStringParams\]                    { return HurlElementTypes.T_QUERY_STRING_PARAMS_SECTION; }
  \[Query\]                                { return HurlElementTypes.T_QUERY_STRING_PARAMS_SECTION; }
  \[FormParams\]                           { return HurlElementTypes.T_FORM_PARAMS_SECTION; }
  \[Form\]                                 { return HurlElementTypes.T_FORM_PARAMS_SECTION; }
  \[MultipartFormData\]                    { return HurlElementTypes.T_MULTIPART_FORM_DATA_SECTION; }
  \[Multipart\]                            { return HurlElementTypes.T_MULTIPART_FORM_DATA_SECTION; }
  \[Cookies\]                              { return HurlElementTypes.T_COOKIES_SECTION; }
  \[Options\]                              { return HurlElementTypes.T_OPTIONS_SECTION; }
  \[Captures\]                             { return HurlElementTypes.T_CAPTURES_SECTION; }
  \[Asserts\]                              { return HurlElementTypes.T_ASSERTS_SECTION; }

  // Option keywords
  aws-sigv4                                { return HurlElementTypes.T_AWS_SIGV4_OPTION; }
  cacert                                   { return HurlElementTypes.T_CACERT_OPTION; }
  cert                                     { return HurlElementTypes.T_CERT_OPTION; }
  key                                      { return HurlElementTypes.T_KEY_OPTION; }
  compressed                               { return HurlElementTypes.T_COMPRESSED_OPTION; }
  connect-to                               { return HurlElementTypes.T_CONNECT_TO_OPTION; }
  connect-timeout                          { return HurlElementTypes.T_CONNECT_TIMEOUT_OPTION; }
  delay                                    { return HurlElementTypes.T_DELAY_OPTION; }
  location                                 { return HurlElementTypes.T_LOCATION_OPTION; }
  location-trusted                         { return HurlElementTypes.T_LOCATION_TRUSTED_OPTION; }
  header                                   { return HurlElementTypes.T_HEADER_OPTION; }
  http1\.0                                 { return HurlElementTypes.T_HTTP10_OPTION; }
  http1\.1                                 { return HurlElementTypes.T_HTTP11_OPTION; }
  http2                                    { return HurlElementTypes.T_HTTP2_OPTION; }
  http3                                    { return HurlElementTypes.T_HTTP3_OPTION; }
  insecure                                 { return HurlElementTypes.T_INSECURE_OPTION; }
  ipv4                                     { return HurlElementTypes.T_IPV4_OPTION; }
  ipv6                                     { return HurlElementTypes.T_IPV6_OPTION; }
  limit-rate                               { return HurlElementTypes.T_LIMIT_RATE_OPTION; }
  max-redirs                               { return HurlElementTypes.T_MAX_REDIRS_OPTION; }
  max-time                                 { return HurlElementTypes.T_MAX_TIME_OPTION; }
  netrc                                    { return HurlElementTypes.T_NETRC_OPTION; }
  netrc-file                               { return HurlElementTypes.T_NETRC_FILE_OPTION; }
  netrc-optional                           { return HurlElementTypes.T_NETRC_OPTIONAL_OPTION; }
  output                                   { return HurlElementTypes.T_OUTPUT_OPTION; }
  path-as-is                               { return HurlElementTypes.T_PATH_AS_IS_OPTION; }
  pinnedpubkey                             { return HurlElementTypes.T_PINNEDPUBKEY_OPTION; }
  proxy                                    { return HurlElementTypes.T_PROXY_OPTION; }
  resolve                                  { return HurlElementTypes.T_RESOLVE_OPTION; }
  repeat                                   { return HurlElementTypes.T_REPEAT_OPTION; }
  retry                                    { return HurlElementTypes.T_RETRY_OPTION; }
  retry-interval                           { return HurlElementTypes.T_RETRY_INTERVAL_OPTION; }
  skip                                     { return HurlElementTypes.T_SKIP_OPTION; }
  unix-socket                              { return HurlElementTypes.T_UNIX_SOCKET_OPTION; }
  user                                     { return HurlElementTypes.T_USER_OPTION; }
  variable                                 { return HurlElementTypes.T_VARIABLE_OPTION; }
  verbose                                  { return HurlElementTypes.T_VERBOSE_OPTION; }
  very-verbose                             { return HurlElementTypes.T_VERY_VERBOSE_OPTION; }

  // Predicate keywords
  equals|==                                { return HurlElementTypes.T_EQUALS_PREDICATE; }
  "!="                                     { return HurlElementTypes.T_NOT_EQUALS_PREDICATE; }
  greaterThan|>                            { return HurlElementTypes.T_GREATER_THAN_PREDICATE; }
  greaterThanOrEquals|>=                   { return HurlElementTypes.T_GTE_PREDICATE; }
  lessThan|<                               { return HurlElementTypes.T_LESS_THAN_PREDICATE; }
  lessThanOrEquals|<=                      { return HurlElementTypes.T_LTE_PREDICATE; }
  startsWith                               { return HurlElementTypes.T_STARTS_WITH_PREDICATE; }
  endsWith                                 { return HurlElementTypes.T_ENDS_WITH_PREDICATE; }
  contains                                 { return HurlElementTypes.T_CONTAINS_PREDICATE; }
  includes                                 { return HurlElementTypes.T_INCLUDES_PREDICATE; }
  matches                                  { return HurlElementTypes.T_MATCHES_PREDICATE; }
  exists                                   { return HurlElementTypes.T_EXISTS_PREDICATE; }
  isInteger                                { return HurlElementTypes.T_IS_INTEGER_PREDICATE; }
  isFloat                                  { return HurlElementTypes.T_IS_FLOAT_PREDICATE; }
  isBoolean                                { return HurlElementTypes.T_IS_BOOLEAN_PREDICATE; }
  isString                                 { return HurlElementTypes.T_IS_STRING_PREDICATE; }
  isCollection                             { return HurlElementTypes.T_IS_COLLECTION_PREDICATE; }
  isEmpty                                  { return HurlElementTypes.T_IS_EMPTY_PREDICATE; }
  isNull                                   { return HurlElementTypes.T_IS_NULL_PREDICATE; }

  // Filter keywords
  count                                    { return HurlElementTypes.T_COUNT_FILTER; }
  urlDecode                                { return HurlElementTypes.T_URL_DECODE_FILTER; }
  urlEncode                                { return HurlElementTypes.T_URL_ENCODE_FILTER; }
  htmlDecode                               { return HurlElementTypes.T_HTML_DECODE_FILTER; }
  htmlEncode                               { return HurlElementTypes.T_HTML_ENCODE_FILTER; }
  base64                                   { return HurlElementTypes.T_BASE64_FILTER; }
  base64Decode                             { return HurlElementTypes.T_BASE64_DECODE_FILTER; }
  base32                                   { return HurlElementTypes.T_BASE32_FILTER; }
  base32Decode                             { return HurlElementTypes.T_BASE32_DECODE_FILTER; }
  sha1                                     { return HurlElementTypes.T_SHA1_FILTER; }
  sha256                                   { return HurlElementTypes.T_SHA256_FILTER; }
  sha512                                   { return HurlElementTypes.T_SHA512_FILTER; }
  md5                                      { return HurlElementTypes.T_MD5_FILTER; }
  split                                    { return HurlElementTypes.T_SPLIT_FILTER; }
  "["                                      { return HurlElementTypes.T_LBRACKET; }
  "]"                                      { return HurlElementTypes.T_RBRACKET; }
  join                                     { return HurlElementTypes.T_JOIN_FILTER; }
  ltrimChars                               { return HurlElementTypes.T_LTRIM_CHARS_FILTER; }
  rtrimChars                               { return HurlElementTypes.T_RTRIM_CHARS_FILTER; }
  trimChars                                { return HurlElementTypes.T_TRIM_CHARS_FILTER; }
  ltrim                                    { return HurlElementTypes.T_LTRIM_FILTER; }
  rtrim                                    { return HurlElementTypes.T_RTRIM_FILTER; }
  trim                                     { return HurlElementTypes.T_TRIM_FILTER; }
  replace                                  { return HurlElementTypes.T_REPLACE_FILTER; }

  // Query types
  jsonpath|"$."                            { return HurlElementTypes.T_JSONPATH_QUERY; }
  xpath                                    { return HurlElementTypes.T_XPATH_QUERY; }
  regex                                    { return HurlElementTypes.T_REGEX_QUERY; }
  cookie                                   { return HurlElementTypes.T_COOKIE_QUERY; }
  header                                   { return HurlElementTypes.T_HEADER_QUERY; }
  "status"                                 { return HurlElementTypes.T_STATUS_QUERY; }
  "url"                                    { return HurlElementTypes.T_URL_QUERY; }
  "body"                                   { return HurlElementTypes.T_BODY_QUERY; }
  "bytes"                                  { return HurlElementTypes.T_BYTES_QUERY; }
  "duration"                               { return HurlElementTypes.T_DURATION_QUERY; }
  "ssl"                                    { return HurlElementTypes.T_SSL_QUERY; }
  "certificate"                            { return HurlElementTypes.T_CERTIFICATE_QUERY; }

  // Keywords
  true|false                               { return HurlElementTypes.T_BOOLEAN; }
  null                                     { return HurlElementTypes.T_NULL; }
  file                                     { return HurlElementTypes.T_FILE_KEYWORD; }
  redact                                   { return HurlElementTypes.T_REDACT_KEYWORD; }

  // Strings (double quoted)
  \"                                       { yybegin(IN_MULTILINE_STRING); return HurlElementTypes.T_STRING_START; }

  // Literals and syntax
  ":"                                      { return HurlElementTypes.T_COLON; }
  "="                                      { return HurlElementTypes.T_EQUALS; }
  ";"                                      { return HurlElementTypes.T_SEMICOLON; }
  ","                                      { return HurlElementTypes.T_COMMA; }
  "{"                                      { return HurlElementTypes.T_LBRACE; }
  "}"                                      { return HurlElementTypes.T_RBRACE; }
  "("                                      { return HurlElementTypes.T_LPAREN; }
  ")"                                      { return HurlElementTypes.T_RPAREN; }

  // Numbers
  {Float}                                  { return HurlElementTypes.T_FLOAT_LITERAL; }
  {Integer}                                { return HurlElementTypes.T_INTEGER_LITERAL; }

  // Durations
  {Integer}ms                              { return HurlElementTypes.T_DURATION_MS; }
  {Integer}s                               { return HurlElementTypes.T_DURATION_S; }
  {Integer}m                               { return HurlElementTypes.T_DURATION_M; }

  // Hex bytes
  {HexByte}                                { return HurlElementTypes.T_HEX_BYTE; }

  // Identifiers (must be after keywords)
  {Identifier}                             { return HurlElementTypes.T_IDENTIFIER; }

  // URLs
  (https?|ftp):\/\/[^ \t\r\n]+             { return HurlElementTypes.T_URL; }

  // Whitespace and newlines
  {WhiteSpace}                             { return HurlElementTypes.WHITE_SPACE; }
  {LineTerminator}                         { return HurlElementTypes.T_LINE_BREAK; }

  {Comment}                                { return HurlElementTypes.T_COMMENT; }

  .                                        { return TokenType.BAD_CHARACTER; }

  <<EOF>>                                  { return null; }
}

<IN_MULTILINE_STRING> {
  \"                                       { yybegin(YYINITIAL); return HurlElementTypes.T_STRING_END; }
  \\\"                                     { return HurlElementTypes.T_ESCAPED_CHAR; }
  \\\\                                     { return HurlElementTypes.T_ESCAPED_CHAR; }
  \\\{\{                                   { return HurlElementTypes.T_ESCAPED_TEMPLATE; }
  \{\{                                     { yybegin(IN_EXPR); return HurlElementTypes.T_TEMPLATE_START; }
  [^\"\\]+                                 { return HurlElementTypes.T_STRING_CONTENT; }
  \\[0-9a-fA-F]{4}                         { return HurlElementTypes.T_UNICODE_ESCAPE; }
  \\[btnfr\"\\]                            { return HurlElementTypes.T_ESCAPED_CHAR; }
  .                                        { return TokenType.BAD_CHARACTER; }
  <<EOF>>                                  { yybegin(YYINITIAL); return HurlElementTypes.T_STRING_END; }
}

<IN_EXPR> {
  \}\}                                     { yybegin(IN_MULTILINE_STRING); return HurlElementTypes.T_TEMPLATE_END; }
  {Identifier}                             { return HurlElementTypes.T_TEMPLATE_IDENTIFIER; }
  {Integer}                                { return HurlElementTypes.T_TEMPLATE_NUMBER; }
  "."                                      { return HurlElementTypes.T_DOT; }
  "["                                      { return HurlElementTypes.T_LBRACKET; }
  "]"                                      { return HurlElementTypes.T_RBRACKET; }
  {WhiteSpace}                             { return HurlElementTypes.T_SPACE; }
  .                                        { return TokenType.BAD_CHARACTER; }
  <<EOF>>                                  { yybegin(YYINITIAL); return HurlElementTypes.T_TEMPLATE_END; }
}

[^] { return TokenType.BAD_CHARACTER; }
