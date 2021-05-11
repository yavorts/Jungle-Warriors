package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

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
        switchToIframeAndClickElementFromText(information);
    }

    public void setGender(String information) {
        WaitUtils.waitForClickableElement(gender, driver);
        gender.click();
        switchToIframeAndClickElementFromText(information);
    }

    public void setNationalIdType(String information) {
        WaitUtils.waitForClickableElement(nationalIdType, driver);
        nationalIdType.click();
        switchToIframeAndClickElementFromText(information);
    }

    public void setDateOfBirth(String information) {
        WaitUtils.waitForClickableElement(dateOfBirth, driver);
        dateOfBirth.sendKeys(information);
    }

    public void clickContinueButton() {
        WaitUtils.waitForClickableElement(continueButton, driver);
        continueButton.click();
    }

    private void switchToIframeAndClickElementFromText(String text) {
        driver.switchTo().frame(iframeElement);
        WebElement element = driver.findElement(By.cssSelector("#__af_Z_window li[_adfiv='" + text + "']"));
        element.click();
        driver.switchTo().defaultContent();
    }
}

