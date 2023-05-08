package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseFive extends BaseTest {
    @Test
    public void verifyBackgroundBlur() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        Assert.assertTrue(homePage.verifyBlur(), "The background is not blurred");
    }
}
