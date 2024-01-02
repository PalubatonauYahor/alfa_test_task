package alfa.screens;

import aquality.appium.mobile.elements.Attributes;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElement;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import static alfa.utils.WaitUtils.getTextWithWait;
import static io.appium.java_client.MobileBy.id;

public class LoginScreen extends Screen {
    private static String alfaResourceId = "com.alfabank.qapp:id/%s";

    private static final By LOC_LOGIN_SCREEN = id(String.format(alfaResourceId, "tvTitle"));

    private final ILabel lblLoginTitle = getElementFactory().getLabel(LOC_LOGIN_SCREEN,
            "Login Screen title Label");
    private final ITextBox txtBoxPassword = getElementFactory().getTextBox(
            id(String.format(alfaResourceId, "etPassword")), "Password Text Box");
    private final ITextBox txtBoxLogin = getElementFactory().getTextBox(
            id(String.format(alfaResourceId, "etUsername")), "Login Text Box");
    private final IButton btnEyeIcon = getElementFactory().getButton(
            id(String.format(alfaResourceId, "text_input_end_icon")), "Eye icon Button");
    private final IButton btnLogin = getElementFactory().getButton(
            id(String.format(alfaResourceId, "btnConfirm")), "Login Button");
    private final ILabel lblError = getElementFactory().getLabel(
            id(String.format(alfaResourceId, "tvError")), "Error Label");

    public LoginScreen() {
        super(LOC_LOGIN_SCREEN, "Login Screen");
    }

    public boolean isPasswordTextBoxPresent() {
        return txtBoxPassword.state().isDisplayed();
    }

    public boolean isLoginTextBoxPresent() {
        return txtBoxLogin.state().isDisplayed();
    }

    public boolean isEyeIconButtonPresent() {
        return btnEyeIcon.state().isDisplayed();
    }

    public boolean isEnterButtonPresent() {
        return btnLogin.state().isDisplayed();
    }

    public void enterPassword(String password) {
        txtBoxPassword.sendKeys(password);
    }

    public void enterLogin(String login) {
        txtBoxLogin.sendKeys(login);
    }

    public String getTextFromTitle() {
        return lblLoginTitle.getText();
    }

    public Point getTitleCenter() {
        return lblLoginTitle.getCenter();
    }

    public Point getPasswordTextBoxCenter() {
        return txtBoxPassword.getCenter();
    }

    public Point getLoginTextBoxCenter() {
        return txtBoxLogin.getCenter();
    }

    public Point getEnterButtonCenter() {
        return btnLogin.getCenter();
    }

    public void clickLogin() {
        btnLogin.state().waitForDisplayed();
        btnLogin.click();
    }

    public void clickEyeIcon() {
        btnEyeIcon.state().waitForDisplayed();
        btnEyeIcon.click();
    }

    public boolean isEyeIconButtonLocatedInPasswordTextBox() {
        Rectangle passwordRect = getElementRect(txtBoxPassword);
        Rectangle eyeIconRect = getElementRect(btnEyeIcon);
        return getJavaRect(passwordRect).contains(getJavaRect(eyeIconRect));
    }

    public boolean isErrorPresent() {
        return lblError.state().waitForDisplayed();
    }

    public String getErrorText() {
        return getTextWithWait(lblError);
    }

    public String getPassword() {
        return getTextWithWait(txtBoxPassword);
    }

    public int getPasswordLength() {
        return getPassword().length();
    }

    public String getLogin() {
        return getTextWithWait(txtBoxLogin);
    }

    public int getLoginLength() {
        return getLogin().length();
    }

    public boolean getEyeIconButtonStatus() {
        return Boolean.parseBoolean(btnEyeIcon.getAttribute(Attributes.CHECKED));
    }

    private Rectangle getElementRect(IElement element) {
        return element.getElement().getRect();
    }

    private java.awt.Rectangle getJavaRect(Rectangle rectangle) {
        return new java.awt.Rectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
