package resource;

import java.io.IOException;
import java.util.Properties;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

public final class PropertiesManager {

    private final Properties properties = new Properties();

    public PropertiesManager(final String resourceName) {
        appendFromResource(properties, resourceName);
    }

    private void appendFromResource(final Properties objProperties, final String resourceName) {
        var inStream = this
                .getClass()
                .getClassLoader()
                .getResourceAsStream(resourceName);

        if (nonNull(inStream)) {
            try {
                objProperties.load(inStream);
                inStream.close();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            throw new IllegalStateException(format("Resource \"%1$s\" could not be found", resourceName));
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getProperty(final String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

}
