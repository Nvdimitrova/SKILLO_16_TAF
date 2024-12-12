package com.nvd.POM;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
    //constants
    public static final String HOME_PAGE_URL = "/posts/all";

    //2.UI Map
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
    @FindBy (xpath = "//i[contains(@class,'fas fa-sign-out-alt fa-lg')]")
    private WebElement navBarLogOutButton;


    //3. constructor
    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    //3.1. navigation
    public void openHomePage() {
        navigateTo(HOME_PAGE_URL);
    }

    //4.User actions

    public void clickOnNavBarLogin () {
        wait.until(ExpectedConditions.visibilityOf(navBarLoginLink));
        navBarLoginLink.click();
    }

    //5.Support methods - getText IsShown

    public boolean isNavHomeShown() {
        return  isPresented(navBarHomeLink);
    }

    public boolean isNavLoginShown() {
        return isPresented(navBarLoginLink);
    }

    //6.Verifications

}