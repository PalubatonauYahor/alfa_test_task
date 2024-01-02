package alfa.utils;

import alfa.enums.Timeout;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IElement;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class WaitUtils {

    public static String getTextWithWait(IElement element) {
        AqualityServices.getLogger().info(String.format("Getting text from element: %s with wait", element.getName()));
        try {
            waitForText(element);
        } catch (TimeoutException e) {
            AqualityServices.getLogger().error("Text not found after time expired");
        }
        return element.getText();
    }

    private static void waitForText(IElement element) throws TimeoutException {
        AqualityServices.getConditionalWait().waitFor(() -> {
            String text = element.getText();
            return text != null && !text.isEmpty();
        }, Duration.ofSeconds(PropertyReader.getTimeout(Timeout.GET_TEXT_TIMEOUT)));
    }
}
