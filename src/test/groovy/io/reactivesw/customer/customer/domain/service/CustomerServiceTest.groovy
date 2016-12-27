package io.reactivesw.customer.customer.domain.service

import io.reactivesw.common.exception.AlreadyExistException
import io.reactivesw.common.exception.ConflictException
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.exception.PasswordErrorException
import io.reactivesw.customer.customer.domain.entity.CustomerEntity
import io.reactivesw.customer.customer.infrastructure.repository.CustomerRepository
import io.reactivesw.customer.customer.infrastructure.util.PasswordUtil
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/27.
 */
class CustomerServiceTest extends Specification {

    CustomerRepository repository = Mock(CustomerRepository)

    CustomerService service


    CustomerEntity entity

    def customerId = "tmpCustomerId"

    def version = 1

    def customerName = "tmpCustomerName"

    def email = "test@test.com"

    def password = "tmpPassword"

    def hashedPassword = PasswordUtil.hashPassword(password)

    def setup() {
        service = new CustomerService(customerRepository: repository)

        entity = new CustomerEntity(id: customerId, version: version, customerName: customerName, email: email, password: hashedPassword)
    }

    def "Test 1.1: Get by id"() {

        when:
        repository.findOne(_) >> entity
        service.getById(customerId)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Get by id that not exist"() {

        when:
        repository.findOne(_) >> null
        service.getById(customerId)
        then:
        thrown(NotExistException)
    }

    def "Test 2.1: Get by customer name"() {

        when:
        repository.findOneByCustomerName(_) >> entity
        service.getByCustomerName(customerName)
        then:
        noExceptionThrown()
    }

    def "Test 2.2: Get by customer name that not exist"() {

        when:
        repository.findOneByCustomerName(_) >> null
        service.getByCustomerName(customerName)
        then:
        thrown(NotExistException)
    }

    def "Test 3.1: Get by customer email"() {

        when:
        repository.findOneByEmail(_) >> entity
        service.getByEmail(email)
        then:
        noExceptionThrown()
    }

    def "Test 3.2: Get by customer email that not exist"() {

        when:
        repository.findOneByEmail(_) >> null
        service.getByEmail(email)
        then:
        thrown(NotExistException)
    }

    def "Test 4.1: create with correct info"() {

        when:
        repository.findOneByCustomerName(_) >> null
        repository.findOneByEmail(_) >> null

        service.create(entity)
        then:
        noExceptionThrown()
    }

    def "Test 4.2: create with customer name already exist"() {

        when:
        repository.findOneByCustomerName(_) >> entity
        repository.findOneByEmail(_) >> null

        service.create(entity)
        then:
        thrown(AlreadyExistException)
    }

    def "Test 4.3: create with customer email already exist"() {

        when:
        repository.findOneByCustomerName(_) >> null
        repository.findOneByEmail(_) >> entity

        service.create(entity)
        then:
        thrown(AlreadyExistException)
    }

    def "Test 5.1: sign in with correct info"() {

        when:
        repository.findOneByEmail(_) >> entity

        service.signIn(email, password)
        then:
        noExceptionThrown()
    }

    def "Test 5.2: sign in with wrong password"() {
        def fakePassword = "fakePassword"
        when:
        repository.findOneByEmail(_) >> entity

        service.signIn(email, fakePassword)
        then:
        thrown(PasswordErrorException)
    }

    def "Test 6.1: change password"() {
        def newPassword = "newPassword"
        when:
        repository.findOne(_) >> entity
        service.changePassword(customerId, version, password, newPassword)
        then:
        noExceptionThrown()
    }

    def "Test 6.2: change password with wrong version"() {
        def newPassword = "newPassword"
        when:
        repository.findOne(_) >> entity
        service.changePassword(customerId, version + 1, password, newPassword)
        then:
        thrown(ConflictException)
    }

    def "Test 7.1: create reset token"() {
        when:
        service.createResetToken(email)
        then:
        noExceptionThrown()
    }

    def "Test 8.1: reset password"() {
        def newPassword = "newPassword"
        def token = "token"
        when:
        service.resetPassword(token, newPassword, version)
        then:
        noExceptionThrown()
    }

    def "Test 9.1: create verify email token"() {

        when:
        service.createVerifyEmailToken(email, version)
        then:
        noExceptionThrown()
    }

    def "Test 10.1: verify email"() {
        def token = "token"
        when:
        service.verifyEmail(token, version)
        then:
        noExceptionThrown()
    }

    def "Test 11.1: delete customer"() {

        when:
        repository.findOne(_) >> entity
        service.deleteCustomer(customerId, version)
        then:
        noExceptionThrown()
    }


}
