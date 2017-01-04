package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.product.application.model.attributes.LocalizedEnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.SetLocalizedEnumValueLabel;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service(value = ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_LABEL)
public class SetLocalizedEnumValueLabelService implements Update<ProductTypeEntity> {

  /**
   * set enum value label.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }
    SetLocalizedEnumValueLabel setPlainEnumValueLabel = (SetLocalizedEnumValueLabel) action;
    entity.getAttributes().forEach(
        attribute -> {
          if (attribute.getName().equals(setPlainEnumValueLabel.getAttributeName())
              && attribute.getType() instanceof SetLocalizedEnumValueLabel){
              ((LocalizedEnumAttributeType) attribute.getType()).getValues().forEach(
                  type -> {
                    if (type.getKey().equals(setPlainEnumValueLabel.getNewValue().getKey())) {
                      type.setLabel(setPlainEnumValueLabel.getNewValue().getLabel());
                    }
                  }
              );
          }
        }
    );
  }
}
