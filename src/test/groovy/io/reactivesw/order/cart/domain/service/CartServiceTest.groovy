package io.reactivesw.order.cart.domain.service

import io.reactivesw.common.exception.*
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.order.cart.application.service.update.CartUpdateService
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import io.reactivesw.order.cart.infrastructure.enums.CartState
import io.reactivesw.order.cart.infrastructure.repository.CartRepository
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
class CartServiceTest extends Specification {

    CartRepository cartRepository = Mock(CartRepository)

    CartUpdateService cartUpdateService = Mock(CartUpdateService)

    CartService cartService = new CartService(cartRepository: cartRepository)

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 5

    def lineItemId = "tmpLineItemId"

    def shippingMethodId = "shippingMethodId"

    def version = 1

    CartEntity cartEntity

    List<UpdateAction> actions

    def setup() {
        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, productId: productId, variant: variantId, quantity: quantity, supplyChannel: supplyChannel, distributionChannel: distributionChannel)
        lineItems.add(lineItem)


        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(shippingMethod: shippingMethodId)

        cartEntity = new CartEntity(id: cartId, version: version, lineItems: lineItems, shippingInfo: shippingInfoValue)

        actions = new ArrayList<>()

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

    def "Test 2.5: Get cart by customer id and state"() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        List<CartEntity> entities = cartService.getCartByCustomerIdAndState(customerId, CartState.Active)
        then:
        !entities.isEmpty()
    }

    def "Test 2.6: Get cart by anonymousId"() {
        when:
        cartRepository.findOneByAnonymousId(anonymousId) >> cartEntity
        CartEntity result = cartService.getCartByAnonymousId(anonymousId)
        then:
        result != null
    }

    def "Test 2.7: Get cart by anonymousId with non-existing cart"() {
        when:
        cartRepository.findOneByAnonymousId(anonymousId) >> null
        cartRepository.save(_) >> cartEntity
        CartEntity result = cartService.getCartByAnonymousId(anonymousId)
        then:
        result != null
    }


    def "Test 3.1: Update cart"() {

        cartEntity.setCartState(CartState.Active)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartRepository.save(_) >> cartEntity
        cartService.updateCart(cartId, version, cartEntity)
        then:
        noExceptionThrown()
    }

    def "Test 3.2: Update non-active cart"() {

        cartEntity.setCartState(CartState.Merged)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.updateCart(cartId, version, cartEntity)
        then:
        thrown(ImmutableException)
    }

    def "Test 3.3: Update cart with wrong version"() {

        cartEntity.setVersion(version + 1)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.updateCart(cartId, version, cartEntity)
        then:
        thrown(ConflictException)
    }

    def "Test 4.1: Delete cart"() {

        cartEntity.setVersion(version)
        cartEntity.setCartState(CartState.Active)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.deleteCart(cartId, version)
        then:
        noExceptionThrown()
    }


    def "Test 4.2: Delete cart with non-active cart"() {

        cartEntity.setVersion(version)
        cartEntity.setCartState(CartState.Merged)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.deleteCart(cartId, version)
        then:
        thrown(ImmutableException)
    }

    def "Test 4.3: Delete cart with wrong version"() {

        cartEntity.setVersion(version + 1)
        cartEntity.setCartState(CartState.Active)
        when:
        cartRepository.findOne(cartId) >> cartEntity
        cartService.deleteCart(cartId, version)
        then:
        thrown(ConflictException)
    }


}
