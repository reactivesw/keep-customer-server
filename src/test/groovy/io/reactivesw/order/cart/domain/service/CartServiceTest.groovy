package io.reactivesw.order.cart.domain.service

import io.reactivesw.common.entity.MoneyEntity
import io.reactivesw.common.exception.AlreadyExistException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.exception.ParametersException
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.*
import io.reactivesw.order.cart.infrastructure.enums.CartState
import io.reactivesw.order.cart.infrastructure.repository.CartRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
class CartServiceTest extends Specification {

    CartRepository cartRepository = Mock(CartRepository)

    PriceService priceService = new PriceService()

    LineItemService lineItemService = new LineItemService(priceService: priceService)

    CustomLineItemService customLineItemService = new CustomLineItemService()

    ShippingInfoService shippingInfoService = new ShippingInfoService()

    CartService cartService = new CartService(cartRepository: cartRepository, lineItemService: lineItemService, customLineItemService: customLineItemService, shippingInfoService: shippingInfoService)

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 1;

    def lineItemId = "tmpLineItemId"

    CartEntity cartEntity

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, quantity: 5, supplyChannel: supplyChannel, distributionChannel: distributionChannel, productId: productId)
        lineItem.setVariant(new ProductVariantValue(id: variantId))
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)


        Set<CustomLineItemValue> customItems = new HashSet()
        CustomLineItemValue customItem = new CustomLineItemValue()
        customItem.setMoney(new MoneyEntity("RMB", 12))
        customItem.setQuantity(5)
        customItems.add(customItem)

        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(price: new MoneyEntity("RMB", 12), shippingRate: new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120)), taxRate: new TaxRateValue(amount: 0.1, includedInPrice: false))

        cartEntity = new CartEntity(lineItems: lineItems, customLineItems: customItems, shippingInfo: shippingInfoValue)
    }

    def "Test 1.1: Create new Active cart by customerId"() {

        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createActiveCartWithCustomerId(customerId)
        then:
        entity != null

    }

    def "Test 1.2: Create new Active cart by anonymousId"() {

        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createActiveCartWithAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Test 1.3: Create new cart with sample whose customer id set"() {
        CartEntity param = new CartEntity()
        param.setCustomerId(customerId)
        when:
        cartRepository.save(_) >> param
        CartEntity entity = cartService.createActiveCartWithSample(param)
        then:
        noExceptionThrown()
        entity != null
        entity.getCustomerId() == customerId
    }

    def "Test 1.4: Create new cart with Sample whose anonymous id set"() {
        CartEntity param = new CartEntity()
        param.setAnonymousId(anonymousId)
        when:
        cartRepository.save(_) >> param
        CartEntity entity = cartService.createActiveCartWithSample(param)
        then:
        noExceptionThrown()
        entity.getAnonymousId() == anonymousId
    }

    def "Test 1.5: Create new cart with sample throw ParametersException"() {
        CartEntity param = new CartEntity()
        when:
        cartRepository.save(_) >> cartEntity
        cartService.createActiveCartWithSample(param)
        then:
        thrown(ParametersException)
    }

    def "Test 1.6: Create new cart with sample throw AlreadyExistException"() {
        CartEntity param = new CartEntity()
        param.setCustomerId(customerId)
        List<CartEntity> ret = new ArrayList<>()
        ret.add(param)
        when:
        cartRepository.save(_) >> cartEntity
        cartRepository.findByCustomerIdAndCartState(_, _) >> ret
        cartService.createActiveCartWithSample(param)
        then:
        thrown(AlreadyExistException)
    }

    def "Test 2.1: Get cart by cart id"() {
        when:
        cartRepository.findOne(_) >> cartEntity
        CartEntity entity = cartService.getById(customerId)
        then:
        entity != null
    }

    def "Test 2.2: Get cart by cart id not exist"() {
        when:
        cartRepository.findOne(_) >> null
        cartService.getById(customerId)
        then:
        thrown(NotExistException)
    }

    def "Test 2.3: Get Active cart By customer id"() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        CartEntity entity = cartService.getActiveCartByCustomerId(customerId)
        then:
        entity != null
    }

    def "Test 2.4: Get Active cart By customer id with empty list"() {
        List<CartEntity> ret = new ArrayList<>()
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.getActiveCartByCustomerId(customerId)
        then:
        entity != null
    }

    def "Test 2.5: Get Active cart By anonymous id "() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(anonymousId, CartState.Active) >> ret
        CartEntity entity = cartService.getActiveCartByAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Test 2.6: Get Active cart By anonymous id with empty list"() {
        List<CartEntity> ret = new ArrayList<>()
        when:
        cartRepository.findByCustomerIdAndCartState(anonymousId, CartState.Active) >> ret
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.getActiveCartByAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Test 2.7: Get cart by customer id and state"() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        List<CartEntity> entities = cartService.getCartByCustomerIdAndState(customerId, CartState.Active)
        then:
        !entities.isEmpty()
    }

    def "Test 3.1: Update cart: add LineItem to cart with non-existing items"() {
        Set<LineItemValue> lineItemValues = new HashSet<>()
        cartEntity.setLineItems(lineItemValues)

        LineItemValue newItem = new LineItemValue()
        newItem.setProductId(productId)
        newItem.setDistributionChannel(distributionChannel)
        newItem.setSupplyChannel(supplyChannel)
        newItem.setQuantity(quantity)
        newItem.setVariant(new ProductVariantValue(id: variantId))
        newItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        when:
        cartRepository.findOne(cartId) >> cartEntity

        cartService.addLineItem(cartId, newItem)
        then:
        noExceptionThrown()
    }

    def "Test 3.2: Update cart: add LineItem to cart with existing item"() {

        LineItemValue newItem = new LineItemValue()
        newItem.setProductId(productId)
        newItem.setDistributionChannel(distributionChannel)
        newItem.setSupplyChannel(supplyChannel)
        newItem.setQuantity(quantity)
        ProductVariantValue newVariant = new ProductVariantValue()
        newVariant.setId(variantId)
        newItem.setVariant(newVariant)
        newItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.addLineItem(cartId, newItem)
        then:
        noExceptionThrown()
    }

    def "Test 3.3: Update cart: remove LineItem "() {

        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.removeLineItem(cartId, lineItemId, 5)
        then:
        noExceptionThrown()

    }

    def "Test 3.4: Update cart: remove LineItem for reduce to many "() {

        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.removeLineItem(cartId, lineItemId, 10)
        then:
        noExceptionThrown()

    }

    def "Test 3.5: Update cart: remove not existing LineItem "() {

        Set<LineItemValue> lineItemValues = new HashSet<>()
        cartEntity.setLineItems(lineItemValues)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.removeLineItem(cartId, lineItemId, 5)
        then:
        thrown(NotExistException)

    }

    def "Test 4.1: Recalculate total price"() {

        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue()
        lineItem.setProductId(productId)
        lineItem.setDistributionChannel(distributionChannel)
        lineItem.setSupplyChannel(supplyChannel)
        lineItem.setQuantity(5)
        lineItem.setId(lineItemId)
        lineItem.setPrice(new PriceValue(id: "priceId", value: new MoneyEntity(centAmount: 12, currencyCode: "RMB")))
        lineItems.add(lineItem)


        Set<CustomLineItemValue> customItems = new HashSet()
        CustomLineItemValue customItem = new CustomLineItemValue()
        customItem.setMoney(new MoneyEntity("RMB", 12))
        customItem.setQuantity(5)
        customItems.add(customItem)

        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(price: new MoneyEntity("RMB", 12), shippingRate: new ShippingRateValue(price: new MoneyEntity("RMB", 12), freeAbove: new MoneyEntity("RMB", 120)), taxRate: new TaxRateValue(amount: 0.1, includedInPrice: false))

        CartEntity cart = new CartEntity(lineItems: lineItems, customLineItems: customItems, shippingInfo: shippingInfoValue)

        when:
        cartService.calculateCartPrice(cart)
        then:
        noExceptionThrown()
    }


}
