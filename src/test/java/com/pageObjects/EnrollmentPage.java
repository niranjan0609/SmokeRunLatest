package com.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private By MyFamAdminLoginNameTxt = By.id("lblUserName");

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
    private By WAGetEcardLnk = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/a[1]");
    private By GHIdforEcardtxt = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div[1]/table/thead/tr/th[1]/span");
    private By WADwnldLink = By.xpath("//*[@id=\"policylogin\"]/div/div/button");
    private By GHIdTxt = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]");
    private By WAEmpLink = By.xpath("//*[@id=\"divLogin\"]/div[6]/ul/li[1]/a");
    private By GroupNameTxt = By.id("txtGroupName");
    private By WAempIdTxt = By.id("txtGroupUsr");
    private By WAPwdTxt  = By.id("txtGroupPassword");
    private By WAEmpLoginLink = By.id("Button1");
    private By loader = By.cssSelector(".blockUI");
    private By WApolicyDetailsLink = By.linkText("Policy Information");
    private By profileTxt = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td/h1[1]");

    private By WABankLink = By.xpath("//*[@id=\"divLogin\"]/div[6]/ul/li[2]/a");
    private By WAbankNameTxt = By.id("txtbanogroup");
    private By WAbankIdTxt = By.id("txtbano");
    private By WAbankRadioBtn = By.xpath("//*[@id=\"banologin\"]/div/div[2]/div[3]/label[2]/span");
    private By WAAccRadioBtn = By.xpath("//*[@id=\"accountlogin\"]/div/div[2]/div[3]/label[2]/span");
    private By WAbankPwdTxt  = By.id("txtbanopwd");
    private By WAbankLoginLink = By.id("divBANOLogincheck");
    private By WABankEcardLink = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/a[1]");
    private By WAbankDwnloadBtn = By.xpath("//*[@id=\"policylogin\"]/div/div/button");

    private By WAAccountLink = By.xpath("//*[@id=\"divLogin\"]/div[6]/ul/li[3]/a");
    private By WAAccbankNameTxt = By.id("txtaccountgroup");
    private By WAAccbankIdTxt = By.id("txtaccountno");
    private By WAAccbankPwdTxt = By.id("txtaccountpwd");
    private By WAAccbankLoginLink = By.id("divaccountLogincheck");
    private By WAAccGetEcardLink = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[7]/a[1]");


    private By WAPolicyNoLink = By.xpath("//*[@id=\"divLogin\"]/div[6]/ul/li[4]/a");
    private By WAPolicyNoTxt = By.id("txtpolicyno");
    private By WAPolicyInsurerNameTxt = By.id("txtpolicygroup");
    private By WAPolicyRadioBtn = By.xpath("//*[@id=\"policylogin\"]/div/div[2]/div[4]/label[2]/span");
    private By WAPolicyPwdTxt = By.id("txtpolicypwd");
    private By WAPolicyLoginLink = By.id("divpolicyLogincheck");
    private By WAPolicyClickEcardLink = By.xpath("//*[@id=\"form1\"]/div[3]/div/div[2]/div/div[1]/div[1]/table/thead/tr/th[1]/span");
    private By WApolicyDwbldLink = By.xpath("//*[@id=\"policylogin\"]/div/div/button");

    private By WAHPGetEcardLink = By.xpath("//*[@id=\"divLogin\"]/div[7]/ul/li[1]/a");
    private By WAHPPolTypeLink = By.id("ddlSelectType");
    private By WAHPGrpNameTxt = By.id("txtcorpgroupname");
    private By WAHPGHPLIDTxt = By.id("txtcorpghid");
    private By WAHPSubmitBtnLink = By.id("btnSubmitcorp");
    private By WAHPOtpTxt = By.id("txtotpent");
    private By WAHPOtpsubmitBtnLink = By.id("btnopt");
    private By WAHPSelectGHPLRadioBtnLink = By.xpath("//*[@id=\"tb\"]/tbody/tr[1]/td[5]/p/label/span");
    private By WAHPDwnldEcardfBtnLink = By.id("btndownloadEcard");

    private By WAHPClaimIntimationLink = By.xpath("//*[@id=\"divLogin\"]/div[7]/ul/li[2]/a");
    private By WACIntiSelectState = By.id("ContentPlaceHolder1_ddlStates");
    private By WACIntiSelectCity =  By.id("ContentPlaceHolder1_ddlCity");
    private By  WACIntiSelectHosp = By.xpath("//*[@id=\"tbNetwork\"]/tbody/tr[5]/td[1]/p/label/span");
    private By WACIntiHospName = By.id("ContentPlaceHolder1_txtHospitalNames");

    private By WAHPCheckClaimsLink = By.xpath("//*[@id=\"divLogin\"]/div[7]/ul/li[3]/a");
    private By WACClaimMsgTxt = By.id("ContentPlaceHolder1_lblError");


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
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
    }

    public void clickOnPolicyDetails() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WApolicyDetailsLink)));
        driver.findElement(WApolicyDetailsLink).click();

    }

    public void clickOnGHIdForEcard() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(GHIdforEcardtxt)));
        driver.findElement(GHIdforEcardtxt).click();
    }

    public String getAfterLoginTxt() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(profileTxt)));
        return driver.findElement(profileTxt).getText();
    }

    public void ClickOnBankLink() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WABankLink)));
        driver.findElement(WABankLink).click();
    }

    public void enterAccBankName(String bankName) {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccbankNameTxt)));
        driver.findElement(WAAccbankNameTxt).sendKeys(bankName);
    }
    public void enterBankName(String bankName) {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankNameTxt)));
        driver.findElement(WAbankNameTxt).sendKeys(bankName);
    }
    public void enterAccountNo(String bankAcNo) {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankIdTxt)));
        driver.findElement(WAbankIdTxt).sendKeys(bankAcNo);
    }

    public void enterPasswordforBankAccount(String accPassword) {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankPwdTxt)));
        driver.findElement(WAbankPwdTxt).sendKeys(accPassword);
    }

    public void enterPasswordforAccBankAccount(String accPassword) {


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccbankPwdTxt)));
        driver.findElement(WAAccbankPwdTxt).sendKeys(accPassword);
    }

    public void clickOnLoginBankAccount() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankLoginLink)));
        driver.findElement(WAbankLoginLink).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
    }

    public void clickOnRadioBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankRadioBtn)));
        driver.findElement(WAbankRadioBtn).click();
    }

    public void clickOnBankGetEcardLink() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WABankEcardLink)));
        driver.findElement(WABankEcardLink).click();
    }

    public void clickonBankDwnldCard() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAbankDwnloadBtn)));
        driver.findElement(WAbankDwnloadBtn).click();
    }

    public void ClickOnAccountLink() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccountLink)));
        driver.findElement(WAAccountLink).click();
    }

    public void enterAccountNo2(String bankAccNo) {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccbankIdTxt)));
        driver.findElement(WAAccbankIdTxt).sendKeys(bankAccNo);
    }

    public void clickOnLoginAccBankAccount() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccbankLoginLink)));
        driver.findElement(WAAccbankLoginLink).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
    }

    public void clickOnAccRadioBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccRadioBtn)));
        driver.findElement(WAAccRadioBtn).click();
    }

    public void clickOnAccBankGetEcardLink() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAAccGetEcardLink)));
        driver.findElement(WAAccGetEcardLink).click();
    }

    public void ClickOnPolicyNoLink() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyNoLink)));
        driver.findElement(WAPolicyNoLink).click();

    }

    public void enterInsurerName(String insurerName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyInsurerNameTxt)));
        driver.findElement(WAPolicyInsurerNameTxt).sendKeys(insurerName);
    }

    public void enterPolicyNo(String policyNo) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyNoTxt)));
        driver.findElement(WAPolicyNoTxt).sendKeys(policyNo);
    }

    public void clickOnPolicyRadioBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyRadioBtn)));
        driver.findElement(WAPolicyRadioBtn).click();
    }

    public void enterPasswordforPolicyNo(String accPassword) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyPwdTxt)));
        driver.findElement(WAPolicyPwdTxt).sendKeys(accPassword);
    }

    public void clickOnLoginPolicyNo() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyLoginLink)));
        driver.findElement(WAPolicyLoginLink).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
    }

    public void clickOnPolicyGetEcardLink() {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAPolicyClickEcardLink)));
        driver.findElement(WAPolicyClickEcardLink).click();
    }

    public void clickonPolicyDwnldCard() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WApolicyDwbldLink)));
        driver.findElement(WApolicyDwbldLink).click();
    }

    public void ClickOnGetEcardHomePage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPGetEcardLink)));
        driver.findElement(WAHPGetEcardLink).click();
    }

    public void SelectPolicyType() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPPolTypeLink)));
        Select ptype = new Select(driver.findElement(WAHPPolTypeLink));
        ptype.selectByVisibleText("Corporate Policy");

        Thread.sleep(1000);

        //driver.findElements(topUpTxt1Lac).get(1).click();
    }

    public void enterGroupNameHomePage(String groupName) {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPGrpNameTxt)));
        driver.findElement(WAHPGrpNameTxt).sendKeys(groupName);
    }

    public void enterGHPLIDHomePage(String ghid) {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPGHPLIDTxt)));
        driver.findElement(WAHPGHPLIDTxt).sendKeys(ghid);
    }

    public void clickOnSubmitBtnHomePage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPSubmitBtnLink)));
        driver.findElement(WAHPSubmitBtnLink).click();

    }

    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPOtpTxt)));
        driver.findElement(WAHPOtpTxt).sendKeys(otp);
    }

    public void clickOnOtpSubmitBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPOtpsubmitBtnLink)));
        driver.findElement(WAHPOtpsubmitBtnLink).click();
    }

    public void selectEcardRadioBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPSelectGHPLRadioBtnLink)));
        driver.findElement(WAHPSelectGHPLRadioBtnLink).click();
    }

    public void clickOnDwnldEcardHomePage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPDwnldEcardfBtnLink)));
        driver.findElement(WAHPDwnldEcardfBtnLink).click();
    }

    public void ClickOnClaimIntimationHomePage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPClaimIntimationLink)));
        driver.findElement(WAHPClaimIntimationLink).click();
    }

    public void selectState() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WACIntiSelectState)));
        Select state = new Select(driver.findElement(WACIntiSelectState));
        state.selectByVisibleText("TELANGANA");

        Thread.sleep(1000);
    }

    public void selectCity() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WACIntiSelectCity)));
        Select state = new Select(driver.findElement(WACIntiSelectCity));
        state.selectByVisibleText("HYDERABAD");

        Thread.sleep(1000);
    }

    public void selectHospital() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WACIntiSelectHosp)));
        driver.findElement(WACIntiSelectHosp).click();
    }

    public String readSelectedHospital() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WACIntiHospName)));
       String str = driver.findElement(WACIntiHospName).getText();

       Thread.sleep(4000);
        System.out.print(str);
       return str;
    }

    public void ClickOnCheckClaimStatusHomePage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WAHPCheckClaimsLink)));
        driver.findElement(WAHPCheckClaimsLink).click();
    }

    public String readClaimsMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(WACClaimMsgTxt)));
        String errorMsg = driver.findElement(WACClaimMsgTxt).getText();

        Thread.sleep(4000);
        System.out.print(errorMsg);
        return errorMsg;

    }

    public String readLoginName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MyFamAdminLoginNameTxt)));
        String name = driver.findElement(MyFamAdminLoginNameTxt).getText();

        Thread.sleep(4000);
        System.out.print(name);
        return name;

    }
}

