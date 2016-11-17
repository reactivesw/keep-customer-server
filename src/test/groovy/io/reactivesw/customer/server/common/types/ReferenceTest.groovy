package io.reactivesw.customer.server.common.types

import io.reactivesw.customer.server.catalog.entities.CategoryEntity
import spock.lang.Specification
import sun.security.krb5.internal.PAData

/**
 * Created by Davis on 16/11/16.
 */
class ReferenceTest extends Specification {
    def "test 1 : new Reference"() {
        given:
        def id = "1";
        Reference<CategoryEntity> parent = new Reference<>()

        when:
        parent.setId(id)

        then:
        parent.id == id
        parent.typeId != null
        parent.typeId != ""

        println(parent.toString())
    }
}
