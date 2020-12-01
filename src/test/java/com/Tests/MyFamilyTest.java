package com.Tests;

import java.io.File;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.pageObjects.EnrollmentPage;

import com.util.ExcelReader;

import com.base.TestBase;

public class MyFamilyTest extends TestBase {
    private static final Logger log = LogManager.getLogger(MyFamilyTest.class);

    private WebDriver driver;
    //LoginPage loginPage;
    Actions action;
    EnrollmentPage  enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "username", "password" })
    @Test
    public void iEnrollPortal(String username, String password) throws InterruptedException {

        log.debug("Test started...");
       // ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password");
        enrollmentPage = new EnrollmentPage(driver);
        enrollmentPage.enterEmpID(username);
        enrollmentPage.enterPassword(password);
        enrollmentPage.clickOnSubmit();
       // ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");
        enrollmentPage.clickonProceed();
        enrollmentPage.clickOnECardMyFamily();
        String downloadFilepath = "C:\\Users\\niranjan.t\\Downloads\\TestData\\";
        Assert.assertTrue(isFileDownloaded(downloadFilepath, username+".pdf"), "File download failed");

        Thread.sleep(2000);
        /*SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(SumInsuredValue, pojoData.getSumInsured(), "Sum insured displayed on Portal is not correct");
        //ExtentTestManager.getTest().log(Status.INFO, "Base Sum Insured displayed on Portal is matching with the SI mentioned on DCB policy note");
        softAssert.assertEquals(premiumValue, pojoData.getPremium(), "Actual premium value not matching with expected value");
        //ExtentTestManager.getTest().log(Status.INFO, "Base Premium for Base SI displayed on Portal is matching with the DCB policy Unit rate");


        softAssert.assertAll();*/
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
            System.out.println(dir_contents[i].getName());
            if (dir_contents[i].getName().equals(fileName)) {
                flag=true;
                //delete file once it is found
                dir_contents[i].delete();
            }
        }
        return flag;
    }
}
