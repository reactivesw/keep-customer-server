package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.product.application.model.AttributeDefinitionDraft;
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition;
import io.reactivesw.catalog.product.application.model.attributes.AttributeType;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/8.
 */
public final class AttributeDefinitionMapper {

  /**
   * Model to entity set.
   *
   * @param attributeDefinitionList the attribute definition list
   * @return the set
   */
  public static Set<AttributeDefinitionEntity> modelToEntity(List<AttributeDefinitionDraft>
                                                                 attributeDefinitionList) {
    Set<AttributeDefinitionEntity> entities = new HashSet<>();
    if (attributeDefinitionList != null) {
      entities = attributeDefinitionList.stream().map(attributedefinition -> {
        return modelToEntity(attributedefinition);
      }).collect(Collectors.toSet());
    }
    return entities;
  }

  /**
   * convert Model to AttributeDefinitionEntity.
   *
   * @param draft the draft
   * @return the AttributeDefinitionEntity
   */
  public static AttributeDefinitionEntity modelToEntity(AttributeDefinitionDraft draft) {
    AttributeDefinitionEntity entity = new AttributeDefinitionEntity();
    entity.setName(draft.getName());
    entity.setInputHint(draft.getInputHint());
    entity.setRequired(draft.getRequired());
    entity.setSearchable(draft.getSearchable());
    entity.setType(draft.getType());
    entity.setAttributeConstraint(draft.getAttributeConstraint());
    entity.setLabel(LocalizedStringMapper.modelToEntityDefaultNew(draft.getLabel()));
    return entity;
  }

  /**
   * convert Model to AttributeDefinitionEntity.
   *
   * @param attributeType the attribute type
   * @return the attribute definition entity
   */
  public static AttributeDefinitionEntity modelToEntity(AttributeType attributeType) {
    AttributeDefinitionEntity entity = new AttributeDefinitionEntity();
    return entity;
  }

  /**
   * Entity to model list.
   *
   * @param entities the entity
   * @return the list
   */
  public static List<AttributeDefinition> entityToModel(Set<AttributeDefinitionEntity> entities) {
    List<AttributeDefinition> models = entities.stream().map(entity -> {
      return entityToModel(entity);
    }).collect(Collectors.toList());
    return models;
  }

  /**
   * convert Entity to AttributeDefinition.
   *
   * @param entity the entity
   * @return the attribute definition
   */
  public static AttributeDefinition entityToModel(AttributeDefinitionEntity entity) {
    AttributeDefinition model = new AttributeDefinition();
    model.setName(entity.getName());
    model.setInputHint(entity.getInputHint());
    model.setInputTip(LocalizedStringMapper.entityToModelDefaultNull(entity.getInputTip()));
    model.setLabel(LocalizedStringMapper.entityToModelDefaultNull(entity.getLabel()));
    model.setRequired(entity.getRequired());
    model.setSearchable(entity.getSearchable());
    model.setType(entity.getType());
    model.setAttributeConstraint(entity.getAttributeConstraint());
    return model;
  }
}
