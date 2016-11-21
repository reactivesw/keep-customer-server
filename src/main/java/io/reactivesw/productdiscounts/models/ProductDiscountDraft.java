package io.reactivesw.productdiscounts.models;

import io.reactivesw.productdiscounts.models.ProductDiscountValue;
import io.reactivesw.common.models.LocalizedString;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductDiscountDraft {

  /**
   * The Name.
   */
  private LocalizedString name;

  /**
   * The Description.
   */
  private LocalizedString description;

  /**
   * The Value.
   */
  private ProductDiscountValue value;

  /**
   * A valid ProductDiscount Predicate.
   */
  private String predicate;

  /**
   * The string must contain a decimal number between 0 and 1.
   * A discount with greater sortOrder is prioritized higher than a discount with lower sortOrder.
   */
  private String sortOrder;

  /**
   * If set to true the discount will be applied to product prices.
   */
  private Boolean isActive;

  /**
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public LocalizedString getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public ProductDiscountValue getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(ProductDiscountValue value) {
    this.value = value;
  }

  /**
   * Gets predicate.
   *
   * @return the predicate
   */
  public String getPredicate() {
    return predicate;
  }

  /**
   * Sets predicate.
   *
   * @param predicate the predicate
   */
  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  /**
   * Gets sort order.
   *
   * @return the sort order
   */
  public String getSortOrder() {
    return sortOrder;
  }

  /**
   * Sets sort order.
   *
   * @param sortOrder the sort order
   */
  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  /**
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return isActive;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    isActive = active;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ProductDiscountDraft{" +
        "name=" + name +
        ", description=" + description +
        ", value=" + value +
        ", predicate='" + predicate + '\'' +
        ", sortOrder='" + sortOrder + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
