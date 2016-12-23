package io.reactivesw.catalog.product.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.product.application.model.ProductVariantAvailability;

/**
 * Created by Davis on 16/12/22.
 */
public final class ProductVariantAvailabilityMapper {
  /**
   * Instantiates a new Product variant availability mapper.
   */
  private ProductVariantAvailabilityMapper() {
  }

  public static ProductVariantAvailability toModel(InventoryEntry entry) {
    ProductVariantAvailability model = new ProductVariantAvailability();

    model.setRestockableInDays(entry.getRestockableInDays());
    model.setAvailableQuantity(entry.getAvailableQuantity());
    boolean isOnStock = entry.getAvailableQuantity() > 0 ? true : false;
    model.setIsOnStock(isOnStock);
    // TODO: 16/12/22 set channel
    model.setChannels(null);

    return model;
  }
}
