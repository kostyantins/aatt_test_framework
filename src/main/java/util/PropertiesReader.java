package util;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader {

    private PropertiesReader() {
    }

    private static final String CONFIG_PROPERTIES = "config.properties";

    private static Properties PROPERTIES;

    public static String getProperty(final String propertyName) {

        if (PROPERTIES == null) {
            synchronized (PropertiesReader.class) {
                if (PROPERTIES == null) {
                    try (final InputStream reader = PropertiesReader.class
                            .getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {

                        final Properties properties = new Properties();
                        properties.load(reader);
                        PROPERTIES = properties;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new IllegalStateException("Error occurred during reading properties file !!");
                    }
                }
            }
        }

        final String systemProperty = System.getProperty(propertyName);

        return systemProperty == null
                ? PROPERTIES.getProperty(propertyName, "Wrong property name was set !")
                : systemProperty;
    }
}
