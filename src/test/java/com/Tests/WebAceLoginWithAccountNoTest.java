package com.Tests;

import com.aventstack.extentreports.Status;
import com.base.ExtentTestManager;
import com.base.TestBase;
import com.pageObjects.EnrollmentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebAceLoginWithAccountNoTest extends TestBase {
    private static final Logger log = LogManager.getLogger(WebaceLoginWithBankTest.class);

    private WebDriver driver;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Parameters({ "bankName", "bankAccNo", "accPassword" })
    @Test(enabled=true)
    public void WALoginWithBankDetailsTest(String bankName, String bankAccNo, String accPassword) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "Entered Bank Details");
        enrollmentPage.ClickOnAccountLink();
        Thread.sleep(2000);
        enrollmentPage.enterAccBankName(bankName);

        enrollmentPage.enterAccountNo2(bankAccNo);

        enrollmentPage.clickOnAccRadioBtn();
        Thread.sleep(3000);
        enrollmentPage.enterPasswordforAccBankAccount(accPassword);
        enrollmentPage.clickOnLoginAccBankAccount();
        Thread.sleep(6000);
        enrollmentPage.clickOnAccBankGetEcardLink();
        enrollmentPage.clickonBankDwnldCard();


        //enrollmentPage.clickOnPolicyDetails();


        /*String str1 = "Please update your contact details of your GOOD HEALTH PROFILE\n" +
                "These details will be usefull in sending proper communication to you in case of any event.";
        String str2 = enrollmentPage.getAfterLoginTxt();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(str2, str1, "Login Successful");*/

        ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }
}
