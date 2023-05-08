package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {
    private final String signUpUrl = "https://mind-wend-913065.framer.app/signup";
    @FindBy(name = "Modal")
    WebElement signUpForm;

    @FindBy(css = "input[placeholder='Email']")
    WebElement emailField;

    @FindBy(css = "input[placeholder='Password']")
    WebElement passwordField;

    @FindBy(css = "input[value='Sign Up']")
    WebElement signUpBtn;

    @FindBy(css = "[name='Modal'] svg")
    WebElement confirmLogin;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(signUpUrl);
    }

    public String verifyEmailFormValidation() {
        smallWait.until(ExpectedConditions.visibilityOf(signUpForm));
        clickElement(signUpBtn);
        String boxColor = emailField.getCssValue("box-shadow");
        String[] parts = boxColor.split("\\) ");
        String rgbString = parts[0].substring(4);
        return rgbString;
    }

    public String verifyPasswordFormValidation() {
        smallWait.until(ExpectedConditions.visibilityOf(signUpForm));
        clickElement(signUpBtn);
        String boxColor = passwordField.getCssValue("box-shadow");
        String[] parts = boxColor.split("\\) ");
        String rgbString = parts[0].substring(4);
        return rgbString;
    }

    public boolean sucLoginAsRequired(String email, String password) {
        smallWait.until(ExpectedConditions.visibilityOf(signUpForm));
        enterText(emailField, email);
        enterText(passwordField, password);
        clickElement(signUpBtn);
        return confirmLogin.isDisplayed();
    }
}
