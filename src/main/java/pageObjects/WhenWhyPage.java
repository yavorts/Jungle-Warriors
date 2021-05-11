package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.WebElementUtils;

import java.util.List;

public class WhenWhyPage {
    WebDriver driver;

    @FindBy(css = "[placeholder='m/d/yy']")
    private WebElement hireDate;

    @FindBy(css = "[title='Continue']")
    private WebElement continueButton;

    public WhenWhyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void setHireDate(String date) {
        WaitUtils.waitForVisibleElement(hireDate, driver);
        hireDate.clear();
        hireDate.sendKeys(date);
    }

    public void setWhenWhyOptionFromText(String whenWhyOption, String information) {
        String locator = "//*[contains(text(),'" + whenWhyOption + "')]/../..//input[@type='text']";
        if(driver.findElement(By.xpath(locator)).isDisplayed()) {
        WebElement element = driver.findElement(By.xpath(locator));
            WaitUtils.waitForClickableElement(element, driver);
            element.clear();
            element.sendKeys(information);
        }
    }

    public void clickContinueButton() {
        WaitUtils.waitForClickableElement(continueButton, driver);
        continueButton.click();
    }
}
