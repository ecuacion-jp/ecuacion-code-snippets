package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "littleBrother.age", baselinePropertyPath = "bigBrother.age")
public record Family(Person bigBrother, Person littleBrother) {

}
