package io.reactivesw.common.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeName;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeOrderHint;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeParent;
import io.reactivesw.catalog.categories.applications.models.actions.ChangeSlug;
import io.reactivesw.catalog.categories.applications.models.actions.SetCustomField;
import io.reactivesw.catalog.categories.applications.models.actions.SetCustomType;
import io.reactivesw.catalog.categories.applications.models.actions.SetDescription;
import io.reactivesw.catalog.categories.applications.models.actions.SetExternalID;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaDescription;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaKeywords;
import io.reactivesw.catalog.categories.applications.models.actions.SetMetaTitle;
import io.reactivesw.orders.carts.applications.models.actions.AddLineItem;
import io.reactivesw.orders.carts.applications.models.actions.RemoveLineItem;

/**
 * configurations for update action.
 * Created by umasuo on 16/11/21.
 * TODO this should be split to different class in each micro-service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddLineItem.class, name = "addLineItem"),
    @JsonSubTypes.Type(value = RemoveLineItem.class, name = "removeLineItem"),
    @JsonSubTypes.Type(value = ChangeName.class, name = "changeName"),
    @JsonSubTypes.Type(value = ChangeSlug.class, name = "changeSlug"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = ChangeParent.class, name = "changeParent"),
    @JsonSubTypes.Type(value = ChangeOrderHint.class, name = "changeOrderHint"),
    @JsonSubTypes.Type(value = SetExternalID.class, name = "setExternalID"),
    @JsonSubTypes.Type(value = SetMetaTitle.class, name = "setMetaTitle"),
    @JsonSubTypes.Type(value = SetMetaDescription.class, name = "setMetaDescription"),
    @JsonSubTypes.Type(value = SetMetaKeywords.class, name = "setMetaKeywords"),
    @JsonSubTypes.Type(value = SetCustomType.class, name = "setCustomType"),
    @JsonSubTypes.Type(value = SetCustomField.class, name = "setCustomField"),
})
public interface UpdateAction {
}
