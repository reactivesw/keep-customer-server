package io.reactivesw.customer.server.catalog.models.draft;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.customer.server.common.models.Reference;
import io.reactivesw.customer.server.common.models.draft.CustomFieldsDraft;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class InventoryEntryDraft {

  /**
   * The Sku.
   */
  private String sku;

  /**
   * The Quantity on stock.
   */
  private Integer quantityOnStock;

  /**
   * The Restockable in days.
   */
  private Integer restockableInDays;

  /**
   * The Expected delivery.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime expectedDelivery;

  /**
   * Reference to a Channel.
   * Optional.
   */
  private Reference supplyChannel;

  /**
   * The custom fields.
   */
  private CustomFieldsDraft custom;

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
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFieldsDraft getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "InventoryEntryDraft{" +
        "sku='" + sku + '\'' +
        ", quantityOnStock=" + quantityOnStock +
        ", restockableInDays=" + restockableInDays +
        ", expectedDelivery=" + expectedDelivery +
        ", supplyChannel=" + supplyChannel +
        ", custom=" + custom +
        '}';
  }
}
