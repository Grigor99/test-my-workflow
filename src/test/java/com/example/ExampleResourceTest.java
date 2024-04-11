package com.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {

    @Inject
    @ConfigProperty(name = "AUTH_CLIENT_SECRET")
    String authClientSecret;

    @Test
    void testHelloEndpoint() {
//        String authClientSecret = System.getenv("AUTH_CLIENT_SECRET");
        System.out.println("AUTH_CLIENT_SECRET: " + authClientSecret); // Print the value

        if(authClientSecret.equals("TTTTTTT")){
            throw new RuntimeException();
        }
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}