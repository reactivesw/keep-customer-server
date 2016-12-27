package io.reactivesw.order.shippingmethod.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethodDraft;
import io.reactivesw.order.shippingmethod.application.model.action.ShippingMethodUpdateAction;
import io.reactivesw.order.shippingmethod.application.model.mapper.ShippingMethodMapper;
import io.reactivesw.order.shippingmethod.application.service.ShippingMethodApplication;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import io.reactivesw.route.ShippingMethodRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by umasuo on 16/12/21.
 */
@RestController
public class ShippingMethodController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ShippingMethodController.class);

  /**
   * shipping method application.
   */
  @Autowired
  private transient ShippingMethodApplication application;

  /**
   * shipping method service.
   */
  @Autowired
  private transient ShippingMethodService service;

  /**
   * get shipping method by id.
   *
   * @param id String id
   * @return ShippingMethod
   */
  @ApiOperation("get shipping method by id")
  @GetMapping(ShippingMethodRouter.SHIPPING_METHOD_WITH_ID)
  public ShippingMethod getById(
      @PathVariable @ApiParam(required = true) String id) {
    LOG.info("enter: id: {}", id);

    ShippingMethodEntity entity = service.getById(id);

    LOG.info("exit: entity: {}", entity);
    return ShippingMethodMapper.entityToModel(entity);
  }

  /**
   * get shipping method for cart.
   *
   * @param cartId String
   * @return List of Shipping method
   */
  @GetMapping(value = ShippingMethodRouter.SHIPPING_METHOD_BASE_URL, params = "cartId")
  public List<ShippingMethod> getForCart(
      @RequestParam @ApiParam(required = true) String cartId) {
    LOG.info("enter: cartId: {}", cartId);

    List<ShippingMethodEntity> entities = application.getShippingMethodsForCart(cartId);

    LOG.info("exit: entities: {}", entities);
    return ShippingMethodMapper.listEntityToListModel(entities);
  }

  /**
   * get shipping methods for location
   *
   * @param country  String
   * @param state    String
   * @param currency String
   * @return List of Shipping method
   */
  @ApiOperation("get shipping method for location")
  @GetMapping(value = ShippingMethodRouter.SHIPPING_METHOD_BASE_URL, params = "country")
  public List<ShippingMethod> getForLocation(
      @RequestParam @ApiParam(required = true) String country,
      @RequestParam(required = false) @ApiParam() String state,
      @RequestParam(required = false) @ApiParam() String currency) {
    LOG.info("enter: country: {}, state: {}, currency: {}", country, state, currency);

    List<ShippingMethodEntity> entities = null;
    if (currency == null) {
      entities = application.getByLocation(country, state);
    } else {
      entities = application.getByLocation(country, state, currency);
    }

    LOG.info("exit: entities: {}", entities);
    return ShippingMethodMapper.listEntityToListModel(entities);
  }

  /**
   * create shipping method.
   *
   * @param draft shipping method draft
   * @return shipping method
   */
  @ApiOperation("create shipping method with draft")
  @PostMapping(ShippingMethodRouter.SHIPPING_METHOD_BASE_URL)
  public ShippingMethod createWithDraft(
      @RequestBody @ApiParam(required = true) ShippingMethodDraft draft) {
    LOG.info("enter: draft: {}", draft);

    ShippingMethodEntity entity = ShippingMethodMapper.modelToEntity(draft);
    ShippingMethodEntity result = service.createShippingMethod(entity);

    LOG.info("exit: entity: {}", result);
    return ShippingMethodMapper.entityToModel(result);
  }


  /**
   * update shipping method.
   *
   * @param id            shipping method id
   * @param updateRequest update request
   * @return updated Shipping method
   */
  @ApiOperation("Update shipping method with id")
  @PutMapping(ShippingMethodRouter.SHIPPING_METHOD_WITH_ID)
  public ShippingMethod update(
      @PathVariable @ApiParam(required = true) String id,
      @RequestBody @ApiParam(required = true) UpdateRequest<ShippingMethodUpdateAction>
          updateRequest) {
    LOG.info("enter: id: {}, UpdateRequest: {}", id, updateRequest);

    ShippingMethodEntity entity = service.update(id, updateRequest.getVersion(), updateRequest.getActions());

    LOG.info("exit: ShippingMethodEntity: {}", entity);
    return ShippingMethodMapper.entityToModel(entity);
  }

  /**
   * delete a shipping method.
   *
   * @param id      String
   * @param version Integer
   */
  @ApiOperation("delete shipping method with id & version")
  @DeleteMapping(ShippingMethodRouter.SHIPPING_METHOD_WITH_ID)
  public void delete(@PathVariable @ApiParam(required = true) String id,
                     @RequestParam @ApiParam(required = true) Integer version) {
    LOG.info("enter: id: {}, version: {}", id, version);

    service.deleteById(id, version);
  }

}
