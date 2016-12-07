package io.reactivesw.common.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.catalog.categories.applications.models.actions.SetOrderHint;
import io.reactivesw.catalog.categories.applications.models.actions.SetParent;
import io.reactivesw.catalog.categories.applications.models.actions.SetSlug;
import io.reactivesw.catalog.categories.applications.models.actions.SetCustomField;
import io.reactivesw.catalog.categories.applications.models.actions.SetCustomType;
import io.reactivesw.catalog.categories.applications.models.actions.SetExternalID;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaDescription;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaKeywords;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaTitle;
import io.reactivesw.common.models.updateactions.SetLocalizedName;
import io.reactivesw.common.models.updateactions.SetLocalizedDescription;
import io.reactivesw.orders.carts.applications.models.actions.AddLineItem;
import io.reactivesw.orders.carts.applications.models.actions.RemoveLineItem;
import io.reactivesw.orders.discountcodes.applications.models.updateactions.SetActive;
import io.reactivesw.orders.discountcodes.applications.models.updateactions.SetCartDiscounts;
import io.reactivesw.orders.discountcodes.applications.models.updateactions.SetCartPredicate;
import io.reactivesw.orders.discountcodes.applications.models.updateactions.SetMaxApplications;
import io.reactivesw.orders.discountcodes.applications.models.updateactions
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
    @JsonSubTypes.Type(value = SetMaxApplicationsPerCustomer.class, name = "setMaxApplicationsPerCustomer"),
})
public interface UpdateAction {
}
