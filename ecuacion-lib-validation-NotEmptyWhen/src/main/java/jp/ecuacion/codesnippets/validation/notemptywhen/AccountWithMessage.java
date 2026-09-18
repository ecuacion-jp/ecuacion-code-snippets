package jp.ecuacion.codesnippets.validation.notemptywhen;

import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;

@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isUnderage",
    conditionValueBoolean = true, message = "未成年の場合は保護者名が必須です。")
public record AccountWithMessage(String name, boolean isUnderage, String guardianName) {

}
