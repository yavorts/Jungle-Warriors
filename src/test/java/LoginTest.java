
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;
import testUtils.BaseTest;
import utils.WaitUtils;
import utils.GetDataFromExcel;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginTest extends BaseTest {
    public WebDriver driver;
    static Logger log = LogManager.getLogger(LoginTest.class.getName());


    @BeforeTest
    public void setupTest() throws MalformedURLException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(getUrlFromProperies());
        log.info("Get to homepage url");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"curtis.feitty", "ANP8e^9#"}};
    }
//    public Object[][] dpMethod() {
//        return new Object[][]{{"curtis.feitty", "bUp49695"}};
//    }


    @Test(dataProvider = "data-provider")
    public void verifyUserCanLogin(String email, String password) throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserId(email);
        log.info("Enter email to log in");
        loginPage.setPassword(password);
        log.info("Enter password");
        loginPage.clickSignInButtonButton();
        log.info("User has successfully logged in");

        Assert.assertEquals(driver.getTitle(), "Oracle Applications");
        log.info("User has successfully logged in");
        Thread.sleep(20000);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickMyClientGroups();
        landingPage.clickHireAnEmployee();
        Thread.sleep(20000);
        ManageInfoPage manageInfoPage = new ManageInfoPage(driver);
        manageInfoPage.selectAll();
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickContinueButton();
        Thread.sleep(5000);
        WhenWhyPage whenPage = new WhenWhyPage(driver);
        whenPage.setHireDate(GetDataFromExcel.getData().get(1));

        whenPage.setWhenWhyOptionFromText("hire an employee?", GetDataFromExcel.getData().get(3));
        whenPage.setWhenWhyOptionFromText("Legal Employer", GetDataFromExcel.getData().get(2));
        whenPage.setWhenWhyOptionFromText("Why are you hiring an employee?", GetDataFromExcel.getData().get(4));

//        whenPage.setWhenWhyOptionFromText("Why are you making changes to direct reports?", GetDataFromExcel.getData().get(5));
        whenPage.clickContinueButton();
        Thread.sleep(5000);
        PersonalDetailsPage detailsPage = new PersonalDetailsPage(driver);
        detailsPage.setTitle(GetDataFromExcel.getData().get(7));
        detailsPage.setPersonalDetailsOptionFromText("First Name", GetDataFromExcel.getData().get(8));
        detailsPage.setPersonalDetailsOptionFromText("Middle Name", GetDataFromExcel.getData().get(9));
        detailsPage.setPersonalDetailsOptionFromText("Last Name", GetDataFromExcel.getData().get(10));
        detailsPage.setGender(GetDataFromExcel.getData().get(11));
        detailsPage.setDateOfBirth("1/5/1986");
        detailsPage.setPersonalDetailsOptionFromText("Country of Birth", GetDataFromExcel.getData().get(13));
        detailsPage.setPersonalDetailsOptionFromText("Region of Birth", GetDataFromExcel.getData().get(14));
        detailsPage.setPersonalDetailsOptionFromText("Country", GetDataFromExcel.getData().get(15));
        detailsPage.setNationalIdType(GetDataFromExcel.getData().get(16));
        detailsPage.setNationalIDNumber(GetDataFromExcel.getData().get(17));
        detailsPage.clickContinueButton();
        CommunicationInfo communicationInfo = new CommunicationInfo(driver);
        communicationInfo.setPhoneType(GetDataFromExcel.getData().get(18));
        communicationInfo.setCountry(GetDataFromExcel.getData().get(19));


    }

    @AfterTest
    public void tearDown() {

        // Close application.
        driver.quit();


    }
}

