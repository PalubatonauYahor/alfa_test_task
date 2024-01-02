package alfa.test.loginscreen;

import alfa.constants.ScreensConstants;
import alfa.steps.LoginSteps;
import alfa.test.BaseTest;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

import static alfa.utils.RandomStringGenerator.generateRandomString;

public class InvalidCredentialsCauseAnErrorToAppearTest extends BaseTest {

    private final String STRING_LENGTH = "5";

    @Link(name = "AT-4")
    @Test(groups = "loginscreen")
    public void invalidCredentialsCauseAnErrorToAppearTest() {
        LoginSteps.assetThanLoginScreenIsPresent();
        LoginSteps.enterLogin(generateRandomString(STRING_LENGTH));
        LoginSteps.enterPassword(generateRandomString(STRING_LENGTH));
        LoginSteps.clickLoginButton();
        LoginSteps.asserThatValidationErrorIsPresent();
        LoginSteps.assetThanValidationErrorTextEqualsTo(ScreensConstants.INCORRECT_DATA_ENTERED_TEXT);
    }
}
