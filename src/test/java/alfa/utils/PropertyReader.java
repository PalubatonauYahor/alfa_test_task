package alfa.utils;

import alfa.enums.TestProperty;
import alfa.enums.Timeout;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties = new Properties();

    public static String getTestProperty(TestProperty testProperty) {
        return getProperty(testProperty.getProperty(), "test.properties");
    }

    public static long getTimeout(Timeout timeout) {
        return Long.parseLong(getProperty(timeout.getTimeout(), "timeout.properties"));
    }

    private static String getProperty(String propertyName, String propertyPath) {
        try (FileInputStream input = new FileInputStream(String.format("src/test/resources/%s", propertyPath))) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName.toLowerCase());
    }
}
