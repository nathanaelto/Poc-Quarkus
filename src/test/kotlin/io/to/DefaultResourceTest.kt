package io.to

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class DefaultResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/welcome")
            .then()
            .statusCode(200)
            .body(`is`("Welcome to Quarkus Kotlin POC by !"))
    }

}