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

public class WebAceBancaLoginTest extends TestBase {
    private static final Logger log = LogManager.getLogger(WebAceBancaLoginTest.class);

    private WebDriver driver;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Parameters({ "username", "password" })
    @Test(enabled=true)
    public void WebAceBancaPortalTest(String username, String password) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter Emp ID & Password");
        enrollmentPage.enterWebAceEmpID(username);
        enrollmentPage.enterWebAceEmpPassword(password);
        enrollmentPage.clickOnWebAceLogin();
        ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");
        Thread.sleep(6000);
        //String str = enrollmentPage.getGHID();
        enrollmentPage.clickOnGetEcard();
        ExtentTestManager.getTest().log(Status.INFO, "clicked on Ecard");
        enrollmentPage.clickOnDownloadEcard();
        ExtentTestManager.getTest().log(Status.INFO, "Ecard download Sucessful");
        Thread.sleep(3000);
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
