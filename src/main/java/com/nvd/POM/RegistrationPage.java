package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        isPresented(registrationFormUsernameInputField);
        waitAndTypeTextInField(registrationFormUsernameInputField, username);
    }

    public void provideEmail(String email) {
        isPresented(registrationFormEmailInputField);
        waitAndTypeTextInField(registrationFormEmailInputField, email);
    }

    public void provideBirthDate(String birthDate) {
        isPresented(registrationFormBirthDateInputField);
        waitAndTypeTextInField(registrationFormBirthDateInputField, birthDate);
    }

    public void providePassword(String password) {
        isPresented(registrationFormPasswordInputField);
        waitAndTypeTextInField(registrationFormPasswordInputField, password);
    }

    public void confirmTheProvidedPassword(String password) {
        isPresented(registrationFormConfirmPasswordInputField);
        waitAndTypeTextInField(registrationFormConfirmPasswordInputField, password);
    }

    public void providePublicInfo(String publicInfo) {
        isPresented(registrationFormPublicInfoField);
        waitAndTypeTextInField(registrationFormPublicInfoField, publicInfo);
    }

    public void clickOnSubmitButton() {
        isPresented(registrationFormSubmitButton);
        waitAndClickOnWebElement(registrationFormSubmitButton);
    }


    public String getRegistrationFormHeaderTitle() {
        wait.until(ExpectedConditions.visibilityOf(registrationFormHeaderTitle));
        String actualTitleText = registrationFormHeaderTitle.getText();
        return actualTitleText;
    }

    public String getRegistrationActionMessage() {
        wait.until(ExpectedConditions.visibilityOf(registrationFormToastMessage));
        String actualMessage = registrationFormToastMessage.getText();
        return actualMessage;
    }

    public void verifyRegistrationPageURL() {
        isURLLoaded("http://training.skillo-bg.com:4300/users/register");
    }
}