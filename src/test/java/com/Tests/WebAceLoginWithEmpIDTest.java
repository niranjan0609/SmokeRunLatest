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

public class WebAceLoginWithEmpIDTest extends TestBase {

    private static final Logger log = LogManager.getLogger(WebAceLoginWithEmpIDTest.class);

    private WebDriver driver;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        enrollmentPage = new EnrollmentPage(driver);
    }

    @Parameters({ "groupName", "EmpId", "EmpPassword" })
    @Test(enabled=true)
    public void WALoginWithEmpIDTest(String groupName, String EmpId, String EmpPassword) throws InterruptedException {

        log.debug("Test started...");
        ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter Emp ID & Password");
        enrollmentPage.ClickOnEmpID();
        Thread.sleep(2000);
        enrollmentPage.enterGroupName(groupName);
        enrollmentPage.enterEmpNo(EmpId);
        enrollmentPage.enterPasswordforEmpID(EmpPassword);
        enrollmentPage.clickOnLoginEmpID();

        Thread.sleep(6000);
        //String str = enrollmentPage.getGHID();
        enrollmentPage.clickOnHome();
        ExtentTestManager.getTest().log(Status.INFO, "Login Successful...");

    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }

}
