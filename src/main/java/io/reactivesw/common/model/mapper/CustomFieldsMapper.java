package io.reactivesw.common.model.mapper;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.reactivesw.common.model.Reference;

/**
 * Created by Davis on 16/12/14.
 */
public class CustomFieldsMapper {
  public static CustomFields modelToEntity(CustomFieldsDraft model) {
    CustomFields entity = new CustomFields();

    entity.setType(new Reference(model.getType().getTypeId(), model.getType().getId()));
    entity.setFields(model.getFields());

    return entity;
  }
}
