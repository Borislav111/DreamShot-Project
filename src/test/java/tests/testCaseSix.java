package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.UpdatesPage;


public class testCaseSix extends BaseTest {
    @Test
    public void validateUpdatesPage() {
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        UpdatesPage updatesPage = new UpdatesPage(driver);

        homePage.navigateUrl();
        header.openUpdatesPage();
        updatesPage.verifyUrl();
        Assert.assertTrue(updatesPage.verifyHeaderText(), "The header text 'Updates' is not displayed");
    }
}
