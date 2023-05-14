package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {

    @FindBy(xpath = "//div[@data-framer-name='Desktop']//span[text()='Components']")
    WebElement componentsLink;
    @FindBy(xpath = "//div[@data-framer-name='Desktop']//span[text()='Pricing']")
    WebElement pricingLink;

    @FindBy(css = ".update-nav-button")
    WebElement updatesLink;

    @FindBy(css = ".framer-xkblh5")
    WebElement signUpLink;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPricingPage() {
        clickElement(pricingLink);
    }

    public void openUpdatesPage() {
        clickElement(updatesLink);
    }

    public void openSignUpPage() {
        clickElement(signUpLink);
    }

    public boolean isSignUpBtnVisible(){
        return signUpLink.isDisplayed();
    }

    public void openComponentsPage(){
        clickElement(componentsLink);
    }
}
