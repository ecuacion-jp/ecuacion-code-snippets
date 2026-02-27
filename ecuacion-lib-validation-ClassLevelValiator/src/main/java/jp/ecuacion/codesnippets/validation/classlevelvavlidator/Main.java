package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Set;

public class Main {

  private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static void main(String... args) {
    propertyPathの指定();
  }

  public static void propertyPathの指定() {
    Family family = new Family(new Person("John", 25), new Person("Paul", 27));

    Set<ConstraintViolation<Family>> setPropertyPath = validator.validate(family);
    for (ConstraintViolation<Family> v : setPropertyPath) {
      System.out.println(v.getMessage());
    }
  }
}
