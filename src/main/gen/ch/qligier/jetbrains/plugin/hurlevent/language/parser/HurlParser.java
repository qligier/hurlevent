// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.hurlevent.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ch.qligier.jetbrains.plugin.hurlevent.language.psi.HurlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HurlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return hurlFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // query filter_list? predicate NEWLINE?
  public static boolean assert_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_entry")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSERT_ENTRY, "<assert entry>");
    result_ = query(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, assert_entry_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, predicate(builder_, level_ + 1)) && result_;
    result_ = pinned_ && assert_entry_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // filter_list?
  private static boolean assert_entry_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_entry_1")) return false;
    filter_list(builder_, level_ + 1);
    return true;
  }

  // NEWLINE?
  private static boolean assert_entry_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_entry_3")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // (assert_entry | COMMENT NEWLINE? | NEWLINE)*
  public static boolean assert_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_list")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSERT_LIST, "<assert list>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!assert_list_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "assert_list", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // assert_entry | COMMENT NEWLINE? | NEWLINE
  private static boolean assert_list_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_list_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = assert_entry(builder_, level_ + 1);
    if (!result_) result_ = assert_list_0_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean assert_list_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_list_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && assert_list_0_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean assert_list_0_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assert_list_0_1_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // SECTION_ASSERTS NEWLINE assert_list
  public static boolean asserts_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "asserts_section")) return false;
    if (!nextTokenIs(builder_, SECTION_ASSERTS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSERTS_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_ASSERTS, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && assert_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // BASE64_PREFIX BASE64_DATA?
  public static boolean base64_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "base64_body")) return false;
    if (!nextTokenIs(builder_, BASE64_PREFIX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BASE64_PREFIX);
    result_ = result_ && base64_body_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, BASE_64_BODY, result_);
    return result_;
  }

  // BASE64_DATA?
  private static boolean base64_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "base64_body_1")) return false;
    consumeToken(builder_, BASE64_DATA);
    return true;
  }

  /* ********************************************************** */
  // SECTION_BASIC_AUTH NEWLINE key_value_list
  public static boolean basic_auth_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "basic_auth_section")) return false;
    if (!nextTokenIs(builder_, SECTION_BASIC_AUTH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BASIC_AUTH_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_BASIC_AUTH, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && key_value_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // json_body | xml_body | multiline_string_body | file_body | base64_body | hex_body | raw_body
  public static boolean body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "body")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BODY, "<body>");
    result_ = json_body(builder_, level_ + 1);
    if (!result_) result_ = xml_body(builder_, level_ + 1);
    if (!result_) result_ = multiline_string_body(builder_, level_ + 1);
    if (!result_) result_ = file_body(builder_, level_ + 1);
    if (!result_) result_ = base64_body(builder_, level_ + 1);
    if (!result_) result_ = hex_body(builder_, level_ + 1);
    if (!result_) result_ = raw_body(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // KW_BODY
  public static boolean body_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "body_query")) return false;
    if (!nextTokenIs(builder_, KW_BODY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_BODY);
    exit_section_(builder_, marker_, BODY_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_BYTES
  public static boolean bytes_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "bytes_query")) return false;
    if (!nextTokenIs(builder_, KW_BYTES)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_BYTES);
    exit_section_(builder_, marker_, BYTES_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEY_STRING COLON query filter_list? NEWLINE?
  public static boolean capture_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_entry")) return false;
    if (!nextTokenIs(builder_, KEY_STRING)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CAPTURE_ENTRY, null);
    result_ = consumeTokens(builder_, 2, KEY_STRING, COLON);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, query(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, capture_entry_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && capture_entry_4(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // filter_list?
  private static boolean capture_entry_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_entry_3")) return false;
    filter_list(builder_, level_ + 1);
    return true;
  }

  // NEWLINE?
  private static boolean capture_entry_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_entry_4")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // (capture_entry | COMMENT NEWLINE? | NEWLINE)*
  public static boolean capture_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_list")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CAPTURE_LIST, "<capture list>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!capture_list_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "capture_list", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // capture_entry | COMMENT NEWLINE? | NEWLINE
  private static boolean capture_list_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_list_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = capture_entry(builder_, level_ + 1);
    if (!result_) result_ = capture_list_0_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean capture_list_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_list_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && capture_list_0_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean capture_list_0_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "capture_list_0_1_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // SECTION_CAPTURES NEWLINE capture_list
  public static boolean captures_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "captures_section")) return false;
    if (!nextTokenIs(builder_, SECTION_CAPTURES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CAPTURES_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_CAPTURES, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && capture_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_CERTIFICATE quoted_string_value
  public static boolean certificate_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "certificate_query")) return false;
    if (!nextTokenIs(builder_, KW_CERTIFICATE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_CERTIFICATE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, CERTIFICATE_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_CONTAINS predicate_value
  public static boolean contains_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "contains_predicate")) return false;
    if (!nextTokenIs(builder_, KW_CONTAINS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_CONTAINS);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, CONTAINS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_COOKIE quoted_string_value
  public static boolean cookie_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cookie_query")) return false;
    if (!nextTokenIs(builder_, KW_COOKIE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_COOKIE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, COOKIE_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // SECTION_COOKIES NEWLINE key_value_list
  public static boolean cookies_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cookies_section")) return false;
    if (!nextTokenIs(builder_, SECTION_COOKIES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COOKIES_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_COOKIES, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && key_value_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_COUNT
  public static boolean count_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "count_filter")) return false;
    if (!nextTokenIs(builder_, KW_COUNT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_COUNT);
    exit_section_(builder_, marker_, COUNT_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_DECODE quoted_string_value
  public static boolean decode_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "decode_filter")) return false;
    if (!nextTokenIs(builder_, KW_DECODE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_DECODE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, DECODE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_DURATION
  public static boolean duration_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "duration_query")) return false;
    if (!nextTokenIs(builder_, KW_DURATION)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_DURATION);
    exit_section_(builder_, marker_, DURATION_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_ENDS_WITH predicate_value
  public static boolean ends_with_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ends_with_predicate")) return false;
    if (!nextTokenIs(builder_, KW_ENDS_WITH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_ENDS_WITH);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, ENDS_WITH_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // request NEWLINE* response?
  public static boolean entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENTRY, "<entry>");
    result_ = request(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, entry_1(builder_, level_ + 1));
    result_ = pinned_ && entry_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEWLINE*
  private static boolean entry_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, NEWLINE)) break;
      if (!empty_element_parsed_guard_(builder_, "entry_1", pos_)) break;
    }
    return true;
  }

  // response?
  private static boolean entry_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry_2")) return false;
    response(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> entry
  static boolean entry_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry_")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = entry__0(builder_, level_ + 1);
    result_ = result_ && entry(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, HurlParser::entry_recover);
    return result_;
  }

  // !<<eof>>
  private static boolean entry__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry__0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !eof(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // !(method | HTTP_VERSION | NEWLINE)
  static boolean entry_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !entry_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // method | HTTP_VERSION | NEWLINE
  private static boolean entry_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entry_recover_0")) return false;
    boolean result_;
    result_ = method(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, HTTP_VERSION);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    return result_;
  }

  /* ********************************************************** */
  // KW_EQUALS predicate_value
  public static boolean equals_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "equals_predicate")) return false;
    if (!nextTokenIs(builder_, KW_EQUALS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_EQUALS);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, EQUALS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_EXISTS
  public static boolean exists_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "exists_predicate")) return false;
    if (!nextTokenIs(builder_, KW_EXISTS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_EXISTS);
    exit_section_(builder_, marker_, EXISTS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // FILE_PREFIX FILENAME?
  public static boolean file_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_body")) return false;
    if (!nextTokenIs(builder_, FILE_PREFIX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FILE_PREFIX);
    result_ = result_ && file_body_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, FILE_BODY, result_);
    return result_;
  }

  // FILENAME?
  private static boolean file_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_body_1")) return false;
    consumeToken(builder_, FILENAME);
    return true;
  }

  /* ********************************************************** */
  // count_filter | nth_filter | replace_filter | split_filter
  //          | to_date_filter | to_float_filter | to_int_filter | decode_filter
  //          | format_filter | html_escape_filter | html_unescape_filter
  //          | url_encode_filter | url_decode_filter
  public static boolean filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "filter")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FILTER, "<filter>");
    result_ = count_filter(builder_, level_ + 1);
    if (!result_) result_ = nth_filter(builder_, level_ + 1);
    if (!result_) result_ = replace_filter(builder_, level_ + 1);
    if (!result_) result_ = split_filter(builder_, level_ + 1);
    if (!result_) result_ = to_date_filter(builder_, level_ + 1);
    if (!result_) result_ = to_float_filter(builder_, level_ + 1);
    if (!result_) result_ = to_int_filter(builder_, level_ + 1);
    if (!result_) result_ = decode_filter(builder_, level_ + 1);
    if (!result_) result_ = format_filter(builder_, level_ + 1);
    if (!result_) result_ = html_escape_filter(builder_, level_ + 1);
    if (!result_) result_ = html_unescape_filter(builder_, level_ + 1);
    if (!result_) result_ = url_encode_filter(builder_, level_ + 1);
    if (!result_) result_ = url_decode_filter(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // filter+
  public static boolean filter_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "filter_list")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FILTER_LIST, "<filter list>");
    result_ = filter(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!filter(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "filter_list", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SECTION_FORM_PARAMS NEWLINE key_value_list
  public static boolean form_params_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "form_params_section")) return false;
    if (!nextTokenIs(builder_, SECTION_FORM_PARAMS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FORM_PARAMS_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_FORM_PARAMS, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && key_value_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_FORMAT quoted_string_value
  public static boolean format_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "format_filter")) return false;
    if (!nextTokenIs(builder_, KW_FORMAT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_FORMAT);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, FORMAT_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_GREATER_THAN_OR_EQUALS predicate_value
  public static boolean greater_than_or_equals_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "greater_than_or_equals_predicate")) return false;
    if (!nextTokenIs(builder_, KW_GREATER_THAN_OR_EQUALS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_GREATER_THAN_OR_EQUALS);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, GREATER_THAN_OR_EQUALS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_GREATER_THAN predicate_value
  public static boolean greater_than_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "greater_than_predicate")) return false;
    if (!nextTokenIs(builder_, KW_GREATER_THAN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_GREATER_THAN);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, GREATER_THAN_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // HEADER_KEY COLON header_val?
  public static boolean header(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header")) return false;
    if (!nextTokenIs(builder_, HEADER_KEY)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, HEADER, null);
    result_ = consumeTokens(builder_, 1, HEADER_KEY, COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && header_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // header_val?
  private static boolean header_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header_2")) return false;
    header_val(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_HEADER quoted_string_value
  public static boolean header_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header_query")) return false;
    if (!nextTokenIs(builder_, KW_HEADER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_HEADER);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, HEADER_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // (HEADER_VALUE | template)+
  public static boolean header_val(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header_val")) return false;
    if (!nextTokenIs(builder_, "<header val>", HEADER_VALUE, LBRACE2)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, HEADER_VAL, "<header val>");
    result_ = header_val_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!header_val_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "header_val", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // HEADER_VALUE | template
  private static boolean header_val_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "header_val_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, HEADER_VALUE);
    if (!result_) result_ = template(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // HEX_PREFIX HEX_DATA?
  public static boolean hex_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "hex_body")) return false;
    if (!nextTokenIs(builder_, HEX_PREFIX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, HEX_PREFIX);
    result_ = result_ && hex_body_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, HEX_BODY, result_);
    return result_;
  }

  // HEX_DATA?
  private static boolean hex_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "hex_body_1")) return false;
    consumeToken(builder_, HEX_DATA);
    return true;
  }

  /* ********************************************************** */
  // KW_HTML_ESCAPE
  public static boolean html_escape_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "html_escape_filter")) return false;
    if (!nextTokenIs(builder_, KW_HTML_ESCAPE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_HTML_ESCAPE);
    exit_section_(builder_, marker_, HTML_ESCAPE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_HTML_UNESCAPE
  public static boolean html_unescape_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "html_unescape_filter")) return false;
    if (!nextTokenIs(builder_, KW_HTML_UNESCAPE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_HTML_UNESCAPE);
    exit_section_(builder_, marker_, HTML_UNESCAPE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // (entry_ | COMMENT | NEWLINE)*
  static boolean hurlFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "hurlFile")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!hurlFile_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "hurlFile", pos_)) break;
    }
    return true;
  }

  // entry_ | COMMENT | NEWLINE
  private static boolean hurlFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "hurlFile_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = entry_(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_INCLUDES predicate_value
  public static boolean includes_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "includes_predicate")) return false;
    if (!nextTokenIs(builder_, KW_INCLUDES)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_INCLUDES);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, INCLUDES_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_BOOLEAN
  public static boolean is_boolean_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_boolean_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_BOOLEAN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_BOOLEAN);
    exit_section_(builder_, marker_, IS_BOOLEAN_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_COLLECTION
  public static boolean is_collection_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_collection_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_COLLECTION)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_COLLECTION);
    exit_section_(builder_, marker_, IS_COLLECTION_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_DATE
  public static boolean is_date_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_date_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_DATE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_DATE);
    exit_section_(builder_, marker_, IS_DATE_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_EMPTY
  public static boolean is_empty_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_empty_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_EMPTY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_EMPTY);
    exit_section_(builder_, marker_, IS_EMPTY_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_FLOAT
  public static boolean is_float_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_float_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_FLOAT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_FLOAT);
    exit_section_(builder_, marker_, IS_FLOAT_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_INTEGER
  public static boolean is_integer_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_integer_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_INTEGER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_INTEGER);
    exit_section_(builder_, marker_, IS_INTEGER_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_ISO_DATE
  public static boolean is_iso_date_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_iso_date_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_ISO_DATE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_ISO_DATE);
    exit_section_(builder_, marker_, IS_ISO_DATE_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_NUMBER
  public static boolean is_number_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_number_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_NUMBER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_NUMBER);
    exit_section_(builder_, marker_, IS_NUMBER_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_IS_STRING
  public static boolean is_string_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "is_string_predicate")) return false;
    if (!nextTokenIs(builder_, KW_IS_STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_IS_STRING);
    exit_section_(builder_, marker_, IS_STRING_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE json_content* RBRACE
  public static boolean json_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json_body")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, JSON_BODY, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, json_body_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // json_content*
  private static boolean json_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json_body_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!json_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "json_body_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // JSON_TEXT | template
  public static boolean json_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json_content")) return false;
    if (!nextTokenIs(builder_, "<json content>", JSON_TEXT, LBRACE2)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, JSON_CONTENT, "<json content>");
    result_ = consumeToken(builder_, JSON_TEXT);
    if (!result_) result_ = template(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // KW_JSONPATH quoted_string_value
  public static boolean jsonpath_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "jsonpath_query")) return false;
    if (!nextTokenIs(builder_, KW_JSONPATH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_JSONPATH);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, JSONPATH_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // (key_value_pair | COMMENT NEWLINE? | NEWLINE)*
  public static boolean key_value_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_list")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, KEY_VALUE_LIST, "<key value list>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!key_value_list_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "key_value_list", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // key_value_pair | COMMENT NEWLINE? | NEWLINE
  private static boolean key_value_list_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_list_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = key_value_pair(builder_, level_ + 1);
    if (!result_) result_ = key_value_list_0_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean key_value_list_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_list_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && key_value_list_0_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean key_value_list_0_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_list_0_1_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // kv_key COLON value_content NEWLINE?
  public static boolean key_value_pair(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_pair")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, KEY_VALUE_PAIR, "<key value pair>");
    result_ = kv_key(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, value_content(builder_, level_ + 1));
    result_ = pinned_ && key_value_pair_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEWLINE?
  private static boolean key_value_pair_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_value_pair_3")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // KEY_STRING | QUOTED_STRING | BACKTICK_STRING
  public static boolean kv_key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "kv_key")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, KV_KEY, "<kv key>");
    result_ = consumeToken(builder_, KEY_STRING);
    if (!result_) result_ = consumeToken(builder_, QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, BACKTICK_STRING);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // KW_LESS_THAN_OR_EQUALS predicate_value
  public static boolean less_than_or_equals_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "less_than_or_equals_predicate")) return false;
    if (!nextTokenIs(builder_, KW_LESS_THAN_OR_EQUALS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_LESS_THAN_OR_EQUALS);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, LESS_THAN_OR_EQUALS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_LESS_THAN predicate_value
  public static boolean less_than_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "less_than_predicate")) return false;
    if (!nextTokenIs(builder_, KW_LESS_THAN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_LESS_THAN);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, LESS_THAN_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_MATCHES predicate_value
  public static boolean matches_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "matches_predicate")) return false;
    if (!nextTokenIs(builder_, KW_MATCHES)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_MATCHES);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, MATCHES_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_MD5
  public static boolean md5_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "md5_query")) return false;
    if (!nextTokenIs(builder_, KW_MD5)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_MD5);
    exit_section_(builder_, marker_, MD_5_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // GET | POST | PUT | DELETE | PATCH | HEAD | OPTIONS
  //          | CONNECT | TRACE | LINK | UNLINK | PURGE | LOCK | UNLOCK
  //          | PROPFIND | PROPPATCH | COPY | MOVE | MKCOL | REPORT | SEARCH
  public static boolean method(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD, "<method>");
    result_ = consumeToken(builder_, GET);
    if (!result_) result_ = consumeToken(builder_, POST);
    if (!result_) result_ = consumeToken(builder_, PUT);
    if (!result_) result_ = consumeToken(builder_, DELETE);
    if (!result_) result_ = consumeToken(builder_, PATCH);
    if (!result_) result_ = consumeToken(builder_, HEAD);
    if (!result_) result_ = consumeToken(builder_, OPTIONS);
    if (!result_) result_ = consumeToken(builder_, CONNECT);
    if (!result_) result_ = consumeToken(builder_, TRACE);
    if (!result_) result_ = consumeToken(builder_, LINK);
    if (!result_) result_ = consumeToken(builder_, UNLINK);
    if (!result_) result_ = consumeToken(builder_, PURGE);
    if (!result_) result_ = consumeToken(builder_, LOCK);
    if (!result_) result_ = consumeToken(builder_, UNLOCK);
    if (!result_) result_ = consumeToken(builder_, PROPFIND);
    if (!result_) result_ = consumeToken(builder_, PROPPATCH);
    if (!result_) result_ = consumeToken(builder_, COPY);
    if (!result_) result_ = consumeToken(builder_, MOVE);
    if (!result_) result_ = consumeToken(builder_, MKCOL);
    if (!result_) result_ = consumeToken(builder_, REPORT);
    if (!result_) result_ = consumeToken(builder_, SEARCH);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // MULTILINE_STRING_CONTENT | template
  public static boolean multiline_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_content")) return false;
    if (!nextTokenIs(builder_, "<multiline content>", LBRACE2, MULTILINE_STRING_CONTENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MULTILINE_CONTENT, "<multiline content>");
    result_ = consumeToken(builder_, MULTILINE_STRING_CONTENT);
    if (!result_) result_ = template(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // MULTILINE_STRING_OPEN multiline_content* MULTILINE_STRING_CLOSE
  public static boolean multiline_string_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_string_body")) return false;
    if (!nextTokenIs(builder_, MULTILINE_STRING_OPEN)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MULTILINE_STRING_BODY, null);
    result_ = consumeToken(builder_, MULTILINE_STRING_OPEN);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, multiline_string_body_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, MULTILINE_STRING_CLOSE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // multiline_content*
  private static boolean multiline_string_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multiline_string_body_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!multiline_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "multiline_string_body_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SECTION_MULTIPART_FORM_DATA NEWLINE key_value_list
  public static boolean multipart_form_data_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "multipart_form_data_section")) return false;
    if (!nextTokenIs(builder_, SECTION_MULTIPART_FORM_DATA)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MULTIPART_FORM_DATA_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_MULTIPART_FORM_DATA, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && key_value_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_NOT_EQUALS predicate_value
  public static boolean not_equals_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "not_equals_predicate")) return false;
    if (!nextTokenIs(builder_, KW_NOT_EQUALS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_NOT_EQUALS);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, NOT_EQUALS_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_NOT
  public static boolean not_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "not_predicate")) return false;
    if (!nextTokenIs(builder_, KW_NOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_NOT);
    exit_section_(builder_, marker_, NOT_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_NTH NUMBER
  public static boolean nth_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nth_filter")) return false;
    if (!nextTokenIs(builder_, KW_NTH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, KW_NTH, NUMBER);
    exit_section_(builder_, marker_, NTH_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // (EQUALS_OP | NOT_EQUALS_OP | GREATER_THAN_OP | GREATER_THAN_OR_EQUALS_OP
  //                        | LESS_THAN_OP | LESS_THAN_OR_EQUALS_OP) predicate_value
  public static boolean operator_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operator_predicate")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPERATOR_PREDICATE, "<operator predicate>");
    result_ = operator_predicate_0(builder_, level_ + 1);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // EQUALS_OP | NOT_EQUALS_OP | GREATER_THAN_OP | GREATER_THAN_OR_EQUALS_OP
  //                        | LESS_THAN_OP | LESS_THAN_OR_EQUALS_OP
  private static boolean operator_predicate_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operator_predicate_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EQUALS_OP);
    if (!result_) result_ = consumeToken(builder_, NOT_EQUALS_OP);
    if (!result_) result_ = consumeToken(builder_, GREATER_THAN_OP);
    if (!result_) result_ = consumeToken(builder_, GREATER_THAN_OR_EQUALS_OP);
    if (!result_) result_ = consumeToken(builder_, LESS_THAN_OP);
    if (!result_) result_ = consumeToken(builder_, LESS_THAN_OR_EQUALS_OP);
    return result_;
  }

  /* ********************************************************** */
  // option_key COLON option_value NEWLINE?
  public static boolean option_entry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_entry")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPTION_ENTRY, "<option entry>");
    result_ = option_key(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, option_value(builder_, level_ + 1));
    result_ = pinned_ && option_entry_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEWLINE?
  private static boolean option_entry_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_entry_3")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // KW_AWS_SIGV4 | KW_CACERT | KW_CERT | KW_COMPRESSED | KW_CONNECT_TO
  //              | KW_DELAY | KW_HTTP10 | KW_HTTP11 | KW_HTTP2 | KW_HTTP3
  //              | KW_INSECURE | KW_IPVF | KW_IPVS | KW_KEY | KW_LOCATION
  //              | KW_LOCATION_TRUSTED | KW_MAX_REDIRS | KW_OUTPUT | KW_PATH_AS_IS
  //              | KW_PROXY | KW_RESOLVE | KW_RETRY | KW_RETRY_INTERVAL | KW_SKIP
  //              | KW_UNIX_SOCKET | KW_USER | KW_VERBOSE | KW_VERY_VERBOSE | KW_VARIABLE
  //              | KEY_STRING
  public static boolean option_key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_key")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPTION_KEY, "<option key>");
    result_ = consumeToken(builder_, KW_AWS_SIGV4);
    if (!result_) result_ = consumeToken(builder_, KW_CACERT);
    if (!result_) result_ = consumeToken(builder_, KW_CERT);
    if (!result_) result_ = consumeToken(builder_, KW_COMPRESSED);
    if (!result_) result_ = consumeToken(builder_, KW_CONNECT_TO);
    if (!result_) result_ = consumeToken(builder_, KW_DELAY);
    if (!result_) result_ = consumeToken(builder_, KW_HTTP10);
    if (!result_) result_ = consumeToken(builder_, KW_HTTP11);
    if (!result_) result_ = consumeToken(builder_, KW_HTTP2);
    if (!result_) result_ = consumeToken(builder_, KW_HTTP3);
    if (!result_) result_ = consumeToken(builder_, KW_INSECURE);
    if (!result_) result_ = consumeToken(builder_, KW_IPVF);
    if (!result_) result_ = consumeToken(builder_, KW_IPVS);
    if (!result_) result_ = consumeToken(builder_, KW_KEY);
    if (!result_) result_ = consumeToken(builder_, KW_LOCATION);
    if (!result_) result_ = consumeToken(builder_, KW_LOCATION_TRUSTED);
    if (!result_) result_ = consumeToken(builder_, KW_MAX_REDIRS);
    if (!result_) result_ = consumeToken(builder_, KW_OUTPUT);
    if (!result_) result_ = consumeToken(builder_, KW_PATH_AS_IS);
    if (!result_) result_ = consumeToken(builder_, KW_PROXY);
    if (!result_) result_ = consumeToken(builder_, KW_RESOLVE);
    if (!result_) result_ = consumeToken(builder_, KW_RETRY);
    if (!result_) result_ = consumeToken(builder_, KW_RETRY_INTERVAL);
    if (!result_) result_ = consumeToken(builder_, KW_SKIP);
    if (!result_) result_ = consumeToken(builder_, KW_UNIX_SOCKET);
    if (!result_) result_ = consumeToken(builder_, KW_USER);
    if (!result_) result_ = consumeToken(builder_, KW_VERBOSE);
    if (!result_) result_ = consumeToken(builder_, KW_VERY_VERBOSE);
    if (!result_) result_ = consumeToken(builder_, KW_VARIABLE);
    if (!result_) result_ = consumeToken(builder_, KEY_STRING);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (option_entry | COMMENT NEWLINE? | NEWLINE)*
  public static boolean option_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPTION_LIST, "<option list>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!option_list_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "option_list", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // option_entry | COMMENT NEWLINE? | NEWLINE
  private static boolean option_list_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = option_entry(builder_, level_ + 1);
    if (!result_) result_ = option_list_0_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean option_list_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && option_list_0_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean option_list_0_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list_0_1_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // (VALUE_STRING | QUOTED_STRING | NUMBER | FLOAT_NUMBER | TRUE | FALSE | template)+
  public static boolean option_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPTION_VALUE, "<option value>");
    result_ = option_value_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!option_value_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "option_value", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // VALUE_STRING | QUOTED_STRING | NUMBER | FLOAT_NUMBER | TRUE | FALSE | template
  private static boolean option_value_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_value_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, VALUE_STRING);
    if (!result_) result_ = consumeToken(builder_, QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, FLOAT_NUMBER);
    if (!result_) result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    if (!result_) result_ = template(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // SECTION_OPTIONS NEWLINE option_list
  public static boolean options_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "options_section")) return false;
    if (!nextTokenIs(builder_, SECTION_OPTIONS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPTIONS_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_OPTIONS, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && option_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // not_predicate? predicate_func
  public static boolean predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "predicate")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PREDICATE, "<predicate>");
    result_ = predicate_0(builder_, level_ + 1);
    result_ = result_ && predicate_func(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // not_predicate?
  private static boolean predicate_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "predicate_0")) return false;
    not_predicate(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // equals_predicate | not_equals_predicate
  //                  | greater_than_predicate | greater_than_or_equals_predicate
  //                  | less_than_predicate | less_than_or_equals_predicate
  //                  | starts_with_predicate | ends_with_predicate
  //                  | contains_predicate | includes_predicate | matches_predicate
  //                  | exists_predicate | is_empty_predicate
  //                  | is_number_predicate | is_string_predicate | is_boolean_predicate
  //                  | is_collection_predicate | is_date_predicate | is_iso_date_predicate
  //                  | is_float_predicate | is_integer_predicate
  //                  | operator_predicate
  public static boolean predicate_func(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "predicate_func")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PREDICATE_FUNC, "<predicate func>");
    result_ = equals_predicate(builder_, level_ + 1);
    if (!result_) result_ = not_equals_predicate(builder_, level_ + 1);
    if (!result_) result_ = greater_than_predicate(builder_, level_ + 1);
    if (!result_) result_ = greater_than_or_equals_predicate(builder_, level_ + 1);
    if (!result_) result_ = less_than_predicate(builder_, level_ + 1);
    if (!result_) result_ = less_than_or_equals_predicate(builder_, level_ + 1);
    if (!result_) result_ = starts_with_predicate(builder_, level_ + 1);
    if (!result_) result_ = ends_with_predicate(builder_, level_ + 1);
    if (!result_) result_ = contains_predicate(builder_, level_ + 1);
    if (!result_) result_ = includes_predicate(builder_, level_ + 1);
    if (!result_) result_ = matches_predicate(builder_, level_ + 1);
    if (!result_) result_ = exists_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_empty_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_number_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_string_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_boolean_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_collection_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_date_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_iso_date_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_float_predicate(builder_, level_ + 1);
    if (!result_) result_ = is_integer_predicate(builder_, level_ + 1);
    if (!result_) result_ = operator_predicate(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // QUOTED_STRING | BACKTICK_STRING | NUMBER | FLOAT_NUMBER
  //                    | TRUE | FALSE | NULL | template
  public static boolean predicate_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "predicate_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PREDICATE_VALUE, "<predicate value>");
    result_ = consumeToken(builder_, QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, BACKTICK_STRING);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, FLOAT_NUMBER);
    if (!result_) result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    if (!result_) result_ = consumeToken(builder_, NULL);
    if (!result_) result_ = template(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // status_query
  //         | url_query
  //         | header_query
  //         | cookie_query
  //         | body_query
  //         | xpath_query
  //         | jsonpath_query
  //         | regex_query
  //         | variable_query
  //         | duration_query
  //         | sha256_query
  //         | md5_query
  //         | bytes_query
  //         | certificate_query
  public static boolean query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, QUERY, "<query>");
    result_ = status_query(builder_, level_ + 1);
    if (!result_) result_ = url_query(builder_, level_ + 1);
    if (!result_) result_ = header_query(builder_, level_ + 1);
    if (!result_) result_ = cookie_query(builder_, level_ + 1);
    if (!result_) result_ = body_query(builder_, level_ + 1);
    if (!result_) result_ = xpath_query(builder_, level_ + 1);
    if (!result_) result_ = jsonpath_query(builder_, level_ + 1);
    if (!result_) result_ = regex_query(builder_, level_ + 1);
    if (!result_) result_ = variable_query(builder_, level_ + 1);
    if (!result_) result_ = duration_query(builder_, level_ + 1);
    if (!result_) result_ = sha256_query(builder_, level_ + 1);
    if (!result_) result_ = md5_query(builder_, level_ + 1);
    if (!result_) result_ = bytes_query(builder_, level_ + 1);
    if (!result_) result_ = certificate_query(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SECTION_QUERY_STRING_PARAMS NEWLINE key_value_list
  public static boolean query_string_params_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query_string_params_section")) return false;
    if (!nextTokenIs(builder_, SECTION_QUERY_STRING_PARAMS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, QUERY_STRING_PARAMS_SECTION, null);
    result_ = consumeTokens(builder_, 1, SECTION_QUERY_STRING_PARAMS, NEWLINE);
    pinned_ = result_; // pin = 1
    result_ = result_ && key_value_list(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // QUOTED_STRING | BACKTICK_STRING
  public static boolean quoted_string_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "quoted_string_value")) return false;
    if (!nextTokenIs(builder_, "<quoted string value>", BACKTICK_STRING, QUOTED_STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, QUOTED_STRING_VALUE, "<quoted string value>");
    result_ = consumeToken(builder_, QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, BACKTICK_STRING);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // BODY_DATA+
  public static boolean raw_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "raw_body")) return false;
    if (!nextTokenIs(builder_, BODY_DATA)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BODY_DATA);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, BODY_DATA)) break;
      if (!empty_element_parsed_guard_(builder_, "raw_body", pos_)) break;
    }
    exit_section_(builder_, marker_, RAW_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_REGEX quoted_string_value
  public static boolean regex_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_query")) return false;
    if (!nextTokenIs(builder_, KW_REGEX)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_REGEX);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, REGEX_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_REPLACE quoted_string_value quoted_string_value
  public static boolean replace_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "replace_filter")) return false;
    if (!nextTokenIs(builder_, KW_REPLACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_REPLACE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, REPLACE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // request_line NEWLINE* request_section* body?
  public static boolean request(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REQUEST, "<request>");
    result_ = request_line(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, request_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, request_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && request_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEWLINE*
  private static boolean request_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, NEWLINE)) break;
      if (!empty_element_parsed_guard_(builder_, "request_1", pos_)) break;
    }
    return true;
  }

  // request_section*
  private static boolean request_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!request_section(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "request_2", pos_)) break;
    }
    return true;
  }

  // body?
  private static boolean request_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_3")) return false;
    body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // method url
  public static boolean request_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_line")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REQUEST_LINE, "<request line>");
    result_ = method(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && url(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // header NEWLINE
  //                    | query_string_params_section
  //                    | form_params_section
  //                    | multipart_form_data_section
  //                    | cookies_section
  //                    | basic_auth_section
  //                    | options_section
  //                    | NEWLINE
  //                    | COMMENT NEWLINE?
  public static boolean request_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_section")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REQUEST_SECTION, "<request section>");
    result_ = request_section_0(builder_, level_ + 1);
    if (!result_) result_ = query_string_params_section(builder_, level_ + 1);
    if (!result_) result_ = form_params_section(builder_, level_ + 1);
    if (!result_) result_ = multipart_form_data_section(builder_, level_ + 1);
    if (!result_) result_ = cookies_section(builder_, level_ + 1);
    if (!result_) result_ = basic_auth_section(builder_, level_ + 1);
    if (!result_) result_ = options_section(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    if (!result_) result_ = request_section_8(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // header NEWLINE
  private static boolean request_section_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_section_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = header(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean request_section_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_section_8")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && request_section_8_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean request_section_8_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "request_section_8_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // response_line NEWLINE* response_section* body?
  public static boolean response(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response")) return false;
    if (!nextTokenIs(builder_, HTTP_VERSION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RESPONSE, null);
    result_ = response_line(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, response_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, response_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && response_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEWLINE*
  private static boolean response_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, NEWLINE)) break;
      if (!empty_element_parsed_guard_(builder_, "response_1", pos_)) break;
    }
    return true;
  }

  // response_section*
  private static boolean response_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!response_section(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "response_2", pos_)) break;
    }
    return true;
  }

  // body?
  private static boolean response_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_3")) return false;
    body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // HTTP_VERSION status_value
  public static boolean response_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_line")) return false;
    if (!nextTokenIs(builder_, HTTP_VERSION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RESPONSE_LINE, null);
    result_ = consumeToken(builder_, HTTP_VERSION);
    pinned_ = result_; // pin = 1
    result_ = result_ && status_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // captures_section
  //                     | asserts_section
  //                     | header NEWLINE
  //                     | NEWLINE
  //                     | COMMENT NEWLINE?
  public static boolean response_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_section")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RESPONSE_SECTION, "<response section>");
    result_ = captures_section(builder_, level_ + 1);
    if (!result_) result_ = asserts_section(builder_, level_ + 1);
    if (!result_) result_ = response_section_2(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    if (!result_) result_ = response_section_4(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // header NEWLINE
  private static boolean response_section_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_section_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = header(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMMENT NEWLINE?
  private static boolean response_section_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_section_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && response_section_4_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE?
  private static boolean response_section_4_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "response_section_4_1")) return false;
    consumeToken(builder_, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // KW_SHA256
  public static boolean sha256_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sha256_query")) return false;
    if (!nextTokenIs(builder_, KW_SHA256)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_SHA256);
    exit_section_(builder_, marker_, SHA_256_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_SPLIT quoted_string_value
  public static boolean split_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "split_filter")) return false;
    if (!nextTokenIs(builder_, KW_SPLIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_SPLIT);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, SPLIT_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_STARTS_WITH predicate_value
  public static boolean starts_with_predicate(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "starts_with_predicate")) return false;
    if (!nextTokenIs(builder_, KW_STARTS_WITH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_STARTS_WITH);
    result_ = result_ && predicate_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, STARTS_WITH_PREDICATE, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_STATUS
  public static boolean status_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "status_query")) return false;
    if (!nextTokenIs(builder_, KW_STATUS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_STATUS);
    exit_section_(builder_, marker_, STATUS_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // STATUS_CODE | STAR
  public static boolean status_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "status_value")) return false;
    if (!nextTokenIs(builder_, "<status value>", STAR, STATUS_CODE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STATUS_VALUE, "<status value>");
    result_ = consumeToken(builder_, STATUS_CODE);
    if (!result_) result_ = consumeToken(builder_, STAR);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE2 TEMPLATE_VAR RBRACE2
  public static boolean template(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "template")) return false;
    if (!nextTokenIs(builder_, LBRACE2)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TEMPLATE, null);
    result_ = consumeTokens(builder_, 1, LBRACE2, TEMPLATE_VAR, RBRACE2);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_TO_DATE quoted_string_value
  public static boolean to_date_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "to_date_filter")) return false;
    if (!nextTokenIs(builder_, KW_TO_DATE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_TO_DATE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, TO_DATE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_TO_FLOAT
  public static boolean to_float_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "to_float_filter")) return false;
    if (!nextTokenIs(builder_, KW_TO_FLOAT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_TO_FLOAT);
    exit_section_(builder_, marker_, TO_FLOAT_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_TO_INT
  public static boolean to_int_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "to_int_filter")) return false;
    if (!nextTokenIs(builder_, KW_TO_INT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_TO_INT);
    exit_section_(builder_, marker_, TO_INT_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // url_content+
  public static boolean url(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "url")) return false;
    if (!nextTokenIs(builder_, "<url>", LBRACE2, URL_VALUE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, URL, "<url>");
    result_ = url_content(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!url_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "url", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // URL_VALUE | template
  static boolean url_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "url_content")) return false;
    if (!nextTokenIs(builder_, "", LBRACE2, URL_VALUE)) return false;
    boolean result_;
    result_ = consumeToken(builder_, URL_VALUE);
    if (!result_) result_ = template(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // KW_URL_DECODE
  public static boolean url_decode_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "url_decode_filter")) return false;
    if (!nextTokenIs(builder_, KW_URL_DECODE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_URL_DECODE);
    exit_section_(builder_, marker_, URL_DECODE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_URL_ENCODE
  public static boolean url_encode_filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "url_encode_filter")) return false;
    if (!nextTokenIs(builder_, KW_URL_ENCODE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_URL_ENCODE);
    exit_section_(builder_, marker_, URL_ENCODE_FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_URL
  public static boolean url_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "url_query")) return false;
    if (!nextTokenIs(builder_, KW_URL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_URL);
    exit_section_(builder_, marker_, URL_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // (VALUE_STRING | QUOTED_STRING | BACKTICK_STRING | NUMBER | FLOAT_NUMBER
  //                   | TRUE | FALSE | NULL | template | FILE_PREFIX FILENAME?)+
  public static boolean value_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VALUE_CONTENT, "<value content>");
    result_ = value_content_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!value_content_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "value_content", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // VALUE_STRING | QUOTED_STRING | BACKTICK_STRING | NUMBER | FLOAT_NUMBER
  //                   | TRUE | FALSE | NULL | template | FILE_PREFIX FILENAME?
  private static boolean value_content_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value_content_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VALUE_STRING);
    if (!result_) result_ = consumeToken(builder_, QUOTED_STRING);
    if (!result_) result_ = consumeToken(builder_, BACKTICK_STRING);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, FLOAT_NUMBER);
    if (!result_) result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    if (!result_) result_ = consumeToken(builder_, NULL);
    if (!result_) result_ = template(builder_, level_ + 1);
    if (!result_) result_ = value_content_0_9(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // FILE_PREFIX FILENAME?
  private static boolean value_content_0_9(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value_content_0_9")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FILE_PREFIX);
    result_ = result_ && value_content_0_9_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // FILENAME?
  private static boolean value_content_0_9_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value_content_0_9_1")) return false;
    consumeToken(builder_, FILENAME);
    return true;
  }

  /* ********************************************************** */
  // KW_VARIABLE quoted_string_value
  public static boolean variable_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable_query")) return false;
    if (!nextTokenIs(builder_, KW_VARIABLE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_VARIABLE);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, VARIABLE_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // XML_TEXT+
  public static boolean xml_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "xml_body")) return false;
    if (!nextTokenIs(builder_, XML_TEXT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, XML_TEXT);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, XML_TEXT)) break;
      if (!empty_element_parsed_guard_(builder_, "xml_body", pos_)) break;
    }
    exit_section_(builder_, marker_, XML_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // KW_XPATH quoted_string_value
  public static boolean xpath_query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "xpath_query")) return false;
    if (!nextTokenIs(builder_, KW_XPATH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KW_XPATH);
    result_ = result_ && quoted_string_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, XPATH_QUERY, result_);
    return result_;
  }

}
