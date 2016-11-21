package io.reactivesw.customer.server.cart.models.carts;

import java.util.List;

import io.reactivesw.customer.server.cart.models.orders.Delivery;
import io.reactivesw.customer.server.cart.models.ShippingRate;
import io.reactivesw.customer.server.common.models.Money;
import io.reactivesw.customer.server.common.models.Reference;
import io.reactivesw.customer.server.common.models.TaxRate;
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

  @ApiModelProperty(value = "Deliveries are compilations of information on how the articles are being delivered to the customers.",
          required = true)
  private List<Delivery> deliveries;

  @ApiModelProperty(required = false)
  private DiscountedLineItemPrice discountedPrice;
}
