package tech.donau.course;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.Header;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matchers;
import tech.donau.course.config.RedisConfiguration;

import javax.inject.Inject;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(Matchers.startsWith("ID:"));
    }

    @Test
    void testAdd() {
        given()
                .when()
                .headers(Map.of("Content-Type", "application/json", "Accept", "application/json", "token", "Bearer 123"))
                .post("/hello?name=bota").then().statusCode(200).body("name", equalTo("bota"));
    }
}