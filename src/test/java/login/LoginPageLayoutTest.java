package login;

import base.BaseTest;
import com.nvd.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageLayoutTest extends BaseTest {
    private static final String USERNAME_INPUT_FIELD_PLACEHOLDER = "Username or email";
    private static final String PASSWORD_INPUT_FIELD_PLACEHOLDER = "Password";

    @Test
    public void verifyLoginPagePlaceHolders() {
        LoginPage loginPage = new LoginPage(super.driver, log);

        log.info("STEP 1: Navigate to the Login Page.");
        loginPage.navigateToLoginPage();

        log.info("STEP 2: Verify the placeholder for username input field.");
        String actualUserNameInputFieldPlaceholder = loginPage.verifyUsernameInputFieldPlaceholder();
        Assert.assertEquals(actualUserNameInputFieldPlaceholder, USERNAME_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 3: Verify the placeholder for password input field.");
        String actualPasswordInputFieldPlaceholder = loginPage.verifyPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualPasswordInputFieldPlaceholder, PASSWORD_INPUT_FIELD_PLACEHOLDER);
    }
}