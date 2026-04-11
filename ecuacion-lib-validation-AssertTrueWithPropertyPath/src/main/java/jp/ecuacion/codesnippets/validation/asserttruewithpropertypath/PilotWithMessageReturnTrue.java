package jp.ecuacion.codesnippets.validation.asserttruewithpropertypath;

import jp.ecuacion.lib.validation.constraints.ReturnTrue;

@ReturnTrue(methodName = "isAbleToBecomePilot", propertyPath = {"eyeSight", "physicalStrength"},
    message = "パイロットには良い視力と強靭な体力が必要です")
public record PilotWithMessageReturnTrue(String name, boolean eyeSight,
    boolean physicalStrength) {

  public boolean isAbleToBecomePilot() {
    return eyeSight && physicalStrength;
  }
}
