package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class ManageInfoPage {
    WebDriver driver;
    @FindBy(css = "[title='Communication Info']")
    private WebElement communicationInfo;

    @FindBy(css = "[title='Addresses']")
    private WebElement addresses;

    @FindBy(css = "[title='Legislative Info']")
    private WebElement legislativeInfo;

    @FindBy(css = "[title='Citizenship Info']")
    private WebElement citizenshipInfo;

    @FindBy(css = "[title='Passport Info']")
    private WebElement passportInfo;

    @FindBy(css = "[title*='Licenses']")
    private WebElement driversLicenses;

    @FindBy(css = "[title='Visas and Permits']")
    private WebElement visasandPermits;

    @FindBy(css = "[title='Family and Emergency Contacts']")
    private WebElement family;

    @FindBy(css = "[title='Assign Managers']")
    private WebElement assignManagers;

    @FindBy(css = "[title='Work Relationship Info']")
    private WebElement workInfo;

    @FindBy(css = "[title='Payroll Details']")
    private WebElement payrollDetails;

    @FindBy(css = "[title='Salary']")
    private WebElement salary;

    @FindBy(css = "[title='Compensation']")
    private WebElement compensation;

    @FindBy(css = "[title='Add Direct Reports']")
    private WebElement addReports;

    @FindBy(css = "[title='Comments and Attachments']")
    private WebElement attachments;

    public ManageInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtils.waitForDocumentReadyState(driver);
    }

    public void selectCommunicationInfo() {
        WaitUtils.waitForVisibleElement(communicationInfo, driver);
        communicationInfo.click();
    }

    public void selectAll() {
        WaitUtils.waitForVisibleElement(communicationInfo, driver);
        communicationInfo.click();
        addresses.click();
        legislativeInfo.click();
        citizenshipInfo.click();
        passportInfo.click();
        driversLicenses.click();
        visasandPermits.click();
        family.click();
        assignManagers.click();
        workInfo.click();
        payrollDetails.click();
        salary.click();
        compensation.click();
        addReports.click();
        attachments.click();
    }
}
