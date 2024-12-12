package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage  extends BasePage {
    //1. CONST
    public static final String REGISTRATION_PAGE_URL = "/users/register";
    //2.UI MAP
    @FindBy(xpath = "//h4[contains(text(),'Sign up')]")
    private WebDriver registrationFormHeaderTitle;
    @FindBy(xpath = "//input[contains(@placeholder,'Username')]" )
    private WebDriver registrationFormUsernameInputField;
    @FindBy(xpath = "//input[contains(@placeholder,'email')]")
    private WebDriver registrationFormEmailInputField;
    @FindBy(xpath = "//input[contains(@placeholder,'Birth date')]")
    private WebDriver registrationFormBirthDateInputField;
    @FindBy(id = "defaultRegisterFormPassword")
    private WebDriver registrationFormPasswordInputField;
    @FindBy(id = "defaultRegisterPhonePassword")
    private WebDriver registrationFormConfirmPasswordInputField;
    @FindBy(xpath = "//textarea[contains(@placeholder,'Public info')]")
    private WebDriver registrationFormPublicInfoField;
    @FindBy(css="span.invalid-feedback")
    private WebDriver registrationFormInvalidFeedbackMessage;
    @FindBy(id = "sign-in-button")
    private WebDriver registrationFormSubmitButton;
    @FindBy(css = ".toast-message.ng-star-inserted")
    private WebDriver registrationFormToastMessage;


    //3 CONSTRUCTOR
    public RegistrationPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    //3.1. NAVIGATION
    public void navigateToRegPage(){
        navigateTo(REGISTRATION_PAGE_URL);
    }

    //4 USER ACTION

    //5. SUPPORT METHODS

    //6.Verifications
}