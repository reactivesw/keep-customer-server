package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.LineItemDraft;
import io.reactivesw.order.cart.application.model.action.AddLineItem;
import io.reactivesw.order.cart.application.model.mapper.LineItemMapper;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.domain.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by umasuo on 16/12/16.
 */
@Service
public class AddLineItemService extends CartUpdateService {

  /**
   * LineItem service.
   */
  @Autowired
  private transient LineItemService lineItemService;

  /**
   * recalculate service.
   */
  @Autowired
  private transient RecalculateService recalculateService;

  /**
   * handle add line item action.
   *
   * @param entity CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity entity, UpdateAction action) {
    LineItemValue data = this.getData((AddLineItem) action);

    Optional<LineItemValue> value = entity.getLineItems().parallelStream().filter(
        lineItemValue -> {
          return lineItemValue.equals(data);
        }
    ).findFirst();

    //the first time for add this product, then save the snapshot of it
    if (value.isPresent()) {
      LineItemValue itemInDb = value.get();
      itemInDb.setQuantity(data.getQuantity());
    } else {
      this.lineItemService.fillProduct(data);
      entity.getLineItems().add(data);
    }
    recalculateService.calculate(entity);
  }

  /**
   * get data from action.
   *
   * @param action AddLineItem
   * @return LineItemValue
   */
  private LineItemValue getData(AddLineItem action) {
    return LineItemMapper.modelToEntity((LineItemDraft) action);
  }
}
