package jp.ecuacion.codesnippets.validation.jakartavalidationitemnamekey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jp.ecuacion.lib.core.annotation.ItemNameKeyClass;
import jp.ecuacion.lib.core.item.Item;
import jp.ecuacion.lib.core.item.ItemContainer;

@ItemNameKeyClass("order")
public record OrderFormWithAnnotation(@NotEmpty String productCode, @NotNull Integer qty)
    implements ItemContainer {

  @Override
  public Item[] customizedItems() {
    return new Item[] {};
  }
}
