package io.reactivesw.catalog.inventory.application.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 17/2/8.
 */
@Getter
@Setter
public class InventoryRequest {
  /**
   * The Sku name.
   */
  private String skuName;

  /**
   * The Quantity.
   */
  private Integer quantity;
}
