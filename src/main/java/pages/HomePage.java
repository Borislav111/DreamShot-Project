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

    @FindBy(css = "form input[value='Sign Up']")
    WebElement footerSignUpBtn;

    @FindBy(id = "overlay")
    WebElement blurEffect;

    @FindBy(name = "Modal")
    WebElement signUpForm;

    @FindBy(xpath = "//p[contains(@class,'framer-text')]//span[text()='Click to view in 3D']")
    WebElement viewIn3dBtn;

    @FindBy(tagName = "iframe")
    WebElement iframe3d;

    @FindBy(id = "canvas3d")
    WebElement animation3d;

    @FindBy(css = ".watch-video-button")
    WebElement watchVideoBtn;

    @FindBy(css = "div[data-framer-name='Footer'] input[name='email']")
    WebElement footerInputField;

    @FindBy(xpath = "//div[@name='Content']//span[text()='learn more']")
    WebElement learnMoreBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateUrl() {
        driver.get(homeUrl);
        verifyUrl(homeUrl);
    }

    public boolean checkVisitBtn() throws InterruptedException {
        actions.moveToElement(cardElements.get(cardElements.size() - 1)).perform();

        Thread.sleep(1000);

        boolean isDisplayedInAllCards = true;
        for (WebElement card : cardElements) {
            WebElement visitBtn = card.findElement(By.cssSelector(".visit-button"));
            if (!visitBtn.isDisplayed()) {
                isDisplayedInAllCards = false;
                break;
            }
        }
        return isDisplayedInAllCards;
    }

    public String getFooterSignUpColorBtn() {
        wait.until(ExpectedConditions.visibilityOf(footerSignUpBtn));
        actions.moveToElement(footerSignUpBtn).perform();
        String buttonColor = footerSignUpBtn.getCssValue("background-color");
        Color color = Color.fromString(buttonColor);
        int red = color.getColor().getRed();
        int green = color.getColor().getGreen();
        int blue = color.getColor().getBlue();
        return String.format("rgb(%d,%d,%d)", red, green, blue);
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
                return false;
            }
        }
        return false;
    }

    public boolean verifyBlur() {
        String blurBeforeClick = blurEffect.getAttribute("innerHTML");
        if (blurBeforeClick.isEmpty()) {
            clickElement(getAppBtn);
            smallWait.until(ExpectedConditions.visibilityOf(signUpForm));
            String blurAfterClick = blurEffect.getAttribute("innerHTML");
            if (!blurAfterClick.isEmpty()) {
                return true;
            }
            return false;
        }
        return false;
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
        smallWait.until(ExpectedConditions.visibilityOf(footerSignUpBtn));
        actions.moveToElement(footerSignUpBtn).perform();
        enterText(footerInputField, email);
        clickElement(footerSignUpBtn);
        return footerSignUpBtn.getAttribute("value");
    }

    public void openLearnMorePage() {
        actions.moveToElement(learnMoreBtn).click().perform();
        smallWait.until(ExpectedConditions.urlToBe(learnMoreUrl));
    }
}
