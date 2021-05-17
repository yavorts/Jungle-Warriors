package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.WebElementUtils;

import java.util.List;

public class CommunicationInfo {
    WebDriver driver;

    @FindBy(xpath = "//*[@title='Phones']/../../../../../..//input[@role]")
    private WebElement phoneDropdown;

    @FindBy(css = "#__af_Z_window li")
    private List<WebElement> phoneDropdownOptions;

    @FindBy(xpath = "//*[contains(text(),'Country')]/../..//input[@type='text']")
    private WebElement country;

    @FindBy(xpath = "//*[@title='Emails']/../../../../../..//input[@role]")
    private WebElement emailsDropdown;

    @FindBy(css = "#__af_Z_window li")
    private List<WebElement> emailsDropdownOptions;

    @FindBy(xpath = "//*[contains(text(),'Email')]/../..//input[@type='text']")
    private WebElement email;

    @FindBy(css = "[title='Continue']")
    private WebElement continueButton;

    public CommunicationInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setPhoneType(String option) {
        WaitUtils.waitForClickableElement(phoneDropdown, driver);
        phoneDropdown.click();
        WebElementUtils.clickElementWithTextFromListOfElements(option, phoneDropdownOptions);
    }

    public void setPhoneDetailsFromOption(String detailsOption, String information) {
        WebElement webElement = driver.findElement(By.xpath("//*[contains(text(),'" + detailsOption + "')]/../..//input"));
        WaitUtils.waitForClickableElement(webElement, driver);
        webElement.sendKeys(information);
    }

    public void setCountry(String information) {
        WaitUtils.waitForClickableElement(country, driver);
        country.sendKeys(information);
    }

    public void setEmailType(String option) {
        WaitUtils.waitForClickableElement(emailsDropdown, driver);
        emailsDropdown.click();
        WebElementUtils.clickElementWithTextFromListOfElements(option, emailsDropdownOptions);
    }

    public void setEmail(String emailText) {
        WaitUtils.waitForClickableElement(email, driver);
        email.sendKeys(emailText);
    }

    public void clickContinueButton() {
        WaitUtils.waitForClickableElement(continueButton, driver);
        continueButton.click();
    }
}
