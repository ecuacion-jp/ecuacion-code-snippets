package jp.ecuacion.codesnippets.validation.jakartavalidationprefix;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jp.ecuacion.lib.core.exception.ConstraintViolationExceptionWithParameters;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.violation.Violations;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基本的な使い方();
    メッセージの後ろに文言を追加する場合();
    prefixのlocalize();
  }

  public static void 基本的な使い方() {
    ExcelData data = new ExcelData(null, null);
    var params = Violations.newMessageParameters().messagePrefix("アップロードされたエクセルファイルにおいて、");

    try {
      var constraintViolations = validator.validate(data);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }

  private static void メッセージの後ろに文言を追加する場合() {
    ExcelData data = new ExcelData(null, null);
    var params = Violations.newMessageParameters().messagePostfix("（エラー発生箇所：エクセルファイル）");

    try {
      var constraintViolations = validator.validate(data);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }

  private static void prefixのlocalize() {


    ExcelData data = new ExcelData(null, null);
    var params = Violations.newMessageParameters().messagePrefix("EXCEL_DATA_PREFIX");

    try {
      var constraintViolations = validator.validate(data);
      if (constraintViolations.size() > 0) {
        throw new ConstraintViolationExceptionWithParameters(constraintViolations, params);
      }

    } catch (ConstraintViolationException ex) {
      for (String message : ExceptionUtil.getMessageList(ex)) {
        System.out.println(message);
      }
    }
  }
}
