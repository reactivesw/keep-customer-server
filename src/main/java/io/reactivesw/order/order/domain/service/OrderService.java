package io.reactivesw.order.order.domain.service;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.Money;
import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.order.application.model.InventoryRequest;
import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.application.model.OrderFromCartDraft;
import io.reactivesw.order.order.application.model.mapper.OrderMapper;
import io.reactivesw.order.order.application.service.OrderRestClient;
import io.reactivesw.order.order.domain.entity.OrderEntity;
import io.reactivesw.order.order.infrastructure.repository.OrderRepository;
import io.reactivesw.order.payment.application.model.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/2/6.
 */
@Service
public class OrderService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

  /**
   * order rest client.
   */
  @Autowired
  private transient OrderRestClient orderRestClient;

  /**
   * order repository.
   */
  @Autowired
  private transient OrderRepository orderRepository;

  /**
   * Create order from cart order.
   *
   * @param draft the draft
   * @return the order
   */
  public Order createOrderFromCart(OrderFromCartDraft draft) {
    /* TODO: 17/2/7
    1. get cart
    2. update inventory
    3. checkout
    4. change cart status
     */
    LOG.debug("enter createOrderFromCart, draft is : {}", draft.toString());

    Cart cart = orderRestClient.getCart(draft.getId(), draft.getVersion());

    orderRestClient.changeInventoryEntry(getInventoryRequest(cart));

    Money amount = cart.getTotalPrice();

    Payment payment = orderRestClient.checkout(cart.getCustomerId(), amount.getCentAmount(), draft
        .getPaymentMethodToken());

    OrderEntity entity = OrderMapper.of(cart, payment.getId());
    OrderEntity savedEntity = orderRepository.save(entity);

    Order result = OrderMapper.entityToModel(savedEntity);

    LOG.debug("end createOrderFromCart, result is : {}", result);
    return result;
  }

  /**
   * get inventory request by cart.
   *
   * @param cart Cart
   * @return list of Inventory Request
   */
  private List<InventoryRequest> getInventoryRequest(Cart cart) {
    List<InventoryRequest> result = cart.getLineItems().parallelStream().map(
        lineItem -> {
          return new InventoryRequest(
              lineItem.getProductVariant().getSku(), lineItem.getQuantity());
        }
    ).collect(Collectors.toList());

    return result;
  }

  /**
   * Gets order by id.
   *
   * @param orderId the order id
   * @return the order by id
   */
  public Order getOrderById(String orderId) {
    LOG.debug("enter getOrderById, order id is : {}", orderId);

    OrderEntity entity = getOrderEntity(orderId);
    Order result = OrderMapper.entityToModel(entity);

    LOG.debug("end getOrderById, result is : {}", result);

    return result;
  }

  /**
   * get order entity.
   * @param orderId the order id
   * @return the order entity
   */
  public OrderEntity getOrderEntity(String orderId) {
    LOG.debug("enter getOrderEntity, order is is : {}", orderId);
    OrderEntity result = orderRepository.findOne(orderId);
    if (result == null) {
      LOG.debug("can not find order by id : {}", orderId);
      throw new NotExistException("Order Not Exist");
    }
    LOG.debug("end getOrderEntity, result is : {}", result);
    return result;
  }
}
