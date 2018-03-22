package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import main.BaseClass;
import main.ChapterModule;
import main.DashBoardModule;
import main.DashboardPageObject;
import main.EditorModule;
import main.LoginModule;
import reports.ExtentTestManager;

public class editorModuleScriptForReviewer extends BaseClass {

	WebDriver driver;
	LoginModule loginModule = new LoginModule();
	ChapterModule chapterModule = new ChapterModule();
	EditorModule editorModule = new EditorModule();
	

	@BeforeClass
	public void loginCDPasAuthor() throws InterruptedException {
		
		

		String userName = "authortestin";
		String password = "kahaniya";
		String browser = "firefox";
		// String url = "https://staging-cdp.packtpub.com/";
		String url = "https://rc-cdp.packtpub.com";
		driver = browserToOpen(browser);
		hitURL(driver, url);
		String loggedInPageTitle = loginModule.loginSuccessful(driver, userName, password);
		System.out.println(loggedInPageTitle);
		editorModule.goToEditorForReviewer(driver);

	}

	/*@BeforeMethod
	public void openMyBookCatalog() throws InterruptedException {

		System.out.println("executing my book click");
		System.out.println(driver);

		editorModule.goToEditorForReviewer(driver);
	}*/

	@Test(priority=45)

	public void editorExpandCheckForReviewerTest() throws InterruptedException {
		boolean token = editorModule.editorExpandCheckForReviewer(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the editor is going to distraction free mode or not");

		Assert.assertTrue(token, "distraction free editor is not working for reviewer");
	}

	@Test(priority=47)

	public void editorToolBarCheckForReviewerTest() throws InterruptedException {
		editorModule.editorToolBarElementCheckForReviewer(driver);
		
	}
	
	@Test(priority=46)

	public void editorDistractionFreeModeBtnCheckForReviewerTest() throws InterruptedException {
		editorModule.distractionFreeModeForReviewer(driver);
		
	}
	
	@Test(priority=45)

	public void editorSaveReviewBtnCheckForReviewerTest() throws InterruptedException {
		editorModule.saveReviewBtnForReviewer(driver);
		
	}
	
	
	@Test(priority=44)
	public void edtorContentTabsCheckForReviewerTest() throws InterruptedException{
		editorModule.reviewerContentTabsCheck(driver);
		
	}
	
	@Test(priority=48)
	public void matterTypeDisableCheck() throws InterruptedException{
		editorModule.matterTypeCheckForReviewer(driver);
	}
		
	

	@AfterClass

	public void loggingOutandClosingApp() throws InterruptedException {

		System.out.println("entering sign out proceedure");
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"))).perform();

		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a"))).click().build()
				.perform();

		Thread.sleep(5000);
		System.out.println("quiting driver");
		driver.quit();
	}

}
