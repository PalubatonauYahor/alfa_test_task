package alfa.utils;

import alfa.constants.RegularExpressions;
import aquality.appium.mobile.application.AqualityServices;
import io.qameta.allure.Allure;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static alfa.enums.TestProperty.LOG_PATH;
import static alfa.utils.PropertyReader.getTestProperty;

public class LogUtils {

    private static final String PATH_TO_LOG = getTestProperty(LOG_PATH);

    public static void cleanLog() {
        AqualityServices.getLogger().info("Cleaning log on test start");
        try {
            Files.write(Paths.get(PATH_TO_LOG), RegularExpressions.EMPTY.getBytes());
        } catch (IOException e) {
            AqualityServices.getLogger().error(
                    String.format("Something went wrong during cleaning log. Path to file: %s. Stacktrace: %s",
                            PATH_TO_LOG, e));
        }
    }

    public static void attachLogToReport() {
        AqualityServices.getLogger().info("Attaching log to Allure report");
        try (InputStream is = Files.newInputStream(Paths.get(PATH_TO_LOG))) {
            Allure.addAttachment(PATH_TO_LOG, is);
        } catch (IOException e) {
            AqualityServices.getLogger().error(
                    String.format("Something went wrong during file attaching. Path to file: %s. Stacktrace: %s",
                            PATH_TO_LOG, e));
        }
    }
}
