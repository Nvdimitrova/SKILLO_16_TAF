package com.nvd.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends BasePage {
    private final WebElement postModalWindow;

    @FindBy(css = ".post-modal-img img")
    private WebElement postModalImage;
    @FindBy(className = "post-user")
    private WebElement postProfileUsername;

    public PostModal(WebDriver driver, Logger log) {
        super(driver, log);
        this.postModalWindow = driver.findElement(By.className("post-modal"));
        PageFactory.initElements(driver, this);
    }

    public String getPostUser() {
        wait.until(ExpectedConditions.visibilityOf(postProfileUsername));
        return postProfileUsername.getText();
    }

    public boolean isImageShown() {
        try {
            boolean isVisible = wait.until(ExpectedConditions.visibilityOf(postModalImage)).isDisplayed();
            log.info("CONFIRM # The image is visible.");
            return isVisible;
        } catch (NoSuchElementException e) {
            log.error("ERROR : The image is not visible.");
            return false;
        }
    }
}