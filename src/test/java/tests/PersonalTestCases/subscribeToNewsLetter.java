package tests.PersonalTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class subscribeToNewsLetter extends BaseTest {
    @Test
    public void verifyEmailSubscription() {
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();

        String expectedButtonValue = "Subscribed!";
        String actualButtonValue = homePage.subscribeToNewsletter("testUser@abv.bg");
        Assert.assertEquals(actualButtonValue, expectedButtonValue, "Subscription button value is different");

    }
}
