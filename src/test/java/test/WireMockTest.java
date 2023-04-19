package test;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;

public class WireMockTest extends BaseTest {

    @Test
    public void testMock() {
        var body = base()
                .get("/plaintext/mapping1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .asString();
        assertFalse(body.isEmpty());
    }

    @Test
    public void testMock2() {
        base()
                .get("/jsontext/mapping2?testqueryparam=*")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Anton"));
    }
}
