package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private WebElement loginFormRegisterPageLink;
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
        isPresented(loginFormUsernameInputField);
        waitAndTypeTextInField(loginFormUsernameInputField, username);
    }

    public void providePassword(String password) {
        isPresented(loginFormUsernameInputField);
        waitAndTypeTextInField(loginFormPasswordInputField, password);
    }

    public void clickOnRememberMeCheckBox() {
        isPresented(loginFormRememberMeCheckBox);
        waitAndClickOnWebElement(loginFormRememberMeCheckBox);
    }

    public void clickOnSubmitButton() {
        isPresented(loginFormSubmitButton);
        waitAndClickOnWebElement(loginFormSubmitButton);
    }

    public String getLoginFormHeaderTitle() {
        wait.until(ExpectedConditions.visibilityOf(loginFormHeaderTitle));
        String actualTitleText = loginFormHeaderTitle.getText();
        return actualTitleText;
    }

    public String getLoginActionMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginFormToastMessage));
        String actualMessage = loginFormToastMessage.getText();
        return actualMessage;
    }

    public void verifyLoginPageURL() {
        isURLLoaded("http://training.skillo-bg.com:4300/users/login");
    }
}