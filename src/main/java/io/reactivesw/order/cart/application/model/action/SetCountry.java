package io.reactivesw.order.cart.application.model.action;

import lombok.Data;

/**
 * Created by umasuo on 16/12/15.
 */
@Data
public class SetCountry {

  /**
   * A two-digit country code as per ↗ ISO 3166-1 alpha-2 .
   */
  private String country;
}
