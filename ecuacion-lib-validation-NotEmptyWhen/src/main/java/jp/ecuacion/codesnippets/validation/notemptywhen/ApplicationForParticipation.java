package jp.ecuacion.codesnippets.validation.notemptywhen;

import jakarta.validation.constraints.NotNull;

//@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isAdult",
//    conditionValue = ConditionValue.FALSE, message = "{0}は、未成年の場合は保護者名が必須です。")
public record ApplicationForParticipation(@NotNull String name, boolean isAdult, String guardianName) {

}
