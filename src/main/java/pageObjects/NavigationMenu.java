package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class NavigationMenu {
    WebDriver driver;

    @FindBy(css = ".callToActionSubmit  a")
    private WebElement continueButton;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void clickContinueButton() {
        WaitUtils.waitForVisibleElement(continueButton, driver);
        continueButton.click();
    }

}
