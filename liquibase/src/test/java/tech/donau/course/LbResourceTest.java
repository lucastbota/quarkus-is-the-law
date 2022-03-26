package tech.donau.course;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LbResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/liquibase")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}