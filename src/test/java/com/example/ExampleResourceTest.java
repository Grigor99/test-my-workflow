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
    @ConfigProperty(name = "auth.client.secret")
    String authClientSecret;
    @Inject
    @ConfigProperty(name = "AUTH_ID")
    String AUTH_ID;


    @Test
    void testHelloEndpoint() {
//        String authClientSecret = System.getenv("AUTH_CLIENT_SECRET");
        if (AUTH_ID.equals("11")) {
            System.out.println("GGGGGGG");
        }


        if (authClientSecret.equals("HELLO")) {//threw an error so indeed HELLO got picked
            System.out.println("HHHHHHHHHH");
        }
        if (authClientSecret.equals("TTTTTTT")) {//threw an error so indeed HELLO got picked
            System.out.println("TTTTTT");
        }
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus REST"));
    }

}