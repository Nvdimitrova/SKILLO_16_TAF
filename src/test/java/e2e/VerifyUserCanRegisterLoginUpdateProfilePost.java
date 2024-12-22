package e2e;

import base.BaseTest;
import com.nvd.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class VerifyUserCanRegisterLoginUpdateProfilePost extends BaseTest {

    @Test
    public void basicEndToEnd() throws InterruptedException {
        String testUser = "Nikol VD";
        String testPassword = "EnteringMyPassword";
        File postPicture = new File("src/test/resources/upload/kitty.jpg");
        String caption = "Testing the create post caption";

        HomePage homePage = new HomePage(super.driver, log);
        homePage.navigateToHomePage();
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.provideUsername(testUser);
        loginPage.providePassword(testPassword);
        loginPage.clickOnSignInButton();

        homePage.clickOnNavBarNewPostLink();
        PostPage postPage = new PostPage(super.driver, log);

        postPage.uploadPicture(postPicture);

        postPage.providePostCaption(caption);
        postPage.clickCreatePostButton();

        ProfilePage profilePage = new ProfilePage(super.driver,log);
        boolean isMorePostShown = profilePage.getPostCount() > 0;
        Assert.assertTrue(isMorePostShown);
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(super.driver, log);
        Assert.assertTrue(postModal.isImageVisible(), "The image is not visible!");

        String postUserTxt = postModal.getPostUser();
        Assert.assertEquals(postUserTxt, testUser);
    }
}
