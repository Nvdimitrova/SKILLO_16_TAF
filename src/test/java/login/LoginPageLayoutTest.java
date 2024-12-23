package login;

import base.BaseTest;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageLayoutTest extends BaseTest {
    private static final String LOGIN_FORM_HEADER_TITLE = "Sign in";
    private static final String USERNAME_INPUT_FIELD_PLACEHOLDER = "Username or email";
    private static final String PASSWORD_INPUT_FIELD_PLACEHOLDER = "Password";
    private static final String CHECKBOX_LABEL_TEXT = "Remember me";
    private static final String LOGIN_SUBMIT_BUTTON_TEXT = "Sign in";
    private static final String LOGIN_FORM_FOOTER_LABEL_TEXT = "Not a member?";

    @Test
    public void verifyLoginPageLayout() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Navigate to the Login Page.");
        loginPage.navigateToLoginPage();

        log.info("STEP 2: Verify the Login form header title.");
        String actualLoginFormTitle = loginPage.getLoginFormHeaderTitleText();
        Assert.assertEquals(actualLoginFormTitle, LOGIN_FORM_HEADER_TITLE);

        log.info("STEP 3: Verify the placeholder text for username input field.");
        String actualUserNameInputFieldPlaceholder = loginPage.verifyUsernameInputFieldPlaceholder();
        Assert.assertEquals(actualUserNameInputFieldPlaceholder, USERNAME_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 4: Verify the placeholder text for password input field.");
        String actualPasswordInputFieldPlaceholder = loginPage.verifyPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualPasswordInputFieldPlaceholder, PASSWORD_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 5: Verify the Login form checkbox is visible.");
        boolean isCheckBoxShown = loginPage.isCheckBoxShown();
        Assert.assertTrue(isCheckBoxShown);

        log.info("STEP 5.1: Verify the Login form checkbox is clickable.");
        boolean isCheckBoxClickable = loginPage.isCheckBoxClickable();
        Assert.assertTrue(isCheckBoxClickable);

        log.info("STEP 5.2: Verify the Login form checkbox label text.");
        String actualCheckBoxLabelText = loginPage.getCheckBoxLabelText();
        Assert.assertEquals(actualCheckBoxLabelText, CHECKBOX_LABEL_TEXT);

        log.info("STEP 6: Verify the Login form submit button is visible.");
        boolean isLoginSubmitButtonShown = loginPage.isLoginSubmitButtonShown();
        Assert.assertTrue(isLoginSubmitButtonShown);

        log.info("STEP 6.1: Verify Login form submit button is not clickable without any user data.");
        boolean isLoginSubmitButtonClickable = loginPage.isLoginSubmitButtonClickable();
        Assert.assertFalse(isLoginSubmitButtonClickable);

        log.info("STEP 6.2: Verify Login form submit button text.");
        String actualLoginFormSubmitButtonText = loginPage.getLoginFormSubmitButtonText();
        Assert.assertEquals(actualLoginFormSubmitButtonText, LOGIN_SUBMIT_BUTTON_TEXT);

        log.info("STEP 7: Verify the Login form footer label text.");
        String actualLoginFormFooterLabelText = loginPage.getLoginFormFooterLabelText();
        Assert.assertEquals(actualLoginFormFooterLabelText, LOGIN_FORM_FOOTER_LABEL_TEXT);

        log.info("Step 8: Verify the Register link is visible.");
        boolean isRegisterLinkVisible = loginPage.isRegisterLinkShown();
        Assert.assertTrue(isRegisterLinkVisible);

        log.info("Step 9: Verify the Register link is clickable.");
        boolean isRegisterLinkClickable = loginPage.isRegisterLinkClickable();
        Assert.assertTrue(isRegisterLinkClickable);
    }
}