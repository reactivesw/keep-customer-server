package io.reactivesw.catalog.category.domain.services

import com.google.common.collect.Lists
import io.reactivesw.common.model.action.SetLocalizedName
import io.reactivesw.catalog.category.domain.entities.CategoryEntity
import io.reactivesw.catalog.category.application.model.CategoryDraft
import io.reactivesw.catalog.category.infrastructure.repository.CategoryRepository
import io.reactivesw.common.entity.LocalizedStringEntity
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.exception.ParametersException
import io.reactivesw.common.model.LocalizedString
import io.reactivesw.common.model.Reference
import io.reactivesw.common.model.UpdateAction
import spock.lang.Specification

/**
 * Created by Davis on 16/11/28.
 */
class CategoryServiceTest extends Specification {
    CategoryRepository categoryRepository = Mock();
    CategoryService categoryService = new CategoryService(categoryRepository: categoryRepository);
    def categoryEntity = new CategoryEntity()
    def id = "11111111"
    def version = 1

    def setup() {
        categoryEntity.id = id
        categoryEntity.parent = "000000000000"
    }

    def "test 1.1 : query Category by id and get entity"() {
        given:
        categoryRepository.findOne(_) >> categoryEntity

        when:
        def result = categoryService.getCategoryById(id)

        then:
        result.id == categoryEntity.id
    }

    def "test 1.2 : query Category by id and get null entity"() {
        given:
        categoryRepository.findOne(_) >> null

        when:
        def result = categoryService.getCategoryById(id)

        then:
        thrown(NotExistException)
    }

    def "test 2.1 : delete Category and get null entity"() {
        given:
        categoryRepository.findOne(_) >> null

        when:
        categoryService.deleteCategory(id, version)

        then:
        thrown(NotExistException)
    }

    def "test 2.2 : delete Category and can not match version"() {
        given:
        categoryEntity.version = 2
        categoryRepository.findOne(_) >> categoryEntity

        when:
        categoryService.deleteCategory(id, version)

        then:
        thrown(ParametersException)
    }

    def "test 2.3 : delete Category"() {
        given:
        categoryEntity.version = version
        categoryRepository.findOne(_) >> categoryEntity

        when:
        categoryService.deleteCategory(id, version)

        then:
        true
    }

    def "test 2.4 : delete Category and get subCategory"() {
        given:
        categoryEntity.version = version
        categoryRepository.findOne(_) >> categoryEntity
        categoryRepository.queryCategoryIdsByAncestorId(_) >> Lists.newArrayList(categoryEntity)

        when:
        categoryService.deleteCategory(id, version)

        then:
        true
    }

    def "test 3.1 : create Category"() {
        given:
        CategoryDraft categoryDraft = new CategoryDraft()
        LocalizedString name = new LocalizedString()
        name.addKeyValue("en", "cup")
        name.addKeyValue("zn", "杯子")
        categoryDraft.name = name
        categoryRepository.save(_) >> categoryEntity

        when:
        def category = categoryService.createCategory(categoryDraft)

        then:
        category != null
    }

    def "test 3.2 : create Category with parent and subCategory with difference name"() {
        given:
        CategoryDraft categoryDraft = new CategoryDraft()
        LocalizedString name = new LocalizedString()
        name.addKeyValue("en", "cup")
        name.addKeyValue("zn", "杯子")
        categoryDraft.name = name
        def parentId = "1"
        categoryDraft.parent = new Reference(ReferenceTypes.CATEGORY.getType(), parentId)
        categoryRepository.save(_) >> categoryEntity

        def parentEntity = new CategoryEntity()
        parentEntity.id = parentId
        parentEntity.ancestors = Lists.newArrayList("0")
        categoryRepository.findOne(parentId) >> parentEntity

        List<CategoryEntity> subCategories = new ArrayList<>()
        subCategories.add(new CategoryEntity(name: Lists.newArrayList(new LocalizedStringEntity("en", "cup2"))))
        categoryRepository.queryCategoryByParent(parentId) >> subCategories

        when:
        def category = categoryService.createCategory(categoryDraft)

        then:
        category != null
    }

    def "test 3.3 : create Category with parent and subCategory with same name"() {
        given:
        CategoryDraft categoryDraft = new CategoryDraft()
        LocalizedString name = new LocalizedString()
        name.addKeyValue("en", "cup")
        name.addKeyValue("zn", "杯子")
        categoryDraft.name = name
        def parentId = "1"
        categoryDraft.parent = new Reference(ReferenceTypes.CATEGORY.getType(), parentId)
        categoryRepository.save(_) >> categoryEntity

        def parentEntity = new CategoryEntity()
        parentEntity.id = parentId
        parentEntity.ancestors = Lists.newArrayList("0")
        categoryRepository.findOne(parentId) >> parentEntity

        List<CategoryEntity> subCategories = new ArrayList<>()
        subCategories.add(new CategoryEntity(name: Lists.newArrayList(new LocalizedStringEntity("en", "cup"))))
        categoryRepository.queryCategoryByParent(parentId) >> subCategories

        when:
        def category = categoryService.createCategory(categoryDraft)

        then:
        thrown(ParametersException)
    }

    def "test 4.1 : update Category"() {
        given:
        def updateActions = new ArrayList<UpdateAction>()
        Map<String, String> map = new HashMap<>()
        map.put("en", "value")
        def changeName = new SetLocalizedName(name: new LocalizedString(localized: map))
        updateActions.add(changeName)
        categoryEntity.version = version
        categoryRepository.findOne(_) >> categoryEntity
        categoryRepository.save(_) >> categoryEntity

        when:
        def category = categoryService.updateCategory(id, version, updateActions)

        then:
        category != null

    }
}
