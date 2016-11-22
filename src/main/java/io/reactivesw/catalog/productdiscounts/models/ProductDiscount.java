package io.reactivesw.catalog.productdiscounts.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.Reference;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ProductDiscount {
  /**
   * The unique ID of the product discount
   */
  private String id;

  /**
   * The current version of the product discount.
   */
  private Integer version;

  /**
   * The Created at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

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
   * The string contains a number between 0 and 1.
   * A discount with greater sortOrder is prioritized higher than a discount with lower sortOrder.
   * A sortOrder must be unambiguous.
   */
  private String sortOrder;

  /**
   * Only active discount will be applied to product prices.
   */
  private Boolean isActive;

  /**
   * Array of Reference.
   * The platform will generate this array from the predicate.
   * It contains the references of all the resources that are addressed in the predicat
   */
  private List<Reference> references;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

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
   * Gets references.
   *
   * @return the references
   */
  public List<Reference> getReferences() {
    return references;
  }

  /**
   * Sets references.
   *
   * @param references the references
   */
  public void setReferences(List<Reference> references) {
    this.references = references;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "ProductDiscount{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", name=" + name +
        ", description=" + description +
        ", value=" + value +
        ", predicate='" + predicate + '\'' +
        ", sortOrder='" + sortOrder + '\'' +
        ", isActive=" + isActive +
        ", references=" + references +
        '}';
  }
}
