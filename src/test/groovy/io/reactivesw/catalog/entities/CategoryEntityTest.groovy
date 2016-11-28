package io.reactivesw.catalog.entities

import io.reactivesw.catalog.categories.entities.CategoryEntity
import io.reactivesw.catalog.categories.repositories.CategoryRepository
import io.reactivesw.common.models.CustomFields
import io.reactivesw.common.models.LocalizedString
import io.reactivesw.common.models.Reference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by umasuo on 16/11/22.
 */
//@ContextConfiguration
//@SpringBootTest
class CategoryEntityTest extends Specification{

//    @Autowired
//    CategoryRepository repository;
//
//    def "test 1 : query category id by ancestor id"() {
//        given:
//        def parentId = "first"
//
//        when:
//        def result = repository.queryCategoryIdsByAncestorId(parentId)
//
//        then:
//        result != null
//    }
//
//    def "test entity"() {
//        CategoryEntity entity = new CategoryEntity()
//        LocalizedString str = new LocalizedString()
//        str.addKeyValue("en", "en value")
//        entity.setName(str)
//        entity.parent = "111111111"
//
//        CustomFields custom = new CustomFields()
//        Reference ref = new Reference()
//        ref.setId("idddd")
//        ref.setTypeId("typeiddddd")
//        custom.setType(ref)
//        custom.setFields("{'asdasd':'adas'}")
//        entity.setCustom(custom)
//
//        List<String> list = new ArrayList<>()
//        list.add("first")
//        list.add("second")
//
//        entity.setAncestors(list)
//
//        when:
//        def savedEntity = repository.save(entity)
//        def getEntity = repository.findOne(savedEntity.getId())
//        then:
//        getEntity != null
//    }

//    def "test retrive entity" () {
//        when:
//        def entity = repository.findOne("00259975-484f-4ab2-b138-8480c15d865a")
//        then:
//        entity != null;
//    }
}
