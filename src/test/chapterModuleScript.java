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

import main.BaseClass;
import main.ChapterModule;
import main.DashBoardModule;
import main.DashboardPageObject;
import main.LoginModule;

public class chapterModuleScript extends BaseClass{
	
	WebDriver driver;
	LoginModule loginModule = new LoginModule();
	ChapterModule chapterModule=new ChapterModule();
	
	@BeforeClass
	public void loginCDPasAuthor() throws InterruptedException{
		
		String userName="authortestin";
		String password="kahaniya";
		String browser = "firefox";
		//String url = "https://staging-cdp.packtpub.com/";
		String url="https://rc-cdp.packtpub.com";
		driver = browserToOpen(browser);
		//driver.manage().timeouts().pageLoadTimeout(300L, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		hitURL(driver, url);
		String loggedInPageTitle = loginModule.loginSuccessful(driver, userName, password);
		System.out.println(loggedInPageTitle);
		
		
		
	}
	
	@BeforeMethod
	public void openMyBookCatalog() throws InterruptedException{
		
		System.out.println("executing my book click");
		chapterModule.myBookCatalogPage(driver);
	}
	
	@Test(priority=35)
	public void chpaterSectionCheck() throws InterruptedException{
		boolean token=chapterModule.chapterAddSectionCheck(driver);
		Assert.assertTrue(token,"Add section button is not working as expected");
	
	}
	
	
	@Test(priority=23)
	public void chapterCommentCheck() throws InterruptedException{
		System.out.println("entering test");
		
		boolean token=false;
		token=chapterModule.checkCommentnumber(driver);
		System.out.println(token);
		Assert.assertTrue(token);
		
	}
	
	@Test(priority=24)
	public void chapterStatusCheck() throws InterruptedException{
		System.out.println("entering status check");
		boolean token=false;
		token=chapterModule.checkStatusCheck(driver);
		Assert.assertTrue(token);
	}
	
	@Test(priority=25)
	public void chapterEditDeleteCheckForAuthorTest() throws InterruptedException{
		boolean token=false;
		String actualDeleteText;
		String expectedDeleteText="Delete";
		System.out.println("entere delete buttone check");
		token=chapterModule.chapterEditDeleteCheckForAuthorLogic(driver);
		Assert.assertTrue(token);
		
	}
	@Test(priority=26)
	public void chapterEditBtnChkForAuthorTest()throws InterruptedException{
		//boolean token=false;
		String actualEditText;
		String expectedEditText="Edit";
		System.out.println("enter edit buttone check");
		actualEditText=chapterModule.chapterEditCheckForAuthorLogic(driver);
		Assert.assertEquals(actualEditText, expectedEditText);
		
	}
	
	
	@Test(priority=27)
	public void chapterAddChapterChkTest()throws InterruptedException{
		System.out.println("executing add chapter");
		boolean token=false;
		token=chapterModule.chapterAddChapterchkLogic(driver);
		
		Assert.assertTrue(token);
	}
	
	@Test(priority=28)
	public void chapterAddBackChapterChkTest()throws InterruptedException{
		System.out.println("executing add back chapter");
		boolean token=false;
		token=chapterModule.chapterBackAddChapterchkLogic(driver);
		
		Assert.assertTrue(token);
	}
	
	
	@Test(priority=29)
	public void reviewerDraftClickChKTest() throws InterruptedException{
		System.out.println("executing reviewer draft click");
		boolean token=false;
		token=chapterModule.reviewerDraftClickCheckLogic(driver);
		Assert.assertTrue(token,"chapter in draft state is not clickable");
		
	}
	
	@Test(priority=30)
	public void reviewerDraftClickChKNegativeTest() throws InterruptedException{
		System.out.println("executing reviewer draft click neg");
		boolean token=false;
		token=chapterModule.reviewerDraftClickCheckNegativeLogic(driver);
		Assert.assertTrue(token,"chapter which is not in draft state is not clickable as it should be");
		
	}
	
	@Test(priority=31)
	public void reviewerAllTableDisplayedTest() throws InterruptedException{
		System.out.println("reviewer all table display");
		boolean token=false;
		token=chapterModule.reviewerAllTableDisplayedLogic(driver);
		Assert.assertTrue(token,"front page, back page and chapter details are not displayed");
	}
	
	
	@Test(priority = 32)
	public void editorCommentDashboardCheckTest() throws InterruptedException{
		chapterModule.editorCommentDashboardCheckLogic(driver);
	}
	
	@Test(priority = 33)
	public void adminCommentDashboardCheckTest() throws InterruptedException{
		chapterModule.adminCommentDashboardCheckLogic(driver);
	}
	
	
	@Test(priority = 34)
	public void authorCommentDashboardCheckTest() throws InterruptedException{
		chapterModule.authorCommentDashboardCheckLogic(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	
	public void loggingOutandClosingApp() throws InterruptedException{
		System.out.println("entering sign out proceedure");
		Thread.sleep(3000);
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"))).perform();
		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a"))).click().build().perform();
		
		Thread.sleep(5000);
		System.out.println("quiting driver");
		driver.quit();
	}
	
	
	

}
