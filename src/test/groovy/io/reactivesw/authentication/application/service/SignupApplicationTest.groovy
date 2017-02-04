package io.reactivesw.authentication.application.service

import io.reactivesw.authentication.application.model.LoginResult
import io.reactivesw.authentication.infrastructure.util.JwtUtil
import io.reactivesw.common.exception.NotExistException
import io.reactivesw.common.exception.PasswordErrorException
import io.reactivesw.customer.customer.application.model.Customer
import io.reactivesw.customer.customer.infrastructure.util.PasswordUtil
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/21.
 */
class SignupApplicationTest extends Specification {

    SignupApplication signupApplication

    RestClient restClient = Mock(RestClient)

    JwtUtil jwtUtil = Mock(JwtUtil)

    Customer customer

    def email = "test@test.com"

    def password = "password"

    def hashedPassword = PasswordUtil.hashPassword(password)

    def gToken = "tmpGoogleToken"


    def setup() {
        customer = new Customer(password: hashedPassword, email: email)
        signupApplication = new SignupApplication(restClient: restClient, jwtUtil: jwtUtil)

    }

    def "Test 1.1: login with email and password"() {
        when:
        restClient.createCustomerByEmail(_, _) >> customer
        LoginResult result = signupApplication.signupWithEmail(email, password)
        then:
        result.getCustomer() == customer
        noExceptionThrown()
    }

}
