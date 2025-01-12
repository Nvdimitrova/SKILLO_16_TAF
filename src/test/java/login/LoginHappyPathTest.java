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
    private static final String TEST_USERNAME = "Nikol VD";
    private static final String TEST_PASSWORD = "EnteringMyPassword";
    private static final String SUCCESSFUL_SIGN_IN_MESSAGE = "Successful login!";
    private static final String SUCCESSFUL_SIGN_OUT_MESSAGE = "Successful logout!";

    @Test
    public void verifySuccessfulLoginWithValidCredentials() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page as a registered user (not signed in).");
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

        log.info("STEP 4: Provide valid user credentials.");
        loginPage.provideUserCredentials(TEST_USERNAME, TEST_PASSWORD);

        log.info("STEP 5: Verify the visibility of the 'Remember me' checkbox.");
        boolean isCheckboxVisible = loginPage.isRememberMeCheckboxShown();
        Assert.assertTrue(isCheckboxVisible, "'Remember me' checkbox is not visible.");

        log.info("STEP 5.1: Verify the 'Remember me' checkbox is clickable.");
        boolean isCheckBoxClickable = loginPage.isRememberMeCheckboxClickable();
        Assert.assertTrue(isCheckBoxClickable, "'Remember me' checkbox is not clickable.");

        log.info("STEP 5.2: Select the 'Remember me' checkbox.");
        loginPage.clickOnRememberMeCheckBox();

        log.info("STEP 6: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 6.1: Click the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 7: Verify successful Sign in message.");
        String actualLoginActionMessage = loginPage.getSignInActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, SUCCESSFUL_SIGN_IN_MESSAGE,
                "Successful Sign in message is incorrect!");

        log.info("STEP 8: Verify the user is redirected to the Home Page after signing in.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage,
                "User was not redirected to the Home Page!");

        log.info("STEP 9: Verify Profile link is visible.");
        boolean isProfileLinkVisible = homePage.isNavBarProfileLinkShown();
        Assert.assertTrue(isProfileLinkVisible, "Profile link is not visible!");

        log.info("STEP 10: Verify Sign out button is visible.");
        boolean isLogOutButtonVisible = homePage.isNavBarSignOutButtonShown();
        Assert.assertTrue(isLogOutButtonVisible, "Sign out button is not visible!");

        log.info("STEP 10.1: Verify Sign out button is clickable.");
        boolean isLogOutButtonClickable = homePage.isNavBarSignOutButtonClickable();
        Assert.assertTrue(isLogOutButtonClickable, "Sign out button is not clickable.");

        log.info("STEP 11: Click the Sign out button.");
        homePage.clickOnNavBarSignOutButton();

        log.info("STEP 11.1: Verify successful Sign out message.");
        String actualLogOutActionMessage = loginPage.getSignOutActionMessageText();
        Assert.assertEquals(actualLogOutActionMessage, SUCCESSFUL_SIGN_OUT_MESSAGE,
                "Successful Sign out message is incorrect!");

        log.info("STEP 12: Verify user is redirected back to Login Page.");
        boolean isUserRedirectedToSignInPage = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToSignInPage,
                "User was not redirected to the Login Page!");
    }
}