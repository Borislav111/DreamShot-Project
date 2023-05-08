package tests.PersonalTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComponentsPage;
import pages.Header;
import pages.HomePage;
import tests.BaseTest;

public class openLoginFromComponentPage extends BaseTest {
    @Test
    public void openLoginForm() {
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        ComponentsPage componentsPage = new ComponentsPage(driver);

        homePage.navigateUrl();
        header.openComponentsPage();
        componentsPage.verifyUrl();
        Assert.assertEquals(driver.getCurrentUrl(), componentsPage.getTheAppBtnLoginUrl(), "The URL for 'Sign Up' form is not displayed");
    }
}
