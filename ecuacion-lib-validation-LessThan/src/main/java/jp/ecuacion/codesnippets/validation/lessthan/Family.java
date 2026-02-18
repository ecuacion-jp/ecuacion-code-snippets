package jp.ecuacion.codesnippets.validation.lessthan;

import jp.ecuacion.lib.validation.constraints.GreaterThanOrEqualTo;

@GreaterThanOrEqualTo(propertyPath = "bigBrother.age", basisPropertyPath = "littleBrother.age",
    message = "兄の年齢が弟より下です。")
public record Family(Person bigBrother, Person littleBrother) {

}
