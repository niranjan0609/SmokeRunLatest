package com.Tests;

import com.aventstack.extentreports.Status;
import com.base.ExtentTestManager;
import com.base.TestBase;
import com.pageObjects.EnrollmentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebAceCheckClaimStatusTest extends TestBase {
    private static final Logger log = LogManager.getLogger(WebAceCheckClaimStatusTest.class);

    private WebDriver driver;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Parameters({ "GroupName", "GHPLID", "otp" })
    @Test(enabled=true)
    public void WACheckClaims(String GroupName, String GHPLID, String otp) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "Entered Bank Details");
        enrollmentPage.ClickOnCheckClaimStatusHomePage();
        Thread.sleep(2000);


        enrollmentPage.SelectPolicyType();
        enrollmentPage.enterGroupNameHomePage(GroupName);
        Thread.sleep(6000);
        enrollmentPage.enterGHPLIDHomePage(GHPLID); //GHOI1000005972

        enrollmentPage.clickOnSubmitBtnHomePage();
        Thread.sleep(6000);
        enrollmentPage.enterOtp(otp); //919219
        enrollmentPage.clickOnOtpSubmitBtn();

        Thread.sleep(6000);

        String displayedClaimMsg = enrollmentPage.readClaimsMessage();
        Thread.sleep(6000);
        String expectedMsg = "Claims Not found";
        Thread.sleep(4000);
        Assert.assertEquals(displayedClaimMsg,expectedMsg, "Test has failed" );







        ExtentTestManager.getTest().log(Status.INFO, "Claim Checking Test has been Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }




}
