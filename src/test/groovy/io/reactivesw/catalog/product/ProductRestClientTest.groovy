package io.reactivesw.catalog.product

import io.reactivesw.catalog.product.application.ProductRestClient
import io.reactivesw.catalog.product.application.model.Product
import io.reactivesw.catalog.product.application.model.ProductCatalogData
import io.reactivesw.catalog.product.application.model.ProductData
import io.reactivesw.catalog.product.application.model.ProductVariant
import io.reactivesw.catalog.producttype.application.model.ProductType
import io.reactivesw.common.model.PagedQueryResult
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Davis on 16/12/22.
 */
class ProductRestClientTest extends Specification {
    RestTemplate restTemplate = Mock()
    ProductRestClient productRestClient = new ProductRestClient(restTemplate: restTemplate)

    def setup() {

    }

    def "test 1 : get producttype"() {
        given:
        def productId = "12345677"
        ProductType productType = new ProductType()
        restTemplate.getForObject(_, _) >> productType

        when:
        def result = productRestClient.getProductType(productId)

        then:
        result != null
    }

//    def "test 2 : get InventoryEntry"() {
//        given:
//        Product product = new Product()
//        product.id = "122222"
//        ProductCatalogData masterData = new ProductCatalogData()
//        ProductData currentData = new ProductData()
//        ProductVariant masterVariant = new ProductVariant()
//        masterVariant.sku = "master sku"
//        currentData.masterVariant = masterVariant
//        masterData.current = currentData
//        product.masterData = masterData
//        HttpEntity<PagedQueryResult> inventory = new HttpEntity<>()
//        restTemplate.exchange(_, HttpMethod.GET, null, PagedQueryResult.class) >> inventory
//
//        when:
//        def result = productRestClient.getInventoryEntry(product)
//
//        then:
//        result != null
//    }
}
