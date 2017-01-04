package io.reactivesw.order.cart.application.service

import io.reactivesw.catalog.product.application.model.Price
import io.reactivesw.catalog.product.application.model.Product
import io.reactivesw.catalog.product.application.model.ProductCatalogData
import io.reactivesw.catalog.product.application.model.ProductData
import io.reactivesw.catalog.product.application.model.ProductVariant
import io.reactivesw.catalog.taxcategory.application.model.TaxCategory
import io.reactivesw.catalog.taxcategory.application.model.TaxRate
import io.reactivesw.common.model.Address
import io.reactivesw.common.model.Money
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.order.cart.application.model.LineItem
import io.reactivesw.order.cart.application.model.ShippingInfo
import io.reactivesw.order.cart.application.model.action.SetCustomerId
import io.reactivesw.order.cart.application.service.update.CartUpdateService
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.LineItemValue
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import io.reactivesw.order.cart.domain.service.CartService
import io.reactivesw.order.shippingmethod.application.model.ShippingMethod
import io.reactivesw.order.shippingmethod.application.model.ShippingRate
import io.reactivesw.order.shippingmethod.application.model.ZoneRate
import io.reactivesw.order.zone.application.model.Location
import io.reactivesw.order.zone.application.model.Zone
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/3.
 */
class CartApplicationTest extends Specification {

    CartApplication cartApplication

    CartService cartService = Mock(CartService)

    CartUpdateService cartUpdateService = Mock(CartUpdateService)

    LineItemService lineItemService = new LineItemService()

    ShippingInfoService shippingInfoService = new ShippingInfoService()

    RestTemplate restTemplate = Mock(RestTemplate);

    def id = "tmpCartId"

    def version = 1

    List<UpdateAction> actions
    SetCustomerId setCustomerId


    def customerId = "tmpCustomerId"

    def anonymousId = "tmpAnonymousId"

    def cartId = "tmpCartId"

    def productId = "tmpProductId"

    def supplyChannel = "tmpSupplyChannel"

    def distributionChannel = "tmpDistributionChannel"

    def variantId = 1

    def quantity = 5;

    def lineItemId = "tmpLineItemId"

    ShippingInfo shippingInfo

    ShippingRate shippingRate

    Money price

    Money freeAbove

    TaxRate taxRate

    def amount = 0.5

    def country = "CN"
    def state = "shenzhen"

    def currencyCode = "RMB"

    def includedInPrice = false

    def shippingMethodId = "tmpShippingMethodId"

    def shippingAddressId = "tmpShippingAddressId"

    Address address

    CartEntity cartEntity

    Product product

    ProductVariant variant

    def taxCategoryId = "tmpTaxCategoryId"
    TaxCategory taxCategory

    ZoneRate zoneRate
    ShippingMethod shippingMethod

    def zoneId = "tmpZoneId"
    Zone zone

    def setup() {
        setCustomerId = new SetCustomerId(customerId: customerId)
        actions = new ArrayList<>()
        actions.add(setCustomerId)

        Set<LineItemValue> lineItems = new HashSet()
        LineItemValue lineItem = new LineItemValue(id: lineItemId, productId: productId, variant: variantId, quantity: quantity, supplyChannel: supplyChannel, distributionChannel: distributionChannel)
        lineItems.add(lineItem)

        taxRate = new TaxRate(amount: amount, country: country, includedInPrice: includedInPrice)

        price = new Money(currencyCode: currencyCode, centAmount: 10)

        freeAbove = new Money(currencyCode: currencyCode, centAmount: 100)

        shippingRate = new ShippingRate(price: price, freeAbove: freeAbove)

        shippingInfo = new ShippingInfo(shippingMethod: new Reference(id: shippingMethodId), taxRate: taxRate, shippingRate: shippingRate)

        ShippingInfoValue shippingInfoValue = new ShippingInfoValue(shippingMethod: shippingMethodId)
        cartEntity = new CartEntity(version: version, customerId: customerId, anonymousId: anonymousId, id: cartId, lineItems: lineItems, shippingInfo: shippingInfoValue, shippingAddress: shippingAddressId, billingAddress: shippingAddressId, currencyCode: currencyCode, country: country)

        address = new Address(id: shippingAddressId, country: country)
        cartApplication = new CartApplication(cartService: cartService, cartUpdateService: cartUpdateService, lineItemService: lineItemService, shippingInfoService: shippingInfoService, restTemplate: restTemplate)


        List<Price> prices = new ArrayList<>()
        Price variantPrice = new Price(value: price, country: country, channel: new Reference(id: distributionChannel))
        prices.add(variantPrice)
        variant = new ProductVariant(id: variantId, prices: prices)
        List<ProductVariant> variants = new ArrayList<>()
        variants.add(variant)

        ProductData productData = new ProductData(variants: variants)
        ProductCatalogData masterData = new ProductCatalogData(current: productData)
        product = new Product(id: productId, masterData: masterData, taxCategory: new Reference(id: taxCategoryId))

        List<TaxRate> taxRates = new ArrayList<>()
        taxRates.add(taxRate)
        taxCategory = new TaxCategory(rates: taxRates)

        List<ShippingRate> shippingRates = new ArrayList<>()
        shippingRates.add(shippingRate)
        zoneRate = new ZoneRate(zone: new Reference(id: zoneId), shippingRates: shippingRates)
        List<ZoneRate> zoneRates = new ArrayList<>()
        zoneRates.add(zoneRate)
        shippingMethod = new ShippingMethod(id: shippingMethodId, name: "MSN", taxCategory: new Reference(id: taxCategoryId), zoneRates: zoneRates)

        Location location = new Location(country: country, state: state)
        List<Location> locations = new ArrayList<>()
        locations.add(location)
        zone = new Zone(id: zoneId, locations: locations)
    }

    def "Test 1.1: Update Cart"() {

        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Update Cart with item not exist"() {

        cartEntity.setLineItems(null)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.3: Update Cart with shipping address not set"() {

        cartEntity.setShippingAddress(null)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: Update Cart with billing address not set"() {

        cartEntity.setBillingAddress(null)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> null
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.5: Update Cart with product non-exist"() {

        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> null
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.6: Update Cart with tax category not exist"() {

        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> null
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.7: Update Cart with shipping method's tax category not set"() {

        shippingMethod.setTaxCategory(null)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.8: Update Cart with shipping method's tax category id not set"() {

        shippingMethod.getTaxCategory().setId(null)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }

    def "Test 1.9: Update Cart with chose tax category with country and state"() {

        address.setState(state)
        when:
        cartService.getById(_) >> cartEntity
        cartService.updateCart(_, _, _) >> cartEntity
        restTemplate.getForObject("shipping", _) >> address
        restTemplate.getForObject("billing", _) >> address
        restTemplate.getForObject("item", _) >> product
        restTemplate.getForObject("tax", _) >> taxCategory
        restTemplate.getForObject("shippingInfo", _) >> shippingMethod
        restTemplate.getForObject("zone", _) >> zone
        cartApplication.updateCart(cartId, version, actions)
        then:
        noExceptionThrown()
    }
}
