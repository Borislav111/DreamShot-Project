package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseThree extends BaseTest {
    @Test
    public void displayedVisitBtn() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        Assert.assertTrue(homePage.checkVisitBtn(), "The 'Visit' buttons should be displayed");
    }
}
