package server;

import io.restassured.specification.RequestSpecification;
import stubs.Stub;
import utility.JsonUtils;

import static io.restassured.RestAssured.given;

public class WireMockManager {

    public static void createNewStubMapping(Stub stub) {
        base()
                .when()
                .body(JsonUtils.serialize(stub))
                .post("/__admin/mappings/new")
                .then()
                .statusCode(201);
    }

    private static RequestSpecification base() {
        return given()
                .log()
                .all()
                .baseUri("http://localhost")
                .port(8089);
    }
}
