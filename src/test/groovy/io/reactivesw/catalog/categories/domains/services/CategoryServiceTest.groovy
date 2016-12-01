package io.reactivesw.catalog.categories.domains.services

import com.google.common.collect.Lists
import io.reactivesw.catalog.categories.domains.entities.CategoryEntity
import io.reactivesw.catalog.categories.applications.models.CategoryDraft
import io.reactivesw.catalog.categories.infrastructure.repositories.CategoryRepository
import io.reactivesw.common.entities.LocalizedStringEntity
import io.reactivesw.common.enums.ReferenceTypes
import io.reactivesw.common.exceptions.NotExistException
import io.reactivesw.common.exceptions.ParametersException
import io.reactivesw.common.models.LocalizedString
import io.reactivesw.common.models.Reference
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

    def "test 1 : query Category by id and get entity"() {
        given:
        categoryRepository.findOne(_) >> categoryEntity

        when:
        def result = categoryService.getCategoryById(id)

        then:
        result.id == categoryEntity.id
    }

    def "test 2 : query Category by id and get null entity"() {
        given:
        categoryRepository.findOne(_) >> null

        when:
        def result = categoryService.getCategoryById(id)

        then:
        thrown(NotExistException)
    }

    def "test 3 : delete Category and get null entity"() {
        given:
        categoryRepository.findOne(_) >> null

        when:
        categoryService.deleteCategory(id, version)

        then:
        thrown(NotExistException)
    }

    def "test 4 : delete Category and can not match version"() {
        given:
        categoryEntity.version = 2
        categoryRepository.findOne(_) >> categoryEntity

        when:
        categoryService.deleteCategory(id, version)

        then:
        thrown(ParametersException)
    }

    def "test 5 : delete Category"() {
        given:
        categoryEntity.version = version

        categoryRepository.findOne(_) >> categoryEntity

        when:
        categoryService.deleteCategory(id, version)

        then:
        true
    }

    def "test 6 : create Category"() {
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

    def "test 7 : create Category with parent and subCategory with difference name"() {
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

    def "test 8 : create Category with parent and subCategory with same name"() {
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
}
