package profile;

import base.BaseTest;
import com.nvd.POM.LoginPage;
import com.nvd.POM.ProfilePage;
import org.testng.annotations.Test;

import java.io.File;

public class CreatePost extends BaseTest {

    @Test
    public void testUserCanUploadImage() throws InterruptedException {
        File postPictureWithKitty = new File("C:\\Users\\Nikol\\IdeaProjects\\SKILLO_AT_16_TAF\\src\\test\\resources\\kitty.jpg");

        LoginPage loginPage = new LoginPage(super.driver, log);
        loginPage.navigateToLoginPage();
        loginPage.provideUsername("Nikol VD");
        loginPage.providePassword("EnteringMyPassword");
        loginPage.clickOnSignInButton();

        ProfilePage profilePage = new ProfilePage(super.driver, log);
        profilePage.clickOnNavBarNewPostLink();
        profilePage.uploadPicture(postPictureWithKitty);

        Thread.sleep(555);
    }
}