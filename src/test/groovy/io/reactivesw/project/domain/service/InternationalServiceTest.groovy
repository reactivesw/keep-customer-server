package io.reactivesw.project.domain.service

import com.google.common.collect.Lists
import io.reactivesw.common.exception.AlreadyExistException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.project.application.model.Currency
import io.reactivesw.project.domain.entity.CurrencyValue
import io.reactivesw.project.domain.entity.InternationalEntity
import io.reactivesw.project.infrastructure.repository.InternationalRepository
import org.springframework.stereotype.Service
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/5.
 */
class InternationalServiceTest extends Specification {

    InternationalRepository repository = Mock(InternationalRepository)

    InternationalService service

    CurrencyValue currencyValue

    InternationalEntity internationalEntity

    Currency currency = new Currency()

    def setup() {

        currency.currencyCode = "USD"
        currency.name = "us dollar"
        currency.conversionFactor = "100"


        service = new InternationalService(repository: repository)

        currencyValue = new CurrencyValue(currencyCode: "USD")

        internationalEntity = new InternationalEntity(defaultCurrency: currencyValue)
    }

    def "Test 1.1: get default currency"() {
        List<InternationalEntity> entities = new ArrayList<>()
        entities.add(internationalEntity)
        when:
        repository.findAll() >> entities
        service.getDefaultCurrency()
        then:
        noExceptionThrown()
    }

    def "Test 1.2: get default currency with defualt not exist"() {
        List<InternationalEntity> entities = new ArrayList<>()
        entities.add(internationalEntity)
        internationalEntity.setDefaultCurrency(null)
        when:
        repository.findAll() >> entities
        service.getDefaultCurrency()
        then:
        noExceptionThrown()
    }

    def "Test 1.3 : get default currency and find null internation"() {
        given:
        repository.findAll() >> null

        when:
        service.getDefaultCurrency()

        then:
        thrown(NotExistException)
    }

    def "test 1.4 : get default currency and find empty internation"() {
        given:
        repository.findAll() >> new ArrayList<InternationalEntity>()

        when:
        service.getDefaultCurrency()

        then:
        thrown(NotExistException)
    }


    def "test 2.1 : create default currency"() {
        given:
        repository.findAll() >> null
        repository.save(_) >> internationalEntity

        when:
        def result = service.createDefaultCurrency(currency)

        then:
        result != null
    }

    def "test 2.2 : create default currency and find internaion"() {
        given:
        repository.findAll() >> Lists.newArrayList(internationalEntity)

        when:
        service.createDefaultCurrency(currency)

        then:
        thrown(AlreadyExistException)
    }

    def "test 3.1 : add currency"() {
        given:
        repository.findAll() >> Lists.newArrayList(internationalEntity)
        repository.save(_) >> internationalEntity

        when:
        def result = service.addCurrency(currency)

        then:
        result != null
    }
}
