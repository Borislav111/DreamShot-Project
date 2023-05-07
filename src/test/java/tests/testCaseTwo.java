package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.PricingPage;

public class testCaseTwo extends BaseTest{
    @Test
    public void faqQuestions(){
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        PricingPage pricingPage = new PricingPage(driver);

        homePage.navigateUrl();
        header.openPricingPage();
        pricingPage.verifyUrl();
        int faqNumber = pricingPage.faqNumber();
        Assert.assertEquals(faqNumber, 4, "The FAQ number is incorrect");
    }
}
