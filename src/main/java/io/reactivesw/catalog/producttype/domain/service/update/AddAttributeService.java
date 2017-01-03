package io.reactivesw.catalog.producttype.domain.service.update;

import com.google.common.collect.Lists;
import io.reactivesw.catalog.producttype.application.model.action.AddAttributeDefinition;
import io.reactivesw.catalog.producttype.application.model.mapper.AttributeDefinitionMapper;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.ADD_ATTRIBUTE_DEFINITION)
public class AddAttributeService implements Update<ProductTypeEntity> {
  /**
   * add attribute definition to product type.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    AddAttributeDefinition addAttributeDefinition = (AddAttributeDefinition) action;
    AttributeDefinitionEntity attributeDefinitionEntity = AttributeDefinitionMapper.modelToEntity
        (addAttributeDefinition.getAttribute());

    List<AttributeDefinitionEntity> attributes = entity.getAttributes();
    if (attributes == null) {
      attributes = Lists.newArrayList();
    }
    attributes.add(attributeDefinitionEntity);

    entity.setAttributes(attributes);
  }
}
