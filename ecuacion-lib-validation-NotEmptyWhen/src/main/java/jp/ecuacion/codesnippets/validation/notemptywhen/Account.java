package jp.ecuacion.codesnippets.validation.notemptywhen;

import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isAdult",
    conditionValue = ConditionValue.FALSE)
public record Account(String name, boolean isAdult, String guardianName) {

}
