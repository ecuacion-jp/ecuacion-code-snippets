package jp.ecuacion.codesnippets.validation.lessthan;

import jp.ecuacion.lib.validation.constraints.GreaterThanOrEqualTo;

@GreaterThanOrEqualTo(propertyPath = "bigBrother.age", basisPropertyPath = "littleBrother.age")
public record FamilyWithoutMessage(Person bigBrother, Person littleBrother) {

}
