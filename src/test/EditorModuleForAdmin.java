package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.BaseClass;
import main.ChapterModule;
import main.EditorModule;
import main.LoginModule;

public class EditorModuleForAdmin extends BaseClass {
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

		editorModule.goToEditorForAdmin(driver);

	}

	/*@BeforeMethod
	public void openMyBookCatalog() throws InterruptedException {

		System.out.println("executing my book click");
		System.out.println(driver);

		editorModule.goToEditorForAdmin(driver);
	}*/

@Test(priority=59)

	public void editorExpandCheckForAdminTest() throws InterruptedException {
		editorModule.distractionFreeModeForAdmin(driver);

	}

	@Test(priority=60)

	public void editorBasicInlineCommentCheckForAdminTest() throws InterruptedException {
		boolean token = editorModule.editorForAdminBasicInlineCommentCheck(driver);
		Assert.assertTrue(token, "Inline Comment is not working for editor");

	}

	@Test(priority=61)

	public void editorSaveBtnCheckForAdminTest() throws InterruptedException {
		boolean token = editorModule.editorForAdminSaveBtnChk(driver);
		Assert.assertTrue(token, "Save Button is not working for editor");

	}

	@Test(priority=62)

	public void editorMakeDrftProofingCheckForAdminTest() throws InterruptedException {
		boolean token = editorModule.editorForAdminMarkForProofingChk(driver);
		Assert.assertTrue(token, "Mark Proofed button is not working for editor");

	}

	@Test(priority=63)

	public void editorMoveToTrashCheckForAdminTest() throws InterruptedException {
		boolean token = editorModule.editorForAdminMoveToTrashChk(driver);
		Assert.assertTrue(token, "Move to Trash button is not working for editor");

	}

	@Test(priority=64)

	public void editorRevisionSectionCheckForAdminTest() throws InterruptedException {
		boolean token = editorModule.editorForAdminRevisionBlockChk(driver);
		Assert.assertTrue(token, "Revision section is not visible for editor");

	}

	@Test(priority=65)

	public void editorToolBarCheckForAdminTest() throws InterruptedException {
		editorModule.editorToolBarElementCheckForAdmin(driver);

	}

	
	
	@Test(priority=66)
	public void editorconterTabscheckForAdminTest() throws InterruptedException {
		editorModule.editorContentTabsCheck(driver);

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
