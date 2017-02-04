package io.reactivesw.order.payment.application.model.mapper;

import io.reactivesw.order.payment.application.model.CreditCard;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/2/3.
 */
public final class CreditCardMapper {
  public static List<CreditCard> entityToModel(List<com.braintreegateway.CreditCard> models) {
    return models.parallelStream().map(
        m -> {
          return entityToModel(m);
        }
    ).collect(Collectors.toList());
  }

  public static CreditCard entityToModel(com.braintreegateway.CreditCard model) {
    CreditCard entity = new CreditCard();
    entity.setBin(model.getBin());
    entity.setCardholderName(model.getCardholderName());
    entity.setCardType(model.getCardType());
    entity.setCommercial(model.getCommercial().toString());
    entity.setCustomerId(model.getCustomerId());
    entity.setExpirationMonth(model.getExpirationMonth());
    entity.setExpirationYear(model.getExpirationYear());
    entity.setExpired(model.isExpired());
    entity.setToken(model.getToken());
    entity.setLast4(model.getLast4());
    return entity;
  }
}
