package io.reactivesw.order.order.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Davis on 17/2/8.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
