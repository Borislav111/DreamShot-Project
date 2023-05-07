package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.PricingPage;

public class testCaseOne extends BaseTest{
    @Test
    public void productsCurrency(){
        Header header = new Header(driver);
        HomePage homePage = new HomePage(driver);
        PricingPage pricingPage = new PricingPage(driver);

        homePage.navigateUrl();
        header.openPricingPage();
        pricingPage.verifyUrl();
        Assert.assertTrue(pricingPage.checkCurrencySymbol(), "The '$' currency is present");
    }
}
