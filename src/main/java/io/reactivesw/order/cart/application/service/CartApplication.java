package io.reactivesw.order.cart.application.service;

import io.reactivesw.catalog.product.application.model.*;
import io.reactivesw.catalog.taxcategory.application.model.*;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.*;
import io.reactivesw.order.cart.application.model.*;
import io.reactivesw.order.cart.application.model.mapper.CartMapper;
import io.reactivesw.order.cart.application.service.update.CartUpdateService;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.entity.value.LineItemValue;
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue;
import io.reactivesw.order.cart.domain.service.CartService;
import io.reactivesw.order.shippingmethod.application.model.*;
import io.reactivesw.order.zone.application.model.Zone;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by umasuo on 16/12/28.
 */
@Service
public class CartApplication {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartApplication.class);

  /**
   * cart service.
   */
  @Autowired
  private transient CartService cartService;

  /**
   * rest client.
   */
  @Autowired
  private transient CartRestClient restClient;

  /**
   * cart update service.
   */
  @Autowired
  private transient CartUpdateService cartUpdateService;

  /**
   * cart LineItem service.
   */
  @Autowired
  private transient LineItemService lineItemService;

  /**
   * cart ShippingInfo service.
   */
  @Autowired
  private transient ShippingInfoService shippingInfoService;

  /**
   * update cart for with action list.
   *
   * @param id      String of cart id
   * @param version Integer
   * @param actions list of actions
   * @return CartEntity
   */
  public Cart updateCart(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter: id{}, version: {}, actions: {}", id, version, actions);
    CartEntity cart = this.cartService.getById(id);

    //update data from action
    actions.parallelStream().forEach(
        action -> this.cartUpdateService.handle(cart, action)
    );

    CartEntity result = this.cartService.updateCart(id, version, cart);

    LOG.debug("exit: result: {}", result);
    return this.getFullCart(result);
  }

  /**
   * get full Cart from an cart entity.
   *
   * @param entity CartEntity
   * @return Cart
   */
  public Cart getFullCart(CartEntity entity) {
    LOG.debug("enter: entity: {}", entity);

    Cart data = this.fillData(entity);

    this.calculateCartPrice(data);

    LOG.debug("exit cart: {}", data);
    return data;
  }

  /**
   * fetch data from other service, and then fill it into the cart
   *
   * @return Cart
   */
  private Cart fillData(CartEntity entity) {
    LOG.debug("enter: entity: {}", entity);
    //got the base info
    Cart cart = CartMapper.entityToModel(entity);

    // Attention: we should set address first, because Tax category should use the shipping address.

    //fill the address info: shipping address, billing address
    this.fillShippingAddress(cart, entity.getShippingAddress());
    this.fillBillingAddress(cart, entity.getBillingAddress());

    // fill the LineItem info
    this.fillLineItem(cart, entity.getLineItems());

    //fill the shipping info
    this.fillShippingInfo(cart, entity.getShippingInfo());

    LOG.debug("end fillData, exit: cart: {}", cart);
    return cart;
  }


  /**
   * get shipping address from customer service.
   *
   * @param cart      Cart
   * @param addressId address id.
   */
  private void fillShippingAddress(Cart cart, String addressId) {
    LOG.debug("enter: cart: {}, addressId: {}", cart, addressId);
    if (StringUtils.isNotBlank(addressId)) {
      //get address from customer service
      Address address = restClient.getAddress(addressId);
      cart.setShippingAddress(address);
      LOG.debug("enter: cart: {}, address: {}", cart, address);
    }
  }

  /**
   * get billing address from customer service.
   *
   * @param cart      Cart
   * @param addressId String address id
   */
  private void fillBillingAddress(Cart cart, String addressId) {
    LOG.debug("enter: cart: {}, addressId: {}", cart, addressId);
    if (StringUtils.isNotBlank(addressId)) {
      //get address from customer service
      Address address = restClient.getAddress(addressId);
      cart.setBillingAddress(address);
      LOG.debug("enter: cart: {}, addressId: {}", cart, addressId);
    }
  }


  /**
   * fill the line items' info.
   *
   * @param cart      Cart
   * @param lineItems Set<LineItemValue>
   */
  private void fillLineItem(Cart cart, Set<LineItemValue> lineItems) {
    LOG.debug("enter: cart: {}, lineItems: {}", cart, lineItems);
    if (lineItems != null) {
      List<LineItem> items = new ArrayList<>();
      lineItems.parallelStream().forEach(
          lineItemValue -> {
            LineItem item = new LineItem();
            this.setLineItemBaseInfo(item, lineItemValue);
            //TODO get Product from product service.
            Product product = restClient.getProduct(item.getProductId());
            if (product == null) {
              //TODO if the product has been deleted , then remove it from cart
              LOG.warn("Remove non-existing product");
            } else {
              // the product from the cart.
              ProductData productData = product.getMasterData().getCurrent();
              this.setLineItemProductInfo(item, productData, lineItemValue.getVariant());

              Address shippingAddress = cart.getShippingAddress();
              if (shippingAddress != null) {
                Reference taxCategoryRef = product.getTaxCategory();
                TaxRate taxRate = this.getTaxRate(taxCategoryRef, shippingAddress.getCountry(),
                    shippingAddress.getState());
                item.setTaxRate(taxRate);
              }
              if (item.getProductVariant() != null) {
                items.add(item);
              }
            }
          }
      );
      LOG.debug("exit: cart: {}", cart);
      cart.setLineItems(items);
    }
  }

  /**
   * set id, quantity, product id, distribution channel, and supply channel that save in CartEntity.
   *
   * @param item          LineItem
   * @param lineItemValue LineItemEntity
   */
  private void setLineItemBaseInfo(LineItem item, LineItemValue lineItemValue) {
    LOG.debug("enter: LineItem: {}, LineItemValue: {}", item, lineItemValue);
    item.setId(lineItemValue.getId());
    item.setQuantity(lineItemValue.getQuantity());
    item.setProductId(lineItemValue.getProductId());
    item.setDistributionChannel(new Reference(ReferenceTypes.CHANNEL.getType(),
        lineItemValue.getDistributionChannel()));
    item.setSupplyChannel(new Reference(ReferenceTypes.CHANNEL.getType(),
        lineItemValue.getSupplyChannel()));

    LOG.debug("exit: LineItem: {}", item);
  }

  /**
   * set the product info of this lineItem. product name, slug, and selected variant.
   *
   * @param item        LineItem
   * @param productData ProductData
   * @param variantId   Integer of variantId
   */
  private void setLineItemProductInfo(LineItem item, ProductData productData, Integer variantId) {
    LOG.debug("enter: LineItem: {}, productData: {}, variantId: {}", item, productData, variantId);
    item.setName(productData.getName());
    item.setSlug(productData.getSlug());

    ProductVariant variant = productData.getVariants().parallelStream().filter(
        productVariant -> productVariant.getId() == variantId
    ).findAny().orElse(null);

    if (variant == null) {
      //TODO remove the product
      LOG.warn("Delete non-existing variant.");
    } else {
      item.setProductVariant(variant);
    }
    LOG.debug("exit: LineItem: {}", item);
  }

  /**
   * fill shipping info if the shipping method has been set
   *
   * @param cart      Cart
   * @param infoValue ShippingInfoValue
   */
  private void fillShippingInfo(Cart cart, ShippingInfoValue infoValue) {
    LOG.debug("enter: cart: {}, ShippingInfoValue: {}", cart, infoValue);
    String shippingMethodId = infoValue == null ? null : infoValue.getShippingMethod();
    if (shippingMethodId != null) {
      // get shipping method from shipping method service.
      ShippingMethod shippingMethod = restClient.getShippingMethod(shippingMethodId);
      if (shippingMethod == null) {
        //TODO remove the shipping method, the customer need to select again.
        LOG.warn("Remove non-existing shipping method.");
      } else {

        ShippingInfo info = new ShippingInfo();
        info.setShippingMethod(new Reference(ReferenceTypes.SHIPPING_METHOD.getType(),
            shippingMethod.getId()));
        info.setShippingMethodName(shippingMethod.getName());

        Address address = cart.getShippingAddress();
        Reference tc = shippingMethod.getTaxCategory();
        info.setTaxCategory(tc);
        if (address != null) {
          String country = address.getCountry();
          String state = address.getState();

          //TODO currency should be saved in cart
          ShippingRate shippingRate = this.getShippingRate(shippingMethod.getZoneRates(),
              country, state, cart.getCurrencyCode());
          info.setShippingRate(shippingRate);

          TaxRate taxRate = this.getTaxRate(tc, country, state);
          info.setTaxRate(taxRate);
        }
        cart.setShippingInfo(info);
      }
    }
    LOG.debug("exit: cart: {}", cart);
  }

  /**
   * get shipping rate by country, state, currency.
   *
   * @param zoneRates List ZoneRate
   * @param country   String
   * @param state     String
   * @param currency  String
   * @return ShippingRate
   */
  private ShippingRate getShippingRate(List<ZoneRate> zoneRates, String country, String state,
                                       String currency) {
    LOG.debug("enter: zoneRates: {}, country: {}, state: {}, currency: {}", zoneRates, country,
        state, currency);
    ShippingRate shippingRate = null;
    if (zoneRates != null) {
      ZoneRate rate = zoneRates.parallelStream().filter(
          zoneRate -> {
            //TODO get zone id by country & state
            Zone zone = restClient.getZone(zoneRate.getZone().getId());
            LOG.debug("Zone got by country: {}, state: {}, Zone:{}", country, state, zone);
            return StringUtils.equals(zone.getId(), zoneRate.getZone().getId());
          }
      ).findAny().orElse(null);

      List<ShippingRate> shippingRates = rate.getShippingRates();
      shippingRate = shippingRates.parallelStream().filter(
          shippingRate1 -> {
            String savedCurrency = shippingRate1.getPrice().getCurrencyCode();
            return StringUtils.equals(savedCurrency, currency);
          }
      ).findAny().orElse(null);
    }

    LOG.debug("exit: shippingRate: {}", shippingRate);
    return shippingRate;
  }

  /**
   * get the TaxRate from TaxCategory service
   *
   * @param txRef   Reference of TaxCategory
   * @param country String
   * @param state   String
   * @return TaxRate
   */
  private TaxRate getTaxRate(Reference txRef, String country, String state) {
    LOG.debug("enter: Reference: {}, country: {}, state: {}", txRef, country, state);
    TaxRate taxRate = null;
    if (txRef != null && txRef.getId() != null) {
      String taxCategoryId = txRef.getId();
      TaxCategory taxCategory = restClient.getTaxCategory(taxCategoryId);
      taxRate = this.getTaxRate(taxCategory, country, state);
    }
    LOG.debug("exit: TaxRate: {}", taxRate);
    return taxRate;
  }

  /**
   * get tax rate from tax category by country and state.
   * if only country is passed, then just compare the country
   *
   * @param tc      TaxCategory
   * @param country String
   * @param state   String
   * @return TaxRate
   */
  private TaxRate getTaxRate(TaxCategory tc, String country, String state) {
    LOG.debug("enter: TaxCategory: {}, country: {}, state: {}", tc, country, state);
    TaxRate taxRate = null;
    if (tc != null) {
      taxRate = tc.getRates().parallelStream().filter(
          taxRate1 -> {
            String saveCountry = taxRate1.getCountry();
            String saveState = taxRate1.getState();
            boolean onlyCountry = state == null && Objects.equals(saveCountry, country);
            boolean bothCountryAndState = Objects.equals(saveCountry, country) && Objects.equals
                (saveState, state);
            return onlyCountry | bothCountryAndState;
          }
      ).findAny().orElse(null);
    }
    LOG.debug("exit: TaxRate: {}", taxRate);
    return taxRate;
  }

  /**
   * calculate cart total price
   *
   * @param cart Cart
   */
  private void calculateCartPrice(Cart cart) {
    LOG.debug("enter: cart: {}", cart);
    String currencyCode = cart.getCurrencyCode();
    String country = cart.getCountry();
    List<LineItem> items = cart.getLineItems();
    int lineItemTotalPrice = 0;
    if (items != null) {
      items.parallelStream().forEach(
          lineItem -> {
            this.lineItemService.selectItemPrice(lineItem, currencyCode, country);
            this.lineItemService.calculateItemPrice(lineItem);
          }
      );
      //count total price of all line item
      lineItemTotalPrice = items.parallelStream().mapToInt(
          lineItem -> lineItem.getTotalPrice() == null ? 0 : lineItem.getTotalPrice()
              .getCentAmount()
      ).sum();
    }

    //select and calculate shipping price
    int shippingPrice = 0;
    ShippingInfo shippingInfo = cart.getShippingInfo();
    if (shippingInfo != null) {
      this.shippingInfoService.calculateShippingPrice(shippingInfo, currencyCode,
          lineItemTotalPrice);
      Money shippingInfoPrice = shippingInfo.getPrice();
      if (shippingInfoPrice != null) {
        shippingPrice = shippingInfoPrice.getCentAmount();
      }
    }

    int cartTotalPrice = lineItemTotalPrice + shippingPrice;
    Money cartTotal = new Money();
    cartTotal.setCurrencyCode(cart.getCurrencyCode());
    cartTotal.setCentAmount(cartTotalPrice);
    cart.setTotalPrice(cartTotal);
    LOG.debug("exit: cart: {}", cart);
  }
}
