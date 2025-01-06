package login;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativePathTest extends BaseTest {
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String LOGIN_ERROR_MESSAGE = "Wrong username or password!";

    private static final String VALID_USERNAME = "Nikol VD";
    private static final String VALID_PASSWORD = "EnteringMyPassword";
    private static final String WRONG_USERNAME = "User...Name";
    private static final String WRONG_PASSWORD = "WrongPassword";

    private void navigateToLoginPageAndValidate() {
        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isURLLoaded(LOGIN_PAGE_PATH), "Login page URL validation failed.");
        Assert.assertEquals(loginPage.getLoginFormHeaderTitleText(), LOGIN_FORM_HEADER_TITLE, "Login form title mismatch.");
        Assert.assertTrue(loginPage.isLoginSubmitButtonShown(), "Login submit button is not visible.");
    }

    @Test
    public void verifyUnsuccessfulLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Open ISkillo Login page as a registered user (not signed in).");
        navigateToLoginPageAndValidate();

        log.info("STEP 2: Enter a valid username.");
        loginPage.provideUsername(WRONG_USERNAME);

        log.info("STEP 3: Enter an invalid password.");
        loginPage.providePassword(VALID_PASSWORD);

        log.info("STEP 4: Attempt to sign in by clicking the 'Sign in' button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 5: Verify the error message for invalid sign in credential.");
        String actualLoginActionMessage = loginPage.getLoginActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, LOGIN_ERROR_MESSAGE,
                "Error message for invalid credentials is incorrect.");

        log.info("STEP 6: Confirm the user remains on the Login Page.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage, "User did not remain on the Login Page.");
    }

    @Test
    public void verifyUserCannotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Open ISkillo Login page as a registered user (not signed in).");
        loginPage.navigateToLoginPage();

        log.info("STEP 1.1: Validate that the Login Page URL is correct.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("STEP 2: Validate the Login form header title.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3. Confirm the visibility of the login submit button.");
        boolean isLoginSubmitButtonShown = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isLoginSubmitButtonShown);

        log.info("STEP 4: Enter an invalid username.");
        loginPage.provideUsername(VALID_USERNAME);

        log.info("STEP 5: Enter a valid password.");
        loginPage.providePassword(WRONG_PASSWORD);

        log.info("STEP 6: Click on the 'Sign in' button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 7: Verify the error message for invalid sign in credential.");
        String actualLoginActionMessage = loginPage.getLoginActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, LOGIN_ERROR_MESSAGE,
                "Error message for invalid credentials is incorrect.");

        log.info("STEP 8: Confirm the user remains on the Login Page.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage, "User did not remain on the Login Page.");
    }

    @Test
    public void verifyUserCannotLoginWithEmptyCredentials() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Open ISkillo Login page as a registered user (not signed in).");
        loginPage.navigateToLoginPage();

        log.info("STEP 1.1: Validate that the Login Page URL is correct.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("STEP 2: Validate the Login form header title.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3. Confirm the visibility of the login submit button.");
        boolean isLoginSubmitButtonShown = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isLoginSubmitButtonShown);

        log.info("STEP 4: Enter an empty username.");
        loginPage.provideUsername("");

        log.info("STEP 5: Enter an empty password.");
        loginPage.providePassword("");

        log.info("STEP 6: Verify that the 'Sign in' button is not clickable due to empty credentials.");
        boolean isLoginSubmitButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertFalse(isLoginSubmitButtonClickable,
                "Sign in button is clickable despite empty credentials.");
    }
}