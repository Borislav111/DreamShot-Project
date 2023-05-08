package tests.PersonalTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class verifyLearnMorePage extends BaseTest {
    @Test
    public void openLearnMorePage(){
        HomePage homePage = new HomePage(driver);

        homePage.navigateUrl();
        homePage.openLearnMorePage();
    }
}
