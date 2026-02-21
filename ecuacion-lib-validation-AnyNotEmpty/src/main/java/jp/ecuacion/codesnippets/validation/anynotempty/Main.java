package jp.ecuacion.codesnippets.validation.anynotempty;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;
import jp.ecuacion.lib.core.util.ExceptionUtil;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    基礎();
    ExceptionUtilによるメッセージ出力();
  }

  public static void 基礎() {
    Name nameAllEmpty = new Name("", null, "");
    
    Set<ConstraintViolation<Name>> set = validator.validate(nameAllEmpty);
    for (ConstraintViolation<Name> v : set) {
      System.out.println(v.getMessage());
    }
}

private static void ExceptionUtilによるメッセージ出力() {
  NameWithoutMessage nameAllEmpty = new NameWithoutMessage("", null, "");

  Set<ConstraintViolation<NameWithoutMessage>> set = validator.validate(nameAllEmpty);
  for (String message : ExceptionUtil.getMessageList(set)) {
    System.out.println(message);
  }
}
}
