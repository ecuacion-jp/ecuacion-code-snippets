package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "littleBrother.age", baselinePropertyPath = "bigBrother.age",
    message = "{ageOfBigBrotherIsLargerThanThatOfLittleBrother.message}")
public record FamilyWithMessageKey(Person bigBrother, Person littleBrother) {

}
