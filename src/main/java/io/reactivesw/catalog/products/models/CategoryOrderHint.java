package io.reactivesw.catalog.products.models;

/**
 * Created by umasuo on 16/11/18.
 */
public class CategoryOrderHint {

  /**
   * use category id as key.
   */
  String key;

  /**
   * number, values between [0...1]
   */
  String order;
}
