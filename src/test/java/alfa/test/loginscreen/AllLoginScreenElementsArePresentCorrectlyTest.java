package alfa.test.loginscreen;

import alfa.annotations.TestDataKeys;
import alfa.constants.ScreensConstants;
import alfa.steps.AppSteps;
import alfa.steps.LoginSteps;
import alfa.test.BaseTest;
import io.qameta.allure.Link;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class AllLoginScreenElementsArePresentCorrectlyTest extends BaseTest {

    @Link(name = "AT-1")
    @Test(dataProvider = "testDataFromJson", groups = "loginscreen")
    @TestDataKeys("orientation")
    public void allLoginScreenElementsArePresentCorrectlyTest(String orientation) {
        AppSteps.setOrientation(ScreenOrientation.valueOf(orientation.toUpperCase()));
        LoginSteps.assetThanLoginScreenIsPresent();
        LoginSteps.assetThanLoginScreenTitleTextEqualsTo(ScreensConstants.LOGIN_TITLE_TEXT);
        LoginSteps.assetThanLoginTextBoxIsPresent();
        LoginSteps.assetThanPasswordTextBoxIsPresent();
        LoginSteps.assetThanEyeIconButtonIsPresent();
        LoginSteps.assetThanEnterButtonIsPresent();
        LoginSteps.assetThanAllElementsArePositionedCorrectly();
    }
}
