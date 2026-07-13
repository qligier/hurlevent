// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlElementTypes.*;
import static ch.qligier.jetbrains.plugin.hurlevent.language.parser.HurlParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HurlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return hurl_file(b, l + 1);
  }

  /* ********************************************************** */
  // line_break* query filter* space predicate line_break
  public static boolean assert_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_$")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSERT, "<assert>");
    r = assert_0(b, l + 1);
    r = r && query(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, assert_2(b, l + 1));
    r = p && report_error_(b, space(b, l + 1)) && r;
    r = p && report_error_(b, predicate(b, l + 1)) && r;
    r = p && line_break(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean assert_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assert_0", c)) break;
    }
    return true;
  }

  // filter*
  private static boolean assert_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!filter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assert_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(query | T_METHOD)
  static boolean assert_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !assert_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // query | T_METHOD
  private static boolean assert_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = query(b, l + 1);
    if (!r) r = consumeToken(b, T_METHOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_ASSERTS_SECTION line_break assert*
  public static boolean asserts_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSERTS_SECTION, "<asserts section>");
    r = asserts_section_0(b, l + 1);
    r = r && consumeToken(b, T_ASSERTS_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && asserts_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::assert_recover);
    return r || p;
  }

  // line_break*
  private static boolean asserts_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asserts_section_0", c)) break;
    }
    return true;
  }

  // assert*
  private static boolean asserts_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assert_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asserts_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_AWS_SIGV4_OPTION T_COLON value_string
  public static boolean aws_sigv4_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aws_sigv4_option")) return false;
    if (!nextTokenIs(b, T_AWS_SIGV4_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_AWS_SIGV4_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, AWS_SIGV_4_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_BASIC_AUTH_SECTION line_break key_value*
  public static boolean basic_auth_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BASIC_AUTH_SECTION, "<basic auth section>");
    r = basic_auth_section_0(b, l + 1);
    r = r && consumeToken(b, T_BASIC_AUTH_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && basic_auth_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean basic_auth_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "basic_auth_section_0", c)) break;
    }
    return true;
  }

  // key_value*
  private static boolean basic_auth_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "basic_auth_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line_break* bytes line_break
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = body_0(b, l + 1);
    r = r && bytes(b, l + 1);
    p = r; // pin = 2
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_BOOLEAN | T_IDENTIFIER
  public static boolean boolean_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_option")) return false;
    if (!nextTokenIs(b, "<boolean option>", T_BOOLEAN, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_OPTION, "<boolean option>");
    r = consumeToken(b, T_BOOLEAN);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_HEX_BYTE+ | string_literal | json_value
  public static boolean bytes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BYTES, "<bytes>");
    r = bytes_0(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = json_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_HEX_BYTE+
  private static boolean bytes_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytes_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_HEX_BYTE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, T_HEX_BYTE)) break;
      if (!empty_element_parsed_guard_(b, "bytes_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_CACERT_OPTION T_COLON filename
  public static boolean cacert_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cacert_option")) return false;
    if (!nextTokenIs(b, T_CACERT_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_CACERT_OPTION, T_COLON);
    r = r && filename(b, l + 1);
    exit_section_(b, m, CACERT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* key_string T_COLON query filter* (space T_REDACT_KEYWORD)? line_break
  public static boolean capture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CAPTURE, "<capture>");
    r = capture_0(b, l + 1);
    r = r && key_string(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, T_COLON));
    r = p && report_error_(b, query(b, l + 1)) && r;
    r = p && report_error_(b, capture_4(b, l + 1)) && r;
    r = p && report_error_(b, capture_5(b, l + 1)) && r;
    r = p && line_break(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean capture_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "capture_0", c)) break;
    }
    return true;
  }

  // filter*
  private static boolean capture_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!filter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "capture_4", c)) break;
    }
    return true;
  }

  // (space T_REDACT_KEYWORD)?
  private static boolean capture_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_5")) return false;
    capture_5_0(b, l + 1);
    return true;
  }

  // space T_REDACT_KEYWORD
  private static boolean capture_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = space(b, l + 1);
    r = r && consumeToken(b, T_REDACT_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(key_string | T_ASSERTS_SECTION | T_METHOD)
  static boolean capture_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !capture_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key_string | T_ASSERTS_SECTION | T_METHOD
  private static boolean capture_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_recover_0")) return false;
    boolean r;
    r = key_string(b, l + 1);
    if (!r) r = consumeToken(b, T_ASSERTS_SECTION);
    if (!r) r = consumeToken(b, T_METHOD);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_CAPTURES_SECTION line_break capture*
  public static boolean captures_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "captures_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CAPTURES_SECTION, "<captures section>");
    r = captures_section_0(b, l + 1);
    r = r && consumeToken(b, T_CAPTURES_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && captures_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::capture_recover);
    return r || p;
  }

  // line_break*
  private static boolean captures_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "captures_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "captures_section_0", c)) break;
    }
    return true;
  }

  // capture*
  private static boolean captures_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "captures_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!capture(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "captures_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_CERT_OPTION T_COLON filename_password
  public static boolean cert_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cert_option")) return false;
    if (!nextTokenIs(b, T_CERT_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_CERT_OPTION, T_COLON);
    r = r && filename_password(b, l + 1);
    exit_section_(b, m, CERT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_COMPRESSED_OPTION T_COLON boolean_option
  public static boolean compressed_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compressed_option")) return false;
    if (!nextTokenIs(b, T_COMPRESSED_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_COMPRESSED_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, COMPRESSED_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_CONNECT_TIMEOUT_OPTION T_COLON duration_option
  public static boolean connect_timeout_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connect_timeout_option")) return false;
    if (!nextTokenIs(b, T_CONNECT_TIMEOUT_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_CONNECT_TIMEOUT_OPTION, T_COLON);
    r = r && duration_option(b, l + 1);
    exit_section_(b, m, CONNECT_TIMEOUT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_CONNECT_TO_OPTION T_COLON value_string
  public static boolean connect_to_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connect_to_option")) return false;
    if (!nextTokenIs(b, T_CONNECT_TO_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_CONNECT_TO_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, CONNECT_TO_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_COOKIES_SECTION line_break key_value*
  public static boolean cookies_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COOKIES_SECTION, "<cookies section>");
    r = cookies_section_0(b, l + 1);
    r = r && consumeToken(b, T_COOKIES_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && cookies_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean cookies_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cookies_section_0", c)) break;
    }
    return true;
  }

  // key_value*
  private static boolean cookies_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cookies_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_DELAY_OPTION T_COLON duration_option
  public static boolean delay_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delay_option")) return false;
    if (!nextTokenIs(b, T_DELAY_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_DELAY_OPTION, T_COLON);
    r = r && duration_option(b, l + 1);
    exit_section_(b, m, DELAY_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_DURATION_MS | T_DURATION_S | T_DURATION_M | T_INTEGER_LITERAL | T_IDENTIFIER
  public static boolean duration_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "duration_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DURATION_OPTION, "<duration option>");
    r = consumeToken(b, T_DURATION_MS);
    if (!r) r = consumeToken(b, T_DURATION_S);
    if (!r) r = consumeToken(b, T_DURATION_M);
    if (!r) r = consumeToken(b, T_INTEGER_LITERAL);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* request response?
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = entry_0(b, l + 1);
    r = r && request(b, l + 1);
    p = r; // pin = 2
    r = r && entry_2(b, l + 1);
    exit_section_(b, l, m, r, p, HurlParser::entry_recover);
    return r || p;
  }

  // line_break*
  private static boolean entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entry_0", c)) break;
    }
    return true;
  }

  // response?
  private static boolean entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_2")) return false;
    response(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(T_METHOD | T_HTTP_VERSION | T_URL)
  static boolean entry_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !entry_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_METHOD | T_HTTP_VERSION | T_URL
  private static boolean entry_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_METHOD);
    if (!r) r = consumeToken(b, T_HTTP_VERSION);
    if (!r) r = consumeToken(b, T_URL);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER | string_literal
  public static boolean filename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename")) return false;
    if (!nextTokenIs(b, "<filename>", T_IDENTIFIER, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILENAME, "<filename>");
    r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* key_string T_COLON filename_value line_break
  public static boolean filename_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_param")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FILENAME_PARAM, "<filename param>");
    r = filename_param_0(b, l + 1);
    r = r && key_string(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    p = r; // pin = 3
    r = r && report_error_(b, filename_value(b, l + 1));
    r = p && line_break(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean filename_param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_param_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "filename_param_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // filename (T_COLON string_literal)?
  public static boolean filename_password(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_password")) return false;
    if (!nextTokenIs(b, "<filename password>", T_IDENTIFIER, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILENAME_PASSWORD, "<filename password>");
    r = filename(b, l + 1);
    r = r && filename_password_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (T_COLON string_literal)?
  private static boolean filename_password_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_password_1")) return false;
    filename_password_1_0(b, l + 1);
    return true;
  }

  // T_COLON string_literal
  private static boolean filename_password_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_password_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_FILE_KEYWORD T_COMMA filename string_part?
  public static boolean filename_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_value")) return false;
    if (!nextTokenIs(b, T_FILE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FILENAME_VALUE, null);
    r = consumeTokens(b, 1, T_FILE_KEYWORD, T_COMMA);
    p = r; // pin = 1
    r = r && report_error_(b, filename(b, l + 1));
    r = p && filename_value_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // string_part?
  private static boolean filename_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_value_3")) return false;
    string_part(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // space filter_type filter_arg?
  public static boolean filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter")) return false;
    if (!nextTokenIs(b, T_SPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FILTER, null);
    r = space(b, l + 1);
    r = r && filter_type(b, l + 1);
    p = r; // pin = 2
    r = r && filter_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // filter_arg?
  private static boolean filter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_2")) return false;
    filter_arg(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // string_literal | T_IDENTIFIER
  public static boolean filter_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_arg")) return false;
    if (!nextTokenIs(b, "<filter arg>", T_IDENTIFIER, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER_ARG, "<filter arg>");
    r = string_literal(b, l + 1);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_COUNT_FILTER
  //              | T_URL_DECODE_FILTER
  //              | T_URL_ENCODE_FILTER
  //              | T_HTML_DECODE_FILTER
  //              | T_HTML_ENCODE_FILTER
  //              | T_BASE64_FILTER
  //              | T_BASE64_DECODE_FILTER
  //              | T_BASE32_FILTER
  //              | T_BASE32_DECODE_FILTER
  //              | T_SHA1_FILTER
  //              | T_SHA256_FILTER
  //              | T_SHA512_FILTER
  //              | T_MD5_FILTER
  //              | T_SPLIT_FILTER
  //              | T_JOIN_FILTER
  //              | T_LTRIM_CHARS_FILTER
  //              | T_RTRIM_CHARS_FILTER
  //              | T_TRIM_CHARS_FILTER
  //              | T_LTRIM_FILTER
  //              | T_RTRIM_FILTER
  //              | T_TRIM_FILTER
  //              | T_REPLACE_FILTER
  public static boolean filter_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER_TYPE, "<filter type>");
    r = consumeToken(b, T_COUNT_FILTER);
    if (!r) r = consumeToken(b, T_URL_DECODE_FILTER);
    if (!r) r = consumeToken(b, T_URL_ENCODE_FILTER);
    if (!r) r = consumeToken(b, T_HTML_DECODE_FILTER);
    if (!r) r = consumeToken(b, T_HTML_ENCODE_FILTER);
    if (!r) r = consumeToken(b, T_BASE64_FILTER);
    if (!r) r = consumeToken(b, T_BASE64_DECODE_FILTER);
    if (!r) r = consumeToken(b, T_BASE32_FILTER);
    if (!r) r = consumeToken(b, T_BASE32_DECODE_FILTER);
    if (!r) r = consumeToken(b, T_SHA1_FILTER);
    if (!r) r = consumeToken(b, T_SHA256_FILTER);
    if (!r) r = consumeToken(b, T_SHA512_FILTER);
    if (!r) r = consumeToken(b, T_MD5_FILTER);
    if (!r) r = consumeToken(b, T_SPLIT_FILTER);
    if (!r) r = consumeToken(b, T_JOIN_FILTER);
    if (!r) r = consumeToken(b, T_LTRIM_CHARS_FILTER);
    if (!r) r = consumeToken(b, T_RTRIM_CHARS_FILTER);
    if (!r) r = consumeToken(b, T_TRIM_CHARS_FILTER);
    if (!r) r = consumeToken(b, T_LTRIM_FILTER);
    if (!r) r = consumeToken(b, T_RTRIM_FILTER);
    if (!r) r = consumeToken(b, T_TRIM_FILTER);
    if (!r) r = consumeToken(b, T_REPLACE_FILTER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_FORM_PARAMS_SECTION line_break key_value*
  public static boolean form_params_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FORM_PARAMS_SECTION, "<form params section>");
    r = form_params_section_0(b, l + 1);
    r = r && consumeToken(b, T_FORM_PARAMS_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && form_params_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean form_params_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "form_params_section_0", c)) break;
    }
    return true;
  }

  // key_value*
  private static boolean form_params_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "form_params_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line_break* key_value line_break
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = header_0(b, l + 1);
    r = r && key_value(b, l + 1);
    p = r; // pin = 2
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "header_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_HEADER_OPTION T_COLON value_string
  public static boolean header_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_option")) return false;
    if (!nextTokenIs(b, T_HEADER_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_HEADER_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, HEADER_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_HTTP10_OPTION T_COLON boolean_option
  public static boolean http10_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http10_option")) return false;
    if (!nextTokenIs(b, T_HTTP10_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_HTTP10_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, HTTP_10_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_HTTP11_OPTION T_COLON boolean_option
  public static boolean http11_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http11_option")) return false;
    if (!nextTokenIs(b, T_HTTP11_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_HTTP11_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, HTTP_11_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_HTTP2_OPTION T_COLON boolean_option
  public static boolean http2_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http2_option")) return false;
    if (!nextTokenIs(b, T_HTTP2_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_HTTP2_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, HTTP_2_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_HTTP3_OPTION T_COLON boolean_option
  public static boolean http3_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http3_option")) return false;
    if (!nextTokenIs(b, T_HTTP3_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_HTTP3_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, HTTP_3_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_HTTP_VERSION
  public static boolean http_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http_version")) return false;
    if (!nextTokenIs(b, T_HTTP_VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_HTTP_VERSION);
    exit_section_(b, m, HTTP_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // (entry | line_break)*
  static boolean hurl_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurl_file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!hurl_file_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hurl_file", c)) break;
    }
    return true;
  }

  // entry | line_break
  private static boolean hurl_file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurl_file_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entry(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_INSECURE_OPTION T_COLON boolean_option
  public static boolean insecure_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insecure_option")) return false;
    if (!nextTokenIs(b, T_INSECURE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_INSECURE_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, INSECURE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_INTEGER_LITERAL | T_IDENTIFIER
  public static boolean integer_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_option")) return false;
    if (!nextTokenIs(b, "<integer option>", T_IDENTIFIER, T_INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_OPTION, "<integer option>");
    r = consumeToken(b, T_INTEGER_LITERAL);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_IPV4_OPTION T_COLON boolean_option
  public static boolean ipv4_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ipv4_option")) return false;
    if (!nextTokenIs(b, T_IPV4_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IPV4_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, IPV_4_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_IPV6_OPTION T_COLON boolean_option
  public static boolean ipv6_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ipv6_option")) return false;
    if (!nextTokenIs(b, T_IPV6_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IPV6_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, IPV_6_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_LBRACKET (json_value (T_COMMA json_value)* T_COMMA?)? T_RBRACKET
  public static boolean json_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_ARRAY, "<json array>");
    r = consumeToken(b, T_LBRACKET);
    r = r && json_array_1(b, l + 1);
    r = r && consumeToken(b, T_RBRACKET);
    exit_section_(b, l, m, r, false, HurlParser::json_recover);
    return r;
  }

  // (json_value (T_COMMA json_value)* T_COMMA?)?
  private static boolean json_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1")) return false;
    json_array_1_0(b, l + 1);
    return true;
  }

  // json_value (T_COMMA json_value)* T_COMMA?
  private static boolean json_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = json_value(b, l + 1);
    r = r && json_array_1_0_1(b, l + 1);
    r = r && json_array_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA json_value)*
  private static boolean json_array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!json_array_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "json_array_1_0_1", c)) break;
    }
    return true;
  }

  // T_COMMA json_value
  private static boolean json_array_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && json_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA?
  private static boolean json_array_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_2")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // (string_literal | T_IDENTIFIER) T_COLON json_value
  public static boolean json_member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_member")) return false;
    if (!nextTokenIs(b, "<json member>", T_IDENTIFIER, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_MEMBER, "<json member>");
    r = json_member_0(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && json_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // string_literal | T_IDENTIFIER
  private static boolean json_member_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_member_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_FLOAT_LITERAL | T_INTEGER_LITERAL
  public static boolean json_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_number")) return false;
    if (!nextTokenIs(b, "<json number>", T_FLOAT_LITERAL, T_INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_NUMBER, "<json number>");
    r = consumeToken(b, T_FLOAT_LITERAL);
    if (!r) r = consumeToken(b, T_INTEGER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_LBRACE (json_member (T_COMMA json_member)* T_COMMA?)? T_RBRACE
  public static boolean json_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_OBJECT, "<json object>");
    r = consumeToken(b, T_LBRACE);
    r = r && json_object_1(b, l + 1);
    r = r && consumeToken(b, T_RBRACE);
    exit_section_(b, l, m, r, false, HurlParser::json_recover);
    return r;
  }

  // (json_member (T_COMMA json_member)* T_COMMA?)?
  private static boolean json_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1")) return false;
    json_object_1_0(b, l + 1);
    return true;
  }

  // json_member (T_COMMA json_member)* T_COMMA?
  private static boolean json_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = json_member(b, l + 1);
    r = r && json_object_1_0_1(b, l + 1);
    r = r && json_object_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA json_member)*
  private static boolean json_object_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!json_object_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "json_object_1_0_1", c)) break;
    }
    return true;
  }

  // T_COMMA json_member
  private static boolean json_object_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && json_member(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA?
  private static boolean json_object_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_2")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // !(T_RBRACE | T_RBRACKET | T_COMMA | line_break)
  static boolean json_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !json_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_RBRACE | T_RBRACKET | T_COMMA | line_break
  private static boolean json_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_RBRACE);
    if (!r) r = consumeToken(b, T_RBRACKET);
    if (!r) r = consumeToken(b, T_COMMA);
    if (!r) r = line_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string_literal
  public static boolean json_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_string")) return false;
    if (!nextTokenIs(b, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    exit_section_(b, m, JSON_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // json_object
  //             | json_array
  //             | json_string
  //             | json_number
  //             | T_BOOLEAN
  //             | T_NULL
  public static boolean json_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_VALUE, "<json value>");
    r = json_object(b, l + 1);
    if (!r) r = json_array(b, l + 1);
    if (!r) r = json_string(b, l + 1);
    if (!r) r = json_number(b, l + 1);
    if (!r) r = consumeToken(b, T_BOOLEAN);
    if (!r) r = consumeToken(b, T_NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_KEY_OPTION T_COLON value_string
  public static boolean key_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_option")) return false;
    if (!nextTokenIs(b, T_KEY_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_KEY_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, KEY_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER | string_literal
  public static boolean key_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_string")) return false;
    if (!nextTokenIs(b, "<key string>", T_IDENTIFIER, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_STRING, "<key string>");
    r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* key_string T_COLON value_string line_break?
  public static boolean key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE, "<key value>");
    r = key_value_0(b, l + 1);
    r = r && key_string(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    p = r; // pin = 3
    r = r && report_error_(b, value_string(b, l + 1));
    r = p && key_value_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::key_value_recover);
    return r || p;
  }

  // line_break*
  private static boolean key_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_value_0", c)) break;
    }
    return true;
  }

  // line_break?
  private static boolean key_value_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_4")) return false;
    line_break(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(key_string | line_break | T_LBRACKET)
  static boolean key_value_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !key_value_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key_string | line_break | T_LBRACKET
  private static boolean key_value_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_recover_0")) return false;
    boolean r;
    r = key_string(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    if (!r) r = consumeToken(b, T_LBRACKET);
    return r;
  }

  /* ********************************************************** */
  // T_LIMIT_RATE_OPTION T_COLON integer_option
  public static boolean limit_rate_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "limit_rate_option")) return false;
    if (!nextTokenIs(b, T_LIMIT_RATE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_LIMIT_RATE_OPTION, T_COLON);
    r = r && integer_option(b, l + 1);
    exit_section_(b, m, LIMIT_RATE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_LINE_BREAK+
  public static boolean line_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_break")) return false;
    if (!nextTokenIs(b, T_LINE_BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LINE_BREAK);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, T_LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "line_break", c)) break;
    }
    exit_section_(b, m, LINE_BREAK, r);
    return r;
  }

  /* ********************************************************** */
  // T_LOCATION_OPTION T_COLON boolean_option
  public static boolean location_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_option")) return false;
    if (!nextTokenIs(b, T_LOCATION_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_LOCATION_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, LOCATION_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_LOCATION_TRUSTED_OPTION T_COLON boolean_option
  public static boolean location_trusted_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_trusted_option")) return false;
    if (!nextTokenIs(b, T_LOCATION_TRUSTED_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_LOCATION_TRUSTED_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, LOCATION_TRUSTED_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_MAX_REDIRS_OPTION T_COLON integer_option
  public static boolean max_redirs_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_redirs_option")) return false;
    if (!nextTokenIs(b, T_MAX_REDIRS_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MAX_REDIRS_OPTION, T_COLON);
    r = r && integer_option(b, l + 1);
    exit_section_(b, m, MAX_REDIRS_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_MAX_TIME_OPTION T_COLON integer_option
  public static boolean max_time_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_time_option")) return false;
    if (!nextTokenIs(b, T_MAX_TIME_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MAX_TIME_OPTION, T_COLON);
    r = r && integer_option(b, l + 1);
    exit_section_(b, m, MAX_TIME_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_METHOD
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, T_METHOD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_METHOD);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  /* ********************************************************** */
  // filename_param | key_value
  public static boolean multipart_form_data_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPART_FORM_DATA_PARAM, "<multipart form data param>");
    r = filename_param(b, l + 1);
    if (!r) r = key_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_MULTIPART_FORM_DATA_SECTION line_break multipart_form_data_param*
  public static boolean multipart_form_data_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MULTIPART_FORM_DATA_SECTION, "<multipart form data section>");
    r = multipart_form_data_section_0(b, l + 1);
    r = r && consumeToken(b, T_MULTIPART_FORM_DATA_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && multipart_form_data_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean multipart_form_data_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multipart_form_data_section_0", c)) break;
    }
    return true;
  }

  // multipart_form_data_param*
  private static boolean multipart_form_data_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multipart_form_data_param(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multipart_form_data_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_NETRC_FILE_OPTION T_COLON value_string
  public static boolean netrc_file_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_file_option")) return false;
    if (!nextTokenIs(b, T_NETRC_FILE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_NETRC_FILE_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, NETRC_FILE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_NETRC_OPTION T_COLON boolean_option
  public static boolean netrc_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_option")) return false;
    if (!nextTokenIs(b, T_NETRC_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_NETRC_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, NETRC_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_NETRC_OPTIONAL_OPTION T_COLON boolean_option
  public static boolean netrc_optional_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_optional_option")) return false;
    if (!nextTokenIs(b, T_NETRC_OPTIONAL_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_NETRC_OPTIONAL_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, NETRC_OPTIONAL_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* option_type line_break
  public static boolean option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTION, "<option>");
    r = option_0(b, l + 1);
    r = r && option_type(b, l + 1);
    p = r; // pin = 2
    r = r && line_break(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // line_break*
  private static boolean option_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "option_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // aws_sigv4_option
  //              | cacert_option
  //              | cert_option
  //              | key_option
  //              | compressed_option
  //              | connect_to_option
  //              | connect_timeout_option
  //              | delay_option
  //              | location_option
  //              | location_trusted_option
  //              | header_option
  //              | http10_option
  //              | http11_option
  //              | http2_option
  //              | http3_option
  //              | insecure_option
  //              | ipv4_option
  //              | ipv6_option
  //              | limit_rate_option
  //              | max_redirs_option
  //              | max_time_option
  //              | netrc_option
  //              | netrc_file_option
  //              | netrc_optional_option
  //              | output_option
  //              | path_as_is_option
  //              | pinnedpubkey_option
  //              | proxy_option
  //              | resolve_option
  //              | repeat_option
  //              | retry_option
  //              | retry_interval_option
  //              | skip_option
  //              | unix_socket_option
  //              | user_option
  //              | variable_option
  //              | verbose_option
  //              | very_verbose_option
  public static boolean option_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTION_TYPE, "<option type>");
    r = aws_sigv4_option(b, l + 1);
    if (!r) r = cacert_option(b, l + 1);
    if (!r) r = cert_option(b, l + 1);
    if (!r) r = key_option(b, l + 1);
    if (!r) r = compressed_option(b, l + 1);
    if (!r) r = connect_to_option(b, l + 1);
    if (!r) r = connect_timeout_option(b, l + 1);
    if (!r) r = delay_option(b, l + 1);
    if (!r) r = location_option(b, l + 1);
    if (!r) r = location_trusted_option(b, l + 1);
    if (!r) r = header_option(b, l + 1);
    if (!r) r = http10_option(b, l + 1);
    if (!r) r = http11_option(b, l + 1);
    if (!r) r = http2_option(b, l + 1);
    if (!r) r = http3_option(b, l + 1);
    if (!r) r = insecure_option(b, l + 1);
    if (!r) r = ipv4_option(b, l + 1);
    if (!r) r = ipv6_option(b, l + 1);
    if (!r) r = limit_rate_option(b, l + 1);
    if (!r) r = max_redirs_option(b, l + 1);
    if (!r) r = max_time_option(b, l + 1);
    if (!r) r = netrc_option(b, l + 1);
    if (!r) r = netrc_file_option(b, l + 1);
    if (!r) r = netrc_optional_option(b, l + 1);
    if (!r) r = output_option(b, l + 1);
    if (!r) r = path_as_is_option(b, l + 1);
    if (!r) r = pinnedpubkey_option(b, l + 1);
    if (!r) r = proxy_option(b, l + 1);
    if (!r) r = resolve_option(b, l + 1);
    if (!r) r = repeat_option(b, l + 1);
    if (!r) r = retry_option(b, l + 1);
    if (!r) r = retry_interval_option(b, l + 1);
    if (!r) r = skip_option(b, l + 1);
    if (!r) r = unix_socket_option(b, l + 1);
    if (!r) r = user_option(b, l + 1);
    if (!r) r = variable_option(b, l + 1);
    if (!r) r = verbose_option(b, l + 1);
    if (!r) r = very_verbose_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_OPTIONS_SECTION line_break option*
  public static boolean options_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTIONS_SECTION, "<options section>");
    r = options_section_0(b, l + 1);
    r = r && consumeToken(b, T_OPTIONS_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && options_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean options_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "options_section_0", c)) break;
    }
    return true;
  }

  // option*
  private static boolean options_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!option(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "options_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_OUTPUT_OPTION T_COLON value_string
  public static boolean output_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_option")) return false;
    if (!nextTokenIs(b, T_OUTPUT_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_OUTPUT_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, OUTPUT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // !(key_string | T_BASIC_AUTH_SECTION | T_QUERY_STRING_PARAMS_SECTION
  //                            | T_FORM_PARAMS_SECTION | T_MULTIPART_FORM_DATA_SECTION | T_COOKIES_SECTION
  //                            | T_OPTIONS_SECTION | T_HTTP_VERSION | T_CAPTURES_SECTION | T_ASSERTS_SECTION)
  static boolean params_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !params_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key_string | T_BASIC_AUTH_SECTION | T_QUERY_STRING_PARAMS_SECTION
  //                            | T_FORM_PARAMS_SECTION | T_MULTIPART_FORM_DATA_SECTION | T_COOKIES_SECTION
  //                            | T_OPTIONS_SECTION | T_HTTP_VERSION | T_CAPTURES_SECTION | T_ASSERTS_SECTION
  private static boolean params_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_recover_0")) return false;
    boolean r;
    r = key_string(b, l + 1);
    if (!r) r = consumeToken(b, T_BASIC_AUTH_SECTION);
    if (!r) r = consumeToken(b, T_QUERY_STRING_PARAMS_SECTION);
    if (!r) r = consumeToken(b, T_FORM_PARAMS_SECTION);
    if (!r) r = consumeToken(b, T_MULTIPART_FORM_DATA_SECTION);
    if (!r) r = consumeToken(b, T_COOKIES_SECTION);
    if (!r) r = consumeToken(b, T_OPTIONS_SECTION);
    if (!r) r = consumeToken(b, T_HTTP_VERSION);
    if (!r) r = consumeToken(b, T_CAPTURES_SECTION);
    if (!r) r = consumeToken(b, T_ASSERTS_SECTION);
    return r;
  }

  /* ********************************************************** */
  // T_PATH_AS_IS_OPTION T_COLON boolean_option
  public static boolean path_as_is_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_as_is_option")) return false;
    if (!nextTokenIs(b, T_PATH_AS_IS_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_PATH_AS_IS_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, PATH_AS_IS_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_PINNEDPUBKEY_OPTION T_COLON value_string
  public static boolean pinnedpubkey_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pinnedpubkey_option")) return false;
    if (!nextTokenIs(b, T_PINNEDPUBKEY_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_PINNEDPUBKEY_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, PINNEDPUBKEY_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // predicate_type predicate_value?
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE, "<predicate>");
    r = predicate_type(b, l + 1);
    p = r; // pin = 1
    r = r && predicate_1(b, l + 1);
    exit_section_(b, l, m, r, p, HurlParser::predicate_recover);
    return r || p;
  }

  // predicate_value?
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    predicate_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(line_break | T_METHOD)
  static boolean predicate_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !predicate_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // line_break | T_METHOD
  private static boolean predicate_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_recover_0")) return false;
    boolean r;
    r = line_break(b, l + 1);
    if (!r) r = consumeToken(b, T_METHOD);
    return r;
  }

  /* ********************************************************** */
  // T_EQUALS_PREDICATE
  //                 | T_NOT_EQUALS_PREDICATE
  //                 | T_GREATER_THAN_PREDICATE
  //                 | T_GTE_PREDICATE
  //                 | T_LESS_THAN_PREDICATE
  //                 | T_LTE_PREDICATE
  //                 | T_STARTS_WITH_PREDICATE
  //                 | T_ENDS_WITH_PREDICATE
  //                 | T_CONTAINS_PREDICATE
  //                 | T_INCLUDES_PREDICATE
  //                 | T_MATCHES_PREDICATE
  //                 | T_EXISTS_PREDICATE
  //                 | T_IS_INTEGER_PREDICATE
  //                 | T_IS_FLOAT_PREDICATE
  //                 | T_IS_BOOLEAN_PREDICATE
  //                 | T_IS_STRING_PREDICATE
  //                 | T_IS_COLLECTION_PREDICATE
  //                 | T_IS_EMPTY_PREDICATE
  //                 | T_IS_NULL_PREDICATE
  public static boolean predicate_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE_TYPE, "<predicate type>");
    r = consumeToken(b, T_EQUALS_PREDICATE);
    if (!r) r = consumeToken(b, T_NOT_EQUALS_PREDICATE);
    if (!r) r = consumeToken(b, T_GREATER_THAN_PREDICATE);
    if (!r) r = consumeToken(b, T_GTE_PREDICATE);
    if (!r) r = consumeToken(b, T_LESS_THAN_PREDICATE);
    if (!r) r = consumeToken(b, T_LTE_PREDICATE);
    if (!r) r = consumeToken(b, T_STARTS_WITH_PREDICATE);
    if (!r) r = consumeToken(b, T_ENDS_WITH_PREDICATE);
    if (!r) r = consumeToken(b, T_CONTAINS_PREDICATE);
    if (!r) r = consumeToken(b, T_INCLUDES_PREDICATE);
    if (!r) r = consumeToken(b, T_MATCHES_PREDICATE);
    if (!r) r = consumeToken(b, T_EXISTS_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_INTEGER_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_FLOAT_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_BOOLEAN_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_STRING_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_COLLECTION_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_EMPTY_PREDICATE);
    if (!r) r = consumeToken(b, T_IS_NULL_PREDICATE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // json_value | string_literal
  public static boolean predicate_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE_VALUE, "<predicate value>");
    r = json_value(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_PROXY_OPTION T_COLON value_string
  public static boolean proxy_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proxy_option")) return false;
    if (!nextTokenIs(b, T_PROXY_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_PROXY_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, PROXY_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // query_type query_target?
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY, "<query>");
    r = query_type(b, l + 1);
    r = r && query_1(b, l + 1);
    exit_section_(b, l, m, r, false, HurlParser::query_recover);
    return r;
  }

  // query_target?
  private static boolean query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_1")) return false;
    query_target(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(filter | space | predicate)
  static boolean query_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !query_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // filter | space | predicate
  private static boolean query_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = filter(b, l + 1);
    if (!r) r = space(b, l + 1);
    if (!r) r = predicate(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* T_QUERY_STRING_PARAMS_SECTION line_break key_value*
  public static boolean query_string_params_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, QUERY_STRING_PARAMS_SECTION, "<query string params section>");
    r = query_string_params_section_0(b, l + 1);
    r = r && consumeToken(b, T_QUERY_STRING_PARAMS_SECTION);
    p = r; // pin = 2
    r = r && report_error_(b, line_break(b, l + 1));
    r = p && query_string_params_section_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::params_recover);
    return r || p;
  }

  // line_break*
  private static boolean query_string_params_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "query_string_params_section_0", c)) break;
    }
    return true;
  }

  // key_value*
  private static boolean query_string_params_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "query_string_params_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // string_literal | T_IDENTIFIER | T_INTEGER_LITERAL
  public static boolean query_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_target")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY_TARGET, "<query target>");
    r = string_literal(b, l + 1);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, T_INTEGER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_JSONPATH_QUERY
  //             | T_XPATH_QUERY
  //             | T_REGEX_QUERY
  //             | T_COOKIE_QUERY
  //             | T_HEADER_QUERY
  //             | T_STATUS_QUERY
  //             | T_URL_QUERY
  //             | T_BODY_QUERY
  //             | T_BYTES_QUERY
  //             | T_DURATION_QUERY
  //             | T_SSL_QUERY
  //             | T_CERTIFICATE_QUERY
  public static boolean query_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY_TYPE, "<query type>");
    r = consumeToken(b, T_JSONPATH_QUERY);
    if (!r) r = consumeToken(b, T_XPATH_QUERY);
    if (!r) r = consumeToken(b, T_REGEX_QUERY);
    if (!r) r = consumeToken(b, T_COOKIE_QUERY);
    if (!r) r = consumeToken(b, T_HEADER_QUERY);
    if (!r) r = consumeToken(b, T_STATUS_QUERY);
    if (!r) r = consumeToken(b, T_URL_QUERY);
    if (!r) r = consumeToken(b, T_BODY_QUERY);
    if (!r) r = consumeToken(b, T_BYTES_QUERY);
    if (!r) r = consumeToken(b, T_DURATION_QUERY);
    if (!r) r = consumeToken(b, T_SSL_QUERY);
    if (!r) r = consumeToken(b, T_CERTIFICATE_QUERY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_REPEAT_OPTION T_COLON integer_option
  public static boolean repeat_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeat_option")) return false;
    if (!nextTokenIs(b, T_REPEAT_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_REPEAT_OPTION, T_COLON);
    r = r && integer_option(b, l + 1);
    exit_section_(b, m, REPEAT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* method space url line_break header* request_section* body?
  public static boolean request(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REQUEST, "<request>");
    r = request_0(b, l + 1);
    r = r && method(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, space(b, l + 1));
    r = p && report_error_(b, url(b, l + 1)) && r;
    r = p && report_error_(b, line_break(b, l + 1)) && r;
    r = p && report_error_(b, request_5(b, l + 1)) && r;
    r = p && report_error_(b, request_6(b, l + 1)) && r;
    r = p && request_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::request_recover);
    return r || p;
  }

  // line_break*
  private static boolean request_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_0", c)) break;
    }
    return true;
  }

  // header*
  private static boolean request_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!header(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_5", c)) break;
    }
    return true;
  }

  // request_section*
  private static boolean request_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_section(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_6", c)) break;
    }
    return true;
  }

  // body?
  private static boolean request_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_7")) return false;
    body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(T_HTTP_VERSION | T_METHOD)
  static boolean request_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !request_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_HTTP_VERSION | T_METHOD
  private static boolean request_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_HTTP_VERSION);
    if (!r) r = consumeToken(b, T_METHOD);
    return r;
  }

  /* ********************************************************** */
  // basic_auth_section
  //                  | query_string_params_section
  //                  | form_params_section
  //                  | multipart_form_data_section
  //                  | cookies_section
  //                  | options_section
  public static boolean request_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REQUEST_SECTION, "<request section>");
    r = basic_auth_section(b, l + 1);
    if (!r) r = query_string_params_section(b, l + 1);
    if (!r) r = form_params_section(b, l + 1);
    if (!r) r = multipart_form_data_section(b, l + 1);
    if (!r) r = cookies_section(b, l + 1);
    if (!r) r = options_section(b, l + 1);
    exit_section_(b, l, m, r, false, HurlParser::section_recover);
    return r;
  }

  /* ********************************************************** */
  // T_RESOLVE_OPTION T_COLON value_string
  public static boolean resolve_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resolve_option")) return false;
    if (!nextTokenIs(b, T_RESOLVE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_RESOLVE_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, RESOLVE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // line_break* http_version space status line_break header* response_section* body?
  public static boolean response(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESPONSE, "<response>");
    r = response_0(b, l + 1);
    r = r && http_version(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, space(b, l + 1));
    r = p && report_error_(b, status(b, l + 1)) && r;
    r = p && report_error_(b, line_break(b, l + 1)) && r;
    r = p && report_error_(b, response_5(b, l + 1)) && r;
    r = p && report_error_(b, response_6(b, l + 1)) && r;
    r = p && response_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::response_recover);
    return r || p;
  }

  // line_break*
  private static boolean response_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line_break(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "response_0", c)) break;
    }
    return true;
  }

  // header*
  private static boolean response_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!header(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "response_5", c)) break;
    }
    return true;
  }

  // response_section*
  private static boolean response_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!response_section(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "response_6", c)) break;
    }
    return true;
  }

  // body?
  private static boolean response_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_7")) return false;
    body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(T_METHOD | T_HTTP_VERSION)
  static boolean response_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !response_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_METHOD | T_HTTP_VERSION
  private static boolean response_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_METHOD);
    if (!r) r = consumeToken(b, T_HTTP_VERSION);
    return r;
  }

  /* ********************************************************** */
  // captures_section | asserts_section
  public static boolean response_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESPONSE_SECTION, "<response section>");
    r = captures_section(b, l + 1);
    if (!r) r = asserts_section(b, l + 1);
    exit_section_(b, l, m, r, false, HurlParser::response_section_recover);
    return r;
  }

  /* ********************************************************** */
  // !(T_CAPTURES_SECTION | T_ASSERTS_SECTION | T_METHOD)
  static boolean response_section_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_section_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !response_section_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_CAPTURES_SECTION | T_ASSERTS_SECTION | T_METHOD
  private static boolean response_section_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_section_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_CAPTURES_SECTION);
    if (!r) r = consumeToken(b, T_ASSERTS_SECTION);
    if (!r) r = consumeToken(b, T_METHOD);
    return r;
  }

  /* ********************************************************** */
  // T_RETRY_INTERVAL_OPTION T_COLON duration_option
  public static boolean retry_interval_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "retry_interval_option")) return false;
    if (!nextTokenIs(b, T_RETRY_INTERVAL_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_RETRY_INTERVAL_OPTION, T_COLON);
    r = r && duration_option(b, l + 1);
    exit_section_(b, m, RETRY_INTERVAL_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_RETRY_OPTION T_COLON integer_option
  public static boolean retry_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "retry_option")) return false;
    if (!nextTokenIs(b, T_RETRY_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_RETRY_OPTION, T_COLON);
    r = r && integer_option(b, l + 1);
    exit_section_(b, m, RETRY_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // !(T_BASIC_AUTH_SECTION | T_QUERY_STRING_PARAMS_SECTION | T_FORM_PARAMS_SECTION
  //                             | T_MULTIPART_FORM_DATA_SECTION | T_COOKIES_SECTION | T_OPTIONS_SECTION
  //                             | T_HTTP_VERSION | T_ASSERTS_SECTION | T_CAPTURES_SECTION)
  static boolean section_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !section_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_BASIC_AUTH_SECTION | T_QUERY_STRING_PARAMS_SECTION | T_FORM_PARAMS_SECTION
  //                             | T_MULTIPART_FORM_DATA_SECTION | T_COOKIES_SECTION | T_OPTIONS_SECTION
  //                             | T_HTTP_VERSION | T_ASSERTS_SECTION | T_CAPTURES_SECTION
  private static boolean section_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_BASIC_AUTH_SECTION);
    if (!r) r = consumeToken(b, T_QUERY_STRING_PARAMS_SECTION);
    if (!r) r = consumeToken(b, T_FORM_PARAMS_SECTION);
    if (!r) r = consumeToken(b, T_MULTIPART_FORM_DATA_SECTION);
    if (!r) r = consumeToken(b, T_COOKIES_SECTION);
    if (!r) r = consumeToken(b, T_OPTIONS_SECTION);
    if (!r) r = consumeToken(b, T_HTTP_VERSION);
    if (!r) r = consumeToken(b, T_ASSERTS_SECTION);
    if (!r) r = consumeToken(b, T_CAPTURES_SECTION);
    return r;
  }

  /* ********************************************************** */
  // T_SKIP_OPTION T_COLON boolean_option
  public static boolean skip_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip_option")) return false;
    if (!nextTokenIs(b, T_SKIP_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SKIP_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, SKIP_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_SPACE+
  public static boolean space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space")) return false;
    if (!nextTokenIs(b, T_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, T_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "space", c)) break;
    }
    exit_section_(b, m, SPACE, r);
    return r;
  }

  /* ********************************************************** */
  // T_INTEGER_LITERAL
  public static boolean status(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status")) return false;
    if (!nextTokenIs(b, T_INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INTEGER_LITERAL);
    exit_section_(b, m, STATUS, r);
    return r;
  }

  /* ********************************************************** */
  // T_STRING_START (T_STRING_CONTENT | T_ESCAPED_CHAR | T_UNICODE_ESCAPE | template_expression)* T_STRING_END
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, T_STRING_START);
    r = r && string_literal_1(b, l + 1);
    r = r && consumeToken(b, T_STRING_END);
    exit_section_(b, l, m, r, false, HurlParser::string_recover);
    return r;
  }

  // (T_STRING_CONTENT | T_ESCAPED_CHAR | T_UNICODE_ESCAPE | template_expression)*
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_literal_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_1", c)) break;
    }
    return true;
  }

  // T_STRING_CONTENT | T_ESCAPED_CHAR | T_UNICODE_ESCAPE | template_expression
  private static boolean string_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1_0")) return false;
    boolean r;
    r = consumeToken(b, T_STRING_CONTENT);
    if (!r) r = consumeToken(b, T_ESCAPED_CHAR);
    if (!r) r = consumeToken(b, T_UNICODE_ESCAPE);
    if (!r) r = template_expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_SEMICOLON string_literal
  public static boolean string_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_part")) return false;
    if (!nextTokenIs(b, T_SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, STRING_PART, r);
    return r;
  }

  /* ********************************************************** */
  // !(T_STRING_END)
  static boolean string_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, T_STRING_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_TEMPLATE_START template_variable (T_DOT template_variable | T_LBRACKET T_INTEGER_LITERAL T_RBRACKET)* filter* T_TEMPLATE_END
  public static boolean template_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_expression")) return false;
    if (!nextTokenIs(b, T_TEMPLATE_START)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_EXPRESSION, null);
    r = consumeToken(b, T_TEMPLATE_START);
    p = r; // pin = 1
    r = r && report_error_(b, template_variable(b, l + 1));
    r = p && report_error_(b, template_expression_2(b, l + 1)) && r;
    r = p && report_error_(b, template_expression_3(b, l + 1)) && r;
    r = p && consumeToken(b, T_TEMPLATE_END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (T_DOT template_variable | T_LBRACKET T_INTEGER_LITERAL T_RBRACKET)*
  private static boolean template_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_expression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!template_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "template_expression_2", c)) break;
    }
    return true;
  }

  // T_DOT template_variable | T_LBRACKET T_INTEGER_LITERAL T_RBRACKET
  private static boolean template_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = template_expression_2_0_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, T_LBRACKET, T_INTEGER_LITERAL, T_RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_DOT template_variable
  private static boolean template_expression_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_expression_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOT);
    r = r && template_variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // filter*
  private static boolean template_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!filter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "template_expression_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_TEMPLATE_IDENTIFIER | T_TEMPLATE_NUMBER
  public static boolean template_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_variable")) return false;
    if (!nextTokenIs(b, "<template variable>", T_TEMPLATE_IDENTIFIER, T_TEMPLATE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEMPLATE_VARIABLE, "<template variable>");
    r = consumeToken(b, T_TEMPLATE_IDENTIFIER);
    if (!r) r = consumeToken(b, T_TEMPLATE_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_UNIX_SOCKET_OPTION T_COLON value_string
  public static boolean unix_socket_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unix_socket_option")) return false;
    if (!nextTokenIs(b, T_UNIX_SOCKET_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_UNIX_SOCKET_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, UNIX_SOCKET_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_URL | value_string
  public static boolean url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL, "<url>");
    r = consumeToken(b, T_URL);
    if (!r) r = value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_USER_OPTION T_COLON value_string
  public static boolean user_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_option")) return false;
    if (!nextTokenIs(b, T_USER_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_USER_OPTION, T_COLON);
    r = r && value_string(b, l + 1);
    exit_section_(b, m, USER_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // string_literal | T_BOOLEAN | T_NULL | T_IDENTIFIER | T_INTEGER_LITERAL | T_FLOAT_LITERAL | T_URL
  public static boolean value_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_STRING, "<value string>");
    r = string_literal(b, l + 1);
    if (!r) r = consumeToken(b, T_BOOLEAN);
    if (!r) r = consumeToken(b, T_NULL);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, T_INTEGER_LITERAL);
    if (!r) r = consumeToken(b, T_FLOAT_LITERAL);
    if (!r) r = consumeToken(b, T_URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER T_EQUALS variable_value
  public static boolean variable_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_definition")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IDENTIFIER, T_EQUALS);
    r = r && variable_value(b, l + 1);
    exit_section_(b, m, VARIABLE_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // T_VARIABLE_OPTION T_COLON variable_definition
  public static boolean variable_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_option")) return false;
    if (!nextTokenIs(b, T_VARIABLE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_VARIABLE_OPTION, T_COLON);
    r = r && variable_definition(b, l + 1);
    exit_section_(b, m, VARIABLE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // json_value
  public static boolean variable_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_VALUE, "<variable value>");
    r = json_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_VERBOSE_OPTION T_COLON boolean_option
  public static boolean verbose_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "verbose_option")) return false;
    if (!nextTokenIs(b, T_VERBOSE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_VERBOSE_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, VERBOSE_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // T_VERY_VERBOSE_OPTION T_COLON boolean_option
  public static boolean very_verbose_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "very_verbose_option")) return false;
    if (!nextTokenIs(b, T_VERY_VERBOSE_OPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_VERY_VERBOSE_OPTION, T_COLON);
    r = r && boolean_option(b, l + 1);
    exit_section_(b, m, VERY_VERBOSE_OPTION, r);
    return r;
  }

}
