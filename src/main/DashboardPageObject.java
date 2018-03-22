package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;



public class DashboardPageObject {

	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;

	}
	
	
	By chapterWidgetOnSashBoard=By.id("cdp-chapters-widget");
	By allUserOfABookWidget=By.id("cdp-users-widget");

	By profileTabHover = By.xpath("//*[@id='wp-admin-bar-my-account']/a");
	By logOutBtn = By.linkText("Log Out");
	By myBooks = By.xpath("//*[@id='toplevel_page_cdp-mybooks-menu']/a");
	By linksOnAuthorDashboard = By.xpath("//*[@id='adminmenu']/li");
	By linksOnReviewerDashBoard = By.xpath("//*[@id='adminmenu']/li/a");
	By reviewerHeading = By.xpath("//*[@id='wp-admin-bar-userdata']/div");
	By draftTextForReviewer = By.cssSelector("#cdp-chapters-widget > div > div > div:nth-child(2) > ul > li:nth-child(2) > span.cdp-chapters-widget-status.cdp-post-status-box-draft");//By.xpath("//*[@class='cdp-chapters-widget-list']/li[4]/span[4]");
	By draftedChapterForReviewer = By.xpath("//*[@class='cdp-chapters-widget-list']/li[4]/span[3]");
	By continueWritingBtnForAuthor = By.xpath("//*[@class='button button-primary cdp-book-cover-button']");
	By chaptersBtnForAuthors=By.id("toplevel_page_cdp-organize");
	By myBooksBtnForAuthors=By.id("toplevel_page_cdp-mybooks-menu");
	
	By chapterInDraftStageForReviewer=By.partialLinkText("Hadoop Security Framework");
	By chapterInPublishedStageForReviewer=By.cssSelector("#cdp-chapters-widget > div > div > div:nth-child(2) > ul > li:nth-child(5) > span.cdp-chapters-widget-post-title");//By.xpath("//*[@class='cdp-chapters-widget-part-container'][2]//li[3]");
	
	By dashboardBtn=By.id("menu-dashboard");
	By ContinueBtnForAuthor=By.xpath("//*[@class='cdp-book-cover-continue-container']/a");
	By chapterInDashBoard=By.xpath("//*[@id='toplevel_page_cdp-organize']/a");
	
	By walkmeCloseBtn=By.className("walkme-click-and-hover walkme-custom-balloon-close-button walkme-action-close");
	
	By commentBtnOnDashboard=By.id("toplevel_page_comments");
	
	
	By roleText=By.cssSelector("#wp-admin-bar-userdata > div");

	public String myBookCheck(String userID, String pwd) throws InterruptedException {
		System.out.println("entered dashboard page object");
		System.out.println(driver);
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		System.out.println(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		driver.findElement(myBooks).click();
		Thread.sleep(2000);
		String myBookPageTitle = driver.getTitle();
		return myBookPageTitle;
	}

	public List<WebElement> dashboardForAuther(String userID, String pwd) throws InterruptedException {
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		Thread.sleep(2000);
		chapterModulePageObject.myBookPageCatalog();
		Thread.sleep(3000);
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(3000);
		driver.findElement(dashboardBtn).click();
		Thread.sleep(5000);
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(driver.findElement(roleText).getText(), "You are author of this book","Not landed on Author Page");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if the page is showing 'You are the author of this book' message or not");
		softAssert.assertTrue(driver.findElement(chapterWidgetOnSashBoard).isDisplayed(),"chapters are not displaying");
		softAssert.assertTrue(driver.findElement(allUserOfABookWidget).isDisplayed(),"user list connected to the book is not displaying");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if chapter information and user list associated with the book is displaying");
		softAssert.assertAll();
		
		List<WebElement> dashboardElements = driver.findElements(linksOnAuthorDashboard);
		return dashboardElements;

	}

	public boolean dashboardForReviewers(String userID, String pwd) throws InterruptedException {
		boolean token = false;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		Thread.sleep(2000);
		chapterModulePageObject.myBookPageCatalog();
		Thread.sleep(3000);
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(3000);
		driver.findElement(dashboardBtn).click();
		Thread.sleep(2000);
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(driver.findElement(roleText).getText(), "You are technical_reviewer of this book","Not landed on technical_reviewer dashboard");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if the header of the page showing 'You are techinical_reviewer of this book'");
		softAssert.assertTrue(driver.findElement(chapterWidgetOnSashBoard).isDisplayed(),"chapters are not displaying");
		softAssert.assertTrue(driver.findElement(allUserOfABookWidget).isDisplayed(),"user list connected to the book is not displaying");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if chapter information and user list associated with the book is displaying");
		softAssert.assertAll();
		List<WebElement> dashboardElements = driver.findElements(linksOnAuthorDashboard);
		//String reviewerHeadingMessage = driver.findElement(reviewerHeading).getText();
		int numberOfDashboardLinks = dashboardElements.size();
		for (int i = 0; i < numberOfDashboardLinks; i++) {
			token = dashboardElements.get(i).isDisplayed();
		}
		
	
		
		return token;

	}

	// dashboardcheck for Admin
	public boolean dashboardForAdmin(String userID, String pwd) throws InterruptedException {
		boolean token = false;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		String dashBoardTitle = loginModulePageObject.loginSuccessFul(userID, pwd);
		Thread.sleep(2000);
		chapterModulePageObject.myBookPageCatalog();
		Thread.sleep(3000);
		chapterModulePageObject.dashboardLinkForAdmin();
		Thread.sleep(3000);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the header message for admin-'You are administrator of this book");
		Assert.assertEquals(driver.findElement(roleText).getText(), "You are administrator of this book","Not landed on technical_reviewer dashboard");
		List<WebElement> dashboardElements = driver.findElements(linksOnAuthorDashboard);
		//String reviewerHeadingMessage = driver.findElement(reviewerHeading).getText();
		int numberOfDashboardLinks = dashboardElements.size();
		for (int i = 0; i < numberOfDashboardLinks; i++) {
			token = dashboardElements.get(i).isDisplayed();
		}
		
		return token;

	}

	// dashboard for user
	public boolean dashboardForEditor(String userID, String pwd) throws InterruptedException {
		boolean token = false;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		Thread.sleep(2000);
		chapterModulePageObject.myBookPageCatalog();
		Thread.sleep(3000);
		chapterModulePageObject.dashboardLinkForEditor();
		Thread.sleep(3000);
		Thread.sleep(2000);
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(driver.findElement(roleText).getText(), "You are editor of this book","Not landed on technical_reviewer dashboard");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the header message for editor-'You are editor of this book");
		softAssert.assertTrue(driver.findElement(chapterWidgetOnSashBoard).isDisplayed());
		softAssert.assertTrue(driver.findElement(allUserOfABookWidget).isDisplayed());
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if chapter information and user list associated with the book is displaying");
		softAssert.assertAll();
		List<WebElement> dashboardElements = driver.findElements(linksOnAuthorDashboard);
		//String reviewerHeadingMessage = driver.findElement(reviewerHeading).getText();
		int numberOfDashboardLinks = dashboardElements.size();
		for (int i = 0; i < numberOfDashboardLinks; i++) {
			token = dashboardElements.get(i).isDisplayed();
		}
		return token;
		
		

	

	}
	// author chapter check

	public boolean AuthorLandingPageCheck(String userID, String pwd) throws InterruptedException {
		boolean token = false;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		String dashBoardTitle = loginModulePageObject.loginSuccessFul(userID, pwd);
		Thread.sleep(2000);
		return token;
	}

	public boolean ReviewerDraftClickCheck(String userID, String pwd) throws InterruptedException {
		boolean token = false;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		//EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		chapterModulePageObject.myBookPageCatalog();
		
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(6000);
		//LoginModule.waitForPagetoLoad(driver, chapterModulePageObject.chapterNotInDraftState);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		//Actions action=new Actions(driver);
		//action.moveToElement(driver.findElement(dashboardBtn)).perform();
		//action.doubleClick().build().perform();
		//Thread.sleep(9000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on dashboard button of reviewer menu");
		driver.findElement(dashboardBtn).click();
		Thread.sleep(5000);
		//LoginModule.waitForPagetoLoad(driver, chapterInDraftStageForReviewer);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		token=driver.findElement(chapterInDraftStageForReviewer).isEnabled();
		
		return token;
	}

	public boolean ReviewerDraftClickCheckNegative(String userID, String pwd) throws InterruptedException {
		boolean token = true;
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		//EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		loginModulePageObject.loginSuccessFul(userID, pwd);
		chapterModulePageObject.myBookPageCatalog();
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(6000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking of dashbaoard button of the menu");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(dashboardBtn));
		action.doubleClick();
		action.build().perform();
		Thread.sleep(5000);
		//LoginModule.waitForPagetoLoad(driver, chapterInPublishedStageForReviewer);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		token=driver.findElement(chapterInPublishedStageForReviewer).isEnabled();
		return token;
	}

	public boolean authorContinueWritingBtnChk(String userID, String pwd) throws InterruptedException {
		LoginModulePageObject loginModulePageObject = new LoginModulePageObject(driver);
		//EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		 loginModulePageObject.loginSuccessFul(userID, pwd);
		chapterModulePageObject.myBookPageCatalog();
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking of dashboard button of reviewer menu");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(dashboardBtn));
		action.doubleClick();
		action.build().perform();
		Thread.sleep(6000);
	
		//driver.findElement(dashboardBtn).click();
		
		return driver.findElement(continueWritingBtnForAuthor).isEnabled();
		
		

	}
	
	public void myBookInfoTabForAuthorLogin(String userName,String pwd) throws InterruptedException{
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		loginModulePageObject.loginSuccessFullWIthoutSignIn(userName, pwd);
	}
	
	public void myBookInfoTabForAuthorLoginwithoutWalkMe(String userName,String pwd) throws InterruptedException{
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		loginModulePageObject.loginSuccessFullWIthoutSignInandWalkMe(userName, pwd);
	}
	
	
		
		
		
		
		
		


}
