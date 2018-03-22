package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import main.BaseClass;
import main.ChapterModule;
import main.EditorModule;
import main.LoginModule;
import reports.ExtentTestManager;

public class EditorModuleScriptForEditor extends BaseClass {

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
		editorModule.goToEditorForEditor(driver);

	}

	/*@BeforeMethod
	public void openMyBookCatalog() throws InterruptedException {

		System.out.println("executing my book click");
		System.out.println(driver);

		//editorModule.goToEditorForEditor(driver);
	}*/

	@Test(priority=58)

	public void editorExpandCheckForEditorTest() throws InterruptedException {
		editorModule.distractionFreeModeForEditor(driver);
		
	}
	
	@Test(priority=57)

	public void editorBasicInlineCommentCheckForEditorTest() throws InterruptedException {
		boolean token=editorModule.editorForEditorBasicInlineCommentCheck(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'Inline Comment' panel is visible");

		Assert.assertTrue(token,"Inline Comment is not working for editor");
		
	}
	
	@Test(priority=49)

	public void editorSaveBtnCheckForEditorTest() throws InterruptedException {
		boolean token=editorModule.editorForEditorSaveBtnChk(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'Save' button is working fine");

		Assert.assertTrue(token,"Save Button is not working for editor");
		
	}
	
	@Test(priority=50)

	public void editorMakeDrftProofingCheckForEditorTest() throws InterruptedException {
		boolean token=editorModule.editorForEditorMarkForProofingChk(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'Marked Proofed' button is working fine");

		Assert.assertTrue(token,"Mark Proofed button is not working for editor");
		
	}
	
	@Test(priority=51)

	public void editorMoveToTrashCheckForEditorTest() throws InterruptedException {
		boolean token=editorModule.editorForEditorMoveToTrashChk(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'move to trash' button is working fine");

		Assert.assertTrue(token,"Move to Trash button is not working for editor");
		
	}
	
	
	@Test(priority=52)

	public void editorRevisionSectionCheckForEditorTest() throws InterruptedException {
		boolean token=editorModule.editorForEditoreRevisionBlockChk(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the 'Revision' section is visible or not");

		Assert.assertTrue(token,"Revision section is not visible for editor");
		
	}


	@Test(priority=53)

	public void editorToolBarCheckForEditorTest() throws InterruptedException {
		editorModule.editorToolBarElementCheckForEditor(driver);
		
	}
	
	@Test(priority=54)

	public void editorRevisionRestoreForEditorTest() throws InterruptedException {
		editorModule.revisionRestoreforEditor(driver);
		
	}
	
	@Test(priority=55)
	public void editorcontentTabsForEditorTest() throws InterruptedException {
		editorModule.editorContentTabsCheck(driver);
	}
	
	@Test(priority=56)
	public void editorcommentTabcheckForEditorTest() throws InterruptedException {
		editorModule.saveCommentByEditor(driver);
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
