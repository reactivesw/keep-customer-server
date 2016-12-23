package io.reactivesw.order.cartdiscount.application.model.mapper;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.mapper.MoneyMapper;
import io.reactivesw.order.cartdiscount.application.model.CartDiscountValue;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountValueValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/22.
 */
public class CartDiscountValueMapper {

  public static CartDiscountValue entityToModel(CartDiscountValueValue entity) {
    CartDiscountValue model = null;
    if (entity != null) {
      model = new CartDiscountValue();
      model.setPermyriad(entity.getPermyriad());
      model.setType(entity.getType());

      Set<MoneyEntity> money = entity.getMoney();
      List<Money> moneyList = money.parallelStream().map(
          moneyEntity -> MoneyMapper.entityToModel(moneyEntity)
      ).collect(Collectors.toList());

      model.setMoney(moneyList);
    }
    return model;
  }

  public static CartDiscountValueValue modelToEntity(CartDiscountValue model) {
    CartDiscountValueValue entity = null;
    if (model != null) {
      entity = new CartDiscountValueValue();
      entity.setPermyriad(model.getPermyriad());
      entity.setType(model.getType());

      List<Money> money = model.getMoney();
      Set<MoneyEntity> moneyList = money.parallelStream().map(
          money1 -> MoneyMapper.modelToEntity(money1)
      ).collect(Collectors.toSet());

      entity.setMoney(moneyList);
    }
    return entity;
  }
}
