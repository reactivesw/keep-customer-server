package io.reactivesw.orders.carts.domains.services

import io.reactivesw.common.exceptions.AlreadyExistException
import io.reactivesw.common.exceptions.NotExistException
import io.reactivesw.common.exceptions.ParametersException
import io.reactivesw.orders.carts.domains.entities.CartEntity
import io.reactivesw.orders.carts.infrastructures.enums.CartState
import io.reactivesw.orders.carts.infrastructures.repositories.CartRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/29.
 */
class CartServiceTest extends Specification {

    Logger LOG = LoggerFactory.getLogger(CartServiceTest)


    CartRepository cartRepository = Mock(CartRepository)

    CartService cartService = new CartService(cartRepository: cartRepository)

    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    CartEntity cartEntity

    def setup() {
        LOG.info("init cart service test.")
        cartService.setCartRepository(cartRepository)
        cartEntity = new CartEntity(id: "id")
    }

    def "Create new Active cart by customerId"() {

        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createActiveCartWithCustomerId(customerId)
        then:
        entity != null

    }

    def "Create new Active cart by anonymousId"() {

        when:
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.createActiveCartWithAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Create new cart with sample whose customer id set"() {
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

    def "Create new cart with Sample whose anonymous id set"() {
        CartEntity param = new CartEntity()
        param.setAnonymousId(anonymousId)
        when:
        cartRepository.save(_) >> param
        CartEntity entity = cartService.createActiveCartWithSample(param)
        then:
        noExceptionThrown()
        entity.getAnonymousId() == anonymousId
    }

    def "Create new cart with sample throw ParametersException"() {
        CartEntity param = new CartEntity()
        when:
        cartRepository.save(_) >> cartEntity
        cartService.createActiveCartWithSample(param)
        then:
        thrown(ParametersException)
    }

    def "Create new cart with sample throw AlreadyExistException"() {
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

    def "Get cart by cart id"() {
        when:
        cartRepository.findOne(_) >> cartEntity
        CartEntity entity = cartService.getCartByCartId(customerId)
        then:
        entity != null
    }

    def "Get cart by cart id not exist"() {
        when:
        cartRepository.findOne(_) >> null
        cartService.getCartByCartId(customerId)
        then:
        thrown(NotExistException)
    }

    def "Get Active cart By customer id"() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        CartEntity entity = cartService.getActiveCartByCustomerId(customerId)
        then:
        entity != null
    }

    def "Get Active cart By customer id with empty list"() {
        List<CartEntity> ret = new ArrayList<>()
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.getActiveCartByCustomerId(customerId)
        then:
        entity != null
    }

    def "Get Active cart By anonymous id "() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(anonymousId, CartState.Active) >> ret
        CartEntity entity = cartService.getActiveCartByAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Get Active cart By anonymous id with empty list"() {
        List<CartEntity> ret = new ArrayList<>()
        when:
        cartRepository.findByCustomerIdAndCartState(anonymousId, CartState.Active) >> ret
        cartRepository.save(_) >> cartEntity
        CartEntity entity = cartService.getActiveCartByAnonymousId(anonymousId)
        then:
        entity != null
    }

    def "Get cart by customer id and state"() {
        List<CartEntity> ret = new ArrayList<>()
        ret.add(cartEntity)
        when:
        cartRepository.findByCustomerIdAndCartState(customerId, CartState.Active) >> ret
        List<CartEntity> entities = cartService.getCartByCustomerIdAndState(customerId, CartState.Active)
        then:
        !entities.isEmpty()
    }

    def "Update cart"() {
        when:
        cartService.updateCart(cartEntity)
        then:
        noExceptionThrown()
    }
}
