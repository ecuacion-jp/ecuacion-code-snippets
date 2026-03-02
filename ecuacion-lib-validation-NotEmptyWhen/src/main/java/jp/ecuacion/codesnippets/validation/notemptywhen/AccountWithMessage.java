package jp.ecuacion.codesnippets.validation.notemptywhen;

import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isAdult",
    conditionValue = ConditionValue.FALSE, message = "未成年の場合は保護者名が必須です。")
public record AccountWithMessage(String name, boolean isAdult, String guardianName) {

}
