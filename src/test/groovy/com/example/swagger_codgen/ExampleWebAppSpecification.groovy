package com.example.swagger_codgen
import groovyx.net.http.RESTClient
import groovyx.net.http.Status
import spock.lang.Specification



class ExampleWebAppSpecification extends Specification {
    def primerEndpoint = new RESTClient('http://localhost:8080')


    def 'should return 201 code (created) when trying to save record with all required fields'() {
        when: 'try to save record with all required fields'
        def response = primerEndpoint.post(
                path: '/update-employeedetails',
                body: [
                           "firstName" : "another",
                           "lastName": "record"

                ],
                requestContentType: 'application/json'
        )

        then: 'server returns 201 code (created)'
       // println (response.toString())
        with(response) {
            Status.SUCCESS
        }

    }

    def 'Should return 200 & a message with the input appended'() {
        when: 'Checking credentials before getting data'
        def resp = primerEndpoint.get(path: '/employee-details')
        then:
        with(resp) {
            Status.SUCCESS
        }
    }



}
