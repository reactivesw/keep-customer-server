package io.reactivesw.catalog.entities

import com.google.common.collect.Lists
import io.reactivesw.catalog.categories.domains.entities.CategoryEntity
import io.reactivesw.catalog.categories.infrastructure.repositories.CategoryRepository
import io.reactivesw.common.entities.LocalizedStringEntity
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
class CategoryEntityTest extends Specification {

//    @Autowired
//    CategoryRepository repository;
//
//    def "test 0 : query by id"() {
//        given:
//        def id = "c968c11f-b229-40d4-87ba-03465ae6091f"
//
//        when:
//        def result = repository.findOne(id)
//        def ancestors = result.getAncestors()
//
//        then:
//        result != null
//        ancestors != null
//        println(ancestors)
//        println(result)
//    }
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
//        println(result)
//    }

//    def "test 2 : query category id by name"() {
//        given:
//        def langKey = "\$.en"
//        def name = "en value"
//
//        when:
//        def result = repository.queryCategoryByName(langKey, name)
//
//        then:
//        result != null
//    }

//    def "test entity"() {
//        CategoryEntity entity = new CategoryEntity()
//        LocalizedString str = new LocalizedString()
//        str.addKeyValue("en", "en value")
//        def enName = new LocalizedStringEntity("en", "en value")
//        def name = new HashSet<LocalizedStringEntity>()
//        name.add(enName)
//
//        entity.setName(name)
//        entity.parent = ""
//
//        Reference ref = new Reference(id: "iddd", typeId: "typeidddd")
//        CustomFields custom = new CustomFields(type: ref)
//        custom.setFields("{'asdasd':'adas'}")
//        entity.setCustom(custom)
//
//        def ancestors = Lists.newArrayList("first", "second");
//
//        entity.setAncestors(ancestors)
//
//        when:
//        def savedEntity = repository.save(entity)
//        def getEntity = repository.findOne(savedEntity.getId())
//
//        then:
//        getEntity != null
//        println(getEntity.id)
//        println(getEntity.version)
//    }

//    def "update entity"() {
//        given:
//        def id = "c32e199d-57e0-4ec3-85ff-df9bbe6ca81f"
//        def parentId = "2222222222222"
//
//        when:
//        def entity = repository.findOne(id)
//        entity.setParent(parentId)
//        def version = entity.version
//        def savedEntity = repository.save(entity)
//
//        then:
//        savedEntity.id == id
//        savedEntity.parent == parentId
//        savedEntity.version == version + 1
//        println(savedEntity.parent)
//        println(savedEntity.version)
//    }

//    def "test retrive entity" () {
//        when:
//        def entity = repository.findOne("00259975-484f-4ab2-b138-8480c15d865a")
//        then:
//        entity != null;
//    }
}
