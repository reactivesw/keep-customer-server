package io.reactivesw.catalog.product.application.model.mapper;

import com.fasterxml.jackson.databind.JsonNode;

import io.reactivesw.catalog.product.application.model.attributes.Attribute;
import io.reactivesw.catalog.product.domain.entity.AttributeEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/14.
 */
public class AttributeMapper {
  public static Set<AttributeEntity> modelToEntity(List<Attribute> models) {
    return models.stream().map(
        model -> {
          AttributeEntity entity = new AttributeEntity();
          entity.setName(model.getName());
          entity.setValue(model.getValue());
          return entity;
//          return new AttributeEntity(model.getName(), model.getValue());
        }
    ).collect(Collectors.toSet());
  }

  public static List<Attribute> entityToModel(Set<AttributeEntity> entities) {
    return entities.stream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }

  public static Attribute entityToModel(AttributeEntity entity) {
    Attribute model = new Attribute();
    
    model.setName(entity.getName());
    model.setValue(entity.getValue());

    return model;
  }
}
