package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {

    @Test
    void testHelloEndpoint() {
        String authClientId = System.getenv("AUTH_CLIENT_SECRET");
        System.out.println("AUTH_CLIENT_SECRET: " + authClientId); // Print the value

        if(!authClientId.equals("HELLO")){
            throw new RuntimeException();
        }
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}