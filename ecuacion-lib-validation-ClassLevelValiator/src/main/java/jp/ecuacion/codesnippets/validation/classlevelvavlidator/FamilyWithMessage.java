package jp.ecuacion.codesnippets.validation.classlevelvavlidator;

import jp.ecuacion.lib.validation.constraints.LessThan;

@LessThan(propertyPath = "littleBrother.age", baselinePropertyPath = "bigBrother.age",
    message = "弟の年齢が兄より上です。")
public record FamilyWithMessage(Person bigBrother, Person littleBrother) {

}
