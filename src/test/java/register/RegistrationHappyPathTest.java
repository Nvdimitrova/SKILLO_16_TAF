package register;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import com.nvd.POM.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.regData.RegistrationDataGenerator;

public class RegistrationHappyPathTest extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String REGISTRATION_PAGE_PATH = "/users/register";
    private static final String REGISTRATION_FORM_HEADER_TITLE = "Sign up";
    private static final String SUCCESSFUL_REGISTRATION_MESSAGE = "Successful register!";

    private static final String USERNAME = RegistrationDataGenerator.createUsername();
    private static final String EMAIL = RegistrationDataGenerator.createEmail();
    private static final String PASSWORD = RegistrationDataGenerator.createPassword();
    private static final String BIRTHDATE = "01072000";

    @Test
    public void verifySuccessfulRegistrationWithValidCredentials() {
        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Open the ISkillo Home Page as a guest user.");
        homePage.navigateToHomePage();

        log.info("STEP 1.1: Verify the Home Page loaded successfully.");
        boolean isHomePageLoaded = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isHomePageLoaded);

        log.info("STEP 1.2: Verify Home Page icon is visible.");
        boolean isHomePageIconVisible = homePage.isHomeIconShown();
        Assert.assertTrue(isHomePageIconVisible);

        log.info("STEP 1.3: Verify the Login link in the navigation bar is visible.");
        boolean isLoginLinkVisible = homePage.isNavBarLoginLinkShown();
        Assert.assertTrue(isLoginLinkVisible);

        log.info("STEP 2: Navigate to the Login Page via the Login link.");
        homePage.clickOnNavBarLoginLink();

        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 2.1: Verify the Login Page loaded successfully.");
        boolean isLoginPageLoaded = loginPage.isURLLoaded(LOGIN_PAGE_PATH);
        Assert.assertTrue(isLoginPageLoaded);

        log.info("Step 2.2: Verify the Register link is visible on the Login Page.");
        boolean isRegisterLinkVisible = loginPage.isRegisterLinkShown();
        Assert.assertTrue(isRegisterLinkVisible);

        log.info("STEP 3: Navigate to the Registration Page via the Register link.");
        loginPage.clickOnRegisterLink();

        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 3.1: Verify the Registration Page loaded successfully.");
        boolean isRegistrationPageLoaded = registrationPage.isURLLoaded(REGISTRATION_PAGE_PATH);
        Assert.assertTrue(isRegistrationPageLoaded);

        log.info("STEP 3.2: Verify the Registration form header title is correct.");
        String actualRegistrationFormHeaderTitle = registrationPage.getRegistrationFormHeaderTitleText();
        Assert.assertEquals(actualRegistrationFormHeaderTitle, REGISTRATION_FORM_HEADER_TITLE);

        log.info("STEP 4: Enter a valid username.");
        registrationPage.provideUsername(USERNAME);

        log.info("STEP 5: Enter a valid email.");
        registrationPage.provideEmail(EMAIL);

        log.info("STEP 6: Enter a valid birthdate.");
        registrationPage.provideBirthDate(BIRTHDATE);

        log.info("STEP 7: Enter a valid password and confirm it.");
        registrationPage.providePassword(PASSWORD);
        registrationPage.confirmTheProvidedPassword(PASSWORD);

        log.info("STEP 8: Enter public information.");
        registrationPage.providePublicInfo("Testing registration with valid credentials");

        log.info("STEP 9: Submit the Registration form.");
        registrationPage.clickOnSubmitButton();

        log.info("STEP 10: Verify successful registration message.");
        String actualRegisterActionMessage = registrationPage.getRegistrationActionMessageText();
        Assert.assertEquals(actualRegisterActionMessage, SUCCESSFUL_REGISTRATION_MESSAGE);

        log.info("STEP 11: Verify that the user is redirected to Home Page after registration.");
        boolean isUserRedirectedToHomePage = homePage.isURLLoaded(HOME_PAGE_PATH);
        Assert.assertTrue(isUserRedirectedToHomePage);
    }
}