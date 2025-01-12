package e2e;

import base.BaseTest;
import com.nvd.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.regData.RegistrationDataGenerator;

import java.io.File;

public class VerifyUserCanRegisterLoginUpdateProfilePost extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String REGISTRATION_PAGE_PATH = "/users/register";
    private static final String NEW_POST_PAGE_PATH = "/posts/create";

    private static final String REGISTRATION_FORM_HEADER_TITLE = "Sign up";
    private static final String USERNAME = RegistrationDataGenerator.createUsername();
    private static final String EMAIL = RegistrationDataGenerator.createEmail();
    private static final String PASSWORD = RegistrationDataGenerator.createPassword();
    private static final String BIRTHDATE = "07012000";
    private static final String PUBLIC_INFO = "Testing Public Info field";

    private static final String UPLOAD_FORM_HEADING = "Post a picture to share with your awesome followers";
    private static final String POST_CAPTION = "Am I testing the code or is the code testing me...";

    private static final String SUCCESSFUL_REGISTRATION_MESSAGE = "Successful register!";
    private static final String SUCCESSFUL_POST_UPLOAD_MESSAGE = "Post created!";
    private static final String SUCCESSFUL_PROFILE_IMAGE_UPLOAD_MESSAGE = "Profile picture updated";

    File postPicture = new File("src/test/resources/uploads/working_as_coded.jpg");
    File profilePicture = new File("src/test/resources/uploads/profile_picture.jpg");

    @Test
    public void verifyEndToEndUserJourney() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Navigate to the ISkillo Home Page as a guest user.");
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

        log.info("STEP 3: Verify the Register link is visible on the Login Page.");
        boolean isRegisterLinkVisible = loginPage.isRegisterLinkShown();
        Assert.assertTrue(isRegisterLinkVisible,
                "Register link is not visible on the Login page.");

        log.info("STEP 3.1: Verify the Register link is clickable.");
        boolean isRegisterLinkClickable = loginPage.isRegisterLinkClickable();
        Assert.assertTrue(isRegisterLinkClickable,
                "Register link is not clickable.");

        log.info("STEP 4: Navigate to the Registration Page via the Register link.");
        loginPage.clickOnRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 5: Verify the Registration Page loaded successfully.");
        boolean isRegistrationPageLoaded = registrationPage.isURLLoaded(REGISTRATION_PAGE_PATH);
        Assert.assertTrue(isRegistrationPageLoaded,
                "Registration Page failed to load!");

        log.info("STEP 5.1: Verify the Registration form header title matches the expected value.");
        String actualRegistrationFormHeaderTitle = registrationPage.getRegistrationFormHeaderTitleText();
        Assert.assertEquals(actualRegistrationFormHeaderTitle, REGISTRATION_FORM_HEADER_TITLE,
                "Registration form header title is incorrect.");

        log.info("STEP 5.2: Verify Registration form submit button is visible.");
        boolean isRegSubmitButtonVisible = registrationPage.isRegistrationSubmitButtonShown();
        Assert.assertTrue(isRegSubmitButtonVisible,
                "Registration form submit button is not visible!");

        log.info("STEP 6: Complete the registration form with valid user credentials.");
        registrationPage.provideUserCredentials(USERNAME, EMAIL, BIRTHDATE, PASSWORD, PASSWORD, PUBLIC_INFO);

        log.info("STEP 7: Verify Registration form submit button is clickable.");
        boolean isRegSubmitButtonClickable = registrationPage.isRegistrationSubmitButtonClickable();
        Assert.assertTrue(isRegSubmitButtonClickable,
                "Registration submit button is not clickable!");

        log.info("STEP 7.1: Submit the Registration form.");
        registrationPage.clickOnRegistrationFormSubmitButton();

        log.info("STEP 8: Verify successful registration message.");
        String actualRegisterActionMessage = registrationPage.getActionMessageText();
        Assert.assertEquals(actualRegisterActionMessage, SUCCESSFUL_REGISTRATION_MESSAGE,
                "Registration message is incorrect.");

        log.info("STEP 9: Verify that the user is redirected to Home Page after registration.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage,
                "User was not redirected to the Home Page after registration.");

        log.info("STEP 10: Verify the New Post link in the navigation bar is visible.");
        boolean isNewPostLinkVisible = homePage.isNavBarNewPostLinkShown();
        Assert.assertTrue(isNewPostLinkVisible,
                "New Post link is not visible in the navigation bar.");

        log.info("STEP 10.1: Verify New Post link is clickable.");
        boolean isNewPostLinkClickable = homePage.isNavBarNewPostLinkClickable();
        Assert.assertTrue(isNewPostLinkClickable, "New Post link is not clickable!");

        log.info("STEP 11: Click on the New Post link.");
        homePage.clickOnNavBarNewPostLink();

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 12: Verify New Post Page loaded successfully.");
        boolean isNewPostPageLoaded = postPage.isURLLoaded(NEW_POST_PAGE_PATH);
        Assert.assertTrue(isNewPostPageLoaded, "New Post Page failed to load!");

        log.info("STEP 12.1: Verify the post picture form heading text is correct.");
        String actualUploadFormHeaderText = postPage.getPostImageHeaderText();
        Assert.assertEquals(actualUploadFormHeaderText, UPLOAD_FORM_HEADING,
                "Post picture form heading text is incorrect!");

        log.info("STEP 13: Verify the Create Post button is visible.");
        boolean isCreatePostButtonVisible = postPage.isCreatePostButtonShown();
        Assert.assertTrue(isCreatePostButtonVisible,
                "The 'Create Post' button is not visible on the New Post Page.");

        log.info("STEP 14: Upload a picture and provide a caption.");
        postPage.uploadImage(postPicture);
        postPage.providePostCaption(POST_CAPTION);

        log.info("STEP 15: Verify the Create Post button is clickable.");
        boolean isCreatePostButtonClickable = postPage.isCreatePostButtonClickable();
        Assert.assertTrue(isCreatePostButtonClickable,
                "The Create Post button is not clickable!");

        log.info("STEP 15.1: Click on the Create Post button to submit the post.");
        postPage.clickCreatePostButton();

        log.info("STEP 13.2: Verify successful post upload message.");
        String actualProfilePictureUploadMessage = postPage.getUploadActionMessage();
        Assert.assertEquals(actualProfilePictureUploadMessage, SUCCESSFUL_POST_UPLOAD_MESSAGE,
                "Success message for post upload is incorrect!");

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 16: Verify that the post is successfully created and visible.");
        boolean isPostCreated = profilePage.getPostCount() > 0;
        Assert.assertTrue(isPostCreated);

        log.info("STEP 17: Validate the post details.");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);

        log.info("STEP 17.1: Verify that the post image is visible.");
        boolean isImageVisible = postModal.isImageShown();
        Assert.assertTrue(isImageVisible);

        log.info("STEP 17.2: Verify that the post belongs to the correct user.");
        String postUserTxt = postModal.getPostUser();
        Assert.assertEquals(postUserTxt, USERNAME);

        log.info("STEP 17.3: Close the post modal using 'Esc' (Escape) key.");
        profilePage.closePostModal();

        log.info("STEP 18: Update the user's profile picture.");
        profilePage.uploadProfilePicture(profilePicture);

        log.info("STEP 19: Verify successful profile picture upload message.");
        String actualPostUploadMessage = profilePage.getUploadActionMessage();
        Assert.assertEquals(actualPostUploadMessage, SUCCESSFUL_PROFILE_IMAGE_UPLOAD_MESSAGE,
                "Success message for profile picture upload is incorrect!");

        log.info("STEP 20: Verify profile picture is visible.");
        boolean isProfilePictureVisible = profilePage.isProfileImageVisible();
        Assert.assertTrue(isProfilePictureVisible, "Profile picture is not visible!");
    }
}