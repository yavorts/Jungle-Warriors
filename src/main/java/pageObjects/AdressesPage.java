package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.WebElementUtils;

import java.util.List;

public class AdressesPage {
    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Country')]/../..//input")
    private WebElement country;

    @FindBy(xpath = "//*[contains(text(),'Type')]/../..//div[@class='xuw']//input[@role]")
    private WebElement typeDropdown;

    @FindBy(css = "#__af_Z_window li")
    private List<WebElement> typeDropdownOptions;

    @FindBy(xpath = "//*[contains(text(),'Postal Code')]/../..//input[@type='text']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[contains(text(),'Address Site')]/../..//input[@type='text']")
    private WebElement addressSite;

    @FindBy(xpath = "//*[contains(text(),'Address')]/../..//div[@class='xkg xk4 x1u']//input[@type='text']")
    private List<WebElement> addressNumberComplementNeighbourhood;

    @FindBy(xpath = "//*[contains(text(),'City')]/../..//span[@class='xdu xkg x1a']//input[@type='text']")
    private WebElement city;

    @FindBy(xpath = "//*[contains(text(),'State')]/../..//span[@class='xdu xkg x1a']//input[@type='text']")
    private WebElement state;

    @FindBy(css = "[title='Continue']")
    private WebElement continueButton;

    public AdressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setAdressDetailsFromOption(String detailsOption, String information) {
        WebElement webElement =
                WebElementUtils.getElementWithTextFromListOfElements(detailsOption, addressNumberComplementNeighbourhood);
        WaitUtils.waitForClickableElement(webElement, driver);
        webElement.sendKeys(information);
    }

    public void setCountry(String information) {
        WaitUtils.waitForClickableElement(country, driver);
        country.sendKeys(information);
        country.sendKeys(Keys.ENTER);
    }

    public void setType(String option) {
        WaitUtils.waitForClickableElement(typeDropdown, driver);
        typeDropdown.click();
        WebElementUtils.clickElementWithTextFromListOfElements(option, typeDropdownOptions);
    }

    public void setPostalCode(String information) {
        WaitUtils.waitForClickableElement(postalCode, driver);
        postalCode.sendKeys(information);
    }

    public void setAddressSite(String information) {
        WaitUtils.waitForClickableElement(addressSite, driver);
        addressSite.sendKeys(information);
    }

    public void setCity(String information) {
        WaitUtils.waitForClickableElement(city, driver);
        city.sendKeys(information);
    }

    public void setState(String information) {
        WaitUtils.waitForClickableElement(state, driver);
        state.sendKeys(information);
    }

    public void clickContinueButton() {
        WaitUtils.waitForClickableElement(continueButton, driver);
        continueButton.click();
    }

}
