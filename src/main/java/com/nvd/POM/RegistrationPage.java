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
    private WebElement registrationFormUsernameInputField;
    @FindBy(xpath = "//input[contains(@placeholder,'email')]")
    private WebElement registrationFormEmailInputField;
    @FindBy(xpath = "//input[contains(@placeholder,'Birth date')]")
    private WebElement registrationFormBirthDateInputField;
    @FindBy(id = "defaultRegisterFormPassword")
    private WebElement registrationFormPasswordInputField;
    @FindBy(id = "defaultRegisterPhonePassword")
    private WebElement registrationFormConfirmPasswordInputField;
    @FindBy(xpath = "//textarea[contains(@placeholder,'Public info')]")
    private WebElement registrationFormPublicInfoField;
    @FindBy(css = "span.invalid-feedback")
    private WebElement registrationFormInvalidFeedbackMessage;
    @FindBy(id = "sign-in-button")
    private WebElement registrationFormSubmitButton;
    @FindBy(css = ".toast-message.ng-star-inserted")
    private WebElement registrationFormToastMessage;


    public RegistrationPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        navigateTo(REGISTRATION_PAGE_PATH);
    }

    public void provideUsername(String username) {
        isElementPresent(registrationFormUsernameInputField);
        waitAndTypeTextInField(registrationFormUsernameInputField, username);
    }

    public void provideEmail(String email) {
        isElementPresent(registrationFormEmailInputField);
        waitAndTypeTextInField(registrationFormEmailInputField, email);
    }

    public void provideBirthDate(String birthDate) {
        isElementPresent(registrationFormBirthDateInputField);
        waitAndTypeTextInField(registrationFormBirthDateInputField, birthDate);
    }

    public void providePassword(String password) {
        isElementPresent(registrationFormPasswordInputField);
        waitAndTypeTextInField(registrationFormPasswordInputField, password);
    }

    public void confirmTheProvidedPassword(String password) {
        isElementPresent(registrationFormConfirmPasswordInputField);
        waitAndTypeTextInField(registrationFormConfirmPasswordInputField, password);
    }

    public void providePublicInfo(String publicInfo) {
        isElementPresent(registrationFormPublicInfoField);
        waitAndTypeTextInField(registrationFormPublicInfoField, publicInfo);
    }

    /*
    public void enterUserCredentials(String username, String email, String birthDate, String password, String publicInfo) {
        waitAndTypeTextInField(registrationFormUsernameInputField, username);
        waitAndTypeTextInField(registrationFormEmailInputField, email);
        waitAndTypeTextInField(registrationFormBirthDateInputField, birthDate);
        waitAndTypeTextInField(registrationFormPasswordInputField, password);
        waitAndTypeTextInField(registrationFormConfirmPasswordInputField, password);
        waitAndTypeTextInField(registrationFormPublicInfoField, publicInfo);
    }
     */

    public void clickOnSubmitButton() {
        isElementPresent(registrationFormSubmitButton);
        waitAndClickOnWebElement(registrationFormSubmitButton);
    }

    public String getRegistrationFormHeaderTitleText() {
        String actualTitleText = getElementText(registrationFormHeaderTitle);
        return actualTitleText;
    }

    public String getInvalidFeedbackMessageText() {
        String actualFeedbackMessageText = getElementText(registrationFormInvalidFeedbackMessage);
        return actualFeedbackMessageText;
    }

    public String getRegistrationActionMessageText() {
        String actualMessageText = getElementText(registrationFormToastMessage);
        return actualMessageText;
    }

    public String verifyRegistrationUsernameInputFieldPlaceholder() {
        String actualUsernamePlaceholder = getAttributeValue(registrationFormUsernameInputField, "placeholder");
        return actualUsernamePlaceholder;
    }

    public String verifyRegistrationEmailInputFieldPlaceholder() {
        String actualEmailPlaceholder = getAttributeValue(registrationFormEmailInputField, "placeholder");
        return actualEmailPlaceholder;
    }

    public String verifyBirthdateInputFieldPlaceholder() {
        String actualBirthdatePlaceholder = getAttributeValue(registrationFormBirthDateInputField, "placeholder");
        return actualBirthdatePlaceholder;
    }

    public String verifyRegistrationPasswordInputFieldPlaceholder() {
        String actualPasswordPlaceholder = getAttributeValue(registrationFormPasswordInputField, "placeholder");
        return actualPasswordPlaceholder;
    }

    public String verifyRegistrationConfirmPasswordInputFieldPlaceholder() {
        String actualConfirmPasswordPlaceholder = getAttributeValue(registrationFormConfirmPasswordInputField, "placeholder");
        return actualConfirmPasswordPlaceholder;
    }

    public String verifyRegistrationPublicInfoInputFieldPlaceholder() {
        String actualPublicInfoPlaceholder = getAttributeValue(registrationFormPublicInfoField, "placeholder");
        return actualPublicInfoPlaceholder;
    }
}