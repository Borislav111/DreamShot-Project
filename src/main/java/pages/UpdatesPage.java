package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdatesPage extends BasePage {
    private final String updatesPageUrl = "https://mind-wend-913065.framer.app/updates";
    @FindBy(name = "Content")
    WebElement contentHeader;

    public UpdatesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(updatesPageUrl);
    }

    public Boolean verifyHeaderText() {
        try {
            WebElement headerText = contentHeader.findElement(By.cssSelector(".framer-styles-preset-o3e5h0"));
            smallWait.until(ExpectedConditions.visibilityOf(headerText));
            return headerText.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The header text element could not be found: " + e.getMessage());
        }
    }
}
