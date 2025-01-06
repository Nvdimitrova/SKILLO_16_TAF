package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends BasePage {
    @FindBy (className = "post-modal")
    private WebElement postModalWindow;
    @FindBy (css = ".post-modal-img img")
    private WebElement postModalImage;
    @FindBy (className = "post-user")
    private WebElement postProfileUsername;

    public PostModal(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public boolean isImageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(postModalImage)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPostUser() {
        wait.until(ExpectedConditions.visibilityOf(postProfileUsername));
        return postProfileUsername.getText();
    }
}
