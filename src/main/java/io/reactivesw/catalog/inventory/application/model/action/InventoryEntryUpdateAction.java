package io.reactivesw.catalog.inventory.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.reactivesw.catalog.category.application.model.action.SetExternalID;
import io.reactivesw.catalog.category.application.model.action.SetMetaDescription;
import io.reactivesw.catalog.category.application.model.action.SetMetaKeywords;
import io.reactivesw.catalog.category.application.model.action.SetMetaTitle;
import io.reactivesw.catalog.category.application.model.action.SetOrderHint;
import io.reactivesw.catalog.category.application.model.action.SetParent;
import io.reactivesw.catalog.category.application.model.action.SetSlug;

/**
 * Created by Davis on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddQuantityAction.class, name = "addQuantity"),
    @JsonSubTypes.Type(value = RemoveQuantityAction.class, name = "removeQuantity"),
    @JsonSubTypes.Type(value = SetQuantityAction.class, name = "setQuantity"),
    @JsonSubTypes.Type(value = SetRestockableInDays.class, name = "setRestockableInDays"),
    @JsonSubTypes.Type(value = SetExpectedDelivery.class, name = "setExpectedDelivery"),
    @JsonSubTypes.Type(value = SetSupplyChannel.class, name = "setSupplyChannel"),
    @JsonSubTypes.Type(value = RemoveReservedQuantityAction.class, name = "removeReserved"),
    @JsonSubTypes.Type(value = AddReservedQuantityAction.class, name = "addReserved"),
})
public interface InventoryEntryUpdateAction {
}
