package jp.ecuacion.codesnippets.validation.notemptywhen;

import jp.ecuacion.lib.validation.constraints.NotEmptyWhen;

@NotEmptyWhen(propertyPath = "guardianName", conditionPropertyPath = "isUnderage",
    conditionValueBoolean = true)
public record Account(String name, boolean isUnderage, String guardianName) {

}
