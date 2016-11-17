package io.reactivesw.customer.server.catalog.repository

import io.reactivesw.customer.server.Application
import io.reactivesw.customer.server.catalog.entities.CategoryEntity

import io.reactivesw.customer.server.common.types.LocalizedString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

/**
 * Created by Davis on 16/11/16.
 */
@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
class CategoryRepositoryTest extends Specification{
    @Autowired
    private CategoryRepository cr

    def "test 1 : add category"() {
        given:
        def metaTitle = new LocalizedString()
        metaTitle.addKeyValue("en", "shoe")
        metaTitle.addKeyValue("cn", "鞋子")
        metaTitle.addKeyValue("de", "husng")
        metaTitle.addKeyValue("cn", "老鞋子")
        def c = new CategoryEntity(name: "name", description: "description", parentId: -1, metaTitle: metaTitle)

        when:
        def result = cr.save(c)

        then:
        result != null
    }

    def "test 2 : query category"() {
        given:
        def id = "5cf55f14-64b3-4643-9ee9-fa612fa1c211"

        when:
        def result = cr.findOne(id)

        then:
        result != null
    }
}
