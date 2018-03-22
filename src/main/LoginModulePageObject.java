package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class LoginModulePageObject {

	WebDriver driver;

	public LoginModulePageObject(WebDriver driver) {
		this.driver = driver;

	}

	// landing page locators

	By signInBtn = By.linkText("Sign in");

	// Log in page element locators
	By userIDTextBox = By.id("user_login");
	By passwordTextBox = By.id("user_pass");
	By captchaBox = By.className("recaptcha-checkbox-checkmark");
	By loginBtn = By.id("wp-submit");
	By loginError = By.id("login_error");
	By lostYourPwdLink = By.xpath("//*[@id='nav']/a");
	By backToCDPLink = By.linkText("← Back to Packt Content Development Platform");
	By getNewPasswordBtn = By.id("wp-submit");
	By getCheckMailMessage = By.className("message");
	By getNegativeChkMailMessage=By.id("login_error");
	
	//walk me pop cross btn
	
	//By walkmePopUpCrossBtn=By.xpath("//*[@id='wm-shoutout-46057']/div[1]");
	By walkmePopUpCrossBtn=By.cssSelector("div.wm-close-button");

	// signOut process locators

	By profileTabHover = By.xpath("//*[@id='wp-admin-bar-my-account']/a");
	By logOutBtn = By.linkText("Log Out");

	// password failure page locators

	public String loginSuccessFul(String userID, String pwd) throws InterruptedException {
		System.out.println("entered login page object");
		System.out.println(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on sign it button");
		
		driver.findElement(signInBtn).click();
		// entering user id
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);

		// entering user password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
		
		*/
		// driver.manage().timeouts().implicitlyWait(4,
		// TimeUnit.SECONDS);--implicite wait not working
		//Thread.sleep(4000);
		// clicking on login button
		// LoginModule.waitForPagetoLoad(driver, loginBtn);--fluent wait not
		// working
		driver.findElement(loginBtn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Log in button clicked after entering correct username and password");

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//Thread.sleep(5000);
		//driver.findElement(walkmePopUpCrossBtn).click();
		String nextPageTitle = driver.getTitle();
		return nextPageTitle;

	}
	
	public void loginSuccessFullWithoutWalkME(String userID,String pwd) throws InterruptedException{
		System.out.println("entered login page object");
		System.out.println(driver);
		driver.findElement(signInBtn).click();
		// entering user id
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);

		// entering user password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
		
		*/
		// driver.manage().timeouts().implicitlyWait(4,
		// TimeUnit.SECONDS);--implicite wait not working
		//Thread.sleep(4000);
		// clicking on login button
		// LoginModule.waitForPagetoLoad(driver, loginBtn);--fluent wait not
		// working
		driver.findElement(loginBtn).click();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void loginSuccessFullWIthoutSignIn(String userID, String pwd)throws InterruptedException{
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);

		// entering user password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
		
		*/
		// driver.manage().timeouts().implicitlyWait(4,
		// TimeUnit.SECONDS);--implicite wait not working
		//Thread.sleep(4000);
		// clicking on login button
		// LoginModule.waitForPagetoLoad(driver, loginBtn);--fluent wait not
		// working
		driver.findElement(loginBtn).click();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		Thread.sleep(5000);
		//driver.findElement(walkmePopUpCrossBtn).click();
		String nextPageTitle = driver.getTitle();
		//return nextPageTitle;

		
	}
	
	public void loginSuccessFullWIthoutSignInandWalkMe(String userID, String pwd)throws InterruptedException{
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);

		// entering user password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
		
		*/
		// driver.manage().timeouts().implicitlyWait(4,
		// TimeUnit.SECONDS);--implicite wait not working
		//Thread.sleep(4000);
		// clicking on login button
		// LoginModule.waitForPagetoLoad(driver, loginBtn);--fluent wait not
		// working
		driver.findElement(loginBtn).click();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		//Thread.sleep(5000);
		//driver.findElement(walkmePopUpCrossBtn).click();
		String nextPageTitle = driver.getTitle();
		//return nextPageTitle;

		
	}

	public String loginFailure(String userID, String pwd) throws InterruptedException {
		driver.findElement(signInBtn).click();
		// entering user id
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);
		//
		// entering user wrong password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();

	*///	Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// clicking on login button

		driver.findElement(loginBtn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "login button clicked after entering wrong username and password");
		
		LoginModule.waitForPagetoLoad(driver, getNegativeChkMailMessage);
		
		String errorText = driver.findElement(getNegativeChkMailMessage).getText();
		ExtentTestManager.getTest().log(LogStatus.INFO, "returning error text");
		return errorText;
		

	}

	public String LoginFailureWrongUserName(String userID, String pwd) throws InterruptedException {
		driver.findElement(signInBtn).click();
		// entering user id
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);
		//
		// entering user wrong password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();

		Thread.sleep(4000);*/
		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// clicking on login button

		driver.findElement(loginBtn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "login button clicked after entering wrong username and password");
		//Thread.sleep(5000);
		LoginModule.waitForPagetoLoad(driver, loginError);
		String errorText = driver.findElement(loginError).getText();
		return errorText;

	}

	public String lostPwd(String userID) {

		driver.findElement(lostYourPwdLink).click();

		System.out.println("entered forgot password");

		System.out.println(driver.getTitle());
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		boolean token = userIDTBox.isDisplayed();
		System.out.println(token);

		userIDTBox.clear();

		userIDTBox.sendKeys(userID);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		

		String lostPasswordPageTitle = driver.getTitle();
		return lostPasswordPageTitle;

	}

	public Boolean loginBtnDisabledCheck(String userID, String pwd) throws InterruptedException {
		driver.findElement(signInBtn).click();
		// entering user id
		Thread.sleep(2000);
		WebElement userIDTBox = driver.findElement(userIDTextBox);
		userIDTBox.clear();
		userIDTBox.sendKeys(userID);
		Thread.sleep(2000);
		// entering user wrong password
		WebElement pwdTBox = driver.findElement(passwordTextBox);
		pwdTBox.clear();
		pwdTBox.sendKeys(pwd);

		Thread.sleep(4000);
		Boolean loginBtnAttribute = driver.findElement(loginBtn).isEnabled();
		return loginBtnAttribute;

	}

	public String backToCDPLinkCheck() throws InterruptedException {
		driver.findElement(signInBtn).click();
		//Thread.sleep(2000);

		driver.findElement(backToCDPLink).click();

		//Thread.sleep(2000);
ExtentTestManager.getTest().log(LogStatus.INFO, "back to CDP link clicked");

		String landingPageTilte = driver.getTitle();
		return landingPageTilte;

	}

	public String passwordRecovery(String userID) throws InterruptedException {
		driver.findElement(signInBtn).click();
		//Thread.sleep(2000);

		driver.findElement(lostYourPwdLink).click();

		WebElement userIDTBox = driver.findElement(userIDTextBox);

		userIDTBox.clear();

		userIDTBox.sendKeys(userID);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
*/
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		Thread.sleep(4000);

		

		driver.findElement(getNewPasswordBtn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "after filling all the inputs correctly clicked on get new password button");
		
		//Thread.sleep(5000);
LoginModule.waitForPagetoLoad(driver, getCheckMailMessage);
		String checkEmailText = driver.findElement(getCheckMailMessage).getText();

		String lostPasswordPageTitle = driver.getTitle();
		return checkEmailText;

	}
	
	public String passwordRecoveryNegative(String userID) throws InterruptedException {
		driver.findElement(signInBtn).click();
		//Thread.sleep(2000);

		driver.findElement(lostYourPwdLink).click();

		WebElement userIDTBox = driver.findElement(userIDTextBox);

		userIDTBox.clear();

		userIDTBox.sendKeys(userID);

		// clicking on recaptcha
/*
		driver.switchTo().frame(0);
		driver.findElement(captchaBox).click();
		driver.switchTo().parentFrame();
*/
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	//	Thread.sleep(4000);

		System.out.println("takesScreenshot");

		driver.findElement(getNewPasswordBtn).click();
		
		//Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "After filling wrong user name, get new password button has been clicked");
		LoginModule.waitForPagetoLoad(driver, getNegativeChkMailMessage);
		String checkEmailText = driver.findElement(getNegativeChkMailMessage).getText();

		String lostPasswordPageTitle = driver.getTitle();
		return checkEmailText;

	}

}
