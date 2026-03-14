package jp.ecuacion.codesnippets.validation.jakartavalidationprefix;

import jakarta.validation.ConstraintViolationException;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;

public class Main {

  public static void main(String... args) {
    基本的な使い方();
    メッセージの後ろに文言を追加する場合();
    prefixのlocalize();
  }

  public static void 基本的な使い方() {
    try {
      ValidationUtil.validateThenThrow(new ExcelData(null, null),
          ValidationUtil.messageParameters().messagePrefix("アップロードされたエクセルファイルにおいて、"));

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }

  private static void メッセージの後ろに文言を追加する場合() {
    try {
      ValidationUtil.validateThenThrow(new ExcelData(null, null),
          ValidationUtil.messageParameters().messagePostfix("（エラー発生箇所：エクセルファイル）"));

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }

  private static void prefixのlocalize() {
    try {
      ValidationUtil.validateThenThrow(new ExcelData(null, null),
          ValidationUtil.messageParameters().messagePrefix("EXCEL_DATA_PREFIX"));

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }
}
