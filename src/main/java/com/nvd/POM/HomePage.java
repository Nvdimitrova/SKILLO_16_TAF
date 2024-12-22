package com.nvd.POM;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
    public static final String HOME_PAGE_PATH = "/posts/all";

    @FindBy(id = "homeIcon")
    private WebElement headerHomeIcon;
    @FindBy(id = "nav-link-home")
    private WebElement navBarHomeLink;
    @FindBy(id = "nav-link-login")
    private WebElement navBarLoginLink;
    @FindBy(id = "nav-link-profile")
    private WebElement navBarProfileLink;
    @FindBy(id = "nav-link-new-post")
    private WebElement navBarNewPostLink;
    @FindBy(id = "search-bar")
    private WebElement navBarSearchInputField;
    @FindBy(xpath = "//i[contains(@class,'fas fa-sign-out-alt fa-lg')]")
    private WebElement navBarSignOutButton;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        navigateTo(HOME_PAGE_PATH);
    }

    public void clickOnNavBarLoginLink() {
        waitAndClickOnWebElement(navBarLoginLink);
    }

    public void clickOnNavBarProfileLink() {
        waitAndClickOnWebElement(navBarProfileLink);
    }

    public void clickOnNavBarSignOutButton() {
        waitAndClickOnWebElement(navBarSignOutButton);
    }

    public void clickOnNavBarNewPostLink() {
        waitAndClickOnWebElement(navBarNewPostLink);
    }

    public void searchInNavBarSearchInputField(String text) {
        waitAndTypeTextInField(navBarSearchInputField, text);
    }

    public boolean isHomeIconShown() {
        return isElementPresent(headerHomeIcon);
    }

    public boolean isNavBarHomeLinkShown() {
        return isElementPresent(navBarHomeLink);
    }

    public boolean isNavBarLoginLinkShown() {
        return isElementPresent(navBarLoginLink);
    }

    public boolean isNavBarProfileLinkShown(){
        return isElementPresent(navBarProfileLink);
    }

    public boolean isNavBarNewPostLinkShown(){
        return isElementPresent(navBarNewPostLink);
    }

    public boolean isNavBarSearchInputFieldShown(){
        return isElementPresent(navBarSearchInputField);
    }

    public boolean isNavBarSignOutButtonShown() {
        return isElementPresent(navBarSignOutButton);
    }
}