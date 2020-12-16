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

public class WebAceLoginWithPolicyNoTest extends TestBase {

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

    @Parameters({ "insurerName", "policyNo", "accPassword" })
    @Test(enabled=true)
    public void WALoginWithBankDetailsTest(String insurerName, String policyNo, String accPassword) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "Entered Bank Details");
        enrollmentPage.ClickOnPolicyNoLink();
        Thread.sleep(2000);
        enrollmentPage.enterInsurerName(insurerName);
        Thread.sleep(2000);
        enrollmentPage.enterPolicyNo(policyNo);

        enrollmentPage.clickOnPolicyRadioBtn();
        Thread.sleep(3000);
        enrollmentPage.enterPasswordforPolicyNo(accPassword);
        enrollmentPage.clickOnLoginPolicyNo();
        Thread.sleep(6000);
        enrollmentPage.clickOnPolicyGetEcardLink();
        enrollmentPage.clickonPolicyDwnldCard();




        ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }
}
