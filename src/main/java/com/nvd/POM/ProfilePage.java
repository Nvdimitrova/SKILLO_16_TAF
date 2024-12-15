package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    public static final String PROFILE_PAGE_PATH = "/users/8864";

    @FindBy(css = "label.btn-all.btn.btn-primary.active")
    private WebElement profileAllRadioButton;
    @FindBy(css = "btn-public btn btn-primary active")
    private WebElement profilePublicRadioButton;
    @FindBy(css = "btn-private btn btn-primary active")
    private WebElement profilePrivateRadioButton;
    @FindBy(css = "new-post-btn btn btn-primary ng-star-inserted")
    private WebElement profileNewPostButtonText;
    @FindBy(css = "far fa-plus-square fa-lg")
    private WebElement profileNewPostButton;


    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfilePage() {
        navigateTo(PROFILE_PAGE_PATH);
    }

    public void clickOnNewPostButton() {
        isElementPresent(profileNewPostButton);
        waitAndClickOnWebElement(profileNewPostButton);
    }
}