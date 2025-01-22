package register;

import base.BaseTest;
import com.nvd.POM.HomePage;
import com.nvd.POM.LoginPage;
import com.nvd.POM.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageLayoutTest extends BaseTest {
    private static final String HOME_PAGE_PATH = "/posts/all";
    private static final String LOGIN_PAGE_PATH = "/users/login";
    private static final String REGISTRATION_PAGE_PATH = "/users/register";

    private static final String REGISTRATION_FORM_HEADER = "Sign up";
    private static final String USERNAME_PLACEHOLDER = "Username";
    private static final String EMAIL_PLACEHOLDER = "email";
    private static final String BIRTHDATE_PLACEHOLDER = "Birth date";
    private static final String PASSWORD_PLACEHOLDER = "Password";
    private static final String CONFIRM_PASSWORD_PLACEHOLDER = "Confirm Password";
    private static final String PUBLIC_INFO_PLACEHOLDER = "Public info";
    private static final String SUBMIT_BUTTON_TEXT = "Sign in";
    private static final String REQUIRED_FIELD_ERROR_MESSAGE = "This field is required!";

    @Test
    public void verifyRegistrationPageLayout() {
        HomePage homePage = new HomePage(super.driver, log);

        log.info("STEP 1: Open the ISkillo Home Page.");
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

        log.info("STEP 6: Verify the Registration form header title.");
        String actualRegFormHeaderText = registrationPage.getRegistrationFormHeaderTitleText();
        Assert.assertEquals(actualRegFormHeaderText, REGISTRATION_FORM_HEADER,
                "Registration form header title is incorrect.");

        log.info("STEP 7: Verify the placeholder for Username input field.");
        String actualUsernamePlaceholder = registrationPage.getUsernameInputFieldPlaceholder();
        Assert.assertEquals(actualUsernamePlaceholder, USERNAME_PLACEHOLDER,
                "Username input field placeholder text does not match.");

        log.info("STEP 8: Verify the placeholder for Email input field.");
        String actualEmailPlaceholder = registrationPage.getEmailInputFieldPlaceholder();
        Assert.assertEquals(actualEmailPlaceholder, EMAIL_PLACEHOLDER,
                "Email input field placeholder text does not match.");

        log.info("STEP 9: Verify the placeholder for Birthdate input field");
        String actualBirthdatePlaceholder = registrationPage.getBirthdateInputFieldPlaceholder();
        Assert.assertEquals(actualBirthdatePlaceholder, BIRTHDATE_PLACEHOLDER,
                "Birthdate input field placeholder text does not match.");

        log.info("STEP 10: Verify the placeholder for Password input field.");
        String actualPasswordPlaceholder = registrationPage.getPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualPasswordPlaceholder, PASSWORD_PLACEHOLDER,
                "Password input field placeholder text does not match.");

        log.info("STEP 11: Verify the placeholder for Confirm Password input field.");
        String actualConfirmPasswordPlaceholder = registrationPage.getConfirmPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualConfirmPasswordPlaceholder, CONFIRM_PASSWORD_PLACEHOLDER,
                "Confirm Password input field placeholder text does not match.");

        log.info("STEP 12: Verify the placeholder for Public Info input field.");
        String actualPublicInfoPlaceholder = registrationPage.getPublicInfoInputFieldPlaceholder();
        Assert.assertEquals(actualPublicInfoPlaceholder, PUBLIC_INFO_PLACEHOLDER,
                "Public Info input field placeholder text does not match.");

        log.info("STEP 13: Verify the Registration form submit button is visible.");
        boolean isRegSubmitButtonVisible = registrationPage.isRegistrationSubmitButtonShown();
        Assert.assertTrue(isRegSubmitButtonVisible,
                "Registration form submit button is not visible.");

        log.info("STEP 13.1: Verify Registration form submit button is not clickable without user data.");
        boolean isRegSubmitButtonClickable = registrationPage.isRegistrationSubmitButtonClickable();
        Assert.assertFalse(isRegSubmitButtonClickable,
                "Registration submit button should not be clickable without user data.");

        log.info("STEP 13.2: Verify Registration form submit button text.");
        String actualRegSubmitButtonText = registrationPage.getRegistrationFormSubmitButtonText();
        Assert.assertEquals(actualRegSubmitButtonText, SUBMIT_BUTTON_TEXT,
                "Registration submit button text is incorrect.");

        log.info("STEP 14: Verify that invalid feedback message is shown for the fields with missing required information.");
        registrationPage.verifyFieldsInvalidFeedback();

        log.info("STEP 14.1: Verify invalid feedback message text.");
        String actualInvalidFeedbackMessageText = registrationPage.getInvalidFeedbackMessageText();
        Assert.assertEquals(actualInvalidFeedbackMessageText, REQUIRED_FIELD_ERROR_MESSAGE,
                "Invalid feedback message text does not match.");
    }
}