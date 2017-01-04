package io.reactivesw.catalog.category.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;

/**
 * Created by Davis on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetLocalizedName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetSlug.class, name = "setSlug"),
    @JsonSubTypes.Type(value = SetLocalizedDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = SetParent.class, name = "setParent"),
    @JsonSubTypes.Type(value = SetOrderHint.class, name = "setOrderHint"),
    @JsonSubTypes.Type(value = SetExternalID.class, name = "setExternalID"),
    @JsonSubTypes.Type(value = SetMetaTitle.class, name = "setMetaTitle"),
    @JsonSubTypes.Type(value = SetMetaDescription.class, name = "setMetaDescription"),
    @JsonSubTypes.Type(value = SetMetaKeywords.class, name = "setMetaKeywords"),
})
public interface CategoryUpdateAction {
}
