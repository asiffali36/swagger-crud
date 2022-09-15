package com.example.swagger_codgen

import groovyx.net.http.RESTClient
import groovyx.net.http.Status
import spock.lang.Specification



class ExampleWebAppSpecification extends Specification {
    def primerEndpoint = new RESTClient('http://localhost:8080')
    int userid;

    def 'create Test'() {
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

        def  id=  response.responseData.body
        int userid = (Integer) id;

        with(response) {

            Status.SUCCESS
        }

    }

    def 'Read Test'() {
        when: 'Checking credentials before getting data'
        def resp = primerEndpoint.get(path: '/employee-details')
        then:
        with(resp) {
            Status.SUCCESS

        }
    }
    def 'Update Test'() {

        when: 'try to save record with all required fields'
        def response = primerEndpoint.put(
                path: '/update-employeedetails',
                body: [
                        "firstName" : "updated",
                        "lastName": "record"

                ],
                query : [ id : userid ],
                requestContentType: 'application/json'
        )

        then: 'server returns 204 code (updated)'
        with(response) {
            Status.SUCCESS
        }

    }
    def 'Delete testing'() {
        when: 'Checking credentials before getting data'
        def resp = primerEndpoint.delete( path: '/delete-employee', query : [ id : userid ])
        then:
        with(resp) {
            Status.SUCCESS
        }
    }



}
