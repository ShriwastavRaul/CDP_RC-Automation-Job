package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import main.BaseClass;
import main.LoginModule;
import reports.ExtentTestManager;

public class LoginModuleScript extends BaseClass {

	WebDriver driver;

	LoginModule loginModule = new LoginModule();
	// collection to fill the data

	@BeforeMethod

	public void launchApplication() {

		// function of extracting the data from csv:data filled

		String browser = "firefox";
		String url = "https://rc-cdp.packtpub.com/";
		driver = browserToOpen(browser);
		driver.manage().timeouts().pageLoadTimeout(25L, TimeUnit.SECONDS);
		hitURL(driver, url);
		

	}

	@Test(priority=1)

	public void loginSuccessful() throws InterruptedException {
		System.out.println(driver);
		String landingPageTitle = driver.getTitle();
		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "calling successfull login funcltion");
		String loggedInPageTitle = loginModule.loginSuccessful(driver, userName, password);
		System.out.println(loggedInPageTitle);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the next page title");
		Assert.assertFalse(landingPageTitle.equals(loggedInPageTitle), "did not log in successfully");
	}

	@Test(priority = 2)

	public void loginFailiureandLostPassword() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniyawrong";
		ExtentTestManager.getTest().log(LogStatus.INFO, "Called log in method to be failed");
		String loginFailureErrorText = loginModule.loginFailiure(driver, userName, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting failure message");
		Assert.assertEquals(loginFailureErrorText,
				"ERROR: The password you entered for the username authortestin is incorrect. Lost your password?");
									
		ExtentTestManager.getTest().log(LogStatus.INFO, "lost password method called");																												// System.out.println(driver.getTitle());																													// String
		String lostPasswordPageTitle = loginModule.lostPwd(driver, userName);
		ExtentTestManager.getTest().log(LogStatus.INFO, "lost password protocol checked");

		System.out.println(lostPasswordPageTitle);
	}
	
	
	@Test(priority = 3)

	public void loginFailiureWrongUserName() throws InterruptedException {
		String userName = "authortestingwrong";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "Called log in method to be failed");
		String loginFailureErrorText = loginModule.loginFailiureWrongUserName(driver, userName, password);
		String expectedLoginFailureErrorText = "ERROR: Invalid username. Lost your password?";
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting error message for wrong user name");
		Assert.assertEquals(loginFailureErrorText, expectedLoginFailureErrorText,
				"Error message is wrong for wrong user name entry");

		String lostPasswordPageTitle = loginModule.lostPwd(driver, userName);
		String expectedlostPasswordPageTitle = "Packt Content Development Platform ‹ Lost Password";
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the lost password title");
		Assert.assertEquals(lostPasswordPageTitle, expectedlostPasswordPageTitle,
				"It is not landing on right page after clicking on lost password link");
	}

	@Test(priority = 4)
	public void loginWithoutCaptcha() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		Boolean loginBtnDisabledCheck = loginModule.loginBtnDisabledCheck(driver, userName, password);
		System.out.println(loginBtnDisabledCheck);
		Assert.assertFalse(loginBtnDisabledCheck);

	}

	@Test(priority = 5)
	public void backToCDPlink() throws InterruptedException {

		String expectedPageTitle = driver.getTitle();
		ExtentTestManager.getTest().log(LogStatus.INFO, "back to CDP link function has been called");
		String landingPageTitle = loginModule.backToCDPLinkCheck(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the page title after clicking on back to CDP link");
		Assert.assertEquals(landingPageTitle, expectedPageTitle,
				"It is not going to landing page after clicking on mentioned link");

	}

	@Test(priority = 6)

	public void passwordRecovery() throws InterruptedException {
		String userName = "authortestin";
		String expectedChkEmailText = "Check your email for the confirmation link.";
		ExtentTestManager.getTest().log(LogStatus.INFO, "Password Recovery function has been called");
		String actualChkEmailText = loginModule.passwordRecoveryMsg(driver, userName);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the check email message");
		Assert.assertEquals(actualChkEmailText, expectedChkEmailText);
	}

	@Test(priority = 7)

	public void passwordRecoveryNegative() throws InterruptedException {
		String userName = "authortestingwrong";
		String expectedChkEmailText = "ERROR: Invalid username or email.";
		ExtentTestManager.getTest().log(LogStatus.INFO, "Password Recovery function for negative testing has been called");
		String actualChkEmailText = loginModule.passwordRecoveryMsgNegative(driver, userName);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting 'check email' message");
		Assert.assertEquals(actualChkEmailText, expectedChkEmailText);
	}

	@AfterMethod

	public void closingDriver() {
		System.out.println("Switching off driver");
		driver.quit();
	}

}
