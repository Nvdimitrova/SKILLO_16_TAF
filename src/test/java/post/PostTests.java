package post;

import base.BaseTest;
import com.nvd.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PostTests extends BaseTest {
    private static final String TEST_USERNAME = "Nikol VD";
    private static final String TEST_PASSWORD = "EnteringMyPassword";
    private static final String UPLOAD_FORM_HEADING = "Post a picture to share with your awesome followers";

    File postPicture = new File("src/test/resources/uploads/working_as_coded.png");

    @Test
    public void verifyUserCanUploadImage() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Navigate to the Login Page.");
        loginPage.navigateToLoginPage();

        log.info("STEP 2: Provide valid user credentials.");
        loginPage.provideUserCredentials(TEST_USERNAME, TEST_PASSWORD);

        log.info("STEP 3: Click on the 'Sign in' button.");
        loginPage.clickOnSignInButton();

        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 4: Verify navigation bar 'New Post' link visible.");
        boolean isProfileLinkVisible = homePage.isNavBarNewPostLinkShown();
        Assert.assertTrue(isProfileLinkVisible);

        log.info("STEP 4.1: Click on 'New Post' link.");
        homePage.clickOnNavBarNewPostLink();

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 5: Verify post picture form heading text.");
        String actualUploadFormHeaderText = postPage.getPostImageHeaderText();
        Assert.assertEquals(actualUploadFormHeaderText, UPLOAD_FORM_HEADING);

        log.info("STEP 6: Verify the 'Create post' button is visible");
        boolean isCreatePostButtonShown = postPage.isCreatePostButtonShown();
        Assert.assertTrue(isCreatePostButtonShown);

        log.info("STEP 7: Upload a picture for the new post.");
        postPage.uploadImage(postPicture);

        log.info("STEP 8: Add a caption to the post.");
        postPage.providePostCaption("Am I testing the code or is the code testing me...");

        log.info("STEP 9: Click the 'Create Post' button.");
        postPage.clickCreatePostButton();

        ProfilePage profilePage = new ProfilePage(super.driver, log);

        log.info("STEP 10: Verify the post count has increased.");
        boolean isMorePostShown = profilePage.getPostCount() > 0;
        Assert.assertTrue(isMorePostShown);

        log.info("STEP 11: Click on the first post in the profile.");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);

        log.info("STEP 12: Verify the uploaded image is visible in the post modal.");
        boolean isImageVisible = postModal.isImageVisible();
        Assert.assertTrue(isImageVisible);

        log.info("STEP 13: Verify the post was created by the same user.");
        String postUserTxt = postModal.getPostUser();
        Assert.assertEquals(postUserTxt, TEST_USERNAME);
    }
}