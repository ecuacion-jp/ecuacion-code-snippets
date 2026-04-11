package jp.ecuacion.codesnippets.validation.patternwhen;

import jp.ecuacion.lib.validation.constraints.PatternWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@PatternWhen(propertyPath = "remarks", regexp = ".*自己承認.*", conditionPropertyPath = "applicantId",
    conditionValue = ConditionValue.VALUE_OF_PROPERTY_PATH,
    conditionValuePropertyPath = "approverId", message = "申請者と承認者が同一の場合は備考に「自己承認」と記載する必要があります。")
public record ApprovalRequestWithMessage(String applicantId, String approverId, String remarks) {

}
