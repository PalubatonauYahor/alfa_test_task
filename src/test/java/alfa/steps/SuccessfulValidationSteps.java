package alfa.steps;

import alfa.screens.SuccessfulValidationScreen;
import io.qameta.allure.Step;
import org.testng.Assert;

public class SuccessfulValidationSteps {

    //Assertion steps
    @Step("Assertion that Successful Validation Screen is present")
    public static void assetThanSuccessfulValidationScreenIsPresent() {
        Assert.assertTrue(new SuccessfulValidationScreen().state().waitForDisplayed(),
                "Successful Validation Screen is not present");
    }

    @Step("Assertion that Successful Validation Screen title text equals to: {text}")
    public static void assetThanSuccessfulValidationScreenTitleTextEqualsTo(String text) {
        String actualText = new SuccessfulValidationScreen().getTextFromTitle();
        Assert.assertEquals(actualText, text,
                String.format("Actual Successful Validation Screen title text: %s not equals to expected: %s", actualText, text));
    }
}
