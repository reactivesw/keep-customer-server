package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.order.cart.application.model.LineItem;
import io.reactivesw.order.order.domain.entity.value.LineItemValue;

import java.util.List;

/**
 * Created by Davis on 17/2/7.
 */
public final class LineItemMapper {
  /**
   * Instantiates a new Line item mapper.
   */
  private LineItemMapper() {
  }

  /**
   * Model to entity list.
   *
   * @param models the models
   * @return the list
   */
  public static List<LineItemValue> modelToEntity(List<LineItem> models) {
    return null;
  }
}
