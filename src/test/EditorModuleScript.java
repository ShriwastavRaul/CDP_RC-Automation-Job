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

public class EditorModuleScript extends BaseClass {

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
		

	}

	/*@BeforeMethod
	public void openMyBookCatalog() throws InterruptedException {

		System.out.println("executing my book click");
		System.out.println(driver);

		editorModule.goToEditorForAuthor(driver);
	}*/
	
	
	@Test(priority=41)
	public void matterTypeBoxVisible() throws InterruptedException{
	
	editorModule.matterTypeCheck(driver);
	}
	
	@Test(priority=42)
	public void sectionRadioBtnChecked() throws InterruptedException{
		editorModule.sectionRadionBtnCheck(driver);
	}
	
	@Test(priority=43)
	public void chapterRadioBtnChecked() throws InterruptedException{
		editorModule.chapterRadionBtnCheck(driver);
	}

	@Test(priority=40)
	public void editorForAuthorBasicChecksTest() throws InterruptedException {
	editorModule.goToEditorForAuthor(driver);
		boolean token = false;
		token = editorModule.editorForAuthorBasicChecksLogic(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the expanding functionality of editor");
		Assert.assertTrue(token, "nondistrubing view was not there");

	}

	@Test(priority=37)
	public void editorForAuthorBasicChecksTest2() throws InterruptedException {
		editorModule.goToEditorForAuthor(driver);
		boolean token = false;
		token = editorModule.editorFormattingCheck(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the expanding functionality of editor");
		Assert.assertTrue(token, "format btn is not working");

	}

	@Test(priority=38)
	public void makeDrftCompleteForAuthorTest() throws InterruptedException {
		editorModule.goToEditorForAuthor(driver);
		boolean token = false;
		token = editorModule.draftCompleteBtnChkForAuthor(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'make draft complete' button is working fine");
		Assert.assertTrue(token, "make draft complete button is not working for author");

	}
	@Test(priority=39)

	public void editorToolBarCheckForAuthorTest() throws InterruptedException {
		editorModule.goToEditorForAuthor(driver);

		editorModule.editorToolBarElementCheckForAuthor(driver);

	}

	@Test(priority=36)

	public void editorExpandCheckForAuthorTest() throws InterruptedException {
		editorModule.goToEditorForAuthor(driver);

		editorModule.distractionFreeModeForAuthor(driver);

	}

	@Test(priority=40)

	public void editorContentTabsCheckForAuthorTest() throws InterruptedException {
		editorModule.goToEditorForAuthor(driver);

		editorModule.authorContentTabsCheck(driver);

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
