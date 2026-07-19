package ch.qligier.jetbrains.plugin.hurlevent.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes.*;

%%

%class HurlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%{
  private int braceDepth = 0;
  private int stateBeforeTemplate = YYINITIAL;
  private int stateAfterValue = YYINITIAL;
%}

// Basic patterns
NEWLINE = \r\n | \r | \n
WS = [ \t]+
DIGIT = [0-9]
ALPHA = [a-zA-Z]
COMMENT_LINE = "#" [^\r\n]*

// Numbers
INTEGER = "-"? {DIGIT}+
FLOAT = "-"? {DIGIT}+ "." {DIGIT}+
STATUS_CODE_VAL = [1-5] {DIGIT} {DIGIT}

// Strings
QUOTED_STRING_CONTENT = \" ([^\"\\\r\n] | \\.)* \"
BACKTICK_STRING_CONTENT = ` ([^`\\\r\n] | \\.)* `
REGEX_STRING_CONTENT = \/ ([^\/\\\r\n] | \\.)* \/

// URL
URL_CHAR = [^ \t\r\n\#{}]
URL = ({ALPHA}+ "://" | "/") {URL_CHAR}*

// Key (for headers and key-value pairs)
KEY_CHAR = [a-zA-Z0-9\-_.]
KEY = {ALPHA} {KEY_CHAR}*

// HTTP Version
HTTP_VERSION_VAL = "HTTP" | ("HTTP/" ("1.0" | "1.1" | "2" | "3" | "*"))

// Template
TEMPLATE_OPEN = "{{"
TEMPLATE_CLOSE = "}}"
TEMPLATE_VAR_NAME = [a-zA-Z_] [a-zA-Z0-9_\-]*

// Value characters (everything except newline/comment/template)
VALUE_CHAR = [^\r\n\#{}]
// Non-whitespace value characters (for value states that also match keywords)
NONWS_VALUE_CHAR = [^\r\n\#{} \t]

// Hex data
HEX_DIGIT = [0-9a-fA-F]

// Multiline
MULTILINE_OPEN = "```" [a-zA-Z]*
MULTILINE_CLOSE = "```"

%state URL_STATE
%state HEADER_STATE
%state HEADER_VALUE_STATE
%state ASSERT_STATE
%state CAPTURE_KEY_STATE
%state CAPTURE_STATE
%state OPTIONS_STATE
%state OPTIONS_VALUE_STATE
%state KV_VALUE_STATE
%state MULTILINE_STRING_STATE
%state TEMPLATE_STATE
%state JSON_BODY_STATE
%state STATUS_LINE_STATE
%state KEY_VALUE_STATE
%state BODY_STATE
%state HEX_VALUE_STATE

%%

<YYINITIAL> {
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }

    // HTTP Methods -> transition to URL
    "GET"                      { yybegin(URL_STATE); return GET; }
    "POST"                     { yybegin(URL_STATE); return POST; }
    "PUT"                      { yybegin(URL_STATE); return PUT; }
    "DELETE"                   { yybegin(URL_STATE); return DELETE; }
    "PATCH"                    { yybegin(URL_STATE); return PATCH; }
    "HEAD"                     { yybegin(URL_STATE); return HEAD; }
    "OPTIONS"                  { yybegin(URL_STATE); return OPTIONS; }
    "CONNECT"                  { yybegin(URL_STATE); return CONNECT; }
    "TRACE"                    { yybegin(URL_STATE); return TRACE; }
    "LINK"                     { yybegin(URL_STATE); return LINK; }
    "UNLINK"                   { yybegin(URL_STATE); return UNLINK; }
    "PURGE"                    { yybegin(URL_STATE); return PURGE; }
    "LOCK"                     { yybegin(URL_STATE); return LOCK; }
    "UNLOCK"                   { yybegin(URL_STATE); return UNLOCK; }
    "PROPFIND"                 { yybegin(URL_STATE); return PROPFIND; }
    "PROPPATCH"                { yybegin(URL_STATE); return PROPPATCH; }
    "COPY"                     { yybegin(URL_STATE); return COPY; }
    "MOVE"                     { yybegin(URL_STATE); return MOVE; }
    "MKCOL"                    { yybegin(URL_STATE); return MKCOL; }
    "REPORT"                   { yybegin(URL_STATE); return REPORT; }
    "SEARCH"                   { yybegin(URL_STATE); return SEARCH; }

    // HTTP Version (response line start)
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    // Sections
    "[QueryStringParams]"      { yybegin(KEY_VALUE_STATE); return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { yybegin(KEY_VALUE_STATE); return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { yybegin(KEY_VALUE_STATE); return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { yybegin(KEY_VALUE_STATE); return SECTION_COOKIES; }
    "[BasicAuth]"              { yybegin(KEY_VALUE_STATE); return SECTION_BASIC_AUTH; }
    "[Options]"                { yybegin(OPTIONS_STATE); return SECTION_OPTIONS; }
    "[Captures]"               { yybegin(CAPTURE_KEY_STATE); return SECTION_CAPTURES; }
    "[Asserts]"                { yybegin(ASSERT_STATE); return SECTION_ASSERTS; }

    // Body markers
    {MULTILINE_OPEN}           { yybegin(MULTILINE_STRING_STATE); return MULTILINE_STRING_OPEN; }

    // JSON body detection
    "{"                        { braceDepth = 1; yybegin(JSON_BODY_STATE); return LBRACE; }
    "["                        { yybegin(BODY_STATE); return LBRACKET; }

    // File/base64/hex body
    "file,"                    { return FILE_PREFIX; }
    "base64,"                  { return BASE64_PREFIX; }
    "hex,"                     { return HEX_PREFIX; }

    // Template
    {TEMPLATE_OPEN}            { stateBeforeTemplate = YYINITIAL; yybegin(TEMPLATE_STATE); return LBRACE2; }

    // Anything else that looks like a header key followed by colon
    {KEY} / ":"                { yybegin(HEADER_STATE); return HEADER_KEY; }

    .                          { return BAD_CHARACTER; }
}

<URL_STATE> {
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = URL_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    {URL}                      { return URL_VALUE; }
    {URL_CHAR}+                { return URL_VALUE; }
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { yybegin(YYINITIAL); return NEWLINE; }
    .                          { return BAD_CHARACTER; }
}

<HEADER_STATE> {
    ":"                        { yybegin(HEADER_VALUE_STATE); return COLON; }
    {WS}                       { return WHITE_SPACE; }
    {NEWLINE}                  { yybegin(YYINITIAL); return NEWLINE; }
    .                          { return BAD_CHARACTER; }
}

<HEADER_VALUE_STATE> {
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = HEADER_VALUE_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    {VALUE_CHAR}+              { return HEADER_VALUE; }
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { yybegin(YYINITIAL); return NEWLINE; }
}

<STATUS_LINE_STATE> {
    {WS}                       { return WHITE_SPACE; }
    {STATUS_CODE_VAL}          { return STATUS_CODE; }
    "*"                        { return STAR; }
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { yybegin(YYINITIAL); return NEWLINE; }
    .                          { return BAD_CHARACTER; }
}

// ==================== KEY_VALUE_STATE ====================
// For [QueryStringParams], [FormParams], [Cookies], etc.
// Recognizes KEY : then transitions to KV_VALUE_STATE for the value
<KEY_VALUE_STATE> {
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = KEY_VALUE_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }

    // Detect transition out of section
    "GET" / {WS}               { yybegin(URL_STATE); return GET; }
    "POST" / {WS}              { yybegin(URL_STATE); return POST; }
    "PUT" / {WS}               { yybegin(URL_STATE); return PUT; }
    "DELETE" / {WS}            { yybegin(URL_STATE); return DELETE; }
    "PATCH" / {WS}             { yybegin(URL_STATE); return PATCH; }
    "HEAD" / {WS}              { yybegin(URL_STATE); return HEAD; }
    "OPTIONS" / {WS}           { yybegin(URL_STATE); return OPTIONS; }
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    "[QueryStringParams]"      { return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { return SECTION_COOKIES; }
    "[BasicAuth]"              { return SECTION_BASIC_AUTH; }
    "[Options]"                { yybegin(OPTIONS_STATE); return SECTION_OPTIONS; }
    "[Captures]"               { yybegin(CAPTURE_KEY_STATE); return SECTION_CAPTURES; }
    "[Asserts]"                { yybegin(ASSERT_STATE); return SECTION_ASSERTS; }

    // Multiline body in section context
    {MULTILINE_OPEN}           { yybegin(MULTILINE_STRING_STATE); return MULTILINE_STRING_OPEN; }

    // Strings
    {QUOTED_STRING_CONTENT}    { return QUOTED_STRING; }
    {BACKTICK_STRING_CONTENT}  { return BACKTICK_STRING; }
    {REGEX_STRING_CONTENT}     { return REGEX_STRING; }

    // Colon transitions to value state
    ":"                        { stateAfterValue = KEY_VALUE_STATE; yybegin(KV_VALUE_STATE); return COLON; }

    "file,"                    { return FILE_PREFIX; }
    {KEY}                      { return KEY_STRING; }

    .                          { return BAD_CHARACTER; }
}

// Value part of key-value pairs (after the colon)
<KV_VALUE_STATE> {
    {TEMPLATE_OPEN}            { stateBeforeTemplate = KV_VALUE_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { yybegin(stateAfterValue); return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {QUOTED_STRING_CONTENT}    { return QUOTED_STRING; }
    {BACKTICK_STRING_CONTENT}  { return BACKTICK_STRING; }
    "true"                     { return TRUE; }
    "false"                    { return FALSE; }
    "null"                     { return NULL; }
    {FLOAT}                    { return FLOAT_NUMBER; }
    {INTEGER}                  { return NUMBER; }
    "file,"                    { return FILE_PREFIX; }
    {NONWS_VALUE_CHAR}+        { return VALUE_STRING; }
}
// ==================== ASSERT_STATE ====================
<ASSERT_STATE> {
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = ASSERT_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }

    // Exit assert on method/version/section
    "GET" / {WS}               { yybegin(URL_STATE); return GET; }
    "POST" / {WS}              { yybegin(URL_STATE); return POST; }
    "PUT" / {WS}               { yybegin(URL_STATE); return PUT; }
    "DELETE" / {WS}            { yybegin(URL_STATE); return DELETE; }
    "PATCH" / {WS}             { yybegin(URL_STATE); return PATCH; }
    "HEAD" / {WS}              { yybegin(URL_STATE); return HEAD; }
    "OPTIONS" / {WS}           { yybegin(URL_STATE); return OPTIONS; }
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    "[QueryStringParams]"      { yybegin(KEY_VALUE_STATE); return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { yybegin(KEY_VALUE_STATE); return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { yybegin(KEY_VALUE_STATE); return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { yybegin(KEY_VALUE_STATE); return SECTION_COOKIES; }
    "[BasicAuth]"              { yybegin(KEY_VALUE_STATE); return SECTION_BASIC_AUTH; }
    "[Options]"                { yybegin(OPTIONS_STATE); return SECTION_OPTIONS; }
    "[Captures]"               { yybegin(CAPTURE_KEY_STATE); return SECTION_CAPTURES; }
    "[Asserts]"                { return SECTION_ASSERTS; }

    // Query keywords
    "body"                     { return KW_BODY; }
    "bytes"                    { return KW_BYTES; }
    "certificate"              { return KW_CERTIFICATE; }
    "cookie"                   { return KW_COOKIE; }
    "duration"                 { return KW_DURATION; }
    "header"                   { return KW_HEADER; }
    "ip"                       { return KW_IP; }
    "jsonpath"                 { return KW_JSONPATH; }
    "md5"                      { return KW_MD5; }
    "rawbytes"                 { return KW_RAWBYTES; }
    "redirects"                { return KW_REDIRECTS; }
    "regex"                    { return KW_REGEX; }
    "sha256"                   { return KW_SHA256; }
    "status"                   { return KW_STATUS; }
    "url"                      { return KW_URL; }
    "variable"                 { return KW_VARIABLE; }
    "xpath"                    { return KW_XPATH; }

    // Predicate keywords
    "not"                      { return KW_NOT; }
    "equals"                   { return KW_EQUALS; }
    "notEquals"                { return KW_NOT_EQUALS; }
    "greaterThan"              { return KW_GREATER_THAN; }
    "greaterThanOrEquals"      { return KW_GREATER_THAN_OR_EQUALS; }
    "lessThan"                 { return KW_LESS_THAN; }
    "lessThanOrEquals"         { return KW_LESS_THAN_OR_EQUALS; }
    "startsWith"               { return KW_STARTS_WITH; }
    "endsWith"                 { return KW_ENDS_WITH; }
    "contains"                 { return KW_CONTAINS; }
    "includes"                 { return KW_INCLUDES; }
    "matches"                  { return KW_MATCHES; }
    "exists"                   { return KW_EXISTS; }
    "isEmpty"                  { return KW_IS_EMPTY; }
    "isNumber"                 { return KW_IS_NUMBER; }
    "isString"                 { return KW_IS_STRING; }
    "isBoolean"                { return KW_IS_BOOLEAN; }
    "isCollection"             { return KW_IS_COLLECTION; }
    "isDate"                   { return KW_IS_DATE; }
    "isIsoDate"                { return KW_IS_ISO_DATE; }
    "isFloat"                  { return KW_IS_FLOAT; }
    "isInteger"                { return KW_IS_INTEGER; }

    // Filter keywords
    "base64Decode"             { return KW_BASE64_DECODE; }
    "base64Encode"             { return KW_BASE64_ENCODE; }
    "base64UrlSafeDecode"      { return KW_BASE64_URL_SAFE_DECODE; }
    "base64UrlSafeEncode"      { return KW_BASE64_URL_SAFE_ENCODE; }
    "charsetDecode"            { return KW_CHARSET_DECODE; }
    "count"                    { return KW_COUNT; }
    "dateFormat"               { return KW_DATE_FORMAT; }
    "daysAfterNow"             { return KW_DAYS_AFTER_NOW; }
    "daysBeforeNow"            { return KW_DAYS_BEFORE_NOW; }
    "decode"                   { return KW_DECODE; }
    "first"                    { return KW_FIRST; }
    "format"                   { return KW_FORMAT; } // Deprecated, will be removed in a future version
    "htmlEscape"               { return KW_HTML_ESCAPE; }
    "htmlUnescape"             { return KW_HTML_UNESCAPE; }
    "jsonpath"                 { return KW_JSONPATH; }
    "last"                     { return KW_LAST; }
    "location"                 { return KW_LOCATION; }
    "nth"                      { return KW_NTH; }
    "regex"                    { return KW_REGEX; }
    "replace"                  { return KW_REPLACE; }
    "replaceRegex"             { return KW_REPLACE_REGEX; }
    "split"                    { return KW_SPLIT; }
    "toDate"                   { return KW_TO_DATE; }
    "toFloat"                  { return KW_TO_FLOAT; }
    "toHex"                    { return KW_TO_HEX; }
    "toInt"                    { return KW_TO_INT; }
    "toString"                 { return KW_TO_STRING; }
    "urlDecode"                { return KW_URL_DECODE; }
    "urlEncode"                { return KW_URL_ENCODE; }
    "urlQueryParam"            { return KW_URL_QUERY_PARAM; }
    "utf8Decode"               { return KW_UTF8_DECODE; }
    "utf8Encode"               { return KW_UTF8_ENCODE; }
    "xpath"                    { return KW_XPATH; }

    // Operators
    "=="                       { return EQUALS_OP; }
    "!="                       { return NOT_EQUALS_OP; }
    ">="                       { return GREATER_THAN_OR_EQUALS_OP; }
    ">"                        { return GREATER_THAN_OP; }
    "<="                       { return LESS_THAN_OR_EQUALS_OP; }
    "<"                        { return LESS_THAN_OP; }

    // Literals
    "true"                     { return TRUE; }
    "false"                    { return FALSE; }
    "null"                     { return NULL; }
    {FLOAT}                    { return FLOAT_NUMBER; }
    {INTEGER}                  { return NUMBER; }

    // Strings
    {QUOTED_STRING_CONTENT}    { return QUOTED_STRING; }
    {BACKTICK_STRING_CONTENT}  { return BACKTICK_STRING; }
    {REGEX_STRING_CONTENT}     { return REGEX_STRING; }
    ","                        { return COMMA; }
    ":"                        { return COLON; }
    ";"                        { return SEMICOLON; }

    // Hex value
    "hex,"                     { stateAfterValue = ASSERT_STATE; yybegin(HEX_VALUE_STATE); return HEX_PREFIX; }

    .                          { return BAD_CHARACTER; }
}

// ==================== CAPTURE_KEY_STATE ====================
<CAPTURE_KEY_STATE> {
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { return NEWLINE; }
    {KEY}                      { return KEY_STRING; }
    {WS}                       { return WHITE_SPACE; }
    ":"                        { yybegin(CAPTURE_STATE); return COLON; }

    // Exit capture on method/version/section
    "GET" / {WS}               { yybegin(URL_STATE); return GET; }
    "POST" / {WS}              { yybegin(URL_STATE); return POST; }
    "PUT" / {WS}               { yybegin(URL_STATE); return PUT; }
    "DELETE" / {WS}            { yybegin(URL_STATE); return DELETE; }
    "PATCH" / {WS}             { yybegin(URL_STATE); return PATCH; }
    "HEAD" / {WS}              { yybegin(URL_STATE); return HEAD; }
    "OPTIONS" / {WS}           { yybegin(URL_STATE); return OPTIONS; }
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    "[QueryStringParams]"      { yybegin(KEY_VALUE_STATE); return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { yybegin(KEY_VALUE_STATE); return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { yybegin(KEY_VALUE_STATE); return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { yybegin(KEY_VALUE_STATE); return SECTION_COOKIES; }
    "[BasicAuth]"              { yybegin(KEY_VALUE_STATE); return SECTION_BASIC_AUTH; }
    "[Options]"                { yybegin(OPTIONS_STATE); return SECTION_OPTIONS; }
    "[Captures]"               { return SECTION_CAPTURES; }
    "[Asserts]"                { yybegin(ASSERT_STATE); return SECTION_ASSERTS; }

    .                          { return BAD_CHARACTER; }
}

// ==================== CAPTURE_STATE ====================
<CAPTURE_STATE> {
    {COMMENT_LINE}             { yybegin(CAPTURE_KEY_STATE); return COMMENT; }
    {NEWLINE}                  { yybegin(CAPTURE_KEY_STATE); return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = CAPTURE_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }

    // Exit capture on method/version/section
    "GET" / {WS}               { yybegin(URL_STATE); return GET; }
    "POST" / {WS}              { yybegin(URL_STATE); return POST; }
    "PUT" / {WS}               { yybegin(URL_STATE); return PUT; }
    "DELETE" / {WS}            { yybegin(URL_STATE); return DELETE; }
    "PATCH" / {WS}             { yybegin(URL_STATE); return PATCH; }
    "HEAD" / {WS}              { yybegin(URL_STATE); return HEAD; }
    "OPTIONS" / {WS}           { yybegin(URL_STATE); return OPTIONS; }
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    "[QueryStringParams]"      { yybegin(KEY_VALUE_STATE); return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { yybegin(KEY_VALUE_STATE); return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { yybegin(KEY_VALUE_STATE); return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { yybegin(KEY_VALUE_STATE); return SECTION_COOKIES; }
    "[BasicAuth]"              { yybegin(KEY_VALUE_STATE); return SECTION_BASIC_AUTH; }
    "[Options]"                { yybegin(OPTIONS_STATE); return SECTION_OPTIONS; }
    "[Captures]"               { return SECTION_CAPTURES; }
    "[Asserts]"                { yybegin(ASSERT_STATE); return SECTION_ASSERTS; }

    // Query keywords
    "status"                   { return KW_STATUS; }
    "url"                      { return KW_URL; }
    "header"                   { return KW_HEADER; }
    "cookie"                   { return KW_COOKIE; }
    "body"                     { return KW_BODY; }
    "xpath"                    { return KW_XPATH; }
    "jsonpath"                 { return KW_JSONPATH; }
    "regex"                    { return KW_REGEX; }
    "variable"                 { return KW_VARIABLE; }
    "duration"                 { return KW_DURATION; }
    "sha256"                   { return KW_SHA256; }
    "md5"                      { return KW_MD5; }
    "bytes"                    { return KW_BYTES; }
    "certificate"              { return KW_CERTIFICATE; }

    // Filter keywords (used in captures)
    // Note: that list SHALL be the same as in ASSERT_STATE!
    "base64Decode"             { return KW_BASE64_DECODE; }
    "base64Encode"             { return KW_BASE64_ENCODE; }
    "base64UrlSafeDecode"      { return KW_BASE64_URL_SAFE_DECODE; }
    "base64UrlSafeEncode"      { return KW_BASE64_URL_SAFE_ENCODE; }
    "charsetDecode"            { return KW_CHARSET_DECODE; }
    "count"                    { return KW_COUNT; }
    "dateFormat"               { return KW_DATE_FORMAT; }
    "daysAfterNow"             { return KW_DAYS_AFTER_NOW; }
    "daysBeforeNow"            { return KW_DAYS_BEFORE_NOW; }
    "decode"                   { return KW_DECODE; }
    "first"                    { return KW_FIRST; }
    "format"                   { return KW_FORMAT; } // Deprecated, will be removed in a future version
    "htmlEscape"               { return KW_HTML_ESCAPE; }
    "htmlUnescape"             { return KW_HTML_UNESCAPE; }
    "jsonpath"                 { return KW_JSONPATH; }
    "last"                     { return KW_LAST; }
    "location"                 { return KW_LOCATION; }
    "nth"                      { return KW_NTH; }
    "regex"                    { return KW_REGEX; }
    "replace"                  { return KW_REPLACE; }
    "replaceRegex"             { return KW_REPLACE_REGEX; }
    "split"                    { return KW_SPLIT; }
    "toDate"                   { return KW_TO_DATE; }
    "toFloat"                  { return KW_TO_FLOAT; }
    "toHex"                    { return KW_TO_HEX; }
    "toInt"                    { return KW_TO_INT; }
    "toString"                 { return KW_TO_STRING; }
    "urlDecode"                { return KW_URL_DECODE; }
    "urlEncode"                { return KW_URL_ENCODE; }
    "urlQueryParam"            { return KW_URL_QUERY_PARAM; }
    "utf8Decode"               { return KW_UTF8_DECODE; }
    "utf8Encode"               { return KW_UTF8_ENCODE; }
    "xpath"                    { return KW_XPATH; }

    // Special
    "redact"                   { return KW_REDACT; }

    // Strings
    {QUOTED_STRING_CONTENT}    { return QUOTED_STRING; }
    {BACKTICK_STRING_CONTENT}  { return BACKTICK_STRING; }
    {REGEX_STRING_CONTENT}     { return REGEX_STRING; }
    ","                        { return COMMA; }

    .                          { return BAD_CHARACTER; }
}

// ==================== OPTIONS_STATE ====================
// Recognizes option keyword keys, colon transitions to OPTIONS_VALUE_STATE
<OPTIONS_STATE> {
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = OPTIONS_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }

    // Exit options on method/version/section
    "GET" / {WS}               { yybegin(URL_STATE); return GET; }
    "POST" / {WS}              { yybegin(URL_STATE); return POST; }
    "PUT" / {WS}               { yybegin(URL_STATE); return PUT; }
    "DELETE" / {WS}            { yybegin(URL_STATE); return DELETE; }
    "PATCH" / {WS}             { yybegin(URL_STATE); return PATCH; }
    "HEAD" / {WS}              { yybegin(URL_STATE); return HEAD; }
    "OPTIONS" / {WS}           { yybegin(URL_STATE); return OPTIONS; }
    {HTTP_VERSION_VAL}         { yybegin(STATUS_LINE_STATE); return HTTP_VERSION; }

    "[QueryStringParams]"      { yybegin(KEY_VALUE_STATE); return SECTION_QUERY_STRING_PARAMS; }
    "[FormParams]"             { yybegin(KEY_VALUE_STATE); return SECTION_FORM_PARAMS; }
    "[MultipartFormData]"      { yybegin(KEY_VALUE_STATE); return SECTION_MULTIPART_FORM_DATA; }
    "[Cookies]"                { yybegin(KEY_VALUE_STATE); return SECTION_COOKIES; }
    "[BasicAuth]"              { yybegin(KEY_VALUE_STATE); return SECTION_BASIC_AUTH; }
    "[Options]"                { return SECTION_OPTIONS; }
    "[Captures]"               { yybegin(CAPTURE_KEY_STATE); return SECTION_CAPTURES; }
    "[Asserts]"                { yybegin(ASSERT_STATE); return SECTION_ASSERTS; }

    // Option keys
    "aws-sigv4"                { return KW_AWS_SIGV4; }
    "cacert"                   { return KW_CACERT; }
    "cert"                     { return KW_CERT; }
    "compressed"               { return KW_COMPRESSED; }
    "connect-to"               { return KW_CONNECT_TO; }
    "delay"                    { return KW_DELAY; }
    "http1.0"                  { return KW_HTTP10; }
    "http1.1"                  { return KW_HTTP11; }
    "http2"                    { return KW_HTTP2; }
    "http3"                    { return KW_HTTP3; }
    "insecure"                 { return KW_INSECURE; }
    "ipv4"                     { return KW_IPVF; }
    "ipv6"                     { return KW_IPVS; }
    "key"                      { return KW_KEY; }
    "location"                 { return KW_LOCATION; }
    "location-trusted"         { return KW_LOCATION_TRUSTED; }
    "max-redirs"               { return KW_MAX_REDIRS; }
    "output"                   { return KW_OUTPUT; }
    "path-as-is"               { return KW_PATH_AS_IS; }
    "proxy"                    { return KW_PROXY; }
    "resolve"                  { return KW_RESOLVE; }
    "retry"                    { return KW_RETRY; }
    "retry-interval"           { return KW_RETRY_INTERVAL; }
    "skip"                     { return KW_SKIP; }
    "unix-socket"              { return KW_UNIX_SOCKET; }
    "user"                     { return KW_USER; }
    "verbose"                  { return KW_VERBOSE; }
    "very-verbose"             { return KW_VERY_VERBOSE; }
    "variable"                 { return KW_VARIABLE; }

    // Colon transitions to value state
    ":"                        { yybegin(OPTIONS_VALUE_STATE); return COLON; }

    // Fallback key
    {KEY}                      { return KEY_STRING; }

    .                          { return BAD_CHARACTER; }
}

// Value part of option entries (after the colon)
<OPTIONS_VALUE_STATE> {
    {TEMPLATE_OPEN}            { stateBeforeTemplate = OPTIONS_VALUE_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    {COMMENT_LINE}             { return COMMENT; }
    {NEWLINE}                  { yybegin(OPTIONS_STATE); return NEWLINE; }
    {WS}                       { return WHITE_SPACE; }
    {QUOTED_STRING_CONTENT}    { return QUOTED_STRING; }
    {BACKTICK_STRING_CONTENT}  { return BACKTICK_STRING; }
    "true"                     { return TRUE; }
    "false"                    { return FALSE; }
    "null"                     { return NULL; }
    {FLOAT}                    { return FLOAT_NUMBER; }
    {INTEGER}                  { return NUMBER; }
    {NONWS_VALUE_CHAR}+        { return VALUE_STRING; }
}

// ==================== MULTILINE_STRING_STATE ====================
<MULTILINE_STRING_STATE> {
    {MULTILINE_CLOSE}          { yybegin(YYINITIAL); return MULTILINE_STRING_CLOSE; }
    {TEMPLATE_OPEN}            { stateBeforeTemplate = MULTILINE_STRING_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    [^\r\n`{]+                 { return MULTILINE_STRING_CONTENT; }
    "`" / [^`]                 { return MULTILINE_STRING_CONTENT; }
    "`" / "`" [^`]             { return MULTILINE_STRING_CONTENT; }
    "{" / [^{]                 { return MULTILINE_STRING_CONTENT; }
    {NEWLINE}                  { return MULTILINE_STRING_CONTENT; }
    .                          { return MULTILINE_STRING_CONTENT; }
}

// ==================== TEMPLATE_STATE ====================
<TEMPLATE_STATE> {
    {WS}                       { return WHITE_SPACE; }
    {TEMPLATE_VAR_NAME}        { return TEMPLATE_VAR; }
    {TEMPLATE_CLOSE}           { yybegin(stateBeforeTemplate); return RBRACE2; }
    .                          { return BAD_CHARACTER; }
}

// ==================== JSON_BODY_STATE ====================
<JSON_BODY_STATE> {
    {TEMPLATE_OPEN}            { stateBeforeTemplate = JSON_BODY_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    "{"                        { braceDepth++; return JSON_TEXT; }
    "}"                        {
                                   braceDepth--;
                                   if (braceDepth <= 0) {
                                       yybegin(YYINITIAL);
                                       return RBRACE;
                                   }
                                   return JSON_TEXT;
                               }
    [^\r\n{}]+                 { return JSON_TEXT; }
    {NEWLINE}                  { return JSON_TEXT; }
}

// ==================== HEX_VALUE_STATE ====================
// Entered after "hex," is matched; produces HEX_DATA and terminates on ";"
<HEX_VALUE_STATE> {
    {WS}                       { return WHITE_SPACE; }
    {HEX_DIGIT}+               { return HEX_DATA; }
    ";"                        { yybegin(stateAfterValue); return SEMICOLON; }
    {NEWLINE}                  { yybegin(stateAfterValue); return NEWLINE; }
    .                          { return BAD_CHARACTER; }
}

// ==================== BODY_STATE ====================
<BODY_STATE> {
    {TEMPLATE_OPEN}            { stateBeforeTemplate = BODY_STATE; yybegin(TEMPLATE_STATE); return LBRACE2; }
    {NEWLINE} / {NEWLINE}      { yybegin(YYINITIAL); return NEWLINE; }
    {NEWLINE}                  { return BODY_DATA; }
    [^\r\n{]+                  { return BODY_DATA; }
    "{" / [^{]                 { return BODY_DATA; }
}

// Fallback for any state
[^]                            { return BAD_CHARACTER; }
