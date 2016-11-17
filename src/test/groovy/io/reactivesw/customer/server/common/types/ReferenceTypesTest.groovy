package io.reactivesw.customer.server.common.types

import io.reactivesw.customer.server.catalog.entities.CategoryEntity
import spock.lang.Specification

/**
 * Created by Davis on 16/11/16.
 */
class ReferenceTypesTest extends Specification {
    def "test 1 : get Cart"() {
        given:
        Class clazz = CategoryEntity.class

        when:
        def result = ReferenceTypes.getType(clazz)

        then:
        println(result)
        true
    }
}
