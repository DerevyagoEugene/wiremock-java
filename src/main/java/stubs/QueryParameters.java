package stubs;

import lombok.Builder;
import java.util.Map;

@Builder
public class QueryParameters {

    private Map<String, Object> entries;
}
