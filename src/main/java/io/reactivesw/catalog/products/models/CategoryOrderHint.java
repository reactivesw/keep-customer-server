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

  /**
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets key.
   *
   * @param key the key
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Gets order.
   *
   * @return the order
   */
  public String getOrder() {
    return order;
  }

  /**
   * Sets order.
   *
   * @param order the order
   */
  public void setOrder(String order) {
    this.order = order;
  }
}
