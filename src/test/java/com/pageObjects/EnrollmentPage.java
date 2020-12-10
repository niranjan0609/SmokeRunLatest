package com.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnrollmentPage {
    private static final Logger log = LogManager.getLogger(EnrollmentPage.class);

    private WebDriver driver;
    private WebDriverWait wait;
//Ienroll Locators
    private By empIdTxt = By.id("txtUsrName");
    private By passwordTxt = By.id("txtPassword");
    private By submitTxt = By.id("btnLogin");
    private By proceedTxt = By.xpath("//*[@id=\"SnapShot\"]/div[2]/div/button");
    private By eCardMyFamily = By.id("EmpControl_lnkDownloadEcard");
    private By eCardCiti = By.id("lnkDownloadEcard");
    private By eCardZee = By.id("EmpControl_lnkDownloadEcard");
    private By AdminUsernameTxt = By.id("txtUserName");
    private By AdminPwdTxt = By.id("txtPassword");
    private By AdminLoginBtnTxt = By.id("btnLogin");

//Evexia Admin Locators
    private By UsernameEvTxt = By.name("email");
    private By pWordEvTxt = By.name("password");
    private By signinTxt = By.xpath("/html/body/div/div/div/div[3]/form/div[4]/div/div[2]/button");
    private By DashboardTxt = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/h1");

    //Evexia Emp Portal Locators
    private By EmailEvTxt = By.name("email");
    private By pWordEmpEvTxt = By.name("password");
    private By signinEmpTxt = By.id("btnSignIn");
    private By SecondSigninBtnTxt = By.id("BtnLogin");
    private By HomePageTxt = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/div");


    //WebAce Portal Locators
    private By WAEmpIDTxt = By.id("txtUsrName");
    private By WAEmpPwdTxt = By.name("txtPassword");
    private By WALoginBtnTxt = By.id("btnLogin");
    private By WAGetEcardLnk = By.linkText("Get E-Card");
    private By WADwnldLink = By.xpath("//*[@id=\"policylogin\"]/div/div/button");
    private By GHIdTxt = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]");
    private By WAEmpLink = By.linkText("Employee ID");
    private By GroupNameTxt = By.id("txtGroupName");
    private By WAempIdTxt = By.id("txtGroupUsr");
    private By WAPwdTxt  = By.id("txtGroupPassword");
    private By WAEmpLoginLink = By.id("Button1");
    private By WAHomeLink = By.linkText("Home");


    public EnrollmentPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        wait = new WebDriverWait(driver, 120);
    }

    public String getTxt() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(DashboardTxt)));
        String rtnTxt = driver.findElement(DashboardTxt).getText();
        return rtnTxt;
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void enterEmpID(String EmpID) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(empIdTxt)));
        driver.findElement(empIdTxt).clear();
        driver.findElement(empIdTxt).sendKeys(EmpID);
    }

    public void enterPassword(String Password) {
        // TODO Auto-generated method stub
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordTxt)));
        driver.findElement(passwordTxt).clear();
        driver.findElement(passwordTxt).sendKeys(Password);
    }

    public void clickonProceed() {
        // TODO Auto-generated method stub
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedTxt)));
        driver.findElement(proceedTxt).click();
    }


    public void clickOnSubmit() {
        // TODO Auto-generated method stub
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitTxt)));
        driver.findElement(submitTxt).click();
    }

    public void clickOnECardMyFamily() throws InterruptedException {
        // TODO Auto-generated method stub
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(eCardMyFamily)));
        driver.findElement(eCardMyFamily).click();
        //Wait for download to finish
        Thread.sleep(5000);
    }

    public void clickOnECardCiti() throws InterruptedException {
        // TODO Auto-generated method stub
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(eCardCiti)));
        driver.findElement(eCardCiti).click();
        //Wait for download to finish
        Thread.sleep(5000);
    }

    public void enterUserNameEv(String username) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(UsernameEvTxt)));
        driver.findElement(UsernameEvTxt).clear();
        driver.findElement(UsernameEvTxt).sendKeys(username);
    }

    public void enterEvexiaPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pWordEvTxt)));
        driver.findElement(pWordEvTxt).clear();
        driver.findElement(pWordEvTxt).sendKeys(password);

    }

    public void clickOnSignin() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signinTxt)));
        driver.findElement(signinTxt).click();
    }

    public void clickonSigninEmp() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signinEmpTxt)));
        driver.findElement(signinEmpTxt).click();

    }

    public void enterEmail(String username) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(EmailEvTxt)));
        driver.findElement(EmailEvTxt).clear();
        driver.findElement(EmailEvTxt).sendKeys(username);
    }

    public void enterEvexiaEmpPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pWordEmpEvTxt)));
        driver.findElement(pWordEmpEvTxt).clear();
        driver.findElement(pWordEmpEvTxt).sendKeys(password);


    }

    public void clickOnSecondSignin() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SecondSigninBtnTxt)));
        driver.findElement(SecondSigninBtnTxt).click();
    }

    public String getHomeTxt() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePageTxt)));
        String rtnTxt = driver.findElement(HomePageTxt).getText();
        return rtnTxt;
    }

    public void clickOnECardZee() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(eCardZee)));
        driver.findElement(eCardZee).click();
        //Wait for download to finish
        Thread.sleep(5000);
    }

    public void enterAdminID(String username) {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AdminUsernameTxt)));
        driver.findElement(AdminUsernameTxt).clear();
        driver.findElement(AdminUsernameTxt).sendKeys(username);
    }

    public void enterAdminPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AdminPwdTxt)));
        driver.findElement(AdminPwdTxt).clear();
        driver.findElement(AdminPwdTxt).sendKeys(password);
    }

    public void clickOnLoginNow() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AdminLoginBtnTxt)));
        driver.findElement(AdminLoginBtnTxt).click();
    }

    public void enterWebAceEmpID(String username) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAEmpIDTxt)));
        driver.findElement(WAEmpIDTxt).clear();
        driver.findElement(WAEmpIDTxt).sendKeys(username);
    }

    public void enterWebAceEmpPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAEmpPwdTxt)));
        driver.findElement(WAEmpPwdTxt).clear();
        driver.findElement(WAEmpPwdTxt).sendKeys(password);

    }

    public void clickOnWebAceLogin() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WALoginBtnTxt)));
        driver.findElement(WALoginBtnTxt).click();
    }

    public void clickOnGetEcard() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAGetEcardLnk)));
        driver.findElement(WAGetEcardLnk).click();
    }

    public void clickOnDownloadEcard() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WADwnldLink)));
        driver.findElement(WADwnldLink).click();
    }

    public String getGHID() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(GHIdTxt)));
        String GHId = driver.findElement(GHIdTxt).getText();
        return GHId;
    }

    public void ClickOnEmpID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAEmpLink)));
        driver.findElement(WAEmpLink).click();

    }



    public void enterGroupName(String groupName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(GroupNameTxt)));
        driver.findElement(GroupNameTxt).clear();
        driver.findElement(GroupNameTxt).sendKeys(groupName);

    }

    public void enterEmpNo(String EmpId) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAempIdTxt)));
        driver.findElement(WAempIdTxt).clear();
        driver.findElement(WAempIdTxt).sendKeys(EmpId);

    }

    public void enterPasswordforEmpID(String EmpPassword) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPwdTxt)));
        driver.findElement(WAPwdTxt).clear();
        driver.findElement(WAPwdTxt).sendKeys(EmpPassword);

    }

    public void clickOnLoginEmpID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAEmpLoginLink)));
        driver.findElement(WAEmpLoginLink).click();
    }

    public void clickOnHome() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHomeLink)));
        driver.findElement(WAHomeLink).click();

    }

}
