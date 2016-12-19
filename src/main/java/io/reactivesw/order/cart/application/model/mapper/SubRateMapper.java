package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.SubRate;
import io.reactivesw.order.cart.domain.entity.value.SubRateValue;

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
}
