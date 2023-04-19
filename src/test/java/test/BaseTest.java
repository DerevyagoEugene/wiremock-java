package test;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import server.WireMockServer;

import static io.restassured.RestAssured.given;

public class BaseTest extends Hooks {

    @BeforeSuite
    public void startServer() {
        WireMockServer.start(8089);
    }

    @AfterSuite
    public void stopServer() {
        WireMockServer.stop();
    }

    protected RequestSpecification base() {
        return given().baseUri("http://localhost:8089").when();
    }
}
