package com.Tests;

import com.base.TestBase;
import com.pageObjects.EnrollmentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

public class MyFamilyAdminTest extends TestBase {

    private static final Logger log = LogManager.getLogger(MyFamilyTest.class);

    private WebDriver driver;
    //LoginPage loginPage;
    Actions action;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "username", "password" })
    @Test(enabled=true)
    public void iEnrollAdminPortal(String username, String password) throws InterruptedException {

        log.debug("Test started...");
        // ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password");
        enrollmentPage = new EnrollmentPage(driver);
        enrollmentPage.enterAdminID(username);
        enrollmentPage.enterAdminPassword(password);
        enrollmentPage.clickOnLoginNow();
        Thread.sleep(2000);

        String displayedLoginName = enrollmentPage.readLoginName();
        Thread.sleep(6000);
        String expectedName = "Tulasi Krishna Reddy";
        Thread.sleep(4000);
        Assert.assertEquals(displayedLoginName,expectedName, "Login Unsuccessful" );


    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }


}
