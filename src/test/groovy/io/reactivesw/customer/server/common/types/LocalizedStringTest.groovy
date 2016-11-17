package io.reactivesw.customer.server.common.types

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

/**
 * Created by Davis on 16/11/16.
 */
class LocalizedStringTest extends Specification{
    def "test 1 : add and update key value"() {
        given:
        def l = new LocalizedString()
        ObjectMapper objectMapper = new ObjectMapper();

        when:
        l.addKeyValue("en", "shoe")
        l.addKeyValue("cn", "鞋子")
        l.addKeyValue("de", "husng")
        l.addKeyValue("cn", "老鞋子")

//        def resutl = l.getLocalizedString()
        def string = objectMapper.writeValueAsString(l);

        def map = objectMapper.readValue(string, Map.class);

        then:
        string != null
//        resutl != null
        l != null
        !l.getLocalized().isEmpty()
        map != null
        println(string)
    }

//    def "test 2 : json string to object"() {
//        given:
//    }
}
