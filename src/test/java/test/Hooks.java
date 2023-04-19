package test;

import org.testng.annotations.BeforeTest;
import server.WireMockManager;
import stubs.*;
import utility.StringUtils;

import java.util.HashMap;

import static org.eclipse.jetty.http.HttpMethod.GET;
public class Hooks {

    @BeforeTest
    public void setupPlaintextMapping1() {
        var headers = Headers
                .builder()
                .contentType("text/plain")
                .build();

        var request = Request
                .builder()
                .urlPathPattern("/plaintext/mapping1")
                .method(GET.asString())
                .build();

        var response = Response
                .builder()
                .body(StringUtils.randomString(100))
                .headers(headers)
                .status(200)
                .build();

        var stub = Stub
                .builder()
                .request(request)
                .response(response)
                .build();

        WireMockManager.createNewStubMapping(stub);
    }

    @BeforeTest
    public void setupJsontextMapping2() {
        var headers = Headers
                .builder()
                .contentType("application/json")
                .build();

        var equalTo = new HashMap<String, String>() {{
           put("equalTo", "*");
        }};

        var testQueryParam = new HashMap<String, Object>() {{
            put("testqueryparam", equalTo);
        }};

        var request = Request
                .builder()
                .urlPathPattern("/jsontext/mapping2")
                .queryParameters(testQueryParam)
                .method(GET.asString())
                .build();

        var response = Response
                .builder()
                .body("{\"name\": \"Anton\"}")
                .headers(headers)
                .status(200)
                .build();

        var stub = Stub
                .builder()
                .request(request)
                .response(response)
                .build();

        WireMockManager.createNewStubMapping(stub);
    }

//    @BeforeTest
//    public void setupJsontextMapping3() {
//        var headers = Headers
//                .builder()
//                .contentType("text/plain")
//                .build();
//
//        var request = Request
//                .builder()
//                .urlPathPattern("/jsontext/mapping3")
//                .method(POST.asString())
//                .build();
//
//        var response = Response
//                .builder()
//                .body(StringUtils.randomString(20))
//                .headers(headers)
//                .status(500)
//                .build();
//
//        var stub = Stub
//                .builder()
//                .request(request)
//                .response(response)
//                .build();
//
//        WireMockManager.createNewStubMapping(stub);
//    }
}
