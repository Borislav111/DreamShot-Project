package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseFive extends BaseTest {
    @Test
    public void verifyBackgroundBlur() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        String blurValue = homePage.doesBackgroundBlur();
        Assert.assertEquals(blurValue,"blur(20px)", "The background is not blurred");
    }
}
