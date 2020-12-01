package com.Tests;

import com.base.TestBase;
import com.pageObjects.EnrollmentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EvexiaEmpTest extends TestBase {

    private static final Logger log = LogManager.getLogger(EvexiaEmpTest.class);

    private WebDriver driver;
    //LoginPage loginPage;
    Actions action;
    EnrollmentPage enrollmentPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "username", "password" })
    @Test
    public void EvexiaEmpPortal(String username, String password) throws InterruptedException {

        log.debug("Test started...");
        // ExtentTestManager.getTest().log(Status.INFO, "On LoginPage, Enter DCB Emp ID & DOB as Password");
        enrollmentPage = new EnrollmentPage(driver);
        enrollmentPage.clickonSigninEmp();
        enrollmentPage.enterEmail(username);
        enrollmentPage.enterEvexiaEmpPassword(password);
        enrollmentPage.clickOnSecondSignin();

Thread.sleep(5000);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enrollmentPage.getHomeTxt(), "LATEST EVENTS", "Login Failed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void testTearDown() {
        //To start a test from beginning
        enrollmentPage.deleteAllCookies();

    }
}
