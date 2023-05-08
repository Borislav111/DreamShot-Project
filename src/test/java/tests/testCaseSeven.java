package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;


public class testCaseSeven {
    private WebDriver driver;

    @BeforeMethod
    public void setUpMobile() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(375, 812));
    }

    @Test
    public void verifyDisplayedButtons() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();

        Assert.assertTrue(homePage.checkBtnOneAboveOther(), "The 'get the app' and 'watch video' buttons are not displayed one above the other on mobile");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
