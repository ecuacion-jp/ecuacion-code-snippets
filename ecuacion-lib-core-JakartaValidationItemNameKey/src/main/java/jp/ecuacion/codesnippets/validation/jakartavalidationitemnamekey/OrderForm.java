package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamekey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jp.ecuacion.lib.core.item.Item;
import jp.ecuacion.lib.core.item.ItemContainer;

public record OrderForm(@NotEmpty String productCode, @NotNull Integer qty)
    implements ItemContainer {

  @Override
  public Item[] customizedItems() {
    return new Item[] {new Item("productCode").itemNameKey("productName")};
  }
}
