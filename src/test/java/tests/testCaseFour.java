package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseFour extends BaseTest {
    @Test
    public void signUpBtnColor() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        boolean signUpColorBtn = homePage.getFooterSignUpColorBtn("rgba(255, 82, 79, 1)");
        Assert.assertTrue(signUpColorBtn, "The 'Sign Up' background color mismatches");
    }
}
