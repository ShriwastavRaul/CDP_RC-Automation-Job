package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class DashBoardModule {

	public String myBookPageCheck(WebDriver driver, String userID, String pwd) throws InterruptedException {

		String userName = userID;
		String password = pwd;
		System.out.println("entered dashboard module function");
		System.out.println(driver);
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		String myBookPageTitle = dashboardPageObject.myBookCheck(userName, password);
		return myBookPageTitle;
	}

	public boolean dashboardForAuthor(WebDriver driver, String userID, String pwd) throws InterruptedException {
		
		String userName = userID;
		String password = pwd;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to author dashboard");
		List<WebElement> dashboardElements = dashboardPageObject.dashboardForAuther(userName, password);
		boolean token = false;
		for (int i = 0; i < dashboardElements.size(); i++) {
			token = dashboardElements.get(i).isDisplayed();
		}

		return token;
	}

	public boolean dashboardForReviewer(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigating to reviewer dashboard");
		boolean token=dashboardPageObject.dashboardForReviewers(userName, password);
		return token;

	}
	//dashboard check fr admin
	
	public boolean dashboardForAdmin(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		boolean token = dashboardPageObject.dashboardForAdmin(userName, password);
		

		return token;
	}
	
	//dashboard for user
	
	public boolean dashboardForEditor(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		boolean token = dashboardPageObject.dashboardForEditor(userName, password);
		/*boolean token = false;
		for (int i = 0; i < dashboardElements.size(); i++) {
			token = dashboardElements.get(i).isDisplayed();
		}*/

		return token;
	}
	
	//public author chapter/image check
	public boolean AuhtorLandingPageCheck(WebDriver driver, String userID, String pwd) throws InterruptedException {
		boolean token=false;
		String userName = userID;
		String password = pwd;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		return token;
	}
	
	//reviewer draft click check
	
	public boolean ReviewerDraftClickCheck(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		boolean token=false;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		token=dashboardPageObject.ReviewerDraftClickCheck(userName, password);
		return token;
	}
	
	//review draft click negative
	public boolean ReviewerDraftClickCheckNegative(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		boolean token=true;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		token=dashboardPageObject.ReviewerDraftClickCheckNegative(userName, password);
		return token;
	}
	
	//Author countinue writing btn check
	
	public boolean authorContinueWritingBtnChk(WebDriver driver, String userID, String pwd) throws InterruptedException {
		String userName = userID;
		String password = pwd;
		String nextPageTitle;
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		boolean token=dashboardPageObject.authorContinueWritingBtnChk(userName, password);
		return token;
	}
	
	public void myBookInfoTabForAuthorLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Dashboard = driver.findElement(By.cssSelector("#menu-dashboard > a > div.wp-menu-name")).getText();
	    Assert.assertNotEquals(Dashboard, "Book Info");
	    
	    //driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String MyBooks = driver.findElement(By.cssSelector("#toplevel_page_cdp-mybooks-menu > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(MyBooks, "Book Info");
				
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Chapters = driver.findElement(By.cssSelector("#toplevel_page_cdp-organize > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(Chapters, "Book Info");
		
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Publish= driver.findElement(By.cssSelector("#toplevel_page_cdp_export > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(MyBooks, "Publish");
		
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String MediaLibrary = driver.findElement(By.cssSelector("#menu-media > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(MediaLibrary, "Book Info");
		
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Comments = driver.findElement(By.cssSelector("#toplevel_page_comments > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(Comments, "Book Info");
		
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Reviews = driver.findElement(By.cssSelector("#menu-posts-cdp-review > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(Reviews, "Book Info");
		
		//driver.findElement(By.xpath("//*[@id='wm-shoutout-46057']/div[1]")).click();
		String Profile = driver.findElement(By.cssSelector("#menu-users > a > div.wp-menu-name")).getText();
		Assert.assertNotEquals(Profile, "Book Info");
		
		
		
		
		
	}
	
	public void revisionCheckForEditorLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on a chapter to go to editor ");
        driver.findElement(By.xpath("//*[@id='cdp-chapters-widget']/div/div/div[2]/ul/li[3]/span[3]/a")).click();
        Thread.sleep(3000);
        
        ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on revision section");
        
        driver.findElement(By.xpath("//*[@id='misc-publishing-actions']/div[3]")).click();
        Thread.sleep(3000);
        ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on compare button");
        driver.findElement(By.className("compare-two-revisions")).click();
        Thread.sleep(1000);
        boolean isChecked = driver.findElement(By.className("compare-two-revisions")).isSelected();
        Assert.assertTrue(isChecked);
		
	}
	
	public void reiviewsCheckForEditorLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		SoftAssert softAssert=new SoftAssert();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on reviews section on cdp menu");

        driver.findElement(By.xpath("//*[@id='menu-posts-cdp-review']/a/div[3]")).click();
        Thread.sleep(3000);
        ExtentTestManager.getTest().log(LogStatus.INFO, "asserting revision post link is clickable or not");
        boolean token = driver.findElement(By.xpath("//*[@id='post-305']/td[1]/strong/a")).isEnabled();
        softAssert.assertTrue(token);
       // Thread.sleep(3000);
       /* 
         token = driver.findElement(By.xpath("//*[@id='post-84']/td[1]/strong/a")).isEnabled();
        softAssert.assertTrue(token);
       // Thread.sleep(3000);
	  
         token = driver.findElement(By.xpath("//*[@id='post-83']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
        //Thread.sleep(3000);
	   
         token = driver.findElement(By.xpath("//*[@id='post-82']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
       // Thread.sleep(3000);
	   
         token = driver.findElement(By.xpath("//*[@id='post-79']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
       // Thread.sleep(3000);
         */
         softAssert.assertAll();
	   
        
	   
	}
	
	
	public void reivsionCompareCheckForAdminLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		

		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on a chapter to go to admin ");
       
      //  driver.findElement(By.xpath("//*[@id='toplevel_page_cdp-organize']/a/div[3]")).click();
       // Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='cdp-chapters-widget']/div/div/div[2]/ul/li[1]/span[3]/a")).click();
        Thread.sleep(3000);
        ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on revision section");
        driver.findElement(By.xpath("//*[@id='misc-publishing-actions']/div[3]/a/span[1]")).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on compare button");
        driver.findElement(By.className("compare-two-revisions")).click();
        
        boolean isChecked = driver.findElement(By.className("compare-two-revisions")).isSelected();
        Assert.assertTrue(isChecked);
         
         
	   
    
	}
	
	public void reviewsCheckForAdminLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		SoftAssert softAssert=new SoftAssert();

        driver.findElement(By.xpath("//*[@id='menu-posts-cdp-review']/a/div[3]")).click();
        Thread.sleep(3000);
        boolean token=false;
         token = driver.findElement(By.xpath("//*[@id='post-145']/td[1]/strong/a")).isEnabled();
        softAssert.assertTrue(token);
        //Thread.sleep(3000);
      /*  
         token = driver.findElement(By.xpath("//*[@id='post-84']/td[1]/strong/a")).isEnabled();
        softAssert.assertTrue(token);
       // Thread.sleep(3000);
	  
         token = driver.findElement(By.xpath("//*[@id='post-83']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
        //Thread.sleep(3000);
	   
         token = driver.findElement(By.xpath("//*[@id='post-82']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
       // Thread.sleep(3000);
	   
         token = driver.findElement(By.xpath("//*[@id='post-79']/td[1]/strong/a")).isEnabled();
         softAssert.assertTrue(token);
       // Thread.sleep(3000);
      */   
         softAssert.assertAll();
	   

	}
	
	public void metaDataCheckForEditorLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		//DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		//dashboardPageObject.myBookInfoTabForAuthorLogin(userID, pwd);
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		loginModulePageObject.loginSuccessFullWIthoutSignInandWalkMe(userID, pwd);
		SoftAssert softAssert=new SoftAssert();
		

		driver.findElement(By.linkText("Book Info")).click();
		
				
			
		String title = driver.findElement(By.xpath("//*[@for='title']")).getAttribute("for");
		softAssert.assertEquals("title", title);
		
		String shorttitle = driver.findElement(By.xpath("//*[@for='short_title']")).getAttribute("for");
		softAssert.assertEquals("short_title", shorttitle);
		
		String subtitle = driver.findElement(By.xpath("//*[@for='subtitle']")).getAttribute("for");
		softAssert.assertEquals("subtitle", subtitle);
		
		String Author = driver.findElement(By.xpath("//*[@for='author']")).getAttribute("for");
		softAssert.assertEquals("author", Author);
		
		String AuthorAs = driver.findElement(By.xpath("//*[@for='author_file_as']")).getAttribute("for");
		softAssert.assertEquals("author_file_as", AuthorAs);
		
		String ContAuthor = driver.findElement(By.xpath("//*[@for='contributing_authors']")).getAttribute("for");
		softAssert.assertEquals("contributing_authors", ContAuthor);
		
		String Publisher = driver.findElement(By.xpath("//*[@for='publisher']")).getAttribute("for");
		softAssert.assertEquals("publisher", Publisher);
		
		String PubCity = driver.findElement(By.xpath("//*[@for='publisher_city']")).getAttribute("for");
		softAssert.assertEquals("publisher_city", PubCity);
		
		String PubDate = driver.findElement(By.xpath("//*[@for='publication_date']")).getAttribute("for");
		softAssert.assertEquals("publication_date", PubDate);
		
		String SaleDate = driver.findElement(By.xpath("//*[@for='onsale_date']")).getAttribute("for");
		softAssert.assertEquals("onsale_date", SaleDate);
		
		String EISBN = driver.findElement(By.xpath("//*[@for='ebook_isbn']")).getAttribute("for");
		softAssert.assertEquals("ebook_isbn", EISBN);
		
		String PISBN = driver.findElement(By.xpath("//*[@for='print_isbn']")).getAttribute("for");
		softAssert.assertEquals("print_isbn", PISBN);
		
		String Lang = driver.findElement(By.xpath("//*[@for='language']")).getAttribute("for");
		softAssert.assertEquals("language", Lang);
		
		String CoverImage = driver.findElement(By.xpath("//*[@for='cover_image']")).getAttribute("for");
		softAssert.assertEquals("cover_image", CoverImage);
		
		boolean button = driver.findElement(By.id("image-select-button")).isEnabled();
		softAssert.assertTrue(button, "Image select button is not working properly");
		
		String CopyYear = driver.findElement(By.xpath("//*[@for='copyright_year']")).getAttribute("for");
		softAssert.assertEquals("copyright_year", CopyYear);
		
		String CopyHolder = driver.findElement(By.xpath("//*[@for='copyright_holder']")).getAttribute("for");
		softAssert.assertEquals("copyright_holder", CopyHolder);
		
		String CopyLic = driver.findElement(By.xpath("//*[@for='book_license']")).getAttribute("for");
		softAssert.assertEquals("book_license", CopyLic);
		
		String CopyNotice = driver.findElement(By.xpath("//*[@for='custom_copyright']")).getAttribute("for");
		softAssert.assertEquals("custom_copyright", CopyNotice);
		
		String Tagline = driver.findElement(By.xpath("//*[@for='about_140']")).getAttribute("for");
		softAssert.assertEquals("about_140", Tagline);
		
		String ShortDesc = driver.findElement(By.xpath("//*[@for='about_50']")).getAttribute("for");
		softAssert.assertEquals("about_50", ShortDesc);
		
		String LongDesc = driver.findElement(By.xpath("//*[@for='about_unlimited']")).getAttribute("for");
		softAssert.assertEquals("about_unlimited", LongDesc);
		
		String SeriesTitle = driver.findElement(By.xpath("//*[@for='series_title']")).getAttribute("for");
		softAssert.assertEquals("series_title", SeriesTitle);
		
		String SNo = driver.findElement(By.xpath("//*[@for='series_number']")).getAttribute("for");
		softAssert.assertEquals("series_number", SNo);
		
		String Editor = driver.findElement(By.xpath("//*[@for='editor']")).getAttribute("for");
		softAssert.assertEquals("editor", Editor);
		
		String Translator = driver.findElement(By.xpath("//*[@for='translator']")).getAttribute("for");
		softAssert.assertEquals("translator", Translator);
		
		String Keywords = driver.findElement(By.xpath("//*[@for='keywords_tags']")).getAttribute("for");
		softAssert.assertEquals("keywords_tags", Keywords);
		
		String Hashtag = driver.findElement(By.xpath("//*[@for='hashtag']")).getAttribute("for");
		softAssert.assertEquals("hashtag", Hashtag);
		
		String PPrice = driver.findElement(By.xpath("//*[@for='list_price_print']")).getAttribute("for");
		softAssert.assertEquals("list_price_print", PPrice);
		
		String PDFPrice = driver.findElement(By.xpath("//*[@for='list_price_pdf']")).getAttribute("for");
		softAssert.assertEquals("list_price_pdf", PDFPrice);
		
		String EPrice = driver.findElement(By.xpath("//*[@for='list_price_epub']")).getAttribute("for");
		softAssert.assertEquals("list_price_epub", EPrice);
		
		String WPrice = driver.findElement(By.xpath("//*[@for='list_price_web']")).getAttribute("for");
		softAssert.assertEquals("list_price_web", WPrice);
		
		String BISAC = driver.findElement(By.xpath("//*[@for='bisac_subject']")).getAttribute("for");
		softAssert.assertEquals("bisac_subject", BISAC);
		
		String BISACTheme = driver.findElement(By.xpath("//*[@for='bisac_regional_theme']")).getAttribute("for");
		softAssert.assertEquals("bisac_regional_theme", BISACTheme);
		
		String CatOrder = driver.findElement(By.xpath("//*[@for='catalogue_order']")).getAttribute("for");
		softAssert.assertEquals("catalogue_order", CatOrder);
		
		softAssert.assertAll();
		
	}
	
	public void addUserByAdminLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLoginwithoutWalkMe(userID, pwd);
		driver.findElement(By.xpath("//*[@id='menu-users']/a/div[3]")).click();
		
		boolean AddNewBtnEnable = driver.findElement(By.cssSelector("#wpbody-content > div.wrap > h1 > a")).isEnabled();
		Assert.assertTrue(AddNewBtnEnable,"not able to add new user");
		
	}
	public void removeUserByAdminLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);
		dashboardPageObject.myBookInfoTabForAuthorLoginwithoutWalkMe(userID, pwd);
		driver.findElement(By.xpath("//*[@id='menu-users']/a/div[3]")).click();
		
		driver.findElement(By.xpath("//*[@id='user_265']")).click();
		
		boolean Remove = driver.findElement(By.xpath("//*[@id='user-265']/td[1]/div/span[2]/a")).isEnabled();
		Assert.assertTrue(Remove,"not able to remove user");
		
	}
	
	public void networkAdminPageLogic(WebDriver driver, String userID, String pwd) throws InterruptedException{
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		loginModulePageObject.loginSuccessFullWithoutWalkME(userID, pwd);
		
		

		driver.findElement(By.xpath("//*[@id='wp-admin-bar-cdp-network-admin']/a")).click();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://rc-cdp.packtpub.com/wp-admin/network/");
		
		
	}


}
