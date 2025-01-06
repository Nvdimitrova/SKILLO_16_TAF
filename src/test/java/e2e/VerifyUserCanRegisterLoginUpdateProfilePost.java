package e2e;

import base.BaseTest;
import com.nvd.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class VerifyUserCanRegisterLoginUpdateProfilePost extends BaseTest {
    private static final String TEST_USERNAME = "Nikol VD";
    private static final String TEST_PASSWORD = "EnteringMyPassword";
    private static final String CAPTION = "Testing the create post caption";

    File postPicture = new File("src/test/resources/uploads/kitty.jpg");

    @Test
    public void basicEndToEnd() throws InterruptedException {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page.");
        homePage.navigateToHomePage();

        log.info("STEP 2: Click on navigation bar Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 3: Provide valid user credentials and click on Sign in button.");
        loginPage.provideUserCredentials(TEST_USERNAME, TEST_PASSWORD);
        loginPage.clickOnSignInButton();

        log.info("STEP 4: Click on navigation bar New Post link.");
        homePage.clickOnNavBarNewPostLink();

        PostPage postPage = new PostPage(super.driver, log);

        log.info("STEP 5: Upload picture and provide caption.");
        postPage.uploadImage(postPicture);
        postPage.providePostCaption(CAPTION);

        log.info("STEP 6: Click on Create post button.");
        postPage.clickCreatePostButton();

        ProfilePage profilePage = new ProfilePage(super.driver, log);
        boolean isMorePostShown = profilePage.getPostCount() > 0;
        Assert.assertTrue(isMorePostShown);
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible(), "The image is not visible!");

        String postUserTxt = postModal.getPostUser();
        Assert.assertEquals(postUserTxt, TEST_USERNAME);
    }
}
