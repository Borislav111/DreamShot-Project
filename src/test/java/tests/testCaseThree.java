package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class testCaseThree extends BaseTest {
    @Test
    public void displayedVisitBtn() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        Assert.assertTrue(homePage.getCards(), "Not all 'Visit' buttons are displayed");
    }
}
