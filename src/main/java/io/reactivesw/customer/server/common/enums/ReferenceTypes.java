package io.reactivesw.customer.server.common.enums;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;

/**
 * Created by Davis on 16/11/16.
 */
public enum  ReferenceTypes {
  CATEGORY("category"),
  CART("carts"),
  CARTDISCOUNT("carts-discount");
  private String value;

  private ReferenceTypes(String value){
    this.value = value;
  }

  public static String getType(Class clazz){
    if (clazz.equals(CategoryEntity.class)){
      return CATEGORY.value;
    }
    return CARTDISCOUNT.value;
  }
}
