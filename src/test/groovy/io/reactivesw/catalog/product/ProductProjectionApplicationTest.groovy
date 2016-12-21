package io.reactivesw.catalog.product

import com.google.common.collect.Lists
import io.reactivesw.catalog.product.application.ProductApplication
import io.reactivesw.catalog.product.domain.entity.ProductEntity
import io.reactivesw.catalog.product.domain.service.ProductService
import io.reactivesw.common.model.QueryConditions
import spock.lang.Specification

/**
 * Created by Davis on 16/12/21.
 */
class ProductProjectionApplicationTest extends Specification {
    List<ProductEntity> productEntities = Lists.newArrayList()

    ProductService productService = Mock()
    def productApplication = new ProductApplication(productService: productService)
    def queryConditions = new QueryConditions()

    def setup() {
        queryConditions.where = "categoryId:\"12345678\""
    }

    def "test 1 : query product projection"() {
        given:
        productService.queryProductByCategory(_) >> productEntities

        when:
        def result = productApplication.queryProductProject(queryConditions)

        then:
        result != null
    }

}
