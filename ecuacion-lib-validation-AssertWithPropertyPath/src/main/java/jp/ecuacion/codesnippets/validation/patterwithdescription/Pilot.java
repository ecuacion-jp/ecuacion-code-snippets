package jp.ecuacion.codesnippets.validation.patterwithdescription;

import jp.ecuacion.lib.validation.constraints.AssertTrueWithPropertyPath;

public record Pilot(String name, boolean eyeSight, boolean physicalStrength) {

  @AssertTrueWithPropertyPath(propertyPath = {"eyeSight", "physicalStrength"},
      message = "パイロットには良い視力と強靭な体力が必要です")
  public boolean isAbleToBecomePilot() {
    return eyeSight && physicalStrength;
  }
}
