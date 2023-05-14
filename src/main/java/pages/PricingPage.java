package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PricingPage extends BasePage {
    private final String pricingPageUrl = "https://mind-wend-913065.framer.app/pricing";

    @FindBy(css = "div .pricing-item")
    List<WebElement> pricingItems;

    @FindBy(css = "div .pricing-container .price")
    WebElement priceTag;

    @FindBy(css = ".faq-question")
    List<WebElement> faqQuestions;

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(pricingPageUrl);
    }

    public Integer faqNumber() {
        return faqQuestions.size();
    }

    public boolean pricingsContainSymbol(String priceSymbol) {
        boolean currSymbol = true;
        for (WebElement symbol : pricingItems) {
            wait.until(ExpectedConditions.visibilityOf(symbol));
            String priceText = priceTag.getText();
            if (!priceText.contains(priceSymbol)) {
                currSymbol = false;
                break;
            }
        }
        return currSymbol;
    }
}
