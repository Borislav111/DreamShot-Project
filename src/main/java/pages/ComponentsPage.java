package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ComponentsPage extends BasePage {

    private final String componentsUrl = "https://mind-wend-913065.framer.app/components";
    private String loginUrl = "https://mind-wend-913065.framer.app/signup";

    @FindBy(css = ".framer-15fwyui")
    WebElement getAppTopBtn;

    public ComponentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(componentsUrl);
    }

    public String getTheAppBtnLoginUrl() {
        clickElement(getAppTopBtn);
        return loginUrl;
    }
}
