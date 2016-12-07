package io.reactivesw.order.order.model;

import io.reactivesw.order.cart.application.model.ItemState;
import io.reactivesw.catalog.product.model.Price;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.catalog.taxcategory.model.TaxRate;
import io.reactivesw.common.model.CustomFieldsDraft;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class LineItemImportDraft {

  /**
   * ID of the existing product.
   * You also need to specify the ID of the variant if this property is set or alternatively
   * you can just specify SKU of the product variant.
   */
  private String productId;

  /**
   * The product name.
   */
  private LocalizedString name;

  /**
   * The Variant.
   */
  private ProductVariantImportDraft variant;

  /**
   * The Price.
   */
  private Price price;

  /**
   * The Quantity.
   */
  private Integer quantity;

  /**
   * Array of ItemState.
   * Optional.
   */
  private List<ItemState> state;

  /**
   * Reference to a Channel.
   * Optional connection to particular supplier.
   * By providing supply channel information,
   * you can unique identify inventory entries that should be reserved.
   * Provided channel should have role InventorySupply.
   * Optional.
   */
  private Reference supplyChannel;


  /**
   * The Tax rate.
   */
  private TaxRate taxRate;

  /**
   * The custom fields.
   */
  private CustomFieldsDraft custom;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public ProductVariantImportDraft getVariant() {
    return variant;
  }

  public void setVariant(ProductVariantImportDraft variant) {
    this.variant = variant;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public List<ItemState> getState() {
    return state;
  }

  public void setState(List<ItemState> state) {
    this.state = state;
  }

  public Reference getSupplyChannel() {
    return supplyChannel;
  }

  public void setSupplyChannel(Reference supplyChannel) {
    this.supplyChannel = supplyChannel;
  }

  public TaxRate getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(TaxRate taxRate) {
    this.taxRate = taxRate;
  }

  public CustomFieldsDraft getCustom() {
    return custom;
  }

  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }
}
