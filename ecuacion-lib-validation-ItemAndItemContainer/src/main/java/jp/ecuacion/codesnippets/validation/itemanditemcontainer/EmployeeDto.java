package jp.ecuacion.codesnippets.validation.itemanditemcontainer;

import jakarta.validation.constraints.NotEmpty;
import jp.ecuacion.lib.core.annotation.ItemNameKeyClass;
import jp.ecuacion.lib.core.item.Item;
import jp.ecuacion.lib.core.item.ItemContainer;

@ItemNameKeyClass("employee")
public record EmployeeDto(@NotEmpty String name, @NotEmpty String deptId) implements ItemContainer {

  @Override
  public Item[] customizedItems() {
    return new Item[] {new Item("deptId").itemNameKey("deptName")};
  }
}
