package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class ChapterModulePageObject {

	WebDriver driver;

	public ChapterModulePageObject(WebDriver driver) {
		this.driver = driver;

	}

	// elements in chapter page for author

	By commentNumberText = By.cssSelector("#chapter-1547 > td.cdp-organize-column-comments > a > span");

	By statusText = By.cssSelector("#chapter-1541 > td.cdp-organize-column-status > div");

	By editDeleteBtn = By.xpath("//*[@id='chapter-1570']/td[7]/a[2]");

	By editBtn = By.xpath("//*[@id='chapter-1541']/td[7]/a");

	By addChapterBtn = By.linkText("Add Chapter");

	By addBackChapBtn = By.linkText("Add Back Matter");
	
	By addSectionBtn=By.linkText("Add Section");
	
	By sectionLink=By.cssSelector("#chapter-1687 > td.cdp-organize-column-title > span.cdp-organizer-chapter-title > a");
	

	By chapterInDraftStateForAuthor = By.linkText("Analyzing and Debugging Your Code");//("//*[@id='chapter-116']/td[2]/span[2]/a");
	
	

	// element in chapter page for reviewer

	By frontPageTable = By.id("front-matter");
	By backPageTable = By.id("back-matter");
	By chapterTable = By.id("chapter");

	By chapterInDraftState = By.partialLinkText("Hadoop Security Framework");//By.xpath("//*[@id='chapter-27']/td[2]/span[2]/a");
	By chapterNotInDraftState = By.xpath("//*[@id='chapter-37']/td[2]/span[2]");
	//By chapterInDraftState=By.cssSelector("tr#chapter-27 > td.cdp-organize-column-title > span.cdp-organizer-chapter-title > a");
	//By chapterNotInDraftState = By.xpath("tr#chapter-28 > td.cdp-organize-column-title > span.cdp-organizer-chapter-title > a");
	By chapterStatusDraft = By.xpath("//*[@id='chapter-30']/td[5]/div");
	By chapterStatusNonDraft = By.xpath("//*[@id='chapter-37']/td[5]/div");
	
	//element in chapter page for admin
	
	By chapterinDraftStateForAdmin=By.partialLinkText("dummy chapter");// By.xpath("//*[@id='chapter-209']/td[2]/span[2]/a");
	
	
	
	//element in chapter page for editor
	
	By chapterInDraftStageForEditor=By.linkText("Angular 2 Building Blocks - Part 1");// By.xpath("//*[@id='chapter-29']/td[2]/span[2]/a");

	// elements in the catalog page
	
	By firstLineOfCatalogPage=By.cssSelector("#wpbody-content > div.wrap > div.notice-panel > h4");

	//By bookTitleCoulumn = By.xpath("//*[@id='the-list']/tr[6]/td[4]/span");
	By bookTitleCoulumn=By.cssSelector("tbody#the-list>tr:nth-child(6)");
	By goToChapters = By.xpath("//*[@id='the-list']/tr[6]/td[4]/div/span/a");

	// element in catalog page for admin
	By bookTitleCoulumnforAdmin=By.cssSelector("tbody#the-list>tr:nth-child(2)");
	//By bookTitleCoulumnforAdmin = By.xpath("//*[@id='the-list']//span[contains(text(),'B05167 Agile Raw Project')]");
	By goToChaptersforAdmin = By.xpath("//*[@id='the-list']/tr[2]/td[4]/div/span/a");

	// element in catalog page for revisor
	By bookTitleCoulumnForRevisor = By.xpath("//*[@id='the-list']/tr[5]/td[4]/span");
	//By bookTitleCoulumnForReviewer=By.cssSelector("tbody#the-list>tr:nth-child(1)");
	By goToChaptersForRevisor = By.xpath("//*[@id='the-list']/tr[5]/td[4]/div/span/a");

	// element in catalog page for reviewer
	By bookTitleCoulumnForReviewer=By.cssSelector("tbody#the-list>tr:nth-child(8)");
	//By bookTitleCoulumnForReviewer = By.xpath("//*[@id='the-list']//span[contains(text(),'B04801 Mastering Microservices with Java')]");
	By goToChaptersForReviewer = By.xpath("//*[@id='the-list']/tr[8]/td[4]/div/span/a");

	// element in catalog page for editor
	//By bookTitleCoulumnForEditor = By.xpath("//*[@id='the-list']/tr[3]/td[4]/span");
	By bookTitleCoulumnForEditor=By.cssSelector("tbody#the-list>tr:nth-child(7)");
	By goToChaptersForEditor = By.xpath("//*[@id='the-list']/tr[7]/td[4]/div/span/a");
	
	
	
	//element in comment page
	By tableHeading1=By.id("author");
	By tableHeading2=By.id("comment");
	By tableHeading3=By.id("response");
	By tableHeading4=By.id("date");
	
	By commentCatagoryPane=By.xpath("//*[@class='subsubsub']/li");

	public void myBookPageCatalog() throws InterruptedException {
		//Thread.sleep(3000);
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		System.out.println(driver.getTitle());

		// LoginModule.waitForPagetoLoad(driver,
		// dashboardPageObject.myBooksBtnForAuthors);
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		//System.out.println(driver.getTitle());

		System.out.println("reached catalog page");
		/*
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
/*
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(dashboardPageObject.myBooks));

		

		builder.doubleClick();

		builder.build().perform();
		
*/
		//WebElement myBooks=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.elementToBeClickable(dashboardPageObject.myBooks));
		//myBooks.click();
		driver.findElement(dashboardPageObject.myBooks).click();
		String firstLineOfThePage=driver.findElement(firstLineOfCatalogPage).getText();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if my book catalog succussfully opened");
		Assert.assertEquals(firstLineOfThePage, "Organize your public Catalog page.","Not able to reach my book catalog page ");
		
		System.out.println(driver.getTitle());
		

	}

	public void chapterLinkForAuthors() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting the process of clcking go to chapter button");
		Actions builder = new Actions(driver);
		//String chapterPageTitle = driver.getTitle();
		//System.out.println(chapterPageTitle);
		//WebElement bookTitle=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumn));

		// builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(bookTitleCoulumn));
		System.out.println("window scrolled down");

		Thread.sleep(4000);
		builder.moveToElement(driver.findElement(bookTitleCoulumn)).perform();
		System.out.println("found out book titile column");
		Thread.sleep(3000);
		builder.moveToElement(driver.findElement(goToChapters));
		Thread.sleep(2000);
		builder.click();
		builder.build().perform();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Go to chapters link have been clicked for authors");
		//WebElement tablesInChapterPage=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(By.id("cdp-chapters-widget")));
		//tablesInChapterPage.isDisplayed();
		System.out.println("reached second checkpouint");
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		//Thread.sleep(6000);
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}

	public void chapterLinkForReviewer() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumnForReviewer));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Go to chapters link have been clicked for reviewers");
		Actions builder = new Actions(driver);
		String chapterPageTitle = driver.getTitle();
		System.out.println(chapterPageTitle);
		
		Point cordinates=driver.findElement(bookTitleCoulumnForReviewer).getLocation();
		
		String xCord=Integer.toString(cordinates.getX());
		String yCord=Integer.toString(cordinates.getY());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-100)", driver.findElement(bookTitleCoulumnForReviewer));
		//jse.executeScript(arg0, arg1)
		//Thread.sleep(3000);
		System.out.println("Scrolled down");
		
		
		builder.moveToElement(driver.findElement(bookTitleCoulumnForReviewer)).perform();
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(goToChaptersForReviewer));
		Thread.sleep(2000);
		builder.click();
		builder.build().perform();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Go to chapters link have been clicked for authors");
		//driver.findElement(goToChaptersForReviewer)
		System.out.println("reached second checkpouint");
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		//Thread.sleep(6000);
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}
	
	public void dashboardLinkForEditor() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting the process of clicking on go to dashboard link for editors");
		Actions builder = new Actions(driver);
		//String chapterPageTitle = driver.getTitle();
		//System.out.println(chapterPageTitle);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumnForEditor));
		//System.out.println(driver.findElement(bookTitleCoulumnForEditor).isDisplayed());

		// builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-100)", driver.findElement(bookTitleCoulumnForEditor));
		System.out.println("window scrolled down");

	
		builder.moveToElement(driver.findElement(bookTitleCoulumnForEditor)).perform();
		System.out.println("found out book titile column");
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(goToChaptersForEditor));
		Thread.sleep(1000);
		builder.click();
		builder.build().perform();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Go to dashboard link have been clicked for editors");
		//Thread.sleep(1000);
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		System.out.println("reached second checkpouint");
		
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*System.out.println("closing walk me");
		driver.findElement(dashboardPageObject.walkmeCloseBtn).click();
		System.out.println("walkme closed");*/
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		/*builder.moveToElement(driver.findElement(dashboardPageObject.chapterInDashBoard)).perform();
		System.out.println("moved to element");
		Thread.sleep(2000);
		builder.doubleClick().build().perform();
		System.out.println("double clicked");*/
		//Thread.sleep(6000);
		
		
		
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}

	public void chapterLinkForEditor() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting the process of navigating for chapters for editor");
		Actions builder = new Actions(driver);
		//String chapterPageTitle = driver.getTitle();
		//System.out.println(chapterPageTitle);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumnForEditor));
		//System.out.println(driver.findElement(bookTitleCoulumnForEditor).isDisplayed());

		// builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-100)", driver.findElement(bookTitleCoulumnForEditor));
		System.out.println("window scrolled down");

	
		builder.moveToElement(driver.findElement(bookTitleCoulumnForEditor)).perform();
		System.out.println("found out book titile column");
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(goToChaptersForEditor));
		Thread.sleep(1000);
		builder.click();
		builder.build().perform();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "completed the process of navigating for chapters for editor");
		//Thread.sleep(1000);
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		System.out.println("reached second checkpouint");
		
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*System.out.println("closing walk me");
		driver.findElement(dashboardPageObject.walkmeCloseBtn).click();
		System.out.println("walkme closed");*/
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		builder.moveToElement(driver.findElement(dashboardPageObject.chapterInDashBoard)).perform();
		System.out.println("moved to element");
		Thread.sleep(2000);
		builder.doubleClick().build().perform();
		System.out.println("double clicked");
		//Thread.sleep(6000);
		
		
		
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}
	
	public void dashboardLinkForAdmin() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting the process of navigating for dashboard for admin");
		Actions builder = new Actions(driver);
		String chapterPageTitle = driver.getTitle();
		System.out.println(chapterPageTitle);
//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumnforAdmin));
		// builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-100)", driver.findElement(bookTitleCoulumnforAdmin));
		System.out.println("window scrolled down");

		//Thread.sleep(4000);
		builder.moveToElement(driver.findElement(bookTitleCoulumnforAdmin)).perform();
		System.out.println("found out book titile column");
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(goToChaptersforAdmin));
		Thread.sleep(2000);
		builder.click();
		builder.build().perform();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "completed the process of navigating for dashboard for admin");
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		/*builder.moveToElement(driver.findElement(dashboardPageObject.chapterInDashBoard)).perform();
		builder.doubleClick().build().perform();*/
		//driver.findElement(dashboardPageObject.chapterInDashBoard).click();
		//System.out.println("reached second checkpouint");
		
		//Thread.sleep(6000);
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}
	public void chapterLinkForAdmin() throws InterruptedException {
		Thread.sleep(4000);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);

		System.out.println("reached catalog page");

		/*
		 * Thread.sleep(2000);
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(dashboardPageObject.myBooks).click();
		 */
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting the process of navigating for chapters for admin");
		Actions builder = new Actions(driver);
		String chapterPageTitle = driver.getTitle();
		System.out.println(chapterPageTitle);
//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(bookTitleCoulumnforAdmin));
		// builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-100)", driver.findElement(bookTitleCoulumnforAdmin));
		System.out.println("window scrolled down");

		//Thread.sleep(4000);
		builder.moveToElement(driver.findElement(bookTitleCoulumnforAdmin)).perform();
		System.out.println("found out book titile column");
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(goToChaptersforAdmin));
		Thread.sleep(2000);
		builder.click();
		builder.build().perform();
		Thread.sleep(5000);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.findElement(dashboardPageObject.chaptersBtnForAuthors).click();
		/*builder.moveToElement(driver.findElement(dashboardPageObject.chapterInDashBoard)).perform();
		builder.doubleClick().build().perform();*/
		driver.findElement(dashboardPageObject.chapterInDashBoard).click();
		System.out.println("reached second checkpouint");
		ExtentTestManager.getTest().log(LogStatus.INFO, "completed the process of navigating for chapters for admin");
		//Thread.sleep(6000);
		// builder.moveToElement(driver.findElement(commentNumberText)).build().perform();

	}


	public void chapterAddChapChkObject() throws InterruptedException {
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.elementToBeClickable(addChapterBtn)).click();;
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on add chapter button");
		driver.findElement(addChapterBtn).click();
		//Thread.sleep(4000);

	}

	public void chapterAddBackChapChkObject() throws InterruptedException {
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.elementToBeClickable(addBackChapBtn)).click();;
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on add back chapter button");
		driver.findElement(addBackChapBtn).click();
		//Thread.sleep(4000);

	}
	
	
	
	

}
