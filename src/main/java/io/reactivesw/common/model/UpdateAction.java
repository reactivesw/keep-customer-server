package io.reactivesw.common.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.application.model.action.SetParent;
import io.reactivesw.catalog.category.application.model.action.SetSlug;
import io.reactivesw.catalog.category.application.model.action.SetCustomField;
import io.reactivesw.catalog.category.application.model.action.SetCustomType;
import io.reactivesw.catalog.category.application.model.action.SetMetaDescription;
import io.reactivesw.catalog.category.application.model.action.SetMetaKeywords;
import io.reactivesw.catalog.category.application.model.action.SetMetaTitle;
import io.reactivesw.catalog.inventory.application.model.action.AddQuantityAction;
import io.reactivesw.catalog.producttype.application.model.action.SetKey;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.order.cart.application.model.action.AddLineItem;
import io.reactivesw.order.cart.application.model.action.RemoveLineItem;
import io.reactivesw.order.discountcode.application.model.action.SetActive;
import io.reactivesw.order.discountcode.application.model.action.SetCartDiscounts;
import io.reactivesw.order.discountcode.application.model.action.SetCartPredicate;
import io.reactivesw.order.discountcode.application.model.action.SetMaxApplications;
import io.reactivesw.order.discountcode.application.model.action
    .SetMaxApplicationsPerCustomer;

/**
 * configurations for update action.
 * Created by umasuo on 16/11/21.
 * TODO this should be split to different class in each micro-service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddLineItem.class, name = "addLineItem"),
    @JsonSubTypes.Type(value = RemoveLineItem.class, name = "removeLineItem"),
    @JsonSubTypes.Type(value = SetLocalizedName.class, name = "setLocalizedName"),
    @JsonSubTypes.Type(value = SetSlug.class, name = "setLocalizedSlug"),
    @JsonSubTypes.Type(value = SetLocalizedDescription.class, name = "setLocalizedDescription"),
    @JsonSubTypes.Type(value = SetParent.class, name = "setParent"),
    @JsonSubTypes.Type(value = SetOrderHint.class, name = "setOrderHint"),
    @JsonSubTypes.Type(value = SetExternalID.class, name = "setExternalID"),
    @JsonSubTypes.Type(value = SetMetaTitle.class, name = "setMetaTitle"),
    @JsonSubTypes.Type(value = SetMetaDescription.class, name = "setMetaDescription"),
    @JsonSubTypes.Type(value = SetMetaKeywords.class, name = "setMetaKeywords"),
    @JsonSubTypes.Type(value = SetCustomType.class, name = "setCustomType"),
    @JsonSubTypes.Type(value = SetCustomField.class, name = "setCustomField"),
    @JsonSubTypes.Type(value = SetCartDiscounts.class, name = "SetCartDiscounts"),
    @JsonSubTypes.Type(value = SetActive.class, name = "setActive"),
    @JsonSubTypes.Type(value = SetCartPredicate.class, name = "setCartPredicate"),
    @JsonSubTypes.Type(value = SetMaxApplications.class, name = "setMaxApplications"),
    @JsonSubTypes.Type(value = SetMaxApplicationsPerCustomer.class, name =
        "setMaxApplicationsPerCustomer"),
    @JsonSubTypes.Type(value = SetKey.class, name = "setDescription"),
    @JsonSubTypes.Type(value = SetName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = AddQuantityAction.class, name = "addQuantity"),
})
public interface UpdateAction {

}
