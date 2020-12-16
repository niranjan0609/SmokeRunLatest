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

import java.io.File;

public class WebAceClaimIntimationTest extends TestBase {

    private static final Logger log = LogManager.getLogger(WebAceClaimIntimationTest.class);

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
    public void WAClaimIntimationCheck(String GroupName, String GHPLID, String otp) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "Entered Bank Details");
        enrollmentPage.ClickOnClaimIntimationHomePage();
        Thread.sleep(2000);


        enrollmentPage.SelectPolicyType();
        enrollmentPage.enterGroupNameHomePage(GroupName);
        Thread.sleep(6000);
        enrollmentPage.enterGHPLIDHomePage(GHPLID); //GHOI1000005972

        enrollmentPage.clickOnSubmitBtnHomePage();
        Thread.sleep(6000);
        enrollmentPage.enterOtp(otp); //919219
        enrollmentPage.clickOnOtpSubmitBtn();
        enrollmentPage.selectEcardRadioBtn();
        Thread.sleep(6000);
        enrollmentPage.selectState();
        enrollmentPage.selectCity();
        enrollmentPage.selectHospital();
        String displayedhospname = enrollmentPage.readSelectedHospital();
        Thread.sleep(6000);
        String expectedhospname = "APOLLO EMERGENCY HOSPITAL-HYDERGUDA";
        Thread.sleep(4000);
        //Assert.assertEquals(displayedhospname,expectedhospname, "Displayed hospital name is incorrect" );







        ExtentTestManager.getTest().log(Status.INFO, "Claim Intimation has been Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }



}
