package tests.PersonalTestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.SignUpPage;
import tests.BaseTest;

public class signUpBtnAfterLogin extends BaseTest {
    @Parameters({"email", "password"})
    @Test
    public void isSignUpButtonDisplayedAfterLogin(String email, String password) {
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        homePage.navigateUrl();
        header.openSignUpPage();
        signUpPage.verifyUrl();
        boolean isLoginSuc = signUpPage.sucLoginAsRequired(email, password);
        Assert.assertTrue(isLoginSuc, "Login failed");
        Assert.assertFalse(header.isSignUpBtnVisible(), "The 'Sign Up' button is still visible");
    }
}
