package io.reactivesw.catalog.entities

import spock.lang.Specification

/**
 * Created by umasuo on 16/11/22.
 */
//@ContextConfiguration
//@SpringBootTest
class CategoryEntityTest extends Specification {
//
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
//        def result = repository.querySubCategoriesByAncestorId(parentId)
//
//        then:
//        result != null
//        println(result)
//    }
//
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
//
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
//
//    def "test 3 : query predicate"() {
//        given:
//        def queryConditions = new QueryConditions()
//        def versionCondition = "name(en=\"en value\") and version = 1 and id=\"159e9da4-22c7-4882-a734-80629cf528b1\""
////        def versionCondition = "name(en=\"en value\")"
//        queryConditions.setWhere(versionCondition)
//
//        when:
//        def result = repository.findAll(CategorySpecs.queryPredicate(queryConditions))
//
//        then:
//        result != null
//        println(result)
//    }
//
//    def "update entity"() {
//        given:
//        def id = "859a9f76-f7aa-4dea-beeb-30cd25af564c"
//        def name = new LocalizedStringEntity(language: "en", text: "text")
//        def names = Sets.newHashSet(name)
//
//        when:
//        def entity = repository.findOne(id)
//        entity.setName(names)
//        def version = entity.version
//        def savedEntity = repository.save(entity)
//
//        then:
//        savedEntity.id == id
//        savedEntity.version == version + 1
//        println(savedEntity.version)
//    }

//    def "test retrive entity" () {
//        when:
//        def entity = repository.findOne("00259975-484f-4ab2-b138-8480c15d865a")
//        then:
//        entity != null;
//    }
}
