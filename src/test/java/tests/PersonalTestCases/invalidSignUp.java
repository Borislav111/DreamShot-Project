package tests.PersonalTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Header;
import pages.HomePage;
import pages.SignUpPage;
import tests.BaseTest;

public class invalidSignUp extends BaseTest {
    private final String expectedBoxShadowColor = "238, 68, 68";

    @Test
    public void emptyFieldsForLogin() {
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        SoftAssert soft = new SoftAssert();

        homePage.navigateUrl();
        header.openSignUpPage();
        signUpPage.verifyUrl();
        soft.assertEquals(signUpPage.verifyEmailFormValidation(), expectedBoxShadowColor, "The email box color is different");
        soft.assertEquals(signUpPage.verifyPasswordFormValidation(), expectedBoxShadowColor, "The password box color is different");
        soft.assertAll();
    }
}
