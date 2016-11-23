package io.reactivesw.catalog.productdiscounts.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.reactivesw.catalog.productdiscounts.models.ProductDiscountValue;
import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;
import io.reactivesw.common.utils.ProductDiscountJsonConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_product_discount")
public class ProductDiscountEntity extends BaseAllEntity {
  @Column
  private LocalizedString name;

  @Column(name = "description", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  @Column(name = "value", columnDefinition = "JSON")
  @Convert(converter = ProductDiscountJsonConverter.class)
  private ProductDiscountValue value;

  @Column
  private String predicate;

  @Column(name = "sort_order")
  private String sortOrder;

  @Column
  private Boolean active;

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
    return active;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "ProductDiscountEntity{" +
        "name=" + name +
        ", description=" + description +
        ", value=" + value +
        ", predicate='" + predicate + '\'' +
        ", sortOrder='" + sortOrder + '\'' +
        ", active=" + active +
        '}';
  }
}
