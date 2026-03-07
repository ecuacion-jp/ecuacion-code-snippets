package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jp.ecuacion.lib.validation.constraints.GreaterThanOrEqualTo;

@GreaterThanOrEqualTo(propertyPath = "bigBrother.age", baselinePropertyPath = "littleBrother.age",
    message = "兄の年齢が弟より下です。")
public record Family(Person bigBrother, Person littleBrother) {

}
