package tests.PersonalTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class watchVideoTestCase extends BaseTest {
    @Test
    public void verifyUrlChange(){
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        Assert.assertEquals(driver.getCurrentUrl(), homePage.verifyWatchVideoBtnUrl(), "Video player URL is incorrect");
    }
}
