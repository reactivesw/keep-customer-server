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
class LoginApplicationTest extends Specification {

    LoginApplication loginService

    RestClient loginRestClient = Mock(RestClient)

    JwtUtil jwtUtil

    Customer customer

    def email = "test@test.com"

    def password = "password"

    def hashedPassword = PasswordUtil.hashPassword(password)

    def gToken = "tmpGoogleToken"

    def setup() {
        customer = new Customer(password: hashedPassword, email: email)
        jwtUtil = new JwtUtil(secret: "QWERTYUIOPASDGHJKLZXCVBNM",expiresIn: 7200000)
        loginService = new LoginApplication(restClient: loginRestClient, jwtUtil: jwtUtil)

    }

    def "Test 1.1: login with email and password"() {
        when:
        loginRestClient.getCustomerByEmail(_) >> customer
        LoginResult result = loginService.loginWithEmail(email, password)
        then:
        result.getCustomer() == customer
        noExceptionThrown()
    }

    def "Test 1.2: login with email and password that not exist"() {
        when:
        loginRestClient.getCustomerByEmail(_) >> null
        loginService.loginWithEmail(email, password)
        then:
        thrown(NotExistException)
    }

    def "Test 1.3: login with email and password that password not correct"() {
        def fakePassword = "fakePassword"
        when:
        loginRestClient.getCustomerByEmail(_) >> customer
        loginService.loginWithEmail(email, fakePassword)
        then:
        thrown(PasswordErrorException)
    }

    def "Test 2.1: login with google "() {
        when:
        loginRestClient.getCustomerByGoogleToken(_) >> customer
        LoginResult result = loginService.loginWithGoogle(gToken)
        then:
        result.getCustomer() == customer
        noExceptionThrown()
    }

    def "Test 2.2: login with google that token is not correct"() {
        when:
        loginRestClient.getCustomerByGoogleToken(_) >> null
        loginService.loginWithGoogle(gToken)
        then:
        thrown(NotExistException)
    }
}
