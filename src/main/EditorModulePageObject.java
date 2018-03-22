package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class EditorModulePageObject {

	WebDriver driver;

	public EditorModulePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// locators for the whole editor page
	By makeDrftCompleteBtn = By.xpath("//*[@id='cdp-publishing-actions']/button[2]");

	By inlineCommentSec = By.id("cdp-comments");

	By saveBtn = By.id("cdp-save");

	By markProofingCompleteBtn = By.xpath("//*[@id='cdp-publishing-actions']/button[2]");

	By moveToTrashLink = By.linkText("Move to Trash");

	//By revisionSection = By.id("revisionsdiv");
	By revisionSection=By.cssSelector("#misc-publishing-actions > div.misc-pub-section.misc-pub-revisions");
	By browsePreviousRivisions=By.cssSelector("#misc-publishing-actions > div.misc-pub-section.misc-pub-revisions > a");

	// editor for Admin and Editor menubar locators

	By undoBtnm = By.xpath("//*[@id='mceu_1']/button");
	By redoBtn = By.xpath("//*[@id='mceu_2']/button");
	By clearFormateBtn = By.xpath("//*[@id='mceu_3']/button");
	By findReplaceBtn = By.xpath("//*[@id='mceu_4']/button");
	By SourceCodeBtn = By.xpath("//*[@id='mceu_5']/button");
	By splCharacterBtn = By.xpath("//*[@id='mceu_6']/button");
	By insertMediaBtn = By.id("mceu_7");
	By snippetBtn = By.id("mceu_8");
	By commentBtn = By.xpath("//*[@id='mceu_9']/button");
	By boldBtn = By.xpath("//*[@id='mceu_10']/button");
	By italicdBtn = By.xpath("//*[@id='mceu_11']/button");
	By underLinedBtn = By.xpath("//*[@id='mceu_12']/button");
	By superScriptBtn = By.xpath("//*[@id='mceu_13']/button");
	By subScriptBtn = By.xpath("//*[@id='mceu_14']/button");
	By insertLinkBtn = By.xpath("//*[@id='mceu_15']/button");
	By removeLinkBtn=By.xpath("//*[@id='mceu_16']/button");
	By insertFormulaBtn=By.xpath("//*[@id='mceu_17']/button");
	By leftAligningBtn=By.xpath("//*[@id='mceu_18']/button");
	By centreAligningBtn=By.xpath("//*[@id='mceu_19']/button");
	By rightAligningBtn=By.xpath("//*[@id='mceu_20']/button");
	By insertIndent1Btn=By.xpath("//*[@id='mceu_21']/button");
	By insertIndent2Btn=By.xpath("//*[@id='mceu_22']/button");
	By tableBtn=By.id("mceu_23-open");
	By codeBtn=By.xpath("//*[@id='mceu_24']/button");
	By screenTextBtn=By.xpath("//*[@id='mceu_25']/button");
	By blockQuoteBtn=By.xpath("//*[@id='mceu_26']/button");
	By bulletinseBtn=By.xpath("//*[@id='mceu_27']/button");
	By numberedbulletinsBtn=By.xpath("//*[@id='mceu_28']/button");
	By arrowbulletinsBtn=By.xpath("//*[@id='mceu_29']/button");
	By pageBrkBtn=By.xpath("//*[@id='mceu_30']/button");
	By distractionFreeModeBtn=By.xpath("//*[@id='mceu_31']/button");
	
	//toolbar element location for reviewer and author:
	By splCharacterBtnEA = By.xpath("//*[@id='mceu_5']/button");
	By insertMediaBtnEA = By.id("mceu_6");
	By snippetBtnEA = By.id("mceu_7");
	By commentBtnEA = By.xpath("//*[@id='mceu_8']/button");
	By boldBtnEA = By.xpath("//*[@id='mceu_9']/button");
	By italicdBtnEA = By.xpath("//*[@id='mceu_10']/button");
	By underLinedBtnEA = By.xpath("//*[@id='mceu_11']/button");
	By superScriptBtnEA = By.xpath("//*[@id='mceu_12']/button");
	By subScriptBtnEA = By.xpath("//*[@id='mceu_13']/button");
	By insertLinkBtnEA = By.xpath("//*[@id='mceu_14']/button");
	By removeLinkBtnEA=By.xpath("//*[@id='mceu_15']/button");
	By insertFormulaBtnEA=By.xpath("//*[@id='mceu_16']/button");
	By leftAligningBtnEA=By.xpath("//*[@id='mceu_17']/button");
	By centreAligningBtnEA=By.xpath("//*[@id='mceu_18']/button");
	By rightAligningBtnEA=By.xpath("//*[@id='mceu_19']/button");
	By insertIndent1BtnEA=By.xpath("//*[@id='mceu_20']/button");
	By insertIndent2BtnEA=By.xpath("//*[@id='mceu_21']/button");
	By tableBtnEA=By.id("mceu_22-open");
	By codeBtnEA=By.xpath("//*[@id='mceu_23']/button");
	By screenTextBtnEA=By.xpath("//*[@id='mceu_24']/button");
	By blockQuoteBtnEA=By.xpath("//*[@id='mceu_25']/button");
	By bulletinseBtnEA=By.xpath("//*[@id='mceu_26']/button");
	By numberedbulletinsBtnEA=By.xpath("//*[@id='mceu_27']/button");
	By arrowbulletinsBtnEA=By.xpath("//*[@id='mceu_28']/button");
	By pageBrkBtnEA=By.xpath("//*[@id='mceu_29']/button");
	By distractionFreeModeBtnEA=By.xpath("//*[@id='mceu_30]/button");
	
	//toolbars locatiors for author
	By splCharacterBtnER = By.xpath("//*[@id='mceu_5']/button");
	By insertMediaBtnER = By.id("mceu_6");
	By snippetBtnER = By.id("mceu_7");
	//By commentBtnER = By.xpath("//*[@id='mceu_8']/button");
	By boldBtnER = By.xpath("//*[@id='mceu_8']/button");
	By italicdBtnER = By.xpath("//*[@id='mceu_9']/button");
	By underLinedBtnER = By.xpath("//*[@id='mceu_10']/button");
	By superScriptBtnER = By.xpath("//*[@id='mceu_11']/button");
	By subScriptBtnER = By.xpath("//*[@id='mceu_12']/button");
	By insertLinkBtnER = By.xpath("//*[@id='mceu_13']/button");
	By removeLinkBtnER=By.xpath("//*[@id='mceu_15']/button");
	By insertFormulaBtnER=By.xpath("//*[@id='mceu_15']/button");
	By leftAligningBtnER=By.xpath("//*[@id='mceu_16']/button");
	By centreAligningBtnER=By.xpath("//*[@id='mceu_17']/button");
	By rightAligningBtnER=By.xpath("//*[@id='mceu_18']/button");
	By insertIndent1BtnER=By.xpath("//*[@id='mceu_19']/button");
	By insertIndent2BtnER=By.xpath("//*[@id='mceu_20']/button");
	By tableBtnER=By.id("mceu_21-open");
	By codeBtnER=By.xpath("//*[@id='mceu_22']/button");
	By screenTextBtnER=By.xpath("//*[@id='mceu_23']/button");
	By blockQuoteBtnER=By.xpath("//*[@id='mceu_24']/button");
	By bulletinseBtnER=By.xpath("//*[@id='mceu_25']/button");
	By numberedbulletinsBtnER=By.xpath("//*[@id='mceu_26']/button");
	By arrowbulletinsBtnER=By.xpath("//*[@id='mceu_27']/button");
	By pageBrkBtnER=By.xpath("//*[@id='mceu_28']/button");
	By distractionFreeModeBtnER=By.xpath("//*[@id='mceu_29]/button");
	
	
	By distractionFreeModeBtnForAuthor=By.xpath("//*[@id='mceu_30']/button");
	
	By contenttabsForAuthor=By.xpath("//*[@id='cdp-editor-tabs']//button");
	By contenttabsForReviewer=By.xpath("//*[@id='cdp-editor-tabs']//button");
	
	By revisionLinkForChapterForEditor=By.xpath("//*[@id='revisionsdiv']//ul/li[2]/a");
	
	//locator of the next page after clicking on revision link
	
	By restoreTheRevisionBtn=By.xpath("//input[@value='Restore This Revision']");
	
	By previousChap=By.xpath("//input[@value='Previous']");
	
	//locators in editor page for the reviewer
	
	By saveReviewBtn=By.id("cdp-create-review");
	By distractionFreeModeBtnForReviewer=By.xpath("//*[@id='mceu_29']/button");
	
	//locator on the iframe editor
	By dragPointinEditor=By.xpath("//*[@id='tinymce']/ul[1]/li[1]");
	By dropPointinEditor=By.xpath("//*[@id='tinymce']/ul[1]/li[2]");

	// locators in the Editor for Author

	By editor = By.id("tinymce");

	String iframeID = "content_ifr";

	By formatttingBtn = By.id("mceu_0-open");

	String selectKeys = Keys.chord(Keys.ALT, Keys.SHIFT, "w");

	By expandingBody = By.id("post-body-content");
	
	//locators for section section
	By matterTyoeBox=By.id("cdp-matter-type");
	By sectionRadionBtn=By.xpath("(//*[@id='matter-type']/label/input)[1]");
	By chapterRadioBtn=By.xpath("(//*[@id='matter-type']/label/input)[2]");
	By sectionLabel=By.xpath("(//*[@id='matter-type']/label)[1]");
	By chapterLabel=By.xpath("(//*[@id='matter-type']/label)[2]");
	

	public void gotoEditorForAuthorPage() throws InterruptedException {
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigation to my book page");
		chapterModulePageObject.myBookPageCatalog();
		

		chapterModulePageObject.chapterLinkForAuthors();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//BaseClass.waitForPagetoLoad(driver, ExpectedConditions.elementToBeClickable(chapterModulePageObject.chapterInDraftStateForAuthor));
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking any chapter in draft state");

		driver.findElement(chapterModulePageObject.chapterInDraftStateForAuthor).click();

	}
	
	public void goToEditorForSection() throws InterruptedException {
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "navigation to my book page");
		chapterModulePageObject.myBookPageCatalog();
		

		chapterModulePageObject.chapterLinkForAuthors();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking any section in draft state");

		driver.findElement(chapterModulePageObject.sectionLink).click();

	}

	public void gotoEditorForReviewerPage() throws InterruptedException {
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);

		chapterModulePageObject.myBookPageCatalog();

		chapterModulePageObject.chapterLinkForReviewer();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking any chapter in draft state");

		driver.findElement(chapterModulePageObject.chapterInDraftState).click();

	}

	public void gotoEditorForEditorPage() throws InterruptedException {
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);
		

		chapterModulePageObject.myBookPageCatalog();

		chapterModulePageObject.chapterLinkForEditor();
		
		//Actions action=new Actions(driver);
		
		/*action.moveToElement(driver.findElement(chapterModulePageObject.chapterInDraftStageForEditor));
		
		action.doubleClick();
		action.build().perform();*/
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking any chapter in draft state");
		
		driver.findElement(chapterModulePageObject.chapterInDraftStageForEditor).click();
	

		

	}

	public void gotoEditorForAdminPage() throws InterruptedException {
		ChapterModulePageObject chapterModulePageObject = new ChapterModulePageObject(driver);

		chapterModulePageObject.myBookPageCatalog();

		chapterModulePageObject.chapterLinkForAdmin();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking any chapter in draft state");

		driver.findElement(chapterModulePageObject.chapterinDraftStateForAdmin).click();

	}

}
