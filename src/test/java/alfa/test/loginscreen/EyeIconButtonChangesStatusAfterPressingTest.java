package alfa.test.loginscreen;

import alfa.steps.LoginSteps;
import alfa.test.BaseTest;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

import static alfa.utils.RandomStringGenerator.generateRandomString;

public class EyeIconButtonChangesStatusAfterPressingTest extends BaseTest {

    private final String PASSWORD_LENGTH = "9";

    @Link(name = "AT-5")
    @Issue("UI-IS-1")
    @Test(groups = "loginscreen")
    public void eyeIconButtonChangesStatusAfterPressingTest() {
        String password = generateRandomString(PASSWORD_LENGTH);
        LoginSteps.assetThanLoginScreenIsPresent();
        LoginSteps.assetThanEyeIconButtonIsPresent();
        LoginSteps.assetThanEyeIconButtonIsEnabled();
        LoginSteps.enterPassword(password);
        //TODO: on UI the password will be displayed as disguised in but the
        // element returns text instead of dots
        LoginSteps.assertThatPasswordIsMasked();
        LoginSteps.clickEyeIconButton();
        LoginSteps.assetThanEyeIconButtonIsPresent();
        LoginSteps.assetThanEyeIconButtonIsDisabled();
        LoginSteps.assertThatPasswordEqualsTo(password);
    }
}
