package io.reactivesw.catalog.producttype.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Davis on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddAttribute.class, name = "addAttribute"),
})
public interface ProductTypeUpdateAction {
}
