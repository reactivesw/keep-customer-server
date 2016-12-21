package io.reactivesw.catalog.inventory.domain.entity;

import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.model.CustomFields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "catalog_inventory_entry")
@TypeDef(name = "Custom", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "io.reactivesw.common.model.CustomFields")}
)
public class InventoryEntryEntity extends BaseAllEntity {

  /**
   * version.
   */
  @Version
  @Column
  private Integer version;

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
   * reserved quantity.
   */
  @Column(name = "reserved_quantity")
  private Integer reservedQuantity;

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
  @Type(type = "Custom")
  private CustomFields custom;
}
