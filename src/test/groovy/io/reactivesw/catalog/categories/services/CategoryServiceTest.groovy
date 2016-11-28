package io.reactivesw.catalog.categories.services

import io.reactivesw.catalog.categories.entities.CategoryEntity
import io.reactivesw.catalog.categories.repositories.CategoryRepository
import io.reactivesw.common.exceptions.NotExistException
import spock.lang.Specification

/**
 * Created by Davis on 16/11/28.
 */
class CategoryServiceTest extends Specification {
    CategoryRepository categoryRepository = Mock();
    CategoryService categoryService = new CategoryService(categoryRepository: categoryRepository);
    def categoryEntity = new CategoryEntity()
    def id = "11111111"

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
}
