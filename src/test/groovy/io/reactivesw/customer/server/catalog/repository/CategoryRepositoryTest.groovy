package io.reactivesw.customer.server.catalog.repository

import io.reactivesw.customer.server.Application
import io.reactivesw.customer.server.catalog.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Davis on 16/11/15.
 */
@ContextConfiguration(classes = Application.class,loader = SpringBootContextLoader.class)
class CategoryRepositoryTest extends Specification{
    @Autowired
    private CategoryRepository cr

//    def "test 1 : query ids by parentId"() {
//        given:
//        def parentIds = new ArrayList<>()
//        parentIds.add(0)
//
//        when:
//        def result = cr.findOne(1)
//
//        then:
//        result != null
//    }
}
