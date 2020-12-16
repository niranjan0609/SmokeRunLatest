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

public class WebAceGetEcardHomePage extends TestBase {

    private static final Logger log = LogManager.getLogger(WebAceGetEcardHomePage.class);

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
    public void WAGetEcardFromHomepageTest(String GroupName, String GHPLID, String otp) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "Entered Bank Details");
        enrollmentPage.ClickOnGetEcardHomePage();
        Thread.sleep(2000);


        enrollmentPage.SelectPolicyType();
        enrollmentPage.enterGroupNameHomePage(GroupName);
        Thread.sleep(6000);
        enrollmentPage.enterGHPLIDHomePage(GHPLID); //GHOI1000005967

        enrollmentPage.clickOnSubmitBtnHomePage();
        Thread.sleep(6000);
        enrollmentPage.enterOtp(otp); //919219
        enrollmentPage.clickOnOtpSubmitBtn();
        enrollmentPage.selectEcardRadioBtn();
        enrollmentPage.clickOnDwnldEcardHomePage();

        Thread.sleep(6000);


        String downloadFilepath = "C:\\Users\\niranjan.t\\Downloads\\TestData\\";

        Assert.assertTrue(isFileDownloaded(downloadFilepath, GHPLID+".pdf"), "File download failed");




        ExtentTestManager.getTest().log(Status.INFO, "Ecard Download Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)) {
                flag=true;
                //delete file once it is found
                dir_contents[i].delete();
            }


        }

        return flag;
    }


}