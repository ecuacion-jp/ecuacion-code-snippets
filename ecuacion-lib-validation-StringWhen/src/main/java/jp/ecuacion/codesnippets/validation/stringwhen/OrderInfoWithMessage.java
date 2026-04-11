package jp.ecuacion.codesnippets.validation.stringwhen;

import jp.ecuacion.lib.validation.constraints.StringWhen;
import jp.ecuacion.lib.validation.constraints.enums.ConditionValue;

@StringWhen(propertyPath = "deliveryType", string = "STORE_PICKUP",
    conditionPropertyPath = "deliveryAddress", conditionValue = ConditionValue.EMPTY,
    message = "配送先住所が未入力の場合は受け取り方法は「店頭受け取り」でなければなりません。")
public record OrderInfoWithMessage(String deliveryAddress, String deliveryType) {

}
