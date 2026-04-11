package jp.ecuacion.codesnippets.validation.truewhen;

import jp.ecuacion.lib.validation.constraints.TrueWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@TrueWhen(propertyPath = "smsConsentAgreed", conditionPropertyPath = "phone",
    conditionValue = ConditionValue.PATTERN, conditionValuePatternRegexp = "^(070|080|090).*",
    message = "携帯電話番号の場合はSMS通知への同意が必要です。")
public record UserContactWithMessage(String phone, boolean smsConsentAgreed) {

}
