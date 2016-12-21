package io.reactivesw.catalog.inventory.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Reference;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode
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
}
