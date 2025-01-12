package login;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativePathTest extends BaseTest {
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String HOME_PAGE_PATH = "/posts/all";

    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String VALID_USERNAME = "Nikol VD";
    private static final String VALID_PASSWORD = "EnteringMyPassword";
    private static final String INVALID_USERNAME = "InvalidUsername";
    private static final String INVALID_PASSWORD = "InvalidPassword";
    private static final String EMPTY_USERNAME = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String CREDENTIALS_ERROR_MESSAGE = "Wrong username or password!";

    @Test(priority = 0)
    public void verifyUnsuccessfulLoginWithInvalidUsername() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page.");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page loaded successfully.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded, "Home Page failed to load!");

        log.info("STEP 1.2: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible,
                "Login link is not visible in the navigation bar.");

        log.info("STEP 1.3: Verify the Login link in the navigation bar is clickable.");
        boolean isLoginLinkClickable = homePage.isNavBarLoginLinkClickable();
        Assert.assertTrue(isLoginLinkClickable, "Login link is not clickable!");

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page loaded successfully.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded, "Login Page failed to load!");

        log.info("STEP 2.2: Verify that the Login form header title matches the expected value.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE,
                "Login form header title is incorrect!");

        log.info("STEP 3: Verify that the Sign in button is visible on the Login Page.");
        boolean isSignInButtonVisible = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isSignInButtonVisible,
                "Sign in button is not visible on the Login Page!");

        log.info("STEP 4: Enter an invalid username.");
        loginPage.provideUsername(INVALID_USERNAME);

        log.info("STEP 5: Enter a valid password.");
        loginPage.providePassword(VALID_PASSWORD);

        log.info("STEP 6: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 7: Attempt to login by clicking the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 8: Verify the error message for invalid credentials.");
        String actualLoginActionMessage = loginPage.getWrongCredentialsActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, CREDENTIALS_ERROR_MESSAGE,
                "Error message for invalid credentials is incorrect.");

        log.info("STEP 9: Ensure the user remains on the Login Page.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage,
                "User did not remain on the Login Page.");
    }

    @Test(priority = 1)
    public void verifyUserCannotLoginWithInvalidPassword() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page.");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page loaded successfully.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded, "Home Page failed to load!");

        log.info("STEP 1.2: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible,
                "Login link is not visible in the navigation bar.");

        log.info("STEP 1.3: Verify the Login link in the navigation bar is clickable.");
        boolean isLoginLinkClickable = homePage.isNavBarLoginLinkClickable();
        Assert.assertTrue(isLoginLinkClickable, "Login link is not clickable!");

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page loaded successfully.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded, "Login Page failed to load!");

        log.info("STEP 2.2: Verify that the Login form header title matches the expected value.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE,
                "Login form header title is incorrect!");

        log.info("STEP 3: Verify that the Sign in button is visible on the Login Page.");
        boolean isSignInButtonVisible = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isSignInButtonVisible,
                "Sign in button is not visible on the Login Page!");

        log.info("STEP 4: Enter a valid username.");
        loginPage.provideUsername(VALID_USERNAME);

        log.info("STEP 5: Enter an invalid password.");
        loginPage.providePassword(INVALID_PASSWORD);

        log.info("STEP 6: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 7: Attempt to login by clicking the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 8: Verify the error message for invalid credentials.");
        String actualLoginActionMessage = loginPage.getWrongCredentialsActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, CREDENTIALS_ERROR_MESSAGE,
                "Error message for invalid credentials is incorrect.");

        log.info("STEP 9: Ensure the user remains on the Login Page.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage,
                "User did not remain on the Login Page.");
    }

    @Test(priority = 3)
    public void verifyUserCannotLoginWithEmptyCredentials() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page.");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page loaded successfully.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded, "Home Page failed to load!");

        log.info("STEP 1.2: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible,
                "Login link is not visible in the navigation bar.");

        log.info("STEP 1.3: Verify the Login link in the navigation bar is clickable.");
        boolean isLoginLinkClickable = homePage.isNavBarLoginLinkClickable();
        Assert.assertTrue(isLoginLinkClickable, "Login link is not clickable!");

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page loaded successfully.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded, "Login Page failed to load!");

        log.info("STEP 2.2: Verify that the Login form header title matches the expected value.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE,
                "Login form header title is incorrect!");

        log.info("STEP 3: Verify that the Sign in button is visible on the Login Page.");
        boolean isSignInButtonVisible = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isSignInButtonVisible,
                "Sign in button is not visible on the Login Page!");

        log.info("STEP 4: Leave the username field empty.");
        loginPage.provideUsername(EMPTY_USERNAME);

        log.info("STEP 5: Leave the password field empty.");
        loginPage.providePassword(EMPTY_PASSWORD);

        log.info("STEP 6: Verify that the Sign in button is disabled due to empty credentials.");
        boolean isLoginSubmitButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertFalse(isLoginSubmitButtonClickable,
                "The Sign in button is enabled despite empty credentials.");
    }
}