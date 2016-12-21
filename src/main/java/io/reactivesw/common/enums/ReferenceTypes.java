package io.reactivesw.common.enums;

/**
 * Created by Davis on 16/11/16.
 */
public enum ReferenceTypes {

  CUSTOMERGROUP("customer-group"),

  CHANNEL("channel"),

  PRODUCTTYPE("product-type"),

  CATEGORY("category"),

  CART("cart"),

  ZONE("zone"),

  CARTDISCOUNT("cart-discount"),

  TAXCATEGORY("tax-category");

  private String value;

  private ReferenceTypes(String value) {
    this.value = value;
  }

  /**
   * get type id.
   *
   * @return String
   */
  public String getType() {
    return this.value;
  }
}
