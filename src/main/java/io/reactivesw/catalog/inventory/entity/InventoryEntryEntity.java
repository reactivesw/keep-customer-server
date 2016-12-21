package io.reactivesw.catalog.inventory.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.util.converter.CustomFieldsJsonConverter;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "catalog_inventory_inventory_entry")
public class InventoryEntryEntity extends BaseAllEntity {
  /**
   * sku name.
   */
  @Column(name = "sku_name")
  private String sku;

  /**
   * supply channel id.
   */
  @Column(name = "supply_channel_id")
  private String supplyChannel;

  /**
   * quantity on stock.
   */
  @Column(name = "quantity_on_stock")
  private Integer quantityOnStock;

  /**
   * available quantity.
   */
  @Column(name = "available_quantity")
  private Integer availableQuantity;

  /**
   * restockable in days.
   */
  @Column(name = "restockable_in_days")
  private Integer restockableInDays;

  /**
   * exapected dalivery.
   */
  @Column(name = "expected_delivery")
  private ZonedDateTime expectedDelivery;

  /**
   * custom.
   */
  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

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
  public String getSupplyChannel() {
    return supplyChannel;
  }

  /**
   * Sets supply channel.
   *
   * @param supplyChannel the supply channel
   */
  public void setSupplyChannel(String supplyChannel) {
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
    return "InventoryEntryEntity{"
        + "sku='" + sku + '\''
        + ", supplyChannel='" + supplyChannel + '\''
        + ", quantityOnStock=" + quantityOnStock
        + ", availableQuantity=" + availableQuantity
        + ", restockableInDays=" + restockableInDays
        + ", expectedDelivery=" + expectedDelivery
        + ", custom=" + custom
        + '}';
  }
}
