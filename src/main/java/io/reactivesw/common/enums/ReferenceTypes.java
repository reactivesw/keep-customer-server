package io.reactivesw.common.enums;

/**
 * Created by Davis on 16/11/16.
 */
public enum  ReferenceTypes {
  CATEGORY("category"),
  CART("cart"),
  CARTDISCOUNT("cart-discount");
  private String value;

  private ReferenceTypes(String value){
    this.value = value;
  }

  /**
   * get type id.
   * @return String
   */
  public String getType(){
    return this.value;
  }
}
