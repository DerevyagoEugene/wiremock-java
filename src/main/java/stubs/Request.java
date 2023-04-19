package stubs;

import lombok.Builder;

import java.util.Map;

@Builder
public class Request {

    private String method;
    private String urlPathPattern;
    private Map<String, Object> queryParameters;
}
