package pageObjects;

import org.openqa.selenium.By;
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

    public AdressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setPhoneType(String option) {
        WaitUtils.waitForClickableElement(typeDropdown, driver);
        typeDropdown.click();
        WebElementUtils.clickElementWithTextFromListOfElements(option, typeDropdownOptions);
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

}
