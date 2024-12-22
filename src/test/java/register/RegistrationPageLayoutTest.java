package register;

import base.BaseTest;
import com.nvd.POM.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageLayoutTest extends BaseTest {
    private static final String USERNAME_INPUT_FIELD_PLACEHOLDER = "Username";
    private static final String EMAIL_INPUT_FIELD_PLACEHOLDER = "email";
    private static final String BIRTHDATE_INPUT_FIELD_PLACEHOLDER = "Birth date";
    //but visible is mm/dd/yyyy
    private static final String PASSWORD_INPUT_FIELD_PLACEHOLDER = "Password";
    private static final String CONFIRM_PASSWORD_INPUT_FIELD_PLACEHOLDER = "Confirm Password";
    private static final String PUBLIC_INFO_INPUT_FIELD_PLACEHOLDER = "Public info";

    @Test
    public void verifyRegistrationPagePlaceHolders() {
        RegistrationPage registrationPage = new RegistrationPage(super.driver, log);

        log.info("STEP 1: Navigate to the Registration Page.");
        registrationPage.navigateToRegistrationPage();

        log.info("STEP 2: Verify the placeholder for username input field.");
        String actualUsernameInputFieldPlaceholder = registrationPage.verifyUsernameInputFieldPlaceholder();
        Assert.assertEquals(actualUsernameInputFieldPlaceholder, USERNAME_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 3: Verify the placeholder for email input field.");
        String actualEmailInputFieldPlaceholder = registrationPage.verifyEmailInputFieldPlaceholder();
        Assert.assertEquals(actualEmailInputFieldPlaceholder, EMAIL_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 4: Verify the placeholder for birthdate input field");
        String actualBirthDateInputFieldPlaceholder = registrationPage.verifyBirthdateInputFieldPlaceholder();
        Assert.assertEquals(actualBirthDateInputFieldPlaceholder, BIRTHDATE_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 5: Verify the placeholder for password input field.");
        String actualPasswordInputFieldPlaceholder = registrationPage.verifyPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualPasswordInputFieldPlaceholder, PASSWORD_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 6: Verify the placeholder for confirm password input field.");
        String actualConfirmPasswordInputFieldPlaceholder = registrationPage.verifyConfirmPasswordInputFieldPlaceholder();
        Assert.assertEquals(actualConfirmPasswordInputFieldPlaceholder, CONFIRM_PASSWORD_INPUT_FIELD_PLACEHOLDER);

        log.info("STEP 7: Verify the placeholder for confirm password input field.");
        String actualPublicInfoInputFieldPlaceholder = registrationPage.verifyPublicInfoInputFieldPlaceholder();
        Assert.assertEquals(actualPublicInfoInputFieldPlaceholder, PUBLIC_INFO_INPUT_FIELD_PLACEHOLDER);
    }
}