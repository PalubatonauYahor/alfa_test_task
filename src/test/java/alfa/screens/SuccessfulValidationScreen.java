package alfa.screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class SuccessfulValidationScreen extends Screen {

    private static final By locSuccessfulValidationScreen = cssSelector(".android.widget.TextView");

    private final ILabel lblSuccessfulValidationTitle = getElementFactory().getLabel(locSuccessfulValidationScreen,
            "Successful Validation title Label");

    public SuccessfulValidationScreen() {
        super(locSuccessfulValidationScreen, "Successful Validation screen");
    }

    public String getTextFromTitle() {
        return lblSuccessfulValidationTitle.getText();
    }
}
