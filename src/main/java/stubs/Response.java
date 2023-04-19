package stubs;

import lombok.Builder;

@Builder
public class Response {

    private String body;
    private Headers headers;
    private long status;
}
