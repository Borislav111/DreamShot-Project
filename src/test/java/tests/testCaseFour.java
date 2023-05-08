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
        String signUpColorBtn = homePage.getFooterSignUpColorBtn();
        Assert.assertEquals(signUpColorBtn, "rgb(255,82,79)", "The 'Sign Up' background color mismatches");
    }
}
