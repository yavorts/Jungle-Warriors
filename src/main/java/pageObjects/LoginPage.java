package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

/**
 * Login Page Object class representing the log in page
 * @author yavort
 */
public class LoginPage {
    WebDriver driver;
    @FindBy(css = "#userid")
    private WebElement userId;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "[type='submit']")
    private WebElement signInButton;

    @FindBy(css = ".ngdialog-close")
    private WebElement closeButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setUserId(String emailText) {
        WaitUtils.waitForVisibleElement(userId, driver);
        userId.sendKeys(emailText);
    }

    public void setPassword(String passwordText) {
        WaitUtils.waitForVisibleElement(password, driver);
        password.sendKeys(passwordText);
    }

    public void clickSignInButtonButton() {
        WaitUtils.waitForVisibleElement(signInButton, driver);
        signInButton.click();
    }

}
