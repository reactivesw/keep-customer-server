package io.reactivesw.project.domain.service

import io.reactivesw.project.domain.entity.CurrencyValue
import io.reactivesw.project.domain.entity.InternationalEntity
import io.reactivesw.project.infrastructure.repository.InternationalRepository
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/5.
 */
class InternationalServiceTest extends Specification {

    InternationalRepository repository = Mock(InternationalRepository)

    InternationalService service

    CurrencyValue currencyValue

    InternationalEntity internationalEntity

    def setup() {
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
}
