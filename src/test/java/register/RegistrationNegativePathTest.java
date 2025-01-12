package register;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import com.nvd.POM.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.regData.RegistrationDataGenerator;

public class RegistrationNegativePathTest extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String REGISTRATION_PAGE_PATH = "/users/register";

    private static final String REGISTRATION_FORM_HEADER_TITLE = "Sign up";
    private static final String DUPLICATE_USERNAME = "Nikol VD";
    private static final String DUPLICATE_EMAIL = "nikolvd3@abv.bg";
    private static final String VALID_USERNAME = RegistrationDataGenerator.createUsername();
    private static final String VALID_EMAIL = RegistrationDataGenerator.createEmail();
    private static final String VALID_PASSWORD = RegistrationDataGenerator.createPassword();
    private static final String BIRTHDATE = "07012000";
    private static final String PUBLIC_INFO = "Testing registration with invalid data";
    private static final String ERROR_MESSAGE_USERNAME_TAKEN = "Username taken";
    private static final String ERROR_MESSAGE_EMAIL_TAKEN = "Email taken";

    @Test(priority = 0)
    public void verifyUserCannotRegisterWithTakenUsername() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page as a guest user.");
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
                "Register link is not visible on the Login Page.");

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

        log.info("STEP 6: Enter a username that is already taken.");
        registrationPage.provideUsername(DUPLICATE_USERNAME);

        log.info("STEP 7: Enter a valid email address.");
        registrationPage.provideEmail(VALID_EMAIL);

        log.info("STEP 8: Enter a valid birthdate.");
        registrationPage.provideBirthDate(BIRTHDATE);

        log.info("STEP 9: Enter a valid password and confirm it.");
        registrationPage.providePassword(VALID_PASSWORD);
        registrationPage.confirmTheProvidedPassword(VALID_PASSWORD);

        log.info("STEP 10: Enter public information.");
        registrationPage.providePublicInfo(PUBLIC_INFO);

        log.info("STEP 11: Verify Registration form submit button is clickable.");
        boolean isRegSubmitButtonClickable = registrationPage.isRegistrationSubmitButtonClickable();
        Assert.assertTrue(isRegSubmitButtonClickable,
                "Registration form submit button is not clickable!");

        log.info("STEP 11.1: Click on the Registration form submit button.");
        registrationPage.clickOnRegistrationFormSubmitButton();

        log.info("STEP 12: Verify error message for duplicate username.");
        String actualRegisterActionMessage = registrationPage.getActionMessageText();
        Assert.assertEquals(actualRegisterActionMessage, ERROR_MESSAGE_USERNAME_TAKEN,
                "Error message for duplicate username is incorrect.");

        log.info("STEP 13: Ensure that the user remains on the Registration Page after unsuccessful registration.");
        boolean isUserStillOnRegistrationPage = registrationPage.isURLLoaded(REGISTRATION_PAGE_PATH);
        Assert.assertTrue(isUserStillOnRegistrationPage,
                "User did not remain on the Registration Page.");
    }

    @Test(priority = 1)
    public void verifyUserCannotRegisterWithTakenEmail() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page as a guest user.");
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
                "Register link is not visible on the Login Page.");

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

        log.info("STEP 6: Enter a valid username.");
        registrationPage.provideUsername(VALID_USERNAME);

        log.info("STEP 7: Enter an email address that is already taken.");
        registrationPage.provideEmail(DUPLICATE_EMAIL);

        log.info("STEP 8: Enter a valid birthdate.");
        registrationPage.provideBirthDate(BIRTHDATE);

        log.info("STEP 9: Enter a valid password and confirm it.");
        registrationPage.providePassword(VALID_PASSWORD);
        registrationPage.confirmTheProvidedPassword(VALID_PASSWORD);

        log.info("STEP 10: Enter public information.");
        registrationPage.providePublicInfo(PUBLIC_INFO);

        log.info("STEP 11: Verify Registration form submit button is clickable.");
        boolean isRegSubmitButtonClickable = registrationPage.isRegistrationSubmitButtonClickable();
        Assert.assertTrue(isRegSubmitButtonClickable,
                "Registration form submit button is not clickable!");

        log.info("STEP 11.1: Click on the Registration form submit button.");
        registrationPage.clickOnRegistrationFormSubmitButton();

        log.info("STEP 12: Verify error message for duplicate email.");
        String actualRegisterActionMessage = registrationPage.getActionMessageText();
        Assert.assertEquals(actualRegisterActionMessage, ERROR_MESSAGE_EMAIL_TAKEN,
                "Error message for duplicate email is incorrect.");

        log.info("STEP 13: Ensure that the user remains on the Registration Page after unsuccessful registration.");
        boolean isUserStillOnRegistrationPage = registrationPage.isURLLoaded(REGISTRATION_PAGE_PATH);
        Assert.assertTrue(isUserStillOnRegistrationPage,
                "User did not remain on the Registration Page.");
    }
}