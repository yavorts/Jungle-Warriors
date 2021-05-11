package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LandingPage {
    WebDriver driver;
    @FindBy(css = "#groupNode_workforce_management")
    private WebElement myClientGroups;

    @FindBy(css = "a[target='my_org_hirean_employee_1']")
    private WebElement hireAnEmployee;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void clickMyClientGroups() {
        WaitUtils.waitForVisibleElement(myClientGroups, driver);
        myClientGroups.click();
    }

    public void clickHireAnEmployee() {
        WaitUtils.waitForVisibleElement(hireAnEmployee, driver);
        hireAnEmployee.click();
    }
}
