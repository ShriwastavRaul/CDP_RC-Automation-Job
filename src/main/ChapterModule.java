package main;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.BASTORE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;



public class ChapterModule {

	public boolean checkCommentnumber(WebDriver driver) throws InterruptedException {

		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		boolean token = false;
		ExtentTestManager.getTest().log(LogStatus.INFO, "started navogation to reach chapter page for authors");
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(3000);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.commentNumberText));
		token = driver.findElement(chapterModulePageObject.commentNumberText).isDisplayed();
		return token;

	}

	public void myBookCatalogPage(WebDriver driver) throws InterruptedException {
		System.out.println(driver);
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.myBookPageCatalog();
	}

	public boolean checkStatusCheck(WebDriver driver) throws InterruptedException {
		boolean token = false;
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(3000);
		//token=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.statusText)).isEnabled();

		token = driver.findElement(chapterModulePageObject.statusText).isDisplayed();

		return token;

	}
	
	public boolean chapterAddSectionCheck(WebDriver driver) throws InterruptedException {
		boolean token = false;
		String nextURL="https://rc-cdp.packtpub.com/endtoendtesting/wp-admin/post-new.php?post_type=chapter&matter_type=section";
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(3000);
		//token=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.statusText)).isEnabled();

		driver.findElement(chapterModulePageObject.addSectionBtn).click();
		Thread.sleep(2000);
		
		if(nextURL.equals(driver.getCurrentUrl()))
			token=true;
		else
			token=false;


		return token;

	}

	public boolean chapterEditDeleteCheckForAuthorLogic(WebDriver driver) throws InterruptedException {
		boolean token = false;
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();

		Thread.sleep(5000);
		//WebElement deleteBtn=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.editDeleteBtn));
		WebElement deleteBtn = driver.findElement(chapterModulePageObject.editDeleteBtn);
		String deleteText = deleteBtn.getText();
		System.out.println(deleteText);

		token = deleteBtn.isDisplayed();

		String expectedDeleteText = "Delete";

		if (deleteText.equals(expectedDeleteText) && token == true) {
			token = true;
		} else
			token = false;

		return token;
	}

	public String chapterEditCheckForAuthorLogic(WebDriver driver) throws InterruptedException {
		boolean token = false;
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();

		Thread.sleep(5000);
		//WebElement deleteBtn=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.editBtn));
		WebElement deleteBtn = driver.findElement(chapterModulePageObject.editBtn);
		String editText = deleteBtn.getText();
		System.out.println(editText);

		token = deleteBtn.isDisplayed();
		return editText;

	}

	public boolean chapterAddChapterchkLogic(WebDriver driver) throws InterruptedException {
		boolean token = false;
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();
		chapterModulePageObject.chapterAddChapChkObject();
		
		String nextPageTitle=driver.getTitle();
		String expectedNextPageTitle="TYPE CLOUD: Add New Post ‹ Sample's title  — Pressbooks";
		System.out.println(nextPageTitle);
		if(nextPageTitle.equals(driver.getTitle()))
			token=true;
		else
			token=false;
		return token;
		

	}
	
	public boolean chapterBackAddChapterchkLogic(WebDriver driver) throws InterruptedException {
		boolean token = false;
		System.out.println("entered add chapter");
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();
		chapterModulePageObject.chapterAddBackChapChkObject();
		
		String nextPageTitle=driver.getTitle();
		String expectedNextPageTitle="TYPE CLOUD: Add New Post ‹ Sample's title  — Pressbooks";
		System.out.println(nextPageTitle);
		if(nextPageTitle.equals(driver.getTitle()))
			token=true;
		else
			token=false;
		return token;
		

	}
	
	public boolean reviewerDraftClickCheckLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(9000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean token=false;
		//WebElement chapInDraftState=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.chapterInDraftState));
		//token=chapInDraftState.isEnabled();
		token=driver.findElement(chapterModulePageObject.chapterInDraftState).isEnabled();
		return token;
		
	}
	
	public boolean reviewerDraftClickCheckNegativeLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(9000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean token=false;
		//WebElement chapNotInDraftState=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.chapterNotInDraftState));
		//token=chapNotInDraftState.isEnabled();
		token=driver.findElement(chapterModulePageObject.chapterNotInDraftState).isEnabled();
		return token;
		
	}
	
	
	public boolean reviewerAllTableDisplayedLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		chapterModulePageObject.chapterLinkForReviewer();
		Thread.sleep(9000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean token=false;
		//WebElement frontTable=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(chapterModulePageObject.frontPageTable));
		//token=frontTable.isDisplayed();
		token=driver.findElement(chapterModulePageObject.frontPageTable).isDisplayed();
		token=driver.findElement(chapterModulePageObject.chapterTable).isDisplayed();
		token=driver.findElement(chapterModulePageObject.backPageTable).isDisplayed();
		
		
		return token;
		
		
	}
	
	public void adminCommentDashboardCheckLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);
		chapterModulePageObject.chapterLinkForAdmin();
		//WebElement element=BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(By.id("cdp-chapters-widget")));
		//element.isDisplayed();
		driver.findElement(dashboardPageObject.commentBtnOnDashboard).click();
		//Thread.sleep(3000);
		
		String AuthorNamePresentcheck=driver.findElement(chapterModulePageObject.tableHeading1).getText();
		String tableHeading2Check=driver.findElement(chapterModulePageObject.tableHeading2).getText();
		String tableHeading3check=driver.findElement(chapterModulePageObject.tableHeading3).getText();
		String tableHeading3Check=driver.findElement(chapterModulePageObject.tableHeading4).getText();
		
		List<WebElement> catagoriesOfComments=driver.findElements(chapterModulePageObject.commentCatagoryPane);
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(AuthorNamePresentcheck, "Author","Author name is not showing in comments");
		softAssert.assertEquals(tableHeading2Check, "Comment", "table heading 2 is not Comment");
		softAssert.assertEquals(tableHeading3check, "In Response To","table heading 3 is not In response to");
		softAssert.assertEquals(tableHeading3Check, "Submitted On","table heading 3 is not submitted to");
		
		System.out.println(catagoriesOfComments.get(1).getText());
		softAssert.assertEquals(catagoriesOfComments.get(1).getText(), "Pending (1) |","Pending comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(1).isEnabled(),"Pending comment are not shown saparately");
		
		softAssert.assertEquals(catagoriesOfComments.get(2).getText(), "Approved (0) |","Approved comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(2).isEnabled(),"Approved comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(3).getText(), "Spam (0) |","Spam comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(3).isEnabled(),"Spam comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(4).getText(), "Trash (0)","Trash comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(4).isEnabled(),"Trash comment are not shown saparately");
		softAssert.assertAll();
	}
	
	public void authorCommentDashboardCheckLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);
		chapterModulePageObject.chapterLinkForAuthors();
		Thread.sleep(3000);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(By.id("cdp-chapters-widget")));
		driver.findElement(dashboardPageObject.commentBtnOnDashboard).click();
		//Thread.sleep(3000);
		
		String AuthorNamePresentcheck=driver.findElement(chapterModulePageObject.tableHeading1).getText();
		String tableHeading2Check=driver.findElement(chapterModulePageObject.tableHeading2).getText();
		String tableHeading3check=driver.findElement(chapterModulePageObject.tableHeading3).getText();
		String tableHeading3Check=driver.findElement(chapterModulePageObject.tableHeading4).getText();
		
		List<WebElement> catagoriesOfComments=driver.findElements(chapterModulePageObject.commentCatagoryPane);
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(AuthorNamePresentcheck, "Author","Author name is not showing in comments");
		softAssert.assertEquals(tableHeading2Check, "Comment", "table heading 2 is not Comment");
		softAssert.assertEquals(tableHeading3check, "In Response To","table heading 3 is not In response to");
		softAssert.assertEquals(tableHeading3Check, "Submitted On","table heading 3 is not submitted to");
		
		System.out.println(catagoriesOfComments.get(1).getText());
		softAssert.assertEquals(catagoriesOfComments.get(1).getText(), "Pending (15) |","Pending comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(1).isEnabled(),"Pending comment are not shown saparately");
		
		softAssert.assertEquals(catagoriesOfComments.get(2).getText(), "Approved (6) |","Approved comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(2).isEnabled(),"Approved comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(3).getText(), "Spam (0) |","Spam comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(3).isEnabled(),"Spam comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(4).getText(), "Trash (0)","Trash comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(4).isEnabled(),"Trash comment are not shown saparately");
		softAssert.assertAll();
	}
	public void editorCommentDashboardCheckLogic(WebDriver driver) throws InterruptedException{
		ChapterModulePageObject chapterModulePageObject=new ChapterModulePageObject(driver);
		DashboardPageObject dashboardPageObject=new DashboardPageObject(driver);
		chapterModulePageObject.chapterLinkForEditor();
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(By.id("cdp-chapters-widget")));
		driver.findElement(dashboardPageObject.commentBtnOnDashboard).click();
		//Thread.sleep(3000);
		
		String AuthorNamePresentcheck=driver.findElement(chapterModulePageObject.tableHeading1).getText();
		String tableHeading2Check=driver.findElement(chapterModulePageObject.tableHeading2).getText();
		String tableHeading3check=driver.findElement(chapterModulePageObject.tableHeading3).getText();
		String tableHeading3Check=driver.findElement(chapterModulePageObject.tableHeading4).getText();
		
		List<WebElement> catagoriesOfComments=driver.findElements(chapterModulePageObject.commentCatagoryPane);
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(AuthorNamePresentcheck, "Author","Author name is not showing in comments");
		softAssert.assertEquals(tableHeading2Check, "Comment", "table heading 2 is not Comment");
		softAssert.assertEquals(tableHeading3check, "In Response To","table heading 3 is not In response to");
		softAssert.assertEquals(tableHeading3Check, "Submitted On","table heading 3 is not submitted to");
		
		System.out.println(catagoriesOfComments.get(1).getText());
		softAssert.assertEquals(catagoriesOfComments.get(1).getText(), "Pending (0) |","Pending comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(1).isEnabled(),"Pending comment are not shown saparately");
		
		softAssert.assertEquals(catagoriesOfComments.get(2).getText(), "Approved (0) |","Approved comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(2).isEnabled(),"Approved comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(3).getText(), "Spam (0) |","Spam comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(3).isEnabled(),"Spam comment are not shown saparately");
		
		
		softAssert.assertEquals(catagoriesOfComments.get(4).getText(), "Trash (0)","Trash comments are not shown saparately");
		softAssert.assertTrue(catagoriesOfComments.get(4).isEnabled(),"Trash comment are not shown saparately");
		softAssert.assertAll();
	}

	
	
	
	
	
	
	
	
	


}
