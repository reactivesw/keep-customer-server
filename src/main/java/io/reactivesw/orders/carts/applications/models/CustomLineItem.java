package io.reactivesw.orders.carts.applications.models;

import java.util.List;

import io.reactivesw.orders.cartdiscounts.models.DiscountedLineItemPriceForQuantity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;
import io.reactivesw.catalog.taxcategories.models.TaxRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomLineItem fields that can be used in query predicates: slug, name, quantity, money, state,
 * discountedPricePerQuantity.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A custom line item is a generic item that can be added to the carts but is not bound to a product. " +
        "You can use it for discounts (negative money), vouchers, complex carts rules, additional services or fees." +
        "You control the lifecycle of this item.")
public class CustomLineItem {

  @ApiModelProperty(value = "The unique ID of this CustomLineItem.", required = true)
  private String id;

  @ApiModelProperty(value = "The name of this CustomLineItem.",
          required = true)
  private LocalizedString name;

  @ApiModelProperty(value = "The cost to add to the carts. The amount can be negative.", required = true)
  private Money money;

  @ApiModelProperty(value = "Set once the taxRate is set.", required = false)
  private TaxedItemPrice taxedPrice;

  @ApiModelProperty(value = "The total price of this custom line item. " +
          "If custom line item is discounted, then the totalPrice would be the discounted custom line item price multiplied by quantity. " +
          "Otherwise a total price is just a money multiplied by the quantity. " +
          "totalPrice may or may not include the taxes: it depends on the taxRate.includedInPrice property.",
          required = true)
  private Money totalPrice;

  @ApiModelProperty(value = "String A unique String in the carts to identify this CustomLineItem.", required = true)
  private String slug;

  @ApiModelProperty(required = true)
  private Integer quantity;

  @ApiModelProperty(value = "Array of ItemState", required = true)
  private List<ItemState> state;

  @ApiModelProperty(value = "Reference to a TaxCategory", required = false)
  private Reference taxCategory;

  @ApiModelProperty(value = "Will be set automatically in the Platform TaxMode once the shipping address is set is set. " +
          "For the External tax mode the tax rate has to be set explicitly with the ExternalTaxRateDraft.",
          required = false)
  private TaxRate taxRate;

  @ApiModelProperty(required = true)
  private List<DiscountedLineItemPriceForQuantity> discountedPricePerQuantity;

  @ApiModelProperty(required = false)
  private CustomFields custom;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public Money getMoney() {
    return money;
  }

  public void setMoney(Money money) {
    this.money = money;
  }

  public TaxedItemPrice getTaxedPrice() {
    return taxedPrice;
  }

  public void setTaxedPrice(TaxedItemPrice taxedPrice) {
    this.taxedPrice = taxedPrice;
  }

  public Money getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Money totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
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

  public Reference getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(Reference taxCategory) {
    this.taxCategory = taxCategory;
  }

  public TaxRate getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(TaxRate taxRate) {
    this.taxRate = taxRate;
  }

  public List<DiscountedLineItemPriceForQuantity> getDiscountedPricePerQuantity() {
    return discountedPricePerQuantity;
  }

  public void setDiscountedPricePerQuantity(List<DiscountedLineItemPriceForQuantity> discountedPricePerQuantity) {
    this.discountedPricePerQuantity = discountedPricePerQuantity;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }
}
