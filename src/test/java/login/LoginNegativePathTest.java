package login;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativePathTest extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String LOGIN_ERROR_MESSAGE = "Wrong username or password!";

    private static final String VALID_USERNAME = "Nikol VD";
    private static final String VALID_PASSWORD = "EnteringMyPassword";
    private static final String WRONG_USERNAME = "User...Name";
    private static final String WRONG_PASSWORD = "StupidPassword";

    @Test
    public void verifyUserCannotLoginWithInvalidPassword() {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Open the ISkillo Home Page as a registered user (not signed in).");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page URL is correct.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded);

        log.info("STEP 1.2: Verify Home Page icon is visible.");
        boolean isHomePageIconVisible = homePage.isHomeIconShown();
        Assert.assertTrue(isHomePageIconVisible);

        log.info("STEP 1.3: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible);

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page URL is correct.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("STEP 2.2: Verify the Login form header title is correct.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3: Enter a valid username.");
        loginPage.provideUsername(VALID_USERNAME);

        log.info("STEP 4: Enter an INVALID password.");
        loginPage.providePassword(WRONG_PASSWORD);

        log.info("STEP 5: Select the 'Remember me' checkbox.");
        loginPage.clickOnRememberMeCheckBox();

        log.info("STEP 6: Click the 'Submit' button to attempt signing in.");
        loginPage.clickOnSignInButton();

        log.info("STEP 7: Verify the ERROR message for unsuccessful sign in.");
        String actualLoginActionMessage = loginPage.getLoginActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, LOGIN_ERROR_MESSAGE);

        log.info("STEP 8: Verify that the user remains on the Login Page after unsuccessful sign in.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage);
    }

    @Test
    public void verifyUserCannotLoginWithInvalidUsername() {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Open the ISkillo Home Page as a registered user (not signed in).");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page URL is correct.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded);

        log.info("STEP 1.2: Verify Home Page icon is visible.");
        boolean isHomePageIconVisible = homePage.isHomeIconShown();
        Assert.assertTrue(isHomePageIconVisible);

        log.info("STEP 1.3: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible);

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page URL is correct.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("STEP 2.2: Verify the Login form header title is correct.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3: Enter an INVALID username.");
        loginPage.provideUsername(WRONG_USERNAME);

        log.info("STEP 4: Enter a valid password.");
        loginPage.providePassword(VALID_PASSWORD);

        log.info("STEP 5: Select the 'Remember me' checkbox.");
        loginPage.clickOnRememberMeCheckBox();

        log.info("STEP 6: Click the 'Submit' button to attempt signing in.");
        loginPage.clickOnSignInButton();

        log.info("STEP 7: Verify the ERROR message for unsuccessful sign in.");
        String actualLoginActionMessage = loginPage.getLoginActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, LOGIN_ERROR_MESSAGE);

        log.info("STEP 8: Verify that the user remains on the Login Page after unsuccessful Sign in.");
        boolean isUserStillOnLoginPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserStillOnLoginPage);
    }
}
