package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ProfilePage extends BasePage {
    final String PROFILE_PAGE_PATH = "/users/8864";

    @FindBy(tagName = "h4")
    private WebElement profileUsername;
    @FindBy(id = "upload-img")
    private WebElement uploadProfileImage;
    @FindBy(tagName = "app-post")
    private WebElement postImageDisplayed;

    @FindBy(css = "i.like.far.fa-heart.fa-2x.ng-star-inserted")
    private WebElement likeButton;
    @FindBy(css = "label.delete-ask")
    private WebElement deletePostButton;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement areYouSureYesButton;
    @FindBy(xpath = "//div[contains(@aria-label,'Post Deleted!')]")
    private WebElement confirmDeletionMessage;
    @FindBy(xpath = "//div[contains(@aria-label,'Post liked')]")
    private WebElement postLikeMessage;
    @FindBy(xpath = "//div[contains(@aria-label,'Post disliked')]")
    private WebElement postDislikeMessage;


    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfilePage() {
        navigateTo(PROFILE_PAGE_PATH);
    }

    public void uploadProfilePicture(File file) {
        uploadProfileImage.sendKeys(file.getAbsolutePath());
    }

    public void clickOnYesButton() {
        waitAndClickOnWebElement(areYouSureYesButton);
    }

    public void clickOnDeleteButton() {
        waitAndClickOnWebElement(deletePostButton);
    }

    public void clickOnLikeButton() {
        waitAndClickOnWebElement(likeButton);
    }

    public void dislikePost(){
        waitAndClickOnWebElement(likeButton);
    }

//    public void ClickOnDislikeButton() {
//        waitAndClickOnWebElement(dislikeButton);
//    }

    Actions action = new Actions(driver);
    public void HoverOverProfilePicture() {
        action.moveToElement(uploadProfileImage).perform();
    }

    public String getUsername() {
        String usernameText = profileUsername.getText();
        return usernameText;
    }

    public int getPostCount() {
        List<WebElement> posts = Collections.singletonList(wait.until(ExpectedConditions.visibilityOf(postImageDisplayed)));
        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = Collections.singletonList(wait.until(ExpectedConditions.visibilityOf(postImageDisplayed)));
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
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).perform();
            log.info("Post modal closed successfully using ESC key.");
        } catch (Exception e) {
            log.error("Failed to close the post modal using ESC key: " + e.getMessage());
        }
    }
}