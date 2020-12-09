package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.pageObjects.EnrollmentPage;

import com.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class EvexiaAdminTest extends TestBase {
    private static final Logger log = LogManager.getLogger(EvexiaAdminTest.class);

    private WebDriver driver;
    //LoginPage loginPage;
    Actions action;
    EnrollmentPage  enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "username", "password" })
    @Test(enabled=true)
    public void EvexiaAdminPortal(String username, String password) throws InterruptedException {

        log.debug("Test started...");
        // ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password");
        enrollmentPage = new EnrollmentPage(driver);
        enrollmentPage.enterUserNameEv(username);
        enrollmentPage.enterEvexiaPassword(password);
        enrollmentPage.clickOnSignin();




        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enrollmentPage.getTxt(), "Dashboard", "Login Failed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }

 }
