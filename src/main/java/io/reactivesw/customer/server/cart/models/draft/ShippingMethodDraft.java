package io.reactivesw.customer.server.cart.models.draft;

import io.swagger.annotations.ApiModel;

/**
 * This representation needs to be given with a Create ShippingMethod request.
 * Created by umasuo on 16/11/17.
 */
@ApiModel(description = "This representation needs to be given with a Create ShippingMethod request.")
public class ShippingMethodDraft {


//          name - String - Required
//  description - String - Optional
//  taxCategory - Reference to a TaxCategory
//  zoneRates - Array of ZoneRate
//  isDefault - Boolean
//  If true the shipping method will be the default one in a project.
}
