package alfa.steps;

import alfa.constants.RegularExpressions;
import alfa.screens.LoginScreen;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static alfa.constants.CommonProjectConstants.TEXT_BOX_LIMIT;

public class LoginSteps {

    //Action steps
    @Step("Entering password")
    public static void enterPassword(String password) {
        new LoginScreen().enterPassword(password);
    }

    @Step("Entering login")
    public static void enterLogin(String login) {
        new LoginScreen().enterLogin(login);
    }

    @Step("Clicking Login button")
    public static void clickLoginButton() {
        new LoginScreen().clickLogin();
    }

    @Step("Clicking Eye Icon button")
    public static void clickEyeIconButton() {
        new LoginScreen().clickEyeIcon();
    }

    //Assertion steps
    @Step("Assertion that Login Screen is present")
    public static void assetThanLoginScreenIsPresent() {
        Assert.assertTrue(new LoginScreen().state().waitForDisplayed(), "Login Screen is not present");
    }

    @Step("Assertion that Login Screen title text equals to: {text}")
    public static void assetThanLoginScreenTitleTextEqualsTo(String text) {
        String actualText = new LoginScreen().getTextFromTitle();
        Assert.assertEquals(actualText, text,
                String.format("Actual Login Screen title text: %s not equals to expected: %s", actualText, text));
    }

    @Step("Assertion that Password text box is present")
    public static void assetThanPasswordTextBoxIsPresent() {
        Assert.assertTrue(new LoginScreen().isPasswordTextBoxPresent(), "Password text box is not present");

    }

    @Step("Assertion that Login text box is present")
    public static void assetThanLoginTextBoxIsPresent() {
        Assert.assertTrue(new LoginScreen().isLoginTextBoxPresent(), "Login text box is not present");

    }

    @Step("Assertion that Eye icon button is present")
    public static void assetThanEyeIconButtonIsPresent() {
        Assert.assertTrue(new LoginScreen().isEyeIconButtonPresent(), "Eye icon button is not present");

    }

    @Step("Assertion that Enter button is present")
    public static void assetThanEnterButtonIsPresent() {
        Assert.assertTrue(new LoginScreen().isEnterButtonPresent(), "Enter button is not present");
    }

    @Step("Assertion that all elements are positioned correctly")
    public static void assetThanAllElementsArePositionedCorrectly() {
        LoginScreen loginScreen = new LoginScreen();
        SoftAssert softAssert = new SoftAssert();
        int loginY = loginScreen.getLoginTextBoxCenter().y;
        int passwordY = loginScreen.getPasswordTextBoxCenter().y;
        softAssert.assertTrue(loginScreen.getTitleCenter().y < loginY,
                "Title is lower than login text box text");
        softAssert.assertTrue(loginY < passwordY,
                "Login text box is lower than password text box text");
        softAssert.assertTrue(passwordY < loginScreen.getEnterButtonCenter().y,
                "Password text box is lower than Enter button");
        softAssert.assertTrue(loginScreen.isEyeIconButtonLocatedInPasswordTextBox(),
                "Eye icon button is not located in Password text box");
        softAssert.assertAll("Elements are positioned incorrectly");
    }

    @Step("Assertion that validation error is present")
    public static void asserThatValidationErrorIsPresent() {
        Assert.assertTrue(new LoginScreen().isErrorPresent());
    }

    @Step("Assertion that validation error text equals to: {}")
    public static void assetThanValidationErrorTextEqualsTo(String errorText) {
        String actualText = new LoginScreen().getErrorText();
        Assert.assertEquals(actualText, errorText,
                String.format("Error text: %s not equals to expected: %s", actualText, errorText));
    }

    @Step("Assertion that Eye icon button is enabled")
    public static void assetThanEyeIconButtonIsEnabled() {
        Assert.assertFalse(new LoginScreen().getEyeIconButtonStatus(), "Eye icon button is disabled");
    }

    @Step("Assertion that Eye icon button is disabled")
    public static void assetThanEyeIconButtonIsDisabled() {
        Assert.assertTrue(new LoginScreen().getEyeIconButtonStatus(), "Eye icon button is enabled");
    }

    @Step("Assertion that password equals to: {password}")
    public static void assertThatPasswordEqualsTo(String password) {
        String actualPassword = new LoginScreen().getPassword();
        Assert.assertEquals(actualPassword, password,
                String.format("Password: %s not equals to expected: %s", actualPassword, password));
    }

    @Step("Assertion that password is masked")
    public static void assertThatPasswordIsMasked() {
        Assert.assertTrue(new LoginScreen().getPassword().matches(RegularExpressions.MASKING_DOT),
                "Password is not masked");
    }

    @Step("Assertion that Login contains up to fifty characters")
    public static void assertThatLoginContainsUpToFiftyCharacters() {
        Assert.assertTrue(new LoginScreen().getLoginLength() <= TEXT_BOX_LIMIT,
                "Login contains more that fifty characters");
    }

    @Step("Assertion that Password contains up to fifty characters")
    public static void assertThatPasswordContainsUpToFiftyCharacters() {
        Assert.assertTrue(new LoginScreen().getPasswordLength() <= TEXT_BOX_LIMIT,
                "Password contains more that fifty characters");
    }
}
