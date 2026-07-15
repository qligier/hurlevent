// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ch.qligier.jetbrains.plugin.hurlevent.language.lexer.HurlTokenType;
import ch.qligier.jetbrains.plugin.hurlevent.language.psi.impl.*;

public interface HurlTypes {

  IElementType ASSERTS_SECTION = new HurlElementType("ASSERTS_SECTION");
  IElementType ASSERT_ENTRY = new HurlElementType("ASSERT_ENTRY");
  IElementType ASSERT_LIST = new HurlElementType("ASSERT_LIST");
  IElementType BASE_64_BODY = new HurlElementType("BASE_64_BODY");
  IElementType BASIC_AUTH_SECTION = new HurlElementType("BASIC_AUTH_SECTION");
  IElementType BODY = new HurlElementType("BODY");
  IElementType BODY_QUERY = new HurlElementType("BODY_QUERY");
  IElementType BYTES_QUERY = new HurlElementType("BYTES_QUERY");
  IElementType CAPTURES_SECTION = new HurlElementType("CAPTURES_SECTION");
  IElementType CAPTURE_ENTRY = new HurlElementType("CAPTURE_ENTRY");
  IElementType CAPTURE_LIST = new HurlElementType("CAPTURE_LIST");
  IElementType CERTIFICATE_QUERY = new HurlElementType("CERTIFICATE_QUERY");
  IElementType CONTAINS_PREDICATE = new HurlElementType("CONTAINS_PREDICATE");
  IElementType COOKIES_SECTION = new HurlElementType("COOKIES_SECTION");
  IElementType COOKIE_QUERY = new HurlElementType("COOKIE_QUERY");
  IElementType COUNT_FILTER = new HurlElementType("COUNT_FILTER");
  IElementType DECODE_FILTER = new HurlElementType("DECODE_FILTER");
  IElementType DURATION_QUERY = new HurlElementType("DURATION_QUERY");
  IElementType ENDS_WITH_PREDICATE = new HurlElementType("ENDS_WITH_PREDICATE");
  IElementType ENTRY = new HurlElementType("ENTRY");
  IElementType EQUALS_PREDICATE = new HurlElementType("EQUALS_PREDICATE");
  IElementType EXISTS_PREDICATE = new HurlElementType("EXISTS_PREDICATE");
  IElementType FILE_BODY = new HurlElementType("FILE_BODY");
  IElementType FILTER = new HurlElementType("FILTER");
  IElementType FILTER_LIST = new HurlElementType("FILTER_LIST");
  IElementType FORMAT_FILTER = new HurlElementType("FORMAT_FILTER");
  IElementType FORM_PARAMS_SECTION = new HurlElementType("FORM_PARAMS_SECTION");
  IElementType GREATER_THAN_OR_EQUALS_PREDICATE = new HurlElementType("GREATER_THAN_OR_EQUALS_PREDICATE");
  IElementType GREATER_THAN_PREDICATE = new HurlElementType("GREATER_THAN_PREDICATE");
  IElementType HEADER = new HurlElementType("HEADER");
  IElementType HEADER_QUERY = new HurlElementType("HEADER_QUERY");
  IElementType HEADER_VAL = new HurlElementType("HEADER_VAL");
  IElementType HEX_BODY = new HurlElementType("HEX_BODY");
  IElementType HTML_ESCAPE_FILTER = new HurlElementType("HTML_ESCAPE_FILTER");
  IElementType HTML_UNESCAPE_FILTER = new HurlElementType("HTML_UNESCAPE_FILTER");
  IElementType INCLUDES_PREDICATE = new HurlElementType("INCLUDES_PREDICATE");
  IElementType IS_BOOLEAN_PREDICATE = new HurlElementType("IS_BOOLEAN_PREDICATE");
  IElementType IS_COLLECTION_PREDICATE = new HurlElementType("IS_COLLECTION_PREDICATE");
  IElementType IS_DATE_PREDICATE = new HurlElementType("IS_DATE_PREDICATE");
  IElementType IS_EMPTY_PREDICATE = new HurlElementType("IS_EMPTY_PREDICATE");
  IElementType IS_FLOAT_PREDICATE = new HurlElementType("IS_FLOAT_PREDICATE");
  IElementType IS_INTEGER_PREDICATE = new HurlElementType("IS_INTEGER_PREDICATE");
  IElementType IS_ISO_DATE_PREDICATE = new HurlElementType("IS_ISO_DATE_PREDICATE");
  IElementType IS_NUMBER_PREDICATE = new HurlElementType("IS_NUMBER_PREDICATE");
  IElementType IS_STRING_PREDICATE = new HurlElementType("IS_STRING_PREDICATE");
  IElementType JSONPATH_QUERY = new HurlElementType("JSONPATH_QUERY");
  IElementType JSON_BODY = new HurlElementType("JSON_BODY");
  IElementType JSON_CONTENT = new HurlElementType("JSON_CONTENT");
  IElementType KEY_VALUE_LIST = new HurlElementType("KEY_VALUE_LIST");
  IElementType KEY_VALUE_PAIR = new HurlElementType("KEY_VALUE_PAIR");
  IElementType KV_KEY = new HurlElementType("KV_KEY");
  IElementType LESS_THAN_OR_EQUALS_PREDICATE = new HurlElementType("LESS_THAN_OR_EQUALS_PREDICATE");
  IElementType LESS_THAN_PREDICATE = new HurlElementType("LESS_THAN_PREDICATE");
  IElementType MATCHES_PREDICATE = new HurlElementType("MATCHES_PREDICATE");
  IElementType MD_5_QUERY = new HurlElementType("MD_5_QUERY");
  IElementType METHOD = new HurlElementType("METHOD");
  IElementType MULTILINE_CONTENT = new HurlElementType("MULTILINE_CONTENT");
  IElementType MULTILINE_STRING_BODY = new HurlElementType("MULTILINE_STRING_BODY");
  IElementType MULTIPART_FORM_DATA_SECTION = new HurlElementType("MULTIPART_FORM_DATA_SECTION");
  IElementType NOT_EQUALS_PREDICATE = new HurlElementType("NOT_EQUALS_PREDICATE");
  IElementType NOT_PREDICATE = new HurlElementType("NOT_PREDICATE");
  IElementType NTH_FILTER = new HurlElementType("NTH_FILTER");
  IElementType OPERATOR_PREDICATE = new HurlElementType("OPERATOR_PREDICATE");
  IElementType OPTIONS_SECTION = new HurlElementType("OPTIONS_SECTION");
  IElementType OPTION_ENTRY = new HurlElementType("OPTION_ENTRY");
  IElementType OPTION_KEY = new HurlElementType("OPTION_KEY");
  IElementType OPTION_LIST = new HurlElementType("OPTION_LIST");
  IElementType OPTION_VALUE = new HurlElementType("OPTION_VALUE");
  IElementType PREDICATE = new HurlElementType("PREDICATE");
  IElementType PREDICATE_FUNC = new HurlElementType("PREDICATE_FUNC");
  IElementType PREDICATE_VALUE = new HurlElementType("PREDICATE_VALUE");
  IElementType QUERY = new HurlElementType("QUERY");
  IElementType QUERY_STRING_PARAMS_SECTION = new HurlElementType("QUERY_STRING_PARAMS_SECTION");
  IElementType QUOTED_STRING_VALUE = new HurlElementType("QUOTED_STRING_VALUE");
  IElementType RAW_BODY = new HurlElementType("RAW_BODY");
  IElementType REGEX_QUERY = new HurlElementType("REGEX_QUERY");
  IElementType REPLACE_FILTER = new HurlElementType("REPLACE_FILTER");
  IElementType REQUEST = new HurlElementType("REQUEST");
  IElementType REQUEST_LINE = new HurlElementType("REQUEST_LINE");
  IElementType REQUEST_SECTION = new HurlElementType("REQUEST_SECTION");
  IElementType RESPONSE = new HurlElementType("RESPONSE");
  IElementType RESPONSE_LINE = new HurlElementType("RESPONSE_LINE");
  IElementType RESPONSE_SECTION = new HurlElementType("RESPONSE_SECTION");
  IElementType SHA_256_QUERY = new HurlElementType("SHA_256_QUERY");
  IElementType SPLIT_FILTER = new HurlElementType("SPLIT_FILTER");
  IElementType STARTS_WITH_PREDICATE = new HurlElementType("STARTS_WITH_PREDICATE");
  IElementType STATUS_QUERY = new HurlElementType("STATUS_QUERY");
  IElementType STATUS_VALUE = new HurlElementType("STATUS_VALUE");
  IElementType TEMPLATE = new HurlElementType("TEMPLATE");
  IElementType TO_DATE_FILTER = new HurlElementType("TO_DATE_FILTER");
  IElementType TO_FLOAT_FILTER = new HurlElementType("TO_FLOAT_FILTER");
  IElementType TO_INT_FILTER = new HurlElementType("TO_INT_FILTER");
  IElementType URL = new HurlElementType("URL");
  IElementType URL_DECODE_FILTER = new HurlElementType("URL_DECODE_FILTER");
  IElementType URL_ENCODE_FILTER = new HurlElementType("URL_ENCODE_FILTER");
  IElementType URL_QUERY = new HurlElementType("URL_QUERY");
  IElementType VALUE_CONTENT = new HurlElementType("VALUE_CONTENT");
  IElementType VARIABLE_QUERY = new HurlElementType("VARIABLE_QUERY");
  IElementType XML_BODY = new HurlElementType("XML_BODY");
  IElementType XPATH_QUERY = new HurlElementType("XPATH_QUERY");

  IElementType BACKTICK_STRING = new HurlTokenType("BACKTICK_STRING");
  IElementType BASE64_DATA = new HurlTokenType("BASE64_DATA");
  IElementType BASE64_PREFIX = new HurlTokenType("BASE64_PREFIX");
  IElementType BODY_DATA = new HurlTokenType("BODY_DATA");
  IElementType COLON = new HurlTokenType(":");
  IElementType COMMA = new HurlTokenType(",");
  IElementType COMMENT = new HurlTokenType("COMMENT");
  IElementType CONNECT = new HurlTokenType("CONNECT");
  IElementType COPY = new HurlTokenType("COPY");
  IElementType DELETE = new HurlTokenType("DELETE");
  IElementType DOT = new HurlTokenType(".");
  IElementType EQUALS_OP = new HurlTokenType("==");
  IElementType FALSE = new HurlTokenType("FALSE");
  IElementType FILENAME = new HurlTokenType("FILENAME");
  IElementType FILE_PREFIX = new HurlTokenType("FILE_PREFIX");
  IElementType FLOAT_NUMBER = new HurlTokenType("FLOAT_NUMBER");
  IElementType GET = new HurlTokenType("GET");
  IElementType GREATER_THAN_OP = new HurlTokenType(">");
  IElementType GREATER_THAN_OR_EQUALS_OP = new HurlTokenType(">=");
  IElementType HEAD = new HurlTokenType("HEAD");
  IElementType HEADER_KEY = new HurlTokenType("HEADER_KEY");
  IElementType HEADER_VALUE = new HurlTokenType("HEADER_VALUE");
  IElementType HEX_DATA = new HurlTokenType("HEX_DATA");
  IElementType HEX_PREFIX = new HurlTokenType("HEX_PREFIX");
  IElementType HTTP_VERSION = new HurlTokenType("HTTP_VERSION");
  IElementType JSON_TEXT = new HurlTokenType("JSON_TEXT");
  IElementType KEY_STRING = new HurlTokenType("KEY_STRING");
  IElementType KW_AWS_SIGV4 = new HurlTokenType("KW_AWS_SIGV4");
  IElementType KW_BODY = new HurlTokenType("KW_BODY");
  IElementType KW_BYTES = new HurlTokenType("KW_BYTES");
  IElementType KW_CACERT = new HurlTokenType("KW_CACERT");
  IElementType KW_CERT = new HurlTokenType("KW_CERT");
  IElementType KW_CERTIFICATE = new HurlTokenType("KW_CERTIFICATE");
  IElementType KW_COMPRESSED = new HurlTokenType("KW_COMPRESSED");
  IElementType KW_CONNECT_TO = new HurlTokenType("KW_CONNECT_TO");
  IElementType KW_CONTAINS = new HurlTokenType("KW_CONTAINS");
  IElementType KW_COOKIE = new HurlTokenType("KW_COOKIE");
  IElementType KW_COUNT = new HurlTokenType("KW_COUNT");
  IElementType KW_DECODE = new HurlTokenType("KW_DECODE");
  IElementType KW_DELAY = new HurlTokenType("KW_DELAY");
  IElementType KW_DURATION = new HurlTokenType("KW_DURATION");
  IElementType KW_ENDS_WITH = new HurlTokenType("KW_ENDS_WITH");
  IElementType KW_EQUALS = new HurlTokenType("KW_EQUALS");
  IElementType KW_EXISTS = new HurlTokenType("KW_EXISTS");
  IElementType KW_FORMAT = new HurlTokenType("KW_FORMAT");
  IElementType KW_GREATER_THAN = new HurlTokenType("KW_GREATER_THAN");
  IElementType KW_GREATER_THAN_OR_EQUALS = new HurlTokenType("KW_GREATER_THAN_OR_EQUALS");
  IElementType KW_HEADER = new HurlTokenType("KW_HEADER");
  IElementType KW_HTML_ESCAPE = new HurlTokenType("KW_HTML_ESCAPE");
  IElementType KW_HTML_UNESCAPE = new HurlTokenType("KW_HTML_UNESCAPE");
  IElementType KW_HTTP10 = new HurlTokenType("KW_HTTP10");
  IElementType KW_HTTP11 = new HurlTokenType("KW_HTTP11");
  IElementType KW_HTTP2 = new HurlTokenType("KW_HTTP2");
  IElementType KW_HTTP3 = new HurlTokenType("KW_HTTP3");
  IElementType KW_INCLUDES = new HurlTokenType("KW_INCLUDES");
  IElementType KW_INSECURE = new HurlTokenType("KW_INSECURE");
  IElementType KW_IPVF = new HurlTokenType("KW_IPVF");
  IElementType KW_IPVS = new HurlTokenType("KW_IPVS");
  IElementType KW_IS_BOOLEAN = new HurlTokenType("KW_IS_BOOLEAN");
  IElementType KW_IS_COLLECTION = new HurlTokenType("KW_IS_COLLECTION");
  IElementType KW_IS_DATE = new HurlTokenType("KW_IS_DATE");
  IElementType KW_IS_EMPTY = new HurlTokenType("KW_IS_EMPTY");
  IElementType KW_IS_FLOAT = new HurlTokenType("KW_IS_FLOAT");
  IElementType KW_IS_INTEGER = new HurlTokenType("KW_IS_INTEGER");
  IElementType KW_IS_ISO_DATE = new HurlTokenType("KW_IS_ISO_DATE");
  IElementType KW_IS_NUMBER = new HurlTokenType("KW_IS_NUMBER");
  IElementType KW_IS_STRING = new HurlTokenType("KW_IS_STRING");
  IElementType KW_JSONPATH = new HurlTokenType("KW_JSONPATH");
  IElementType KW_KEY = new HurlTokenType("KW_KEY");
  IElementType KW_LESS_THAN = new HurlTokenType("KW_LESS_THAN");
  IElementType KW_LESS_THAN_OR_EQUALS = new HurlTokenType("KW_LESS_THAN_OR_EQUALS");
  IElementType KW_LOCATION = new HurlTokenType("KW_LOCATION");
  IElementType KW_LOCATION_TRUSTED = new HurlTokenType("KW_LOCATION_TRUSTED");
  IElementType KW_MATCHES = new HurlTokenType("KW_MATCHES");
  IElementType KW_MAX_REDIRS = new HurlTokenType("KW_MAX_REDIRS");
  IElementType KW_MD5 = new HurlTokenType("KW_MD5");
  IElementType KW_NOT = new HurlTokenType("KW_NOT");
  IElementType KW_NOT_EQUALS = new HurlTokenType("KW_NOT_EQUALS");
  IElementType KW_NTH = new HurlTokenType("KW_NTH");
  IElementType KW_OUTPUT = new HurlTokenType("KW_OUTPUT");
  IElementType KW_PATH_AS_IS = new HurlTokenType("KW_PATH_AS_IS");
  IElementType KW_PROXY = new HurlTokenType("KW_PROXY");
  IElementType KW_REGEX = new HurlTokenType("KW_REGEX");
  IElementType KW_REPLACE = new HurlTokenType("KW_REPLACE");
  IElementType KW_RESOLVE = new HurlTokenType("KW_RESOLVE");
  IElementType KW_RETRY = new HurlTokenType("KW_RETRY");
  IElementType KW_RETRY_INTERVAL = new HurlTokenType("KW_RETRY_INTERVAL");
  IElementType KW_SHA256 = new HurlTokenType("KW_SHA256");
  IElementType KW_SKIP = new HurlTokenType("KW_SKIP");
  IElementType KW_SPLIT = new HurlTokenType("KW_SPLIT");
  IElementType KW_STARTS_WITH = new HurlTokenType("KW_STARTS_WITH");
  IElementType KW_STATUS = new HurlTokenType("KW_STATUS");
  IElementType KW_TO_DATE = new HurlTokenType("KW_TO_DATE");
  IElementType KW_TO_FLOAT = new HurlTokenType("KW_TO_FLOAT");
  IElementType KW_TO_INT = new HurlTokenType("KW_TO_INT");
  IElementType KW_UNIX_SOCKET = new HurlTokenType("KW_UNIX_SOCKET");
  IElementType KW_URL = new HurlTokenType("KW_URL");
  IElementType KW_URL_DECODE = new HurlTokenType("KW_URL_DECODE");
  IElementType KW_URL_ENCODE = new HurlTokenType("KW_URL_ENCODE");
  IElementType KW_USER = new HurlTokenType("KW_USER");
  IElementType KW_VARIABLE = new HurlTokenType("KW_VARIABLE");
  IElementType KW_VERBOSE = new HurlTokenType("KW_VERBOSE");
  IElementType KW_VERY_VERBOSE = new HurlTokenType("KW_VERY_VERBOSE");
  IElementType KW_XPATH = new HurlTokenType("KW_XPATH");
  IElementType LBRACE = new HurlTokenType("{");
  IElementType LBRACE2 = new HurlTokenType("{{");
  IElementType LBRACKET = new HurlTokenType("[");
  IElementType LESS_THAN_OP = new HurlTokenType("<");
  IElementType LESS_THAN_OR_EQUALS_OP = new HurlTokenType("<=");
  IElementType LINK = new HurlTokenType("LINK");
  IElementType LOCK = new HurlTokenType("LOCK");
  IElementType LPAREN = new HurlTokenType("(");
  IElementType MKCOL = new HurlTokenType("MKCOL");
  IElementType MOVE = new HurlTokenType("MOVE");
  IElementType MULTILINE_STRING_CLOSE = new HurlTokenType("MULTILINE_STRING_CLOSE");
  IElementType MULTILINE_STRING_CONTENT = new HurlTokenType("MULTILINE_STRING_CONTENT");
  IElementType MULTILINE_STRING_OPEN = new HurlTokenType("MULTILINE_STRING_OPEN");
  IElementType NEWLINE = new HurlTokenType("NEWLINE");
  IElementType NOT_EQUALS_OP = new HurlTokenType("!=");
  IElementType NULL = new HurlTokenType("NULL");
  IElementType NUMBER = new HurlTokenType("NUMBER");
  IElementType OPTIONS = new HurlTokenType("OPTIONS");
  IElementType PATCH = new HurlTokenType("PATCH");
  IElementType POST = new HurlTokenType("POST");
  IElementType PROPFIND = new HurlTokenType("PROPFIND");
  IElementType PROPPATCH = new HurlTokenType("PROPPATCH");
  IElementType PURGE = new HurlTokenType("PURGE");
  IElementType PUT = new HurlTokenType("PUT");
  IElementType QUOTED_STRING = new HurlTokenType("QUOTED_STRING");
  IElementType RBRACE = new HurlTokenType("}");
  IElementType RBRACE2 = new HurlTokenType("}}");
  IElementType RBRACKET = new HurlTokenType("]");
  IElementType REPORT = new HurlTokenType("REPORT");
  IElementType RPAREN = new HurlTokenType(")");
  IElementType SEARCH = new HurlTokenType("SEARCH");
  IElementType SECTION_ASSERTS = new HurlTokenType("SECTION_ASSERTS");
  IElementType SECTION_BASIC_AUTH = new HurlTokenType("SECTION_BASIC_AUTH");
  IElementType SECTION_CAPTURES = new HurlTokenType("SECTION_CAPTURES");
  IElementType SECTION_COOKIES = new HurlTokenType("SECTION_COOKIES");
  IElementType SECTION_FORM_PARAMS = new HurlTokenType("SECTION_FORM_PARAMS");
  IElementType SECTION_MULTIPART_FORM_DATA = new HurlTokenType("SECTION_MULTIPART_FORM_DATA");
  IElementType SECTION_OPTIONS = new HurlTokenType("SECTION_OPTIONS");
  IElementType SECTION_QUERY_STRING_PARAMS = new HurlTokenType("SECTION_QUERY_STRING_PARAMS");
  IElementType SEMICOLON = new HurlTokenType(";");
  IElementType STAR = new HurlTokenType("*");
  IElementType STATUS_CODE = new HurlTokenType("STATUS_CODE");
  IElementType TEMPLATE_VAR = new HurlTokenType("TEMPLATE_VAR");
  IElementType TRACE = new HurlTokenType("TRACE");
  IElementType TRUE = new HurlTokenType("TRUE");
  IElementType UNLINK = new HurlTokenType("UNLINK");
  IElementType UNLOCK = new HurlTokenType("UNLOCK");
  IElementType URL_VALUE = new HurlTokenType("URL_VALUE");
  IElementType VALUE_STRING = new HurlTokenType("VALUE_STRING");
  IElementType XML_TEXT = new HurlTokenType("XML_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSERTS_SECTION) {
        return new HurlAssertsSectionImpl(node);
      }
      else if (type == ASSERT_ENTRY) {
        return new HurlAssertEntryImpl(node);
      }
      else if (type == ASSERT_LIST) {
        return new HurlAssertListImpl(node);
      }
      else if (type == BASE_64_BODY) {
        return new HurlBase64BodyImpl(node);
      }
      else if (type == BASIC_AUTH_SECTION) {
        return new HurlBasicAuthSectionImpl(node);
      }
      else if (type == BODY) {
        return new HurlBodyImpl(node);
      }
      else if (type == BODY_QUERY) {
        return new HurlBodyQueryImpl(node);
      }
      else if (type == BYTES_QUERY) {
        return new HurlBytesQueryImpl(node);
      }
      else if (type == CAPTURES_SECTION) {
        return new HurlCapturesSectionImpl(node);
      }
      else if (type == CAPTURE_ENTRY) {
        return new HurlCaptureEntryImpl(node);
      }
      else if (type == CAPTURE_LIST) {
        return new HurlCaptureListImpl(node);
      }
      else if (type == CERTIFICATE_QUERY) {
        return new HurlCertificateQueryImpl(node);
      }
      else if (type == CONTAINS_PREDICATE) {
        return new HurlContainsPredicateImpl(node);
      }
      else if (type == COOKIES_SECTION) {
        return new HurlCookiesSectionImpl(node);
      }
      else if (type == COOKIE_QUERY) {
        return new HurlCookieQueryImpl(node);
      }
      else if (type == COUNT_FILTER) {
        return new HurlCountFilterImpl(node);
      }
      else if (type == DECODE_FILTER) {
        return new HurlDecodeFilterImpl(node);
      }
      else if (type == DURATION_QUERY) {
        return new HurlDurationQueryImpl(node);
      }
      else if (type == ENDS_WITH_PREDICATE) {
        return new HurlEndsWithPredicateImpl(node);
      }
      else if (type == ENTRY) {
        return new HurlEntryImpl(node);
      }
      else if (type == EQUALS_PREDICATE) {
        return new HurlEqualsPredicateImpl(node);
      }
      else if (type == EXISTS_PREDICATE) {
        return new HurlExistsPredicateImpl(node);
      }
      else if (type == FILE_BODY) {
        return new HurlFileBodyImpl(node);
      }
      else if (type == FILTER) {
        return new HurlFilterImpl(node);
      }
      else if (type == FILTER_LIST) {
        return new HurlFilterListImpl(node);
      }
      else if (type == FORMAT_FILTER) {
        return new HurlFormatFilterImpl(node);
      }
      else if (type == FORM_PARAMS_SECTION) {
        return new HurlFormParamsSectionImpl(node);
      }
      else if (type == GREATER_THAN_OR_EQUALS_PREDICATE) {
        return new HurlGreaterThanOrEqualsPredicateImpl(node);
      }
      else if (type == GREATER_THAN_PREDICATE) {
        return new HurlGreaterThanPredicateImpl(node);
      }
      else if (type == HEADER) {
        return new HurlHeaderImpl(node);
      }
      else if (type == HEADER_QUERY) {
        return new HurlHeaderQueryImpl(node);
      }
      else if (type == HEADER_VAL) {
        return new HurlHeaderValImpl(node);
      }
      else if (type == HEX_BODY) {
        return new HurlHexBodyImpl(node);
      }
      else if (type == HTML_ESCAPE_FILTER) {
        return new HurlHtmlEscapeFilterImpl(node);
      }
      else if (type == HTML_UNESCAPE_FILTER) {
        return new HurlHtmlUnescapeFilterImpl(node);
      }
      else if (type == INCLUDES_PREDICATE) {
        return new HurlIncludesPredicateImpl(node);
      }
      else if (type == IS_BOOLEAN_PREDICATE) {
        return new HurlIsBooleanPredicateImpl(node);
      }
      else if (type == IS_COLLECTION_PREDICATE) {
        return new HurlIsCollectionPredicateImpl(node);
      }
      else if (type == IS_DATE_PREDICATE) {
        return new HurlIsDatePredicateImpl(node);
      }
      else if (type == IS_EMPTY_PREDICATE) {
        return new HurlIsEmptyPredicateImpl(node);
      }
      else if (type == IS_FLOAT_PREDICATE) {
        return new HurlIsFloatPredicateImpl(node);
      }
      else if (type == IS_INTEGER_PREDICATE) {
        return new HurlIsIntegerPredicateImpl(node);
      }
      else if (type == IS_ISO_DATE_PREDICATE) {
        return new HurlIsIsoDatePredicateImpl(node);
      }
      else if (type == IS_NUMBER_PREDICATE) {
        return new HurlIsNumberPredicateImpl(node);
      }
      else if (type == IS_STRING_PREDICATE) {
        return new HurlIsStringPredicateImpl(node);
      }
      else if (type == JSONPATH_QUERY) {
        return new HurlJsonpathQueryImpl(node);
      }
      else if (type == JSON_BODY) {
        return new HurlJsonBodyImpl(node);
      }
      else if (type == JSON_CONTENT) {
        return new HurlJsonContentImpl(node);
      }
      else if (type == KEY_VALUE_LIST) {
        return new HurlKeyValueListImpl(node);
      }
      else if (type == KEY_VALUE_PAIR) {
        return new HurlKeyValuePairImpl(node);
      }
      else if (type == KV_KEY) {
        return new HurlKvKeyImpl(node);
      }
      else if (type == LESS_THAN_OR_EQUALS_PREDICATE) {
        return new HurlLessThanOrEqualsPredicateImpl(node);
      }
      else if (type == LESS_THAN_PREDICATE) {
        return new HurlLessThanPredicateImpl(node);
      }
      else if (type == MATCHES_PREDICATE) {
        return new HurlMatchesPredicateImpl(node);
      }
      else if (type == MD_5_QUERY) {
        return new HurlMd5QueryImpl(node);
      }
      else if (type == METHOD) {
        return new HurlMethodImpl(node);
      }
      else if (type == MULTILINE_CONTENT) {
        return new HurlMultilineContentImpl(node);
      }
      else if (type == MULTILINE_STRING_BODY) {
        return new HurlMultilineStringBodyImpl(node);
      }
      else if (type == MULTIPART_FORM_DATA_SECTION) {
        return new HurlMultipartFormDataSectionImpl(node);
      }
      else if (type == NOT_EQUALS_PREDICATE) {
        return new HurlNotEqualsPredicateImpl(node);
      }
      else if (type == NOT_PREDICATE) {
        return new HurlNotPredicateImpl(node);
      }
      else if (type == NTH_FILTER) {
        return new HurlNthFilterImpl(node);
      }
      else if (type == OPERATOR_PREDICATE) {
        return new HurlOperatorPredicateImpl(node);
      }
      else if (type == OPTIONS_SECTION) {
        return new HurlOptionsSectionImpl(node);
      }
      else if (type == OPTION_ENTRY) {
        return new HurlOptionEntryImpl(node);
      }
      else if (type == OPTION_KEY) {
        return new HurlOptionKeyImpl(node);
      }
      else if (type == OPTION_LIST) {
        return new HurlOptionListImpl(node);
      }
      else if (type == OPTION_VALUE) {
        return new HurlOptionValueImpl(node);
      }
      else if (type == PREDICATE) {
        return new HurlPredicateImpl(node);
      }
      else if (type == PREDICATE_FUNC) {
        return new HurlPredicateFuncImpl(node);
      }
      else if (type == PREDICATE_VALUE) {
        return new HurlPredicateValueImpl(node);
      }
      else if (type == QUERY) {
        return new HurlQueryImpl(node);
      }
      else if (type == QUERY_STRING_PARAMS_SECTION) {
        return new HurlQueryStringParamsSectionImpl(node);
      }
      else if (type == QUOTED_STRING_VALUE) {
        return new HurlQuotedStringValueImpl(node);
      }
      else if (type == RAW_BODY) {
        return new HurlRawBodyImpl(node);
      }
      else if (type == REGEX_QUERY) {
        return new HurlRegexQueryImpl(node);
      }
      else if (type == REPLACE_FILTER) {
        return new HurlReplaceFilterImpl(node);
      }
      else if (type == REQUEST) {
        return new HurlRequestImpl(node);
      }
      else if (type == REQUEST_LINE) {
        return new HurlRequestLineImpl(node);
      }
      else if (type == REQUEST_SECTION) {
        return new HurlRequestSectionImpl(node);
      }
      else if (type == RESPONSE) {
        return new HurlResponseImpl(node);
      }
      else if (type == RESPONSE_LINE) {
        return new HurlResponseLineImpl(node);
      }
      else if (type == RESPONSE_SECTION) {
        return new HurlResponseSectionImpl(node);
      }
      else if (type == SHA_256_QUERY) {
        return new HurlSha256QueryImpl(node);
      }
      else if (type == SPLIT_FILTER) {
        return new HurlSplitFilterImpl(node);
      }
      else if (type == STARTS_WITH_PREDICATE) {
        return new HurlStartsWithPredicateImpl(node);
      }
      else if (type == STATUS_QUERY) {
        return new HurlStatusQueryImpl(node);
      }
      else if (type == STATUS_VALUE) {
        return new HurlStatusValueImpl(node);
      }
      else if (type == TEMPLATE) {
        return new HurlTemplateImpl(node);
      }
      else if (type == TO_DATE_FILTER) {
        return new HurlToDateFilterImpl(node);
      }
      else if (type == TO_FLOAT_FILTER) {
        return new HurlToFloatFilterImpl(node);
      }
      else if (type == TO_INT_FILTER) {
        return new HurlToIntFilterImpl(node);
      }
      else if (type == URL) {
        return new HurlUrlImpl(node);
      }
      else if (type == URL_DECODE_FILTER) {
        return new HurlUrlDecodeFilterImpl(node);
      }
      else if (type == URL_ENCODE_FILTER) {
        return new HurlUrlEncodeFilterImpl(node);
      }
      else if (type == URL_QUERY) {
        return new HurlUrlQueryImpl(node);
      }
      else if (type == VALUE_CONTENT) {
        return new HurlValueContentImpl(node);
      }
      else if (type == VARIABLE_QUERY) {
        return new HurlVariableQueryImpl(node);
      }
      else if (type == XML_BODY) {
        return new HurlXmlBodyImpl(node);
      }
      else if (type == XPATH_QUERY) {
        return new HurlXpathQueryImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
