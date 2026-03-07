package jp.ecuacion.codesnippets.validation.notemptywhen;

import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isUnderage",
    conditionValue = ConditionValue.TRUE, message = "{underageNeedsGuardian.message}")
public record AccountWithMessageKey(String name, boolean isUnderage, String guardianName) {

}
