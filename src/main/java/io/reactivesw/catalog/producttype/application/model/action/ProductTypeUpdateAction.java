package io.reactivesw.catalog.producttype.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Created by Davis on 16/12/22.
 */
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddAttribute.class, name = "addAttribute"),
})
public interface ProductTypeUpdateAction {
}
