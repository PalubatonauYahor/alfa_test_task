package alfa.test.loginscreen;

import alfa.constants.ScreensConstants;
import alfa.steps.LoginSteps;
import alfa.steps.SuccessfulValidationSteps;
import alfa.test.BaseTest;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

import static alfa.constants.CommonProjectConstants.LOGIN;
import static alfa.constants.CommonProjectConstants.PASSWORD;
import static alfa.utils.AppConfig.getParameterByName;

public class UserReachesSuccessfulValidationScreenWithValidCredentialsTest extends BaseTest {

    @Link(name = "AT-3")
    @Test(groups = "loginscreen")
    public void userReachesSuccessfulValidationScreenWithValidCredentialsTest() {
        LoginSteps.assetThanLoginScreenIsPresent();
        LoginSteps.enterLogin(getParameterByName(LOGIN));
        LoginSteps.enterPassword(getParameterByName(PASSWORD));
        LoginSteps.clickLoginButton();
        SuccessfulValidationSteps.assetThanSuccessfulValidationScreenIsPresent();
        SuccessfulValidationSteps
                .assetThanSuccessfulValidationScreenTitleTextEqualsTo(ScreensConstants.SUCCESS_VALIDATION_TEXT);
    }
}
