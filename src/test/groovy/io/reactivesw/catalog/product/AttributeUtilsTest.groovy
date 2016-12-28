package io.reactivesw.catalog.product

import com.google.common.collect.Lists
import io.reactivesw.catalog.product.application.model.attributes.AttributeConstraint
import io.reactivesw.catalog.product.application.model.attributes.AttributeDefinition
import io.reactivesw.catalog.product.infrastructure.util.AttributeUtils
import spock.lang.Specification

/**
 * Created by Davis on 16/12/20.
 */
class AttributeUtilsTest extends Specification {
    List<AttributeDefinition> attributeDefinitions = Lists.newArrayList()

    AttributeDefinition noneAttribute1 = new AttributeDefinition()
    AttributeDefinition uniqueAttribute1 = new AttributeDefinition()

    def attributeName1 = "none attribute"
    def attributeName2 = "unique attribute"

    def setup() {
        noneAttribute1.name = attributeName1
        noneAttribute1.attributeConstraint = AttributeConstraint.None

        uniqueAttribute1.name = attributeName2
        uniqueAttribute1.attributeConstraint = AttributeConstraint.Unique
    }

    def "test 0 : new instance"() {
        when:
        AttributeUtils attributeUtils = new AttributeUtils()

        then:
        attributeUtils != null
    }

    def "test 1 : get None constraint Attribute"() {
        given:
        attributeDefinitions = Lists.newArrayList(noneAttribute1, uniqueAttribute1)

        when:
        def result = AttributeUtils.getAttributeNameByConstraint(attributeDefinitions, AttributeConstraint.None)

        then:
        result != null
    }
}
