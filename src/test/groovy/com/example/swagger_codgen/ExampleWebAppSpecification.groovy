package com.example.swagger_codgen

import com.example.swagger_codgen.model.Employee
import groovyx.net.http.RESTClient
import groovyx.net.http.Status
import spock.lang.Specification



class ExampleWebAppSpecification extends Specification {
    def primerEndpoint = new RESTClient('http://localhost:8080')
      Employee employee = new Employee()

   public static int userid;


    def 'create Test'() {
        when:
        def response = primerEndpoint.post(
                path: '/update-employeedetails',
                body: [
                        "firstName" : "another",
                        "lastName": "record"

                ],
                requestContentType: 'application/json'
        )

        def  CreatedUserid=  response.responseData.body
        userid = (Integer) CreatedUserid;

        then: 'server returns 201 code (created)'
        with(response) {
            Status.SUCCESS
        }
    }

        def "update-Employee"() {
        setup:
        employee.setFirstName("updated")
        employee.setLastName("RE")
        when:
        def response = primerEndpoint.put(
                path: '/update-employeedetails',
                body: employee,
                query : [ id : userid ],
                requestContentType: 'application/json'
        )
        then:
        with(response) {
            Status.SUCCESS
        }
    }

    def 'Read Test'() {
        when:
        def resp = primerEndpoint.get(path: '/employee-details')
        then:
        with(resp) {
            Status.SUCCESS

        }
    }


    def 'Delete testing'() {
        when:
        def resp = primerEndpoint.delete( path: '/delete-employee', query : [ id : userid ])
        then:
        with(resp) {
            Status.SUCCESS
        }
    }





}
