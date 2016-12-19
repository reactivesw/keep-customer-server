package io.reactivesw.catalog.product

import io.reactivesw.catalog.producttype.application.model.ProductType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Davis on 16/12/19.
 */
//@ContextConfiguration
//@SpringBootTest
class ProductApplicationTest extends Specification{

    RestTemplate restTemplate = new RestTemplate();

    def "test 1.1 : get product type by id"() {
        given:
        def id = "924ff69a-c05e-4856-b316-5e8859f8d89c"

        when:
        String url = "http://localhost:8088/product-types/" + id;
        ProductType productType = restTemplate.getForObject(url, ProductType.class);

        then:
        productType != null
        productType.id == id
        println(productType.toString())
    }
}
