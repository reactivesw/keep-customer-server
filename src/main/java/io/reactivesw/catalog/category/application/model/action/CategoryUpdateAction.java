package io.reactivesw.catalog.category.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Davis on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetSlug.class, name = "setSlug"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = SetParent.class, name = "setParent"),
    @JsonSubTypes.Type(value = SetOrderHint.class, name = "setOrderHint"),
    @JsonSubTypes.Type(value = SetExternalID.class, name = "setExternalId"),
    @JsonSubTypes.Type(value = SetMetaTitle.class, name = "setMetaTitle"),
    @JsonSubTypes.Type(value = SetMetaDescription.class, name = "setMetaDescription"),
    @JsonSubTypes.Type(value = SetMetaKeywords.class, name = "setMetaKeywords"),
})
public interface CategoryUpdateAction {
}
