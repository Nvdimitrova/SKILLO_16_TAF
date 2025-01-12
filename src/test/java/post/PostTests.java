package post;

import base.BaseTest;
import com.nvd.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PostTests extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String NEW_POST_PAGE_PATH = "/posts/create";

    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String SUCCESSFUL_SIGN_IN_MESSAGE = "Successful login!";

    private static final String TEST_USERNAME = "Nikol VD";
    private static final String TEST_PASSWORD = "EnteringMyPassword";

    private static final String UPLOAD_FORM_HEADING = "Post a picture to share with your awesome followers";
    private static final String POST_CAPTION = "Testing the create post caption";
    private static final String FILE_NAME = "software_testing";
    private static final String SUCCESSFUL_POST_UPLOAD_MESSAGE = "Post created!";

    File postPicture = new File("src/test/resources/uploads/software_testing.jpg");

    @Test(priority = 0)
    public void verifyUserCanUploadImage() {
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

        log.info("STEP 5: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 5.1: Click the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 6: Verify successful Sign in message.");
        String actualLoginActionMessage = loginPage.getSignInActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, SUCCESSFUL_SIGN_IN_MESSAGE,
                "Successful Sign in message is incorrect!");

        log.info("STEP 7: Verify the user is redirected to the Home Page after signing in.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage,
                "User was not redirected to the Home Page!");

        log.info("STEP 8: Verify the New Post link is visible in the navigation bar.");
        boolean isNewPostLinkVisible = homePage.isNavBarNewPostLinkShown();
        Assert.assertTrue(isNewPostLinkVisible,
                "New Post link is not visible in the navigation bar!");

        log.info("STEP 8.1: Verify the New Post link is clickable.");
        boolean isNewPostLinkClickable = homePage.isNavBarNewPostLinkClickable();
        Assert.assertTrue(isNewPostLinkClickable,
                "New Post link is not clickable!");

        log.info("STEP 8.2: Click on the New Post link.");
        homePage.clickOnNavBarNewPostLink();

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 9: Verify user is redirected to New Post Page.");
        boolean isNewPostPageLoaded = postPage.isURLLoaded(NEW_POST_PAGE_PATH);
        Assert.assertTrue(isNewPostPageLoaded, "New Post Page failed to load!");

        log.info("STEP 9.1: Verify the post picture form heading text is correct.");
        String actualUploadFormHeaderText = postPage.getPostImageHeaderText();
        Assert.assertEquals(actualUploadFormHeaderText, UPLOAD_FORM_HEADING,
                "Post picture form heading text is incorrect!");

        log.info("STEP 10: Verify the Create post button is visible.");
        boolean isCreatePostButtonShown = postPage.isCreatePostButtonShown();
        Assert.assertTrue(isCreatePostButtonShown,
                "'Create post' button is not visible!");

        log.info("STEP 11: Upload a picture for the new post.");
        postPage.uploadImage(postPicture);

        log.info("STEP 11.1: Verify the uploaded image is visible.");
        boolean isImageShown = postPage.isImageVisible();
        Assert.assertTrue(isImageShown, "Uploaded image is not visible!");

        log.info("STEP 11.2: Verify the uploaded file name is correct.");
        String actualFileName = postPage.getFileName();
        Assert.assertTrue(actualFileName.contains(FILE_NAME),
                "Uploaded file name is incorrect!");

        log.info("STEP 12: Add a caption to the post.");
        postPage.providePostCaption(POST_CAPTION);

        log.info("STEP 13: Verify the Create Post button is clickable.");
        boolean isCreatePostButtonClickable = postPage.isCreatePostButtonClickable();
        Assert.assertTrue(isCreatePostButtonClickable,
                "The Create Post button is not clickable!");

        log.info("STEP 13.1: Click on the Create Post button to submit the post.");
        postPage.clickCreatePostButton();

        log.info("STEP 13.2: Verify successful post upload message.");
        String actualProfilePictureUploadMessage = postPage.getUploadActionMessage();
        Assert.assertEquals(actualProfilePictureUploadMessage, SUCCESSFUL_POST_UPLOAD_MESSAGE,
                "Success message for post upload is incorrect!");

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 14: Verify the user's post count has increased.");
        boolean isPostCountIncreased = profilePage.getPostCount() > 0;
        Assert.assertTrue(isPostCountIncreased,
                "Post count did not increase after creating a post!");

        log.info("STEP 15: Click on the first post in the profile.");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);

        log.info("STEP 15.1: Verify the uploaded image is visible in the post modal.");
        boolean isImageVisible = postModal.isImageShown();
        Assert.assertTrue(isImageVisible,
                "Uploaded image is not visible in the post modal!");

        log.info("STEP 15.2: Verify the post was created by the signed-in user.");
        String postUsername = postModal.getPostUser();
        Assert.assertEquals(postUsername, TEST_USERNAME,
                "Post creator username does not match the signed-in user!");

        log.info("STEP 15.3: Close the post modal using 'Esc' (Escape) key.");
        profilePage.closePostModal();
    }

    @Test(priority = 1)
    public void verifyUserCanDeletePost() {
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

        log.info("STEP 5: Verify the Sign in button is clickable.");
        boolean isSignInButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertTrue(isSignInButtonClickable, "Sign in button is not clickable.");

        log.info("STEP 5.1: Click the Sign in button.");
        loginPage.clickOnSignInButton();

        log.info("STEP 6: Verify successful Sign in message.");
        String actualLoginActionMessage = loginPage.getSignInActionMessageText();
        Assert.assertEquals(actualLoginActionMessage, SUCCESSFUL_SIGN_IN_MESSAGE,
                "Successful Sign in message is incorrect!");

        log.info("STEP 7: Verify the user is redirected to the Home Page after signing in.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage,
                "User was not redirected to the Home Page!");

        log.info("STEP 8: Verify Profile link in the navigation bar is visible.");
        boolean isProfileLinkVisible = homePage.isNavBarProfileLinkShown();
        Assert.assertTrue(isProfileLinkVisible,
                "Profile link is not visible in the navigation bar!");

        log.info("STEP 8.1: Verify Profile link is clickable.");
        boolean isProfileLinkClickable = homePage.isNavBarProfileLinkClickable();
        Assert.assertTrue(isProfileLinkClickable, "Profile link is not clickable!");

        log.info("STEP 8.2: Navigate to the Profile Page by clicking on the Profile link.");
        homePage.clickOnNavBarProfileLink();

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 9: Click on the first post in the profile. ");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);

        log.info("STEP 10: Verify the image is visible in the post modal.");
        boolean isImageVisible = postModal.isImageShown();
        Assert.assertTrue(isImageVisible,
                "The image is not visible in the post modal!");

        log.info("STEP 11: Verify Delete post button is visible.");
        boolean isDeletePostButtonVisible = profilePage.isDeletePostButtonShown();
        Assert.assertTrue(isDeletePostButtonVisible,
                "Delete post button is not visible!");

        log.info("STEP 11.1: Verify Delete post button is clickable.");
        boolean isDeletePostButtonClickable = profilePage.isDeletePostButtonClickable();
        Assert.assertTrue(isDeletePostButtonClickable,
                "Delete post button is not clickable!");

        log.info("STEP 11.2: Click on Delete post button.");
        profilePage.clickOnDeletePostButton();

        log.info("STEP 12: Verify 'Are you sure?' - Yes button is visible.");
        boolean isAreYouSureYesButtonVisible = profilePage.isAreYouSureYesButtonShown();
        Assert.assertTrue(isAreYouSureYesButtonVisible,
                "'Are you sure?' - Yes button is not visible!");

        log.info("STEP 12.1: Verify 'Are you sure?' - Yes button is clickable.");
        boolean isAreYouSureYesButtonClickable = profilePage.isAreYouSureYesButtonShown();
        Assert.assertTrue(isAreYouSureYesButtonClickable,
                "'Are you sure?' - Yes button is not clickable!");

        log.info("STEP 12.2: Click on Yes button.");
        profilePage.clickOnYesButton();

        log.info("STEP 13: Verify successful delete post message");
        profilePage.isDeletedMessageVisible();
    }
}