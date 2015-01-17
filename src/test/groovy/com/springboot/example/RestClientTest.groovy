package com.springboot.example

import com.springboot.example.domain.User
import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.bson.types.ObjectId
import spock.lang.Ignore
import spock.lang.Specification


//@IntegrationTest
//@ContextConfiguration(loader = SpringApplicationContextLoader, classes = Application)
//@WebAppConfiguration

class RestClientTest extends Specification {

    RESTClient restClient = new RESTClient('http://localhost:8080')

    @Ignore
    def "add user"() {

        User user = new User(name: "Test", id: new ObjectId())
        when:
        def response = restClient.post(path: '/user/', body: user, requestContentType: ContentType.JSON)

        then:
        response != null
        response.data.id == user.getId();
    }
}
