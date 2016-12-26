package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.order.cart.application.model.SubRate;
import io.reactivesw.order.cart.domain.entity.value.SubRateValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by umasuo on 16/12/16.
 */
public class SubRateMapper {

  /**
   * convert SubRate to SubRateValue.
   *
   * @param model SubRate
   * @return SubRateValue
   */
  public static SubRateValue modelToEntity(SubRate model) {
    SubRateValue entity = new SubRateValue();
    entity.setName(model.getName());
    entity.setAmount(model.getAmount());
    return entity;
  }

  public static SubRate entityToModel(SubRateValue entity) {
    SubRate model = null;
    if (entity != null) {
      model = new SubRate();
      model.setName(entity.getName());
      model.setAmount(entity.getAmount());
    }
    return model;
  }

  /**
   * convert list of SubRate to set of SubRateValue.
   *
   * @param models List<SubRate>
   * @return Set<SubRateValue>
   */
  public static Set<SubRateValue> modelListToEntitySet(List<SubRate> models) {
    Set<SubRateValue> entities = new HashSet<>();
    models.parallelStream().forEach(
        subRate -> {
          entities.add(modelToEntity(subRate));
        }
    );
    return entities;
  }

  public static List<SubRate> entityToModel(Set<SubRateValue> entities) {
    List<SubRate> models = new ArrayList<>();
    entities.parallelStream().forEach(
        subRateValue -> {
          models.add(entityToModel(subRateValue));
        }
    );
    return models;
  }
}
