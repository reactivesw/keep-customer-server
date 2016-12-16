package io.reactivesw.order.cart.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.LineItemDraft;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by umasuo on 16/12/1.
 */
@ApiModel
public class AddLineItem extends LineItemDraft implements UpdateAction {
}
