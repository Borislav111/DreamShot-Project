package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final WebDriverWait smallWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected void verifyUrl(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }
}
