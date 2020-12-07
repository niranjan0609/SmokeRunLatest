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

public class CitiTest extends TestBase {
    private static final Logger log = LogManager.getLogger(MyFamilyTest.class);

    private WebDriver driver;
    EnrollmentPage  enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Parameters({ "username", "password" })
    @Test
    public void iEnrollPortal(String username, String password) throws InterruptedException {

        log.debug("Test started...");
        // ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password");
        enrollmentPage.enterEmpID(username);
        enrollmentPage.enterPassword(password);
        enrollmentPage.clickOnSubmit();
        // ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");
        Thread.sleep(2000);
        enrollmentPage.clickonProceed();
        enrollmentPage.clickOnECardCiti();
        String downloadFilepath = "C:\\Users\\niranjan.t\\Downloads\\TestData\\";
        Assert.assertTrue(isFileDownloaded(downloadFilepath, username+".pdf"), "File download failed");


        Thread.sleep(2000);

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
