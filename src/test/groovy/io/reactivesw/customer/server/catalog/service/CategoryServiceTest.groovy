package io.reactivesw.customer.server.catalog.service

import io.reactivesw.customer.server.catalog.entities.CategoryEntity
import io.reactivesw.customer.server.catalog.models.Category
import io.reactivesw.customer.server.catalog.repositories.CategoryRepository
import io.reactivesw.customer.server.catalog.services.CategoryService
import spock.lang.Specification

/**
 * Created by Davis on 16/11/15.
 */
class CategoryServiceTest extends Specification {
    CategoryRepository categoryRepository = Mock()
    CategoryService categoryService = new CategoryService(categoryRepository: categoryRepository)
    def category = new Category()
    def categories = new ArrayList()
    def name = "computer"
    def description = "this is computer category"
    def parentId = 1
    def categoryEntity = new CategoryEntity()

    def "test 1 : new a Category and save it"() {
        given:
        categoryRepository.save(_) >> categoryEntity

        when:
        def savedCategory = categoryService.saveCategory(category)

        then:
        savedCategory != null
        savedCategory.name == category.name
        savedCategory.description == category.name
    }

    def "test 2 : new a subCategory and save it"() {
        given:
        category.parentId = parentId
        categoryRepository.save(_) >> categoryEntity

        when:
        def savedCategory = categoryService.saveCategory(category)

        then:
        savedCategory != null
    }

    def "test 3 : delete category by id"() {
        given:
        def id = 1

        when:
        categoryService.deleteCategoryById(id)

        then:
        true
    }

    def "test 4 : find category by id"() {
        given:
        def id = 1
        categoryRepository.findOne(_) >> categoryEntity

        when:
        def result = categoryService.findCategoryById(id)

        then:
        result != null
    }

    def "test 5 : find category by id and get null category"() {
        given:
        def id = 1
        categoryRepository.findOne(_) >> null

        when:
        def result = categoryService.findCategoryById(id)

        then:
        result != null
    }

    def "test 6 : find all categories"() {
        given:
        categoryRepository.findAll() >> categories

        when:
        def result = categoryService.findAllCategories()

        then:
        result != null
    }

    def "test 7 : update category"() {
        given:
        def id = 1
        categoryRepository.save(_) >> categoryEntity

        when:
        def result = categoryService.updateCategory(id, category)

        then:
        result != null
    }
}
