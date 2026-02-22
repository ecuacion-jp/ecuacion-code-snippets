package jp.ecuacion.codesnippets.core.validationutil;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.jakartavalidation.bean.ConstraintViolationBean;
import jp.ecuacion.lib.core.util.ExceptionUtil;
import jp.ecuacion.lib.core.util.ValidationUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基礎();
    ExceptionUtilによるメッセージ出力();
  }

  public static void 基礎() {
    Container container = new Container();

    Set<ConstraintViolation<Container>> set = validator.validate(container);
    for (ConstraintViolation<Container> v : set) {
      System.out.println(v.getMessage());
    }
  }

  private static void ExceptionUtilによるメッセージ出力() {
    Container container = new Container();

    Set<ConstraintViolationBean<Container>> set = ValidationUtil.validate(container,
        ValidationUtil.parameters().messagePrefix("エクセルファイルで、").isMessageWithItemNames(true));
    for (String message : ExceptionUtil.getMessageList(set)) {
      System.out.println(message);
    }
  }
}
