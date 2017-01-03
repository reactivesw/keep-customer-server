package io.reactivesw.catalog.taxcategory

import com.google.common.collect.Lists
import io.reactivesw.catalog.taxcategory.application.model.SubRate
import io.reactivesw.catalog.taxcategory.application.model.TaxCategoryDraft
import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft

import io.reactivesw.catalog.taxcategory.application.model.mapper.TaxCategoryMapper
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity
import io.reactivesw.catalog.taxcategory.domain.service.TaxCategoryService
import io.reactivesw.catalog.taxcategory.domain.service.update.TaxCategoryUpdateService
import io.reactivesw.catalog.taxcategory.infrastructure.repository.TaxCategoryRepository
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.model.QueryConditions
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.common.model.action.SetName
import spock.lang.Specification

/**
 * Created by Davis on 16/12/10.
 */
class TaxCategoryServiceTest extends Specification {

    TaxCategoryUpdateService updateService = Mock()
    TaxCategoryRepository taxCategoryRepository = Mock()
    def taxCategoryService = new TaxCategoryService(taxCategoryRepository: taxCategoryRepository,
            updateService: updateService)
    def taxCategory = new TaxCategoryEntity()
    def taxCategoryDraft = new TaxCategoryDraft()

    def setup() {

        TaxRateDraft taxRate1 = new TaxRateDraft()
        taxRate1.name = "taxRate1"
        taxRate1.country = "US"
        taxRate1.state = "NY"
        taxRate1.amount = 0.02
        taxRate1.includedInPrice = false

        SubRate subRate1 = new SubRate(name: "subRate1", amount: 0.008)
        SubRate subRate2 = new SubRate(name: "subRate2", amount: 0.012)
        List<SubRate> subRates = Lists.newArrayList(subRate1, subRate2)
        taxRate1.subRates = subRates

        TaxRateDraft taxRate2 = new TaxRateDraft()
        taxRate2.name = "taxRate2"
        taxRate2.country = "US"
        taxRate2.state = "NY"
        taxRate2.amount = 0.03
        taxRate2.includedInPrice = true

        SubRate subRate21 = new SubRate(name: "subRate21", amount: 0.01)
        SubRate subRate22 = new SubRate(name: "subRate22", amount: 0.02)
        List<SubRate> subRates2 = Lists.newArrayList(subRate21, subRate22)
        taxRate2.subRates = subRates2

        List<TaxRateDraft> taxRates = Lists.newArrayList(taxRate1, taxRate2)

        taxCategoryDraft.name = "tax"
        taxCategoryDraft.description = "tax category description"
        taxCategoryDraft.rates = taxRates
    }

    def "test 1.1 : create TaxCategory"() {
        given:
        taxCategory = TaxCategoryMapper.modelToEntity(taxCategoryDraft)
        taxCategoryRepository.save(_) >> taxCategory

        when:
        def result = taxCategoryService.createTaxCategory(taxCategoryDraft)

        then:
        result != null
    }

    def "test 2.1 : delete TaxCategory"() {
        given:
        def id = "314334"
        def version = 1
        taxCategory = TaxCategoryMapper.modelToEntity(taxCategoryDraft)
        taxCategory.version = version
        taxCategoryRepository.findOne(_) >> taxCategory

        when:
        taxCategoryService.deleteTaxCategory(id, version)

        then:
        true
    }

    def "test 2.2 : delete TaxCategory and version not match"() {
        given:
        def id = "314334"
        def version = 0
        taxCategory = TaxCategoryMapper.modelToEntity(taxCategoryDraft)
        taxCategoryRepository.findOne(_) >> taxCategory

        when:
        taxCategoryService.deleteTaxCategory(id, version)

        then:
        thrown(ConflictException)
    }

    def "test 3.1 : update TaxCategory and set new name"() {
        given:
        def id = "111111"
        def version = 1
        taxCategory = TaxCategoryMapper.modelToEntity(taxCategoryDraft)
        taxCategory.id = id
        taxCategory.version = version
        taxCategoryRepository.findOne(_) >> taxCategory
        taxCategoryRepository.save(taxCategory) >> taxCategory
        updateService.handle(_,_) >> null

        def actions = new ArrayList<UpdateAction>()
        def setName = new SetName()
        setName.name = "new Tax"
        actions.add(setName)

        when:
        def result = taxCategoryService.updateTaxCategory(id, version, actions)

        then:
        result != null
    }

    def "test 4.1 : get TaxCategory by Id"() {
        given:
        def id = "314334"
        taxCategory = TaxCategoryMapper.modelToEntity(taxCategoryDraft)
        taxCategoryRepository.findOne(_) >> taxCategory

        when:
        def result = taxCategoryService.getTaxCategoryById(id)

        then:
        result != null
        result.id == taxCategory.id
        result.name == taxCategory.name
    }

    def "test 4.2 : get TaxCategory by Id and get null TaxCategoryEntity"() {
        given:
        def id = "314334"
        taxCategoryRepository.findOne(_) >> null

        when:
        def result = taxCategoryService.getTaxCategoryById(id)

        then:
        thrown(NotExistException)

    }

    def "test 5.1 : query TaxCategory"() {
        given:
        List<TaxCategoryEntity> taxCategoryEntities = Lists.newArrayList(TaxCategoryMapper.modelToEntity(taxCategoryDraft))
        taxCategoryRepository.findAll() >> taxCategoryEntities
        QueryConditions queryConditions = new QueryConditions()


        when:
        def result = taxCategoryService.queryTaxCategories(queryConditions)

        then:
        result != null
        result.results.size() == taxCategoryEntities.size()
    }
}
