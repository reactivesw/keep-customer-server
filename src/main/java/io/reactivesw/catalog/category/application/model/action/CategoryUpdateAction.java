package io.reactivesw.catalog.category.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.order.cart.application.model.action.SetCustomField;
import io.reactivesw.order.cart.application.model.action.SetCustomType;

/**
 * Created by Davis on 16/12/22.
 */
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetSlug.class, name = "setLocalizedSlug"),
    @JsonSubTypes.Type(value = SetParent.class, name = "setParent"),
    @JsonSubTypes.Type(value = SetOrderHint.class, name = "setOrderHint"),
    @JsonSubTypes.Type(value = SetExternalID.class, name = "setExternalID"),
    @JsonSubTypes.Type(value = SetMetaTitle.class, name = "setMetaTitle"),
    @JsonSubTypes.Type(value = SetMetaDescription.class, name = "setMetaDescription"),
    @JsonSubTypes.Type(value = SetMetaKeywords.class, name = "setMetaKeywords"),
    @JsonSubTypes.Type(value = SetCustomType.class, name = "setCustomType"),
    @JsonSubTypes.Type(value = SetCustomField.class, name = "setCustomField"),
})
public interface CategoryUpdateAction {
}
