package io.reactivesw.project.domain.service

import com.google.common.collect.Lists
import io.reactivesw.common.model.UpdateAction
import io.reactivesw.project.application.model.Currency
import io.reactivesw.project.application.model.action.SetDefaultCurrencyAction
import io.reactivesw.project.domain.entity.CurrencyValue
import io.reactivesw.project.domain.entity.InternationalEntity
import io.reactivesw.project.domain.service.update.InternationalUpdateService
import io.reactivesw.project.infrastructure.repository.InternationalRepository
import org.springframework.stereotype.Service
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/5.
 */
class InternationalServiceTest extends Specification {

    InternationalRepository repository = Mock()

    InternationalUpdateService updateService = Mock()

    InternationalService service = new InternationalService(repository: repository,updateService: updateService)

    CurrencyValue currencyValue

    InternationalEntity internationalEntity

    Currency currency = new Currency()

    def setup() {

        currency.currencyCode = "USD"
        currency.name = "us dollar"
        currency.conversionFactor = "100"

        currencyValue = new CurrencyValue(currencyCode: "USD")

        internationalEntity = new InternationalEntity(defaultCurrency: currencyValue,
                supportedCurrency: Lists.newArrayList(currencyValue))
    }

    def "test 1.1 : get international"() {
        given:
        repository.findAll() >> Lists.newArrayList(internationalEntity)

        when:
        def result = service.getInternational()

        then:
        result != null
    }

    def "test 1.2 : get international and get null list"() {
        given:
        repository.findAll() >> null
        repository.save(_) >> new InternationalEntity(id: "lskdjfsjdhfksdfsdfsjdhfoiy")

        when:
        def result = service.getInternational()

        then:
        result != null
    }

    def "test 1.3 : get international and get empty list"() {
        given:
        repository.findAll() >> new ArrayList<InternationalEntity>()
        repository.save(_) >> new InternationalEntity(id: "lskdjfsjdhfksdfsdfsjdhfoiy")

        when:
        def result = service.getInternational()

        then:
        result != null
    }

    def "test 2.1 : update international"() {
        given:
        repository.findAll() >> Lists.newArrayList(new InternationalEntity())

        SetDefaultCurrencyAction action = new SetDefaultCurrencyAction()
        action.setCurrencyCode("USD")
        List<UpdateAction> actions = Lists.newArrayList(action)

        updateService.handle(_, _) >> null

        repository.save(_) >> internationalEntity

        when:
        def result = service.updateInternational(actions)

        then:
        result != null
    }
}
