package alfa.test;

import alfa.annotations.TestDataKeys;
import alfa.enums.TestProperty;
import alfa.utils.PropertyReader;
import aquality.appium.mobile.application.AqualityServices;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static alfa.enums.TestProperty.*;
import static alfa.utils.LogUtils.attachLogToReport;
import static alfa.utils.LogUtils.cleanLog;
import static alfa.utils.PropertyReader.getTestProperty;

public class BaseTest {

    public static AndroidDriver androidDriver;
    private static final String ANDROID_SETTINGS = getTestProperty(DRIVER_SETTINGS_ANDROID);

    @BeforeMethod
    public void beforeMethod() {
        cleanLog();
        AqualityServices.getLogger().info("Opening application");
        System.setProperty(ANDROID_SETTINGS, getTestProperty(SAMSUNG));
        getAndroidDriver();
    }

    @AfterMethod
    public void tearDown() {
        attachLogToReport();
        AqualityServices.getLogger().info("Closing application");
        if (AqualityServices.isApplicationStarted()) {
            androidDriver.quit();
            androidDriver = null;
        }
    }

    @DataProvider(name = "testDataFromJson")
    public Object[][] getTestDataFromJson(Method method) {
        JsonElement jsonElement;
        List<Object[]> dataList = new ArrayList<>();
        List<String> keys = Arrays.asList(method.getAnnotation(TestDataKeys.class).value());
        String jsonFileName = String.format(PropertyReader.getTestProperty(TestProperty.TEST_DATA_PATH),
                Arrays.asList(method.getAnnotation(Test.class).groups()).get(0),
                method.getDeclaringClass().getSimpleName());
        try {
            jsonElement = JsonParser.parseReader(new FileReader(jsonFileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray(getTestProperty(TEST_DATA_KEY));
        for (JsonElement element : jsonArray) {
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                List<Object> rowList = new ArrayList<>();
                for (String key : keys) {
                    rowList.add(jsonObject.get(key).getAsString());
                }
                dataList.add(rowList.toArray());
            }
        }
        return dataList.toArray(new Object[0][]);
    }

    private AndroidDriver getAndroidDriver() {
        return androidDriver == null ?
                androidDriver = (AndroidDriver) AqualityServices.getApplication().getDriver() : androidDriver;
    }
}
