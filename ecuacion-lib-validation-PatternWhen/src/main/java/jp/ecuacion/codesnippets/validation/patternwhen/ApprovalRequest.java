package jp.ecuacion.codesnippets.validation.patternwhen;

import jp.ecuacion.lib.validation.constraints.PatternWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@PatternWhen(propertyPath = "remarks", regexp = ".*自己承認.*", description = "自己承認を含む文字列",
    conditionPropertyPath = "applicantId", conditionValue = ConditionValue.VALUE_OF_PROPERTY_PATH,
    conditionValuePropertyPath = "approverId")
public record ApprovalRequest(String applicantId, String approverId, String remarks) {

}
