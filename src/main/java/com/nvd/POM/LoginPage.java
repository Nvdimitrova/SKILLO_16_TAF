package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    final String LOGIN_PAGE_PATH = "/users/login";

    @FindBy(css = "p.h4")
    private WebElement loginFormHeaderTitle;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement checkBoxLabelText;
    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    private WebElement loginSubmitButton;
    @FindBy(xpath = "//span[contains(text(),'Not a member')]")
    private WebElement loginFormFooterLabelText;
    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement registerLink;
    @FindBy(css = ".toast-message.ng-star-inserted")
    private WebElement toastMessage;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_PAGE_PATH);
    }

    public void provideUsername(String username) {
        waitAndTypeTextInField(usernameInputField, username);
    }

    public void providePassword(String password) {
        waitAndTypeTextInField(passwordInputField, password);
    }

    public void provideUserCredentials(String username, String password) {
        waitAndTypeTextInField(usernameInputField, username);
        waitAndTypeTextInField(passwordInputField, password);
    }

    public void clickOnRememberMeCheckBox() {
        waitAndClickOnWebElement(rememberMeCheckBox);
    }

    public void clickOnSignInButton() {
        waitAndClickOnWebElement(loginSubmitButton);
    }

    public void clickOnRegisterLink() {
        waitAndClickOnWebElement(registerLink);
    }

    public String getLoginFormHeaderTitleText() {
        String actualLoginHeaderText = getElementText(loginFormHeaderTitle);
        return actualLoginHeaderText;
    }

    public String getCheckBoxLabelText() {
        String actualCheckBoxLabelText = getElementText(checkBoxLabelText);
        return actualCheckBoxLabelText;
    }

    public String getLoginFormSubmitButtonText() {
        String actualLoginFormSubmitButtonText = getElementText(loginSubmitButton);
        return actualLoginFormSubmitButtonText;
    }

    public String getLoginFormFooterLabelText() {
        String actualFooterText = getElementText(loginFormFooterLabelText);
        return actualFooterText;
    }

    public String getLoginActionMessageText() {
        String actualMessageText = getElementText(toastMessage);
        return actualMessageText;
    }

    public boolean isCheckBoxShown() {
        return isElementPresent(rememberMeCheckBox);
    }

    public boolean isLoginSubmitButtonShown() {
        return isElementPresent(loginSubmitButton);
    }

    public boolean isRegisterLinkShown() {
        return isElementPresent(registerLink);
    }

    public boolean isCheckBoxClickable() {
        return isElementClickable(rememberMeCheckBox);
    }

    public boolean isLoginSubmitButtonClickable() {
        return isElementClickable(loginSubmitButton);
    }

    public boolean isRegisterLinkClickable() {
        return isElementClickable(registerLink);
    }

    public String verifyUsernameInputFieldPlaceholder() {
        String actualUsernamePlaceholder = getAttributeValue(usernameInputField, "placeholder");
        return actualUsernamePlaceholder;
    }

    public String verifyPasswordInputFieldPlaceholder() {
        String actualPasswordPlaceholder = getAttributeValue(passwordInputField, "placeholder");
        return actualPasswordPlaceholder;
    }
}