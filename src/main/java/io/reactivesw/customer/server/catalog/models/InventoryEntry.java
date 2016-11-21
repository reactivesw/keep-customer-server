package io.reactivesw.customer.server.catalog.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.customer.server.common.models.CustomFields;
import io.reactivesw.customer.server.common.models.Reference;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class InventoryEntry {

  /**
   * The unique ID of the inventory entry.
   */
  private String id;

  /**
   * The Version.
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
   * The Sku.
   */
  private String sku;

  /**
   * Reference to a Channel.
   * Optional connection to particular supplier.
   */
  private Reference supplyChannel;

  /**
   * Overall amount of stock. (available + reserved).
   */
  private Integer quantityOnStock;

  /**
   * Available amount of stock. (available means: quantityOnStock - reserved quantity)
   */
  private Integer availableQuantity;

  /**
   * The time period in days, that tells how often this inventory entry is restocked.
   */
  private Integer restockableInDays;

  /**
   * The date and time of the next restock.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime expectedDelivery;

  /**
   * The Custom.
   */
  private CustomFields custom;

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
   * Gets sku.
   *
   * @return the sku
   */
  public String getSku() {
    return sku;
  }

  /**
   * Sets sku.
   *
   * @param sku the sku
   */
  public void setSku(String sku) {
    this.sku = sku;
  }

  /**
   * Gets supply channel.
   *
   * @return the supply channel
   */
  public Reference getSupplyChannel() {
    return supplyChannel;
  }

  /**
   * Sets supply channel.
   *
   * @param supplyChannel the supply channel
   */
  public void setSupplyChannel(Reference supplyChannel) {
    this.supplyChannel = supplyChannel;
  }

  /**
   * Gets quantity on stock.
   *
   * @return the quantity on stock
   */
  public Integer getQuantityOnStock() {
    return quantityOnStock;
  }

  /**
   * Sets quantity on stock.
   *
   * @param quantityOnStock the quantity on stock
   */
  public void setQuantityOnStock(Integer quantityOnStock) {
    this.quantityOnStock = quantityOnStock;
  }

  /**
   * Gets available quantity.
   *
   * @return the available quantity
   */
  public Integer getAvailableQuantity() {
    return availableQuantity;
  }

  /**
   * Sets available quantity.
   *
   * @param availableQuantity the available quantity
   */
  public void setAvailableQuantity(Integer availableQuantity) {
    this.availableQuantity = availableQuantity;
  }

  /**
   * Gets restockable in days.
   *
   * @return the restockable in days
   */
  public Integer getRestockableInDays() {
    return restockableInDays;
  }

  /**
   * Sets restockable in days.
   *
   * @param restockableInDays the restockable in days
   */
  public void setRestockableInDays(Integer restockableInDays) {
    this.restockableInDays = restockableInDays;
  }

  /**
   * Gets expected delivery.
   *
   * @return the expected delivery
   */
  public ZonedDateTime getExpectedDelivery() {
    return expectedDelivery;
  }

  /**
   * Sets expected delivery.
   *
   * @param expectedDelivery the expected delivery
   */
  public void setExpectedDelivery(ZonedDateTime expectedDelivery) {
    this.expectedDelivery = expectedDelivery;
  }

  /**
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFields getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "InventoryEntry{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", sku='" + sku + '\'' +
        ", supplyChannel=" + supplyChannel +
        ", quantityOnStock=" + quantityOnStock +
        ", availableQuantity=" + availableQuantity +
        ", restockableInDays=" + restockableInDays +
        ", expectedDelivery=" + expectedDelivery +
        ", custom=" + custom +
        '}';
  }
}
