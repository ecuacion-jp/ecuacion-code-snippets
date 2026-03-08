package jp.ecuacion.codesnippets.validation.itemanditemcontainer;

import jakarta.validation.constraints.NotEmpty;
import jp.ecuacion.lib.core.item.Item;
import jp.ecuacion.lib.core.item.ItemContainer;
import jp.ecuacion.lib.core.jakartavalidation.annotation.ItemNameKeyClass;

@ItemNameKeyClass("employee")
public record EmployeeDto(@NotEmpty String name, @NotEmpty String deptId) implements ItemContainer {

  @Override
  public Item[] customizedItems() {
    return new Item[] {new Item("deptId").itemNameKey("name")};
  }
}
