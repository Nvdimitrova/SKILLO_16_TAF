package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class ProfilePage extends BasePage {
    public static final String PROFILE_PAGE_PATH = "/users/8864";

    @FindBy(xpath = "//*[@class='profile-image-source']")
    private WebElement profilePicture;
    @FindBy(css = ".profile-user-settings > h2")
    private WebElement profilePageUsername;
    @FindBy(css = "i.fa-user-edit")
    private WebElement modifyProfileInfo;
    @FindBy(xpath = "//li[contains(text(),'posts')]/strong")
    private WebElement profilePagePostsCount;
    @FindBy(xpath = "//li[contains(text(),'following')]/strong")
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

    @FindBy(xpath = "//div[contains(@class,'edit-profile-pic ')]")
    private WebElement uploadImage;
    @FindBy(id = "upload-img")
    private WebElement hiddenUploadImage;
    @FindBy(xpath = "//i[contains(@class,'like far fa-heart fa-2x')]")
    private WebElement likeButton;
    @FindBy(xpath = "//i[contains(@class,'ml-4 far fa-thumbs-down fa-2x')]")
    private WebElement dislikeButton;
    @FindBy(xpath = "//label[contains(@class,'delete-ask')]")
    private WebElement deletePostButton;
    @FindBy(xpath = "//button[contains(@class,'btn btn-primary btn-sm')]")
    private WebElement areYouSureYesButton;
    @FindBy(xpath = "//div[contains(@aria-label,'Post Deleted!')]")
    private WebElement confirmDeletionMessage;
    @FindBy(xpath = "//div[contains(@aria-label,'Post liked')]")
    private WebElement postLikeMessage;
    @FindBy(xpath = "//div[contains(@aria-label,'Post disliked')]")
    private WebElement postDislikeMessage;


    public ProfilePage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public void navigateToProfilePage() {
        navigateTo(PROFILE_PAGE_PATH);
    }

    public void clickOnNavBarNewPostLink() {
        waitAndClickOnWebElement(navBarNewPostLink);
    }

    public void uploadPicture(File file) {
        isElementPresent(uploadPictureBrowseButton);
        uploadPictureBrowseButton.sendKeys(file.getAbsolutePath());
    }

    public void ClickOnYesButton() {
        waitAndClickOnWebElement(areYouSureYesButton);
    }

    public void ClickOnDeleteButton() {
        waitAndClickOnWebElement(deletePostButton);
    }

    public void ClickOnLikeButton() {
        waitAndClickOnWebElement(likeButton);
    }

    public void ClickOnDisikeButton() {
        waitAndClickOnWebElement(dislikeButton);
    }

    Actions action = new Actions(driver);

    public void HoverOverProfilePicture() {
        action.moveToElement(uploadImage).perform();
    }

    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }

    public int getPostCount() {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public boolean isDeletedMessageVisible() {
        boolean isDeletedMessageVisible = false;
        try {
            isDeletedMessageVisible = wait.until(ExpectedConditions.visibilityOf(confirmDeletionMessage)).isDisplayed();
            log.info("CONFIRMATION # The Post Deleted! message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("ERROR : The Post Deleted! message is not displayed!");
            isDeletedMessageVisible = false;
        }
        return isDeletedMessageVisible;
    }

    public boolean isLikeMessageVisible() {
        boolean isLikeMessageVisible = false;
        try {
            isLikeMessageVisible = wait.until(ExpectedConditions.visibilityOf(postLikeMessage)).isDisplayed();
            log.info("CONFIRMATION # The Post liked message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("ERROR : The Post liked message is not displayed!");
            isLikeMessageVisible = false;
        }
        return isLikeMessageVisible;
    }

    public boolean isDislikeMessageVisible() {
        boolean isDislikeMessageVisible = false;
        try {
            isDislikeMessageVisible = wait.until(ExpectedConditions.visibilityOf(postDislikeMessage)).isDisplayed();
            log.info("CONFIRMATION # The Post disliked message is displayed.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("ERROR : The Post disliked message is not displayed!");
            isDislikeMessageVisible = false;
        }
        return isDislikeMessageVisible;
    }


    public void closePostModal() {


    }


}