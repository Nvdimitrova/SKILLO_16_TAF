package profile;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import com.nvd.POM.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadProfilePicture extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String PROFILE_PAGE_PATH = "/users/8864";

    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String SUCCESSFUL_SIGN_IN_MESSAGE = "Successful login!";

    private static final String TEST_USERNAME = "Nikol VD";
    private static final String TEST_PASSWORD = "EnteringMyPassword";

    private static final String SUCCESSFUL_UPLOAD_MESSAGE = "Profile picture updated";

    File profilePicture = new File("src/test/resources/uploads/profile_picture.jpg");

    @Test
    public void verifyUserCanUploadProfileImage() {
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

        log.info("STEP 3. Verify that the Sign in button is visible.");
        boolean isSignInButtonVisible = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isSignInButtonVisible,
                "Sign in button is not visible!");

        log.info("STEP 4: Provide valid user credentials.");
        loginPage.provideUserCredentials(TEST_USERNAME, TEST_PASSWORD);

        log.info("STEP 5: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 5.1: Click the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 6: Verify successful Sign in message is displayed.");
        String actualLoginActionMessage = loginPage.getSignInActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, SUCCESSFUL_SIGN_IN_MESSAGE,
                "Successful Sign in message is not displayed!");

        log.info("STEP 7: Verify Profile link in the navigation bar is visible.");
        boolean isProfileLinkVisible = homePage.isNavBarProfileLinkShown();
        Assert.assertTrue(isProfileLinkVisible,
                "Profile link is not visible in the navigation bar!");

        log.info("STEP 7.1: Verify Profile link is clickable.");
        boolean isProfileLinkClickable = homePage.isNavBarProfileLinkClickable();
        Assert.assertTrue(isProfileLinkClickable, "Profile link is not clickable!");

        log.info("STEP 7.2: Navigate to the Profile Page by clicking on the Profile link.");
        homePage.clickOnNavBarProfileLink();

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 8: Verify the Profile Page loaded successfully.");
        boolean isProfilePageLoaded = loginPage.isURLLoaded(PROFILE_PAGE_PATH);
        Assert.assertTrue(isProfilePageLoaded, "Profile Page failed to load!");

        log.info("STEP 8.1: Verify the Profile Page username.");
        String actualUsername = profilePage.getUsername();
        Assert.assertEquals(actualUsername, TEST_USERNAME, "Username does not match!");

        log.info("STEP 9: Upload a profile picture.");
        profilePage.uploadProfilePicture(profilePicture);

        log.info("STEP 10: Verify successful profile picture upload message.");
        String actualProfilePictureUploadMessage = profilePage.getUploadActionMessage();
        Assert.assertEquals(actualProfilePictureUploadMessage, SUCCESSFUL_UPLOAD_MESSAGE,
                "Success message for profile picture upload is incorrect!");

        log.info("STEP 11: Verify profile picture is visible.");
        boolean isProfilePictureVisible = profilePage.isProfileImageVisible();
        Assert.assertTrue(isProfilePictureVisible, "Profile picture is not visible!");
    }
}