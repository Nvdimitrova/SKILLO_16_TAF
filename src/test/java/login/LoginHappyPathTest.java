package login;

import base.BaseTest;

import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginHappyPathTest extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String SUCCESSFUL_LOGIN_MESSAGE = "Successful login!";

    private static final String REGISTERED_USER_USERNAME = "Nikol VD";
    private static final String REGISTERED_USER_PASSWORD = "EnteringMyPassword";

    @Test
    public void verifySuccessfulLoginWithValidCredentials() {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Open the ISkillo Home Page as a registered user (not signed in).");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page loaded successfully.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded);

        //not so important check!!!!
        log.info("STEP 1.2: Verify that the Home Page icon is visible.");
        boolean isHomePageIconVisible = homePage.isHomeIconShown();
        Assert.assertTrue(isHomePageIconVisible);

        log.info("STEP 1.2: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible);

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page loaded successfully.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("STEP 2.2: Verify that the Login form header title matches the expected value.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3. Verify the login submit button is visible.");
        boolean isLoginSubmitButtonShown = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isLoginSubmitButtonShown);

        log.info("STEP 4: Enter a valid username.");
        loginPage.provideUsername(REGISTERED_USER_USERNAME);

        log.info("STEP 5: Enter a valid password.");
        loginPage.providePassword(REGISTERED_USER_PASSWORD);

        log.info("STEP 6: Select the 'Remember me' checkbox.");
        loginPage.clickOnRememberMeCheckBox();

        log.info("STEP 7: Click the 'Submit' button to attempt signing in.");
        loginPage.clickOnSignInButton();

        log.info("STEP 8: Verify successful Sign in message is displayed.");
        String actualLoginActionMessage = loginPage.getLoginActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, SUCCESSFUL_LOGIN_MESSAGE);

        log.info("STEP 9: Verify the user is redirected to the Home Page after signing in.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage);

        log.info("STEP 10: Verify Profile link is visible.");
        boolean isProfileLinkVisible = homePage.isNavBarProfileLinkShown();
        Assert.assertTrue(isProfileLinkVisible);

        log.info("STEP 11: Verify sign out button is visible.");
        boolean isLogOutButtonVisible = homePage.isNavBarSignOutButtonShown();
        Assert.assertTrue(isLogOutButtonVisible);

        log.info("STEP 12: Click on the sign out button.");
        homePage.clickOnNavBarSignOutButton();

        log.info("STEP 13: Verify Profile link is not visible");
        boolean isProfileLinkShown = homePage.isNavBarProfileLinkShown();
        Assert.assertFalse(isProfileLinkShown);
    }
}