package login;

import base.BaseTest;

import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginHappyPathsTest extends BaseTest {

    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    public static final String SUCCESSFUL_LOGIN_MESSAGE = "Successful login!";
    public static final String UNSUCCESSFUL_LOGIN_MESSAGE = "Wrong username or password!";


    @Test
    public void verifyTheUserCannotLoginWithInvalidCredentials() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Not logged in user has opened the Skillo HomePage.");
        homePage.openHomePage();

        log.info("STEP 1.1.Verify the user is on the home page ");
        //To do
        // create a method in home page that will check the :
        // 1.1.1. Page Title
        // 1.1.2. Verify the nav bar login link is shown
        log.info("STEP 1.1.2. Verify that the login link is presented ");
        boolean isShownNavBarLoginLink = homePage.isNavLoginShown();
        Assert.assertTrue(isShownNavBarLoginLink);

        log.info("STEP 2: The use is navigating to the login page via click on navigation bar login link");
        homePage.clickOnNavBarLoginLink();

        //Step 2.1. Verify the user is on login page
        log.info("STEP 2.1.: The user is successfully on the login page");
        LoginPage loginPage = new LoginPage(super.driver,log);
        
        String actualLoginFormTitle = loginPage.getLoginPageFormTitle();
        Assert.assertEquals(actualLoginFormTitle,LOGIN_FORM_HEADER_TITLE);

        //Step 3. Provide username
        log.info("STEP 3. Provide username");
        loginPage.provideUsername(" ");

        //Step 4. Provide password
        log.info("STEP 4. Provide password");
        loginPage.providePassword(" ");

        //Step 5. Click on login submit button
        log.info("STEP 4. Click on loginButton");
        loginPage.clickOnSubmitButton();

        //Step 6. Verify successful flow
        //Step 6.1. Success message
        String actualLoginActionMSG = loginPage.getLoginActionMessage();
        Assert.assertEquals(actualLoginActionMSG,UNSUCCESSFUL_LOGIN_MESSAGE);


        //Step 6.2. LogOut Button
        //Step 6.3. HomePage navigation bar profile link shown




        Thread.sleep(4444);


    }
    //1. Login with already registered user - valid credentials

    //2. Login with newly created/registered user - valid credentials


}