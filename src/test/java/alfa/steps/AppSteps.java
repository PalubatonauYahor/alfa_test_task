package alfa.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.ScreenOrientation;

import static alfa.test.BaseTest.androidDriver;

public class AppSteps {

    //Action steps
    @Step("Setting screen orientation to: {screenOrientation}")
    public static void setOrientation(ScreenOrientation screenOrientation) {
        androidDriver.rotate(screenOrientation);
    }
}
