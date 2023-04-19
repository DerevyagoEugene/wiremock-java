package stubs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Headers {

    @JsonProperty("Content-Type")
    private String contentType;
}
