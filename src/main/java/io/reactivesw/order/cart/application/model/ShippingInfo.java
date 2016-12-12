package io.reactivesw.order.cart.application.model;

import java.util.List;

import io.reactivesw.order.cartdiscount.model.DiscountedLineItemPrice;
import io.reactivesw.order.order.model.Delivery;
import io.reactivesw.order.shippingmethod.application.model.ShippingRate;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.catalog.taxcategory.application.model.TaxRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */@ApiModel
public class ShippingInfo {

  @ApiModelProperty(required = true)
  private String shippingMethodName;

  @ApiModelProperty(value = "Determined based on the ShippingRate and the sum of LineItem prices.",
          required = true)
  private Money price;

  @ApiModelProperty(value = "The shipping rate used to determine the price.", required = true)
  private ShippingRate shippingRate;

  @ApiModelProperty(value = "Set once the taxRate is set.", required = false)
  private TaxedItemPrice taxedPrice;

  @ApiModelProperty(value = "Will be set automatically in the Platform TaxMode once the shipping address is set is set. For the External tax mode the tax rate has to be set explicitly with the ExternalTaxRateDraft.",
          required = false)
  private TaxRate taxRate;

  @ApiModelProperty(value = "Reference to a TaxCategory", required = false)
  private Reference taxCategory;

  @ApiModelProperty(value = "Reference to a ShippingMethod, Not set if custom shipping method is used.",
          required = false)
  private Reference shippingMethod;

  @ApiModelProperty(value = "Deliveries are compilations of information on how the articles are being delivered to the customer.",
          required = true)
  private List<Delivery> deliveries;

  @ApiModelProperty(required = false)
  private DiscountedLineItemPrice discountedPrice;
}
