package io.reactivesw.customer.customer.application.service

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.json.jackson2.JacksonFactory
import io.reactivesw.common.exception.ParametersException
import io.reactivesw.customer.customer.application.model.Customer
import io.reactivesw.customer.customer.domain.entity.CustomerEntity
import io.reactivesw.customer.customer.domain.service.CustomerService
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/10.
 */
class CustomerApplicationTest extends Specification {

    CustomerApplication customerApplication

    CustomerService customerService = Mock(CustomerService)

    GoogleIdTokenVerifier verifier = Mock(GoogleIdTokenVerifier)

    GoogleIdToken idToken

    GoogleIdToken.Payload payload

    JacksonFactory JSON_FACTORY = new JacksonFactory();

    String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjhmMjQ1NGVhODg3NDRkMWY1MjgxYmE3MTc5ZDhkY2Q3NDNkMDg1NzIifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiaWF0IjoxNDg0MDE3MTE2LCJleHAiOjE0ODQwMjA3MTYsImF0X2hhc2giOiJLOXNkbXFOQkNmaUxKeEdlbWhTZzZnIiwiYXVkIjoiMTMxNTY0MTg0MzIxLThvN2QycnRtYW5zcjIydjdobHVidmprcW1xZ2tkMDhoLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTE1NjA1NjM4NjkwMzczNjI5ODkzIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF6cCI6IjEzMTU2NDE4NDMyMS04bzdkMnJ0bWFuc3IyMnY3aGx1YnZqa3FtcWdrZDA4aC5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsImVtYWlsIjoibGl1cXVhbjg5QGdtYWlsLmNvbSIsIm5hbWUiOiJMaXUgUXVhbiIsInBpY3R1cmUiOiJodHRwczovL2xoNS5nb29nbGV1c2VyY29udGVudC5jb20vLV9ORmV3cjdlSWtJL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FLQl9VOHQ1bkd5cnZIRENyeGdqeXVRUldLUTJ2N0tSeWcvczk2LWMvcGhvdG8uanBnIiwiZ2l2ZW5fbmFtZSI6IkxpdSIsImZhbWlseV9uYW1lIjoiUXVhbiIsImxvY2FsZSI6ImVuIn0.mHkKfLLLIYEP4d84gERdq2uw28ivu_eL_trUG65eEu-78qM5HqsfXuww-rIPUYpM8vsY_55p1pwo7hMk7b3i1QBd9kPW6yA0JhS1E7yTtVpewpVv0fakynGJdx9V_BK50xDOVNlBbN7P-Pfth1bt-lPlaIXuXsz3sfqat3eS-4ih2Ws-VojaKEM4nr7YJ1mBdUa-D8YED7s5Di1eWcNKl155gFI3RP8isHyK_M6_nBKC5lMmwoehnFpNn1lWRxX64vzTgDHHj1Rp3Nz1rvZ2dMp61ZTmKk8OXkx76araiuWmAql_jZfEry2Aaps_i3O8BLyilLdB8OqMhpASkkYi-Q"

    CustomerEntity customerEntity

    def setup() {
        customerApplication = new CustomerApplication(verifier: verifier, customerService: customerService)

        idToken = GoogleIdToken.parse(JSON_FACTORY, token)
        payload = idToken.getPayload()

        customerEntity = new CustomerEntity(email: payload.getEmail(), externalId: payload.getSubject())
    }

    def "Test 1.1: Login with google token and  Create Customer with external info."() {
        when:
        verifier.verify(_) >> idToken
        customerService.getByExternalId(_) >> null
        customerService.createWithExternal(_) >> customerEntity
        Customer customer = customerApplication.getOrCreateWithGoogleToken(token)
        then:
        customer.getExternalId() == payload.getSubject()
        noExceptionThrown()
    }

    def "Test 1.2: Login with google token and token verify failed"() {
        when:
        verifier.verify(_) >> null
        customerApplication.getOrCreateWithGoogleToken(token)
        then:
        thrown(ParametersException)
    }

    def "Test 1.3: Login with google token and customer had signined before"() {
        when:
        verifier.verify(_) >> idToken
        customerService.getByExternalId(_) >> customerEntity
        customerService.createWithExternal(_) >> customerEntity
        Customer customer = customerApplication.getOrCreateWithGoogleToken(token)
        then:
        customer.getExternalId() == payload.getSubject()
        noExceptionThrown()
    }
}
