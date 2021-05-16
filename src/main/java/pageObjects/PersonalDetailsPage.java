package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.WebElementUtils;

public class PersonalDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Title')]/../..//input[@role]")
    private WebElement title;

    @FindBy(xpath = "//*[contains(text(),'Gender')]/../..//input[@role]")
    private WebElement gender;

    @FindBy(xpath = "//*[contains(text(),'Date of Bir')]/../..//input[@placeholder]")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//*[contains(text(),'Pref')]/../..//input")
    private WebElement personalDetailsOptions;

    @FindBy(xpath = "//*[contains(text(),'National')]/../..//input[@role]")
    private WebElement nationalIdType;

    @FindBy(xpath = "//*[contains(text(),'National ID')]/../../..//div[@class='xkg xk4 x1u']//input")
    private WebElement nationalIDNumber;

    @FindBy(css = "[title='Continue']")
    private WebElement continueButton;

    @FindBy(css = ".AFMaskingFrame")
    private WebElement iframeElement;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setPersonalDetailsOptionFromText(String personalDetailsOption, String information) {
        WebElement webElement = driver.findElement(By.xpath("//*[contains(text(),'" + personalDetailsOption + "')]/../..//input"));
        WaitUtils.waitForClickableElement(webElement, driver);
        webElement.sendKeys(information);
    }

    public void setTitle(String information) {
        WaitUtils.waitForClickableElement(title, driver);
        title.click();
        String locator =  getLocatorFromText(information.toUpperCase());
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.click();
    }

    public void setGender(String information) {
        WaitUtils.waitForClickableElement(gender, driver);
        gender.click();
        String substring = information.substring(0,1);
        String locator =  getLocatorFromText(substring);
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.click();
    }

    public void setNationalIdType(String information) {
        WaitUtils.waitForClickableElement(nationalIdType, driver);
        nationalIdType.click();
        String substringInformation = information.substring(0, 3);
       String locator =  getLocatorFromText(substringInformation);
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.click();
    }

    public void setNationalIDNumber(String natNumber) {
        WaitUtils.waitForClickableElement(nationalIDNumber, driver);
        nationalIDNumber.sendKeys(natNumber);
    }

    public void setDateOfBirth(String information) {
        WebElementUtils.scrollElementIntoView(driver, dateOfBirth);
        WaitUtils.waitForClickableElement(dateOfBirth, driver);
        dateOfBirth.sendKeys(information);
    }

    public void clickContinueButton() {
        WaitUtils.waitForClickableElement(continueButton, driver);
        continueButton.click();
    }

    private String getLocatorFromText(String text) {
        String locator = "#__af_Z_window li[_adfiv *='" + text.toUpperCase() + "']";
        WebElement element = driver.findElement(By.cssSelector(locator));
        return locator;
    }
}

