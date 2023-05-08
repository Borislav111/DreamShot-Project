package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseEight extends BaseTest {
    @Test
    public void verify3dAnimation() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        Assert.assertTrue(homePage.verify3dAnimation(), "3D Animation is not displayed");
    }
}
