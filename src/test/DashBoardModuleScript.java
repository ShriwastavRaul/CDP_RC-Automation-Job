package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import main.BaseClass;
import main.ChapterModule;
import main.DashBoardModule;
import main.LoginModule;
import reports.ExtentTestManager;

public class DashBoardModuleScript extends BaseClass {
	WebDriver driver;
	LoginModule loginModule = new LoginModule();
	ChapterModule chapterModule = new ChapterModule();
	DashBoardModule dashBoardModule = new DashBoardModule();

	@BeforeMethod

	public void launchApplication() {

		// function of extracting the data from csv:data filled

		String browser = "firefox";
		String url = "https://rc-cdp.packtpub.com/";
		driver = browserToOpen(browser);
		//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		hitURL(driver, url);

	}
	
	

	@Test(priority = 8)
	public void myBookPageCheck() throws InterruptedException {
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to my book catalog");
		String userName = "authortestin";
		String password = "kahaniya";
		String browser = "firefox"; // String url =
									// "https://staging-cdp.packtpub.com/";

		String loggedInPageTitle = loginModule.loginSuccessful(driver, userName, password);
		System.out.println(loggedInPageTitle);
		chapterModule.myBookCatalogPage(driver);
		//Assert.assertEquals(driver.getTitle(), driver.getTitle());

	}

	@Test(priority = 9)

	public void AuthordashBoardLinkCheck() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to Author dashboard");

		boolean token = dashBoardModule.dashboardForAuthor(driver, userName, password);

		System.out.println(token);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the options in menu of author dashboard are displaying correctly");
		
		Assert.assertEquals(token, true);
	}

	@Test(priority = 10)
	public void ReviewerdashBoardLinkCheck() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";

		boolean token = dashBoardModule.dashboardForReviewer(driver, userName, password);

		
		System.out.println(token);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the options in menu of techinical reviewer dashboard are displaying correctly");
		
		Assert.assertTrue(token);
	}
	// dashboardcheckfor admin

	@Test(priority = 11)
	public void AdminDashBoardCheck() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to admin dashboard");

		boolean token = dashBoardModule.dashboardForAdmin(driver, userName, password);

		System.out.println(token);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the options in menu of admin dashboard are displaying correctly");
		Assert.assertEquals(token, true);
	}

	// dashboard check for user

	@Test(priority = 12)
	public void EditorDashBoardCheck() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to editor dashboard");

		boolean token = dashBoardModule.dashboardForEditor(driver, userName, password);

		System.out.println(token);
		Assert.assertEquals(token, true);
	}

	

	@Test(priority = 13)
	public void reviewerDraftClickCheck() throws InterruptedException {

		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to reviewer dashboard");
		boolean token = dashBoardModule.ReviewerDraftClickCheck(driver, userName, password);
		System.out.println(token);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if chapter link in draft state is enabled");
		//Assert.fail();
		Assert.assertTrue(token);
	}

	@Test(priority = 14)
	public void reviewerDraftClickNegative() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to reviewer dashboard");
		boolean token = dashBoardModule.ReviewerDraftClickCheckNegative(driver, userName, password);
		System.out.println(token);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if chapter link for published is disabled");
		Assert.assertTrue(token);
	}
	// author continue writing btn check

	@Test(priority = 15)
	public void authorContinueWritingBtnChk() throws InterruptedException {
		String userName = "authortestin";
		String password = "kahaniya";
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to author dashboard");
		boolean token = dashBoardModule.authorContinueWritingBtnChk(driver, userName, password);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if conitnue writing button is clickable");
		//Assert.fail();
		Assert.assertTrue(token);
	}

	  @Test(priority = 16)
	  public void myBookInfoCheckForAuthorTest() throws
	  InterruptedException{ 
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to author dashboard");
		  driver.get(
	  "https://rc-cdp.packtpub.com/oattestingbook2/wp-admin/index.php");
	  String userName="menondhiraj"; String password="abc@123";
	  ExtentTestManager.getTest().log(LogStatus.INFO, "checking if my book info tab is present in menu");
	  dashBoardModule.myBookInfoTabForAuthorLogic(driver, userName, password);
	  
	  
	  }
	 
/*
	
	  @Test 
	  public void reivsionCompareCheckForEditorTest() throws
	  InterruptedException{
	 // driver.get("https://staging-cdp.packtpub.com/angular2byexample/wp-admin/"); 
		  driver.get("https://rc-cdp.packtpub.com/oattesting-5/wp-admin/");
	  String userName="vivekb"; String password="gayatri@123456";
	  dashBoardModule.revisionCheckForEditorLogic(driver, userName, password);
	  
	  
	  }
	 
*/
	
	  @Test(priority = 17)
	  public void reviewsCheckForEditorTest() throws
	  InterruptedException{ 
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to reviewer dashboard");
		  driver.get(
	  "https://rc-cdp.packtpub.com/oattesting-5/wp-admin/");
	  String userName="vivekb"; String password="gayatri@123456";
	  ExtentTestManager.getTest().log(LogStatus.INFO, "checking all the reviews are available");
	  dashBoardModule.reiviewsCheckForEditorLogic(driver, userName, password);
	  
	  
	  }

/*	
	  @Test 
	  public void reivsionCompareForAdminTest() throws
	  InterruptedException{
	  driver.get("https://rc-cdp.packtpub.com/oattestingbook1/wp-admin/");
	  String userName="vivekb"; String password="gayatri@123456";
	  dashBoardModule.reivsionCompareCheckForAdminLogic(driver, userName,
	  password);
	  
	  
	  }
	
	*/
	  @Test(priority = 18)
	  public void reviewsCheckForAdminTest()throws InterruptedException{
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to admin dashboard");
	  driver.get(
	  "https://rc-cdp.packtpub.com/oattestingbook1/wp-admin/");
	  String userName="vivekb"; String password="gayatri@123456";
	  ExtentTestManager.getTest().log(LogStatus.INFO, "checing all the reviews are clickable");
	  dashBoardModule.reviewsCheckForAdminLogic(driver, userName, password); }
	 
	
	  @Test(priority = 19)
	  
	  public void addUserByAdminTest() throws InterruptedException {
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to admin dashboard");
	  driver.get(
	  "https://rc-cdp.packtpub.com/oattesting-6/wp-admin/"
	  ); String userName = "dhirajm"; String password = "GREENLAND@1611";
	  ExtentTestManager.getTest().log(LogStatus.INFO, "calling add new user function");
	  dashBoardModule.addUserByAdminLogic(driver, userName, password); }
	 

	
	  @Test(priority = 20)
	  
	  public void removeUserByAdminTest() throws InterruptedException {
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to admin dashboard");
	  driver.get(
	  "https://rc-cdp.packtpub.com/oattesting-6/wp-admin/"
	  ); String userName = "dhirajm"; String password = "GREENLAND@1611";
	  ExtentTestManager.getTest().log(LogStatus.INFO, "calling remove user function");
	  dashBoardModule.removeUserByAdminLogic(driver, userName, password); }
	 
	
	  @Test(priority = 21)
	  
	  public void networkAdminPAgeTest() throws InterruptedException {
		  ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to network admin dashboard");

		  String userName
	  = "dhirajm"; String password = "GREENLAND@1611";
	  dashBoardModule.networkAdminPageLogic(driver, userName, password); }
	 
	
	@Test(priority = 22)
	public void metaDataCheckForEditorTest() throws InterruptedException{
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to editor dashboard");
		driver.get("https://rc-cdp.packtpub.com/oat-snehil-praful/wp-admin/");
		String userName="viveka";
		String password="MySystem@123";
		ExtentTestManager.getTest().log(LogStatus.INFO, "checking the availability of meta data");
		dashBoardModule.metaDataCheckForEditorLogic(driver, userName, password);
		
	}

	@AfterMethod

	public void closeApp() {
		driver.quit();
	}

}
