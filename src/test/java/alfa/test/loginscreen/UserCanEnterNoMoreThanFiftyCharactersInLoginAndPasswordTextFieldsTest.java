package alfa.test.loginscreen;

import alfa.annotations.TestDataKeys;
import alfa.steps.AppSteps;
import alfa.steps.LoginSteps;
import alfa.test.BaseTest;
import io.qameta.allure.Link;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import static alfa.utils.RandomStringGenerator.generateRandomString;

public class UserCanEnterNoMoreThanFiftyCharactersInLoginAndPasswordTextFieldsTest extends BaseTest {

    @Link(name = "AT-2")
    @Test(dataProvider = "testDataFromJson", groups = "loginscreen")
    @TestDataKeys({"orientation", "login_length","password_length"})
    public void userCanEnterNoMoreThanFiftyCharactersInLoginAndPasswordTextFieldsTest(String orientation,
                                                                                      String loginLength,
                                                                                      String passwordLength) {
        AppSteps.setOrientation(ScreenOrientation.valueOf(orientation.toUpperCase()));
        LoginSteps.assetThanLoginScreenIsPresent();
        LoginSteps.assetThanLoginTextBoxIsPresent();
        LoginSteps.enterLogin(generateRandomString(loginLength));
        LoginSteps.assertThatLoginContainsUpToFiftyCharacters();
        LoginSteps.assetThanPasswordTextBoxIsPresent();
        LoginSteps.enterPassword(generateRandomString(passwordLength));
        LoginSteps.assertThatPasswordContainsUpToFiftyCharacters();
    }
}
