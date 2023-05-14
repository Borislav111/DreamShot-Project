package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private final String homeUrl = "https://mind-wend-913065.framer.app/";

    private String videoPlayerUrl = "https://mind-wend-913065.framer.app/video-player";
    private String learnMoreUrl = "https://mind-wend-913065.framer.app/learn-more";
    Actions actions = new Actions(driver);

    @FindAll({
            @FindBy(name = "Card Small"),
            @FindBy(name = "Card")
    })
    List<WebElement> cardElements;
    @FindBy(name = "Content")
    WebElement contentElement;

    @FindBy(css = ".get-app-button")
    WebElement getAppBtn;

    @FindBy(css = "input[value='Sign Up']")
    WebElement footerSignUpBtn;

    @FindBy(css = ".framer-l3ry8h")
    WebElement newsletterForm;

    @FindBy(css = ".framer-wGhh3 .framer-vrqh0x")
    WebElement blurElement;

    @FindBy(css = ".framer-8nn08p")
    WebElement viewIn3dBtn;

    @FindBy(tagName = "iframe")
    WebElement iframe3d;

    @FindBy(id = "canvas3d")
    WebElement animation3d;

    @FindBy(css = ".watch-video-button")
    WebElement watchVideoBtn;

    @FindBy(css = "div[data-framer-name='Footer'] input[name='email']")
    WebElement footerInputField;

    @FindBy(css = ".framer-kd1tz6")
    WebElement learnMoreBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateUrl() {
        driver.get(homeUrl);
        verifyUrl(homeUrl);
    }

    public boolean getCards() {
        actions.moveToElement(cardElements.get(cardElements.size() - 1)).perform();
        boolean isDisplayedInAllCards = true;
        for (WebElement card : cardElements) {
            smallWait.until(ExpectedConditions.visibilityOf(card));
            WebElement visitBtn = card.findElement(By.cssSelector(".visit-button"));
            if (!visitBtn.isDisplayed()) {
                isDisplayedInAllCards = false;
                break;
            }
        }
        return isDisplayedInAllCards;
    }

    public boolean getFooterSignUpColorBtn(String backgroundColor) {
        smallWait.until(ExpectedConditions.visibilityOf(newsletterForm));
        actions.moveToElement(newsletterForm).perform();
        WebElement signUpBtn = newsletterForm.findElement(By.cssSelector("input[type='submit']"));
        String actualBackgroundColor = signUpBtn.getCssValue("background-color");
        return actualBackgroundColor.equals(backgroundColor);
    }

    public boolean checkBtnOneAboveOther() {
        smallWait.until(ExpectedConditions.visibilityOf(contentElement));
        List<WebElement> contentButtons = contentElement.findElements(By.cssSelector(".get-app-button, .watch-video-button"));
        if (contentButtons.size() == 2) {
            WebElement firstBtn = contentButtons.get(0);
            WebElement secondBtn = contentButtons.get(1);

            Point firstBtnLocation = firstBtn.getLocation();
            Point secondBtnLocation = secondBtn.getLocation();

            if (secondBtnLocation.getY() > firstBtnLocation.getY() + firstBtn.getSize().getHeight()) {
                return true;
            } else {
                throw new AssertionError("The second button is not positioned below the first button");
            }
        } else {
            throw new AssertionError("Expected to find exactly 2 buttons, but found " + contentButtons.size());
        }
    }

    public String doesBackgroundBlur() {
        clickElement(getAppBtn);
        if (blurElement.isDisplayed()) {
            return blurElement.getCssValue("backdrop-filter");
        }
        return "The background is not blurred";
    }

    public boolean verify3dAnimation() {
        actions.moveToElement(viewIn3dBtn).click().perform();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe3d));
        smallWait.until(ExpectedConditions.visibilityOf(animation3d));
        return animation3d.isDisplayed();
    }

    public String verifyWatchVideoBtnUrl() {
        clickElement(watchVideoBtn);
        return videoPlayerUrl;
    }

    public String subscribeToNewsletter(String email) {
        smallWait.until(ExpectedConditions.visibilityOf(newsletterForm));
        actions.moveToElement(newsletterForm).perform();
        enterText(footerInputField, email);
        WebElement signUpBtn = newsletterForm.findElement(By.cssSelector("input[type='submit']"));
        clickElement(signUpBtn);
        return signUpBtn.getAttribute("value");
    }

    public void openLearnMorePage() {
        actions.moveToElement(learnMoreBtn).click().perform();
        smallWait.until(ExpectedConditions.urlToBe(learnMoreUrl));
    }
}
