package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public static final String LOGIN_PAGE_PATH = "/users/login";

    @FindBy(css = "p.h4")
    private WebElement loginFormHeaderTitle;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement loginFormUsernameInputField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement loginFormPasswordInputField;
    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement loginFormCheckBoxLabelText;
    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement loginFormRememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'Not a member')]")
    private WebElement loginFormFooterLabelText;
    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegisterLink;
    @FindBy(css = ".toast-message.ng-star-inserted")
    private WebElement loginFormToastMessage;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_PAGE_PATH);
    }

    public void provideUsername(String username) {
        isElementPresent(loginFormUsernameInputField);
        waitAndTypeTextInField(loginFormUsernameInputField, username);
    }

    public void providePassword(String password) {
        isElementPresent(loginFormUsernameInputField);
        waitAndTypeTextInField(loginFormPasswordInputField, password);
    }

    /*
    public void enterUserCredentials(String username, String password) {
        waitAndTypeTextInField(loginFormUsernameInputField, username);
        waitAndTypeTextInField(loginFormPasswordInputField, password);
    }
     */

    public void clickOnRememberMeCheckBox() {
        isElementPresent(loginFormRememberMeCheckBox);
        waitAndClickOnWebElement(loginFormRememberMeCheckBox);
    }

    public void clickOnSubmitButton() {
        isElementPresent(loginFormSubmitButton);
        waitAndClickOnWebElement(loginFormSubmitButton);
    }

    public void clickOnRegisterLink(){
        isElementPresent(loginFormRegisterLink);
        waitAndClickOnWebElement(loginFormRegisterLink);
    }

    public String getLoginFormHeaderTitleText() {
        String actualLoginHeaderText = getElementText(loginFormHeaderTitle);
        return actualLoginHeaderText;
    }

    public String getCheckBoxLabelText(){
        String actualCheckBoxLabelText = getElementText(loginFormCheckBoxLabelText);
        return actualCheckBoxLabelText;
    }

    public String getLoginFormFooterLabelText(){
        String actualFooterText = getElementText(loginFormFooterLabelText);
        return actualFooterText;
    }

    public String getLoginActionMessageText() {
        String actualMessageText = getElementText(loginFormToastMessage);
        return actualMessageText;
    }

    public boolean isRegisterLinkShown(){
        return isElementPresent(loginFormRegisterLink);
    }

    public String verifyLoginUsernameInputFieldPlaceholder() {
        String actualUsernamePlaceholder = getAttributeValue(loginFormUsernameInputField, "placeholder");
        return actualUsernamePlaceholder;
    }

    public String verifyLoginPasswordInputFieldPlaceholder() {
        String actualPasswordPlaceholder = getAttributeValue(loginFormPasswordInputField, "placeholder");
        return actualPasswordPlaceholder;
    }
}