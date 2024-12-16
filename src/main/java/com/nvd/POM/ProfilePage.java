package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;

public class ProfilePage extends BasePage {
    public static final String PROFILE_PAGE_PATH = "/users/8864";

    @FindBy (xpath = "//*[@class='profile-image-source']")
    private WebElement profilePicture;
    @FindBy (css = ".profile-user-settings > h2")
    private WebElement profilePageUsername;
    @FindBy (css = "i.fa-user-edit")
    private WebElement modifyProfileInfo;
    @FindBy (xpath = "//li[contains(text(),'posts')]/strong")
    private WebElement profilePagePostsCount;
    @FindBy (xpath = "//li[contains(text(),'following')]/strong")
    private WebElement profilePageFollowingCount;


    @FindBy(css = "label.btn-all.btn.btn-primary.active")
    private WebElement profilePageAllRadioButton;
    @FindBy(css = "btn-public btn btn-primary active")
    private WebElement profilePagePublicRadioButton;
    @FindBy(css = "btn-private btn btn-primary active")
    private WebElement profilePagePrivateRadioButton;
    @FindBy(css = "far fa-plus-square fa-lg")
    private WebElement profilePageNewPostButton;

    @FindBy(id = "nav-link-new-post")
    private WebElement navBarNewPostLink;
    @FindBy(css = ".file[type='file']")
    private WebElement uploadPictureBrowseButton;


    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfilePage() {
        navigateTo(PROFILE_PAGE_PATH);
    }

    public void clickOnNavBarNewPostLink(){
        waitAndClickOnWebElement(navBarNewPostLink);
    }

    public void uploadPicture(File file){
        isElementPresent(uploadPictureBrowseButton);
        uploadPictureBrowseButton.sendKeys(file.getAbsolutePath());
    }


}