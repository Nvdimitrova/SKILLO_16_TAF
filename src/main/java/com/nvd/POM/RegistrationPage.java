package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    public static final String REGISTRATION_PAGE_PATH = "/users/register";

    @FindBy(xpath = "//h4[contains(text(),'Sign up')]")
    private WebElement registrationFormHeaderTitle;
    @FindBy(xpath = "//input[contains(@placeholder,'Username')]")
    private WebElement usernameInputField;
    @FindBy(xpath = "//input[contains(@placeholder,'email')]")
    private WebElement emailInputField;
    @FindBy(id = "defaultRegisterFormPassword")
    private WebElement passwordInputField;
    @FindBy(id = "defaultRegisterPhonePassword")
    private WebElement confirmPasswordInputField;
    @FindBy(css = "span.invalid-feedback")
    private WebElement invalidFeedbackMessage;
    @FindBy(id = "sign-in-button")
    private WebElement submitButton;
    @FindBy(css = ".toast-message.ng-star-inserted")
    private WebElement toastMessage;


    public RegistrationPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        navigateTo(REGISTRATION_PAGE_PATH);
    }

    public void provideUsername(String username) {
        waitAndTypeTextInField(usernameInputField, username);
    }

    public void provideEmail(String email) {
        waitAndTypeTextInField(emailInputField, email);
    }

    public void providePassword(String password) {
        waitAndTypeTextInField(passwordInputField, password);
    }

    public void confirmTheProvidedPassword(String password) {
        waitAndTypeTextInField(confirmPasswordInputField, password);
    }

    public void provideUserCredentials(String username, String email, String password) {
        waitAndTypeTextInField(usernameInputField, username);
        waitAndTypeTextInField(emailInputField, email);
        waitAndTypeTextInField(passwordInputField, password);
        waitAndTypeTextInField(confirmPasswordInputField, password);
    }

    public void clickOnSubmitButton() {
        waitAndClickOnWebElement(submitButton);
    }

    public String getRegistrationFormHeaderTitleText() {
        String actualTitleText = getElementText(registrationFormHeaderTitle);
        return actualTitleText;
    }

    public String getInvalidFeedbackMessageText() {
        String actualFeedbackMessageText = getElementText(invalidFeedbackMessage);
        return actualFeedbackMessageText;
    }

    public String getActionMessageText() {
        String actualMessageText = getElementText(toastMessage);
        return actualMessageText;
    }

    public String verifyUsernameInputFieldPlaceholder() {
        String actualUsernamePlaceholder = getAttributeValue(usernameInputField, "placeholder");
        return actualUsernamePlaceholder;
    }

    public String verifyEmailInputFieldPlaceholder() {
        String actualEmailPlaceholder = getAttributeValue(emailInputField, "placeholder");
        return actualEmailPlaceholder;
    }

    public String verifyPasswordInputFieldPlaceholder() {
        String actualPasswordPlaceholder = getAttributeValue(passwordInputField, "placeholder");
        return actualPasswordPlaceholder;
    }

    public String verifyConfirmPasswordInputFieldPlaceholder() {
        String actualConfirmPasswordPlaceholder = getAttributeValue(confirmPasswordInputField, "placeholder");
        return actualConfirmPasswordPlaceholder;
    }
}