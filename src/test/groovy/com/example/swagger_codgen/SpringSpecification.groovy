//package com.example.swagger_codgen
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.web.client.TestRestTemplate
//import org.springframework.core.ParameterizedTypeReference
//import org.springframework.http.HttpEntity
//import org.springframework.http.HttpHeaders
//import org.springframework.http.HttpMethod
//import org.springframework.http.ResponseEntity
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.util.Base64Utils
//import org.springframework.util.LinkedMultiValueMap
//import org.springframework.util.MultiValueMap
//import spock.lang.Specification
//import static org.springframework.http.HttpMethod.*
//import static com.example.swagger_codgen.AditionalTestUserConfig.TEST_USER_1
//
//import java.nio.charset.Charset
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles('test')
//class SpringSpecification extends Specification {
//
//  @Autowired
//  protected TestRestTemplate restTemplate
//
//  def GET(String path) {
//    query(GET,path, TEST_USER_1, null)
//  }
//
//  def POST(String path) {
//    query(HttpMethod.POST, path, com.x2iq.sbb.AdditionalTestUserConfig.TEST_USER_1, null)
//  }
//
////  def POST(Map params, String path) {
////
////    TestUser user = params.user ?: com.x2iq.sbb.AdditionalTestUserConfig.TEST_USER_1
////
////    query(HttpMethod.POST, path, user, params.body)
////  }
//
//  def PUT(String path) {
//    query(HttpMethod.PUT, path, com.x2iq.sbb.AdditionalTestUserConfig.TEST_USER_1, null)
//  }
//
////  def PUT(Map params, String path) {
////
////    TestUser user = params.user ?: com.x2iq.sbb.AdditionalTestUserConfig.TEST_USER_1
////
////    query(HttpMethod.PUT, path, user, params.body)
////  }
//
//  def DELETE(String path) {
//    query(HttpMethod.DELETE, path, com.x2iq.sbb.AdditionalTestUserConfig.TEST_USER_1, null)
//  }
//
////  def query(HttpMethod httpMethod, String path, TestUser user, Object body) {
////    def request = [
////        typeRef    : new ParameterizedTypeReference<Object>() {},
////        relativeUrl: path,
////        httpMethod : httpMethod,
////        requestBody: body
////    ]
////
////    query(user, request)
////  }
//
//    ResponseEntity query(TestUser testUser, Map allParams) {
//    allParams = (Map) allParams.clone() // be nice to the outside world..
//        ParameterizedTypeReference typeRef = (ParameterizedTypeReference) allParams.remove("typeRef")
//    String relativeUrl = allParams.remove("relativeUrl") ?: ""
//        HttpMethod httpMethod = (HttpMethod) allParams.remove("httpMethod")
//    Object requestBody = allParams.remove("requestBody")
//    def requestHeaders = new HttpHeaders()
//
//    String token = Base64Utils.encodeToString((testUser.user + ":" + testUser.password).getBytes(Charset.forName("UTF-8")));
//    requestHeaders.set("Authorization", "Basic " + token)
//    requestHeaders.set("Accept-Language", "de")
//    requestHeaders.set("Content-Type", "application/json")
//    def passedData
//    if (requestBody) {
//      passedData = requestBody
//      assert allParams.isEmpty(), "cant combine parameters with requestBody, use pathVars instead!"
//    } else {
//      passedData = new LinkedMultiValueMap<String, String>()
//      allParams.each { k, v -> passedData.set(k, v) }
//    }
//
//    def requestEntity = new HttpEntity<MultiValueMap<String, String>>(passedData, requestHeaders)
//    def pathVars = allParams.findAll { it.key.startsWith("pathVar_") }.collect { it.value }
//
//    restTemplate.exchange(relativeUrl, httpMethod, requestEntity, typeRef)
//  }
//
//}
