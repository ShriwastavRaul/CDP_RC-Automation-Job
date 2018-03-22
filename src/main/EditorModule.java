package main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class EditorModule {

	public void goToEditorForAuthor(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting navigation to the editor for author");
		editorModulePageObject.gotoEditorForAuthorPage();
	}

	public void goToEditorForReviewer(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting navigation to the editor for reviewer");
		editorModulePageObject.gotoEditorForReviewerPage();
	}

	public void goToEditorForEditor(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting navigation to the editor for editor");
		editorModulePageObject.gotoEditorForEditorPage();
	}

	public void goToEditorForAdmin(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "starting navigation to the editor for admin");
		editorModulePageObject.gotoEditorForAdminPage();
	}
	
	public void matterTypeCheck(WebDriver driver) throws InterruptedException{
		EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		editorModulePageObject.goToEditorForSection();
		Thread.sleep(3000);
		String section=(driver.findElement(editorModulePageObject.sectionLabel)).getText();
		String chapter=driver.findElement(editorModulePageObject.chapterLabel).getText();
		System.out.println(section);
		System.out.println(chapter);
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(driver.findElement(editorModulePageObject.matterTyoeBox).isDisplayed());
		softAssert.assertTrue(section.contains("Section"), "section is not written in lable");
		softAssert.assertTrue(chapter.contains("Chapter"), "chapter is not written in label");
		softAssert.assertTrue((driver.findElement(editorModulePageObject.sectionRadionBtn).isDisplayed()));
		softAssert.assertTrue((driver.findElement(editorModulePageObject.chapterRadioBtn).isDisplayed()));
		softAssert.assertAll();
	}
	
	public void sectionRadionBtnCheck(WebDriver driver) throws InterruptedException{
		EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		editorModulePageObject.goToEditorForSection();
		Thread.sleep(3000);
		String sectionCheck=(driver.findElement(editorModulePageObject.sectionRadionBtn)).getAttribute("checked");
		System.out.println(sectionCheck);

		
		Assert.assertTrue(sectionCheck.equals("true"));
	}
	
	public void chapterRadionBtnCheck(WebDriver driver) throws InterruptedException{
		EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		editorModulePageObject.gotoEditorForAuthorPage();
		Thread.sleep(3000);
		String chapterCheck=(driver.findElement(editorModulePageObject.chapterRadioBtn)).getAttribute("checked");
		
		System.out.println(chapterCheck);
		Assert.assertTrue(chapterCheck.equals("true"));
	}


	// called
	public boolean editorForAuthorBasicChecksLogic(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		String prevGetStyle = driver.findElement(editorModulePageObject.expandingBody).getAttribute("Style");
		driver.switchTo().frame(editorModulePageObject.iframeID);
		driver.findElement(editorModulePageObject.editor).click();
		driver.findElement(editorModulePageObject.editor).sendKeys(editorModulePageObject.selectKeys);
		
		

		driver.switchTo().parentFrame();
		String getStyle = driver.findElement(editorModulePageObject.expandingBody).getAttribute("Style");
		System.out.println(getStyle);
		System.out.println(prevGetStyle);
		if (!getStyle.equals(prevGetStyle))
			token = true;
		else
			token = false;
		driver.switchTo().frame(editorModulePageObject.iframeID);
		driver.findElement(editorModulePageObject.editor).click();
		driver.findElement(editorModulePageObject.editor).sendKeys(editorModulePageObject.selectKeys);
		

		driver.switchTo().parentFrame();
		return token;
	}
	// called

	public boolean editorFormattingCheck(WebDriver driver) throws InterruptedException {

		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		token = driver.findElement(editorModulePageObject.formatttingBtn).isEnabled();
		return token;

	}
	// caLLED

	public boolean draftCompleteBtnChkForAuthor(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		token = driver.findElement(editorModulePageObject.makeDrftCompleteBtn).isEnabled();
		return token;
	}

	public boolean editorFormattingCheckForReviewer(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		editorModulePageObject.gotoEditorForReviewerPage();
		token = driver.findElement(editorModulePageObject.makeDrftCompleteBtn).isEnabled();

		return token;

	}

	// CALLED

	public boolean editorExpandCheckForReviewer(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		// editorModulePageObject.gotoEditorForReviewerPage();
		String prevGetStyle = driver.findElement(editorModulePageObject.expandingBody).getAttribute("Style");
		driver.switchTo().frame(editorModulePageObject.iframeID);
		System.out.println("entered the frame");
		driver.findElement(editorModulePageObject.editor).click();
		driver.findElement(editorModulePageObject.editor).sendKeys(editorModulePageObject.selectKeys);
		//driver.findElement(editorModulePageObject.editor).sendKeys(editorModulePageObject.selectKeys);

		driver.switchTo().parentFrame();
		String getStyle = driver.findElement(editorModulePageObject.expandingBody).getAttribute("Style");
		System.out.println(getStyle);
		System.out.println(prevGetStyle);
		if (!getStyle.equals(prevGetStyle))
			token = true;
		else
			token = false;
		driver.switchTo().frame(editorModulePageObject.iframeID);
		driver.findElement(editorModulePageObject.editor).click();
		driver.findElement(editorModulePageObject.editor).sendKeys(editorModulePageObject.selectKeys);

		driver.switchTo().parentFrame();
		return token;
	}
//called
	public boolean editorForAdminBasicInlineCommentCheck(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForAdminPage();

		token = driver.findElement(editorModulePageObject.inlineCommentSec).isDisplayed();
		return token;

	}
//called
	public boolean editorForAdminSaveBtnChk(WebDriver driver) throws InterruptedException {
		boolean tokenSave = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForAdminPage();

		tokenSave = driver.findElement(editorModulePageObject.saveBtn).isEnabled();
		return tokenSave;

	}
//called
	public boolean editorForAdminMarkForProofingChk(WebDriver driver) throws InterruptedException {
		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForAdminPage();

		token = driver.findElement(editorModulePageObject.markProofingCompleteBtn).isEnabled();
		return token;

	}
//called
	public boolean editorForAdminMoveToTrashChk(WebDriver driver) throws InterruptedException {
		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForAdminPage();

		token = driver.findElement(editorModulePageObject.moveToTrashLink).isEnabled();
		return token;

	}
//called
	public boolean editorForAdminRevisionBlockChk(WebDriver driver) throws InterruptedException {
		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForAdminPage();

		token = driver.findElement(editorModulePageObject.revisionSection).isDisplayed();
		return token;

	}

	// called
	public boolean editorForEditorBasicInlineCommentCheck(WebDriver driver) throws InterruptedException {
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		// editorModulePageObject.gotoEditorForEditorPage();

		token = driver.findElement(editorModulePageObject.inlineCommentSec).isDisplayed();
		return token;

	}

	// called
	public boolean editorForEditorSaveBtnChk(WebDriver driver) throws InterruptedException {
		boolean tokenSave = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		// editorModulePageObject.gotoEditorForEditorPage();

		tokenSave = driver.findElement(editorModulePageObject.saveBtn).isEnabled();
		return tokenSave;

	}

	// called
	public boolean editorForEditorMarkForProofingChk(WebDriver driver) throws InterruptedException {
		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		// editorModulePageObject.gotoEditorForEditorPage();

		token = driver.findElement(editorModulePageObject.markProofingCompleteBtn).isEnabled();
		return token;

	}

	// called
	public boolean editorForEditorMoveToTrashChk(WebDriver driver) throws InterruptedException {
		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		//editorModulePageObject.gotoEditorForEditorPage();

		token = driver.findElement(editorModulePageObject.moveToTrashLink).isEnabled();
		return token;

	}

	// called
	public boolean editorForEditoreRevisionBlockChk(WebDriver driver) throws InterruptedException {

		boolean token = false;

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);

		// editorModulePageObject.gotoEditorForEditorPage();

		token = driver.findElement(editorModulePageObject.revisionSection).isDisplayed();
		return token;

	}

	// tinymce menubar for Authors

	public void editorToolBarElementCheckForAuthor(WebDriver driver) throws InterruptedException {

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the buttons on tool bar is enabled");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(editorModulePageObject.undoBtnm).isEnabled(),
				"Undo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.redoBtn).isEnabled(),
				"Redo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.clearFormateBtn).isEnabled(),
				"clear Formatting button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.findReplaceBtn).isEnabled(),
				"Find and Replace button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.splCharacterBtnEA).isEnabled(),
				"special character button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertMediaBtnEA).isEnabled(),
				"Insert Media button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.snippetBtnEA).isEnabled(),
				"snippet button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.commentBtnEA).isEnabled(),
				"comment button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.italicdBtnEA).isEnabled(),
				"Italic button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.underLinedBtnEA).isEnabled(),
				"UnderLine button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.leftAligningBtnEA).isEnabled(),
				"left Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.rightAligningBtnEA).isEnabled(),
				"Right Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.centreAligningBtnEA).isEnabled(),
				"Centre button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent1BtnEA).isEnabled(),
				"increase intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent2BtnEA).isEnabled(),
				"decrease intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.tableBtnEA).isEnabled(),
				"Table button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.codeBtnEA).isEnabled(),
				"code button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.blockQuoteBtnEA).isEnabled(),
				"quote button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.bulletinseBtnEA).isEnabled(),
				"point bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.numberedbulletinsBtnEA).isEnabled(),
				"number bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.arrowbulletinsBtnEA).isEnabled(),
				"arrow button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.pageBrkBtnEA).isEnabled(),
				"page break button is not enabled");

		softAssert.assertAll();

	}

	// tinymce menubar will be same for every other except author

	// called
	public void editorToolBarElementCheckForEditor(WebDriver driver) throws InterruptedException {

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		// editorModulePageObject.gotoEditorForAdminPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the buttons on tool bar is enabled");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(editorModulePageObject.undoBtnm).isEnabled(),
				"Undo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.redoBtn).isEnabled(),
				"Redo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.clearFormateBtn).isEnabled(),
				"clear Formatting button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.findReplaceBtn).isEnabled(),
				"Find and Replace button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.splCharacterBtn).isEnabled(),
				"special character button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertMediaBtn).isEnabled(),
				"Insert Media button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.snippetBtn).isEnabled(),
				"snippet button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.commentBtn).isEnabled(),
				"comment button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.italicdBtn).isEnabled(),
				"Italic button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.underLinedBtn).isEnabled(),
				"UnderLine button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.leftAligningBtn).isEnabled(),
				"left Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.rightAligningBtn).isEnabled(),
				"Right Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.centreAligningBtn).isEnabled(),
				"Centre button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent1Btn).isEnabled(),
				"increase intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent2Btn).isEnabled(),
				"decrease intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.tableBtn).isEnabled(),
				"Table button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.codeBtn).isEnabled(),
				"code button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.blockQuoteBtn).isEnabled(),
				"quote button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.bulletinseBtn).isEnabled(),
				"point bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.numberedbulletinsBtn).isEnabled(),
				"number bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.arrowbulletinsBtn).isEnabled(),
				"arrow button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.pageBrkBtn).isEnabled(),
				"page break button is not enabled");

		softAssert.assertAll();

	}
//called
	public void editorToolBarElementCheckForReviewer(WebDriver driver) throws InterruptedException {

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the buttons on tool bar is enabled");
		// editorModulePageObject.gotoEditorForReviewerPage();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(editorModulePageObject.undoBtnm).isEnabled(),
				"Undo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.redoBtn).isEnabled(),
				"Redo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.clearFormateBtn).isEnabled(),
				"clear Formatting button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.findReplaceBtn).isEnabled(),
				"Find and Replace button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.splCharacterBtnER).isEnabled(),
				"special character button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertMediaBtnER).isEnabled(),
				"Insert Media button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.snippetBtnER).isEnabled(),
				"snippet button button is not enabled");
	
		softAssert.assertTrue(driver.findElement(editorModulePageObject.italicdBtnER).isEnabled(),
				"Italic button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.underLinedBtnER).isEnabled(),
				"UnderLine button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.leftAligningBtnER).isEnabled(),
				"left Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.rightAligningBtnER).isEnabled(),
				"Right Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.centreAligningBtnER).isEnabled(),
				"Centre button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent1BtnER).isEnabled(),
				"increase intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent2BtnER).isEnabled(),
				"decrease intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.tableBtnER).isEnabled(),
				"Table button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.codeBtnER).isEnabled(),
				"code button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.blockQuoteBtnER).isEnabled(),
				"quote button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.bulletinseBtnER).isEnabled(),
				"point bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.numberedbulletinsBtnER).isEnabled(),
				"number bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.arrowbulletinsBtnER).isEnabled(),
				"arrow button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.pageBrkBtnER).isEnabled(),
				"page break button is not enabled");

		softAssert.assertAll();

	}
//called
	public void editorToolBarElementCheckForAdmin(WebDriver driver) throws InterruptedException {

		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if all the buttons on tool bar is enabled");
		//editorModulePageObject.gotoEditorForAdminPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(editorModulePageObject.undoBtnm).isEnabled(),
				"Undo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.redoBtn).isEnabled(),
				"Redo button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.clearFormateBtn).isEnabled(),
				"clear Formatting button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.findReplaceBtn).isEnabled(),
				"Find and Replace button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.splCharacterBtn).isEnabled(),
				"special character button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertMediaBtn).isEnabled(),
				"Insert Media button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.snippetBtn).isEnabled(),
				"snippet button button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.commentBtn).isEnabled(),
				"comment button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.italicdBtn).isEnabled(),
				"Italic button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.underLinedBtn).isEnabled(),
				"UnderLine button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.leftAligningBtn).isEnabled(),
				"left Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.rightAligningBtn).isEnabled(),
				"Right Align button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.centreAligningBtn).isEnabled(),
				"Centre button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent1Btn).isEnabled(),
				"increase intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.insertIndent2Btn).isEnabled(),
				"decrease intend button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.tableBtn).isEnabled(),
				"Table button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.codeBtn).isEnabled(),
				"code button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.blockQuoteBtn).isEnabled(),
				"quote button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.bulletinseBtn).isEnabled(),
				"point bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.numberedbulletinsBtn).isEnabled(),
				"number bulletin button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.arrowbulletinsBtn).isEnabled(),
				"arrow button is not enabled");
		softAssert.assertTrue(driver.findElement(editorModulePageObject.pageBrkBtn).isEnabled(),
				"page break button is not enabled");

		softAssert.assertAll();

	}

	// called

	public void distractionFreeModeForAuthor(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		Assert.assertTrue(driver.findElement(editorModulePageObject.distractionFreeModeBtnForAuthor).isEnabled(),
				"distraction free mode btn in menu bar is not working for Author");

	}

	// called

	public void distractionFreeModeForEditor(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		// editorModulePageObject.gotoEditorForAdminPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if distraction free mode buttons on tool bar is enabled");
		Assert.assertTrue(driver.findElement(editorModulePageObject.distractionFreeModeBtn).isEnabled(),
				"distraction free mode btn in menu bar is not working for Author");

	}
	// called

	public void distractionFreeModeForReviewer(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		// editorModulePageObject.gotoEditorForReviewerPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if distraction free mode buttons on tool bar is enabled");
		Assert.assertTrue(driver.findElement(editorModulePageObject.distractionFreeModeBtnForReviewer).isEnabled(),
				"distraction free mode btn in menu bar is not working for Author");
	}
//called
	public void distractionFreeModeForAdmin(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		//editorModulePageObject.gotoEditorForAdminPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if distraction free mode buttons on tool bar is enabled");
		Assert.assertTrue(driver.findElement(editorModulePageObject.distractionFreeModeBtn).isEnabled(),
				"distraction free mode btn in menu bar is not working for Author");
	}
	
	public void matterTypeCheckForReviewer(WebDriver driver) throws InterruptedException{
		EditorModulePageObject editorModulePageObject=new EditorModulePageObject(driver);
		Assert.assertFalse(driver.findElement(editorModulePageObject.matterTyoeBox).isDisplayed(), "Matter Type Box should be unavailable for Reviewer");
		
	}

	// called
	public void authorContentTabsCheck(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		List<WebElement> contentTabs = driver.findElements(editorModulePageObject.contenttabsForAuthor);
		int numberOfContentTabs = contentTabs.size();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if buttons on editor is working fine");
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(numberOfContentTabs, 2, "HTML tab is present as well");
		
		softAssert.assertFalse(contentTabs.get(0).getText().contains("HTML"),"first tab is not editor");
		
		softAssert.assertEquals(contentTabs.get(1).getText(), "PDF Preview", "Second tab is not PDF Prieview");
		softAssert.assertAll();

	}
	//called
	public void reviewerContentTabsCheck(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		List<WebElement> contentTabs = driver.findElements(editorModulePageObject.contenttabsForReviewer);
		int numberOfContentTabs = contentTabs.size();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if buttons on editor is working fine");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(numberOfContentTabs, 2, "HTML tab is present as well");
		softAssert.assertTrue(contentTabs.get(0).getText().contains("Editor"),"first tab is not editor");
		
		softAssert.assertEquals(contentTabs.get(1).getText(), "PDF Preview", "Second tab is not PDF Prieview");
		softAssert.assertAll();

	}
	
	public void editorContentTabsCheck(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		List<WebElement> contentTabs = driver.findElements(editorModulePageObject.contenttabsForReviewer);
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if buttons on editor is working fine");
		int numberOfContentTabs = contentTabs.size();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(numberOfContentTabs, 6, "HTML tab is not present");
		softAssert.assertTrue(contentTabs.get(3).getText().contains("Editor"),"first tab is not editor");
		
		softAssert.assertEquals(contentTabs.get(4).getText(), "HTML", "Second tab is not HTML");
		softAssert.assertEquals(contentTabs.get(5).getText(), "PDF Preview", "Second tab is not PDF Preview");
		softAssert.assertAll();

	}


	public void saveReviewBtnForReviewer(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		// editorModulePageObject.gotoEditorForReviewerPage();
		boolean token = driver.findElement(editorModulePageObject.saveReviewBtn).isEnabled();
		String btnText=driver.findElement(editorModulePageObject.saveReviewBtn).getText();
		SoftAssert softAssert = new SoftAssert();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if Save Review button is working fine");
		softAssert.assertTrue(token, "Save Review button is not enabled");
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if Save Review button is having correct label");
		softAssert.assertEquals(btnText, "Save review","Button is other than save Review");
		softAssert.assertAll();
	}

	public void revisionRestoreforEditor(WebDriver driver) throws InterruptedException {
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		//editorModulePageObject.gotoEditorForEditorPage();
		ExtentTestManager.getTest().log(LogStatus.INFO, "browsing to previous revisions");
		boolean token = driver.findElement(editorModulePageObject.browsePreviousRivisions).isEnabled();
		SoftAssert softAssert = new SoftAssert();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting if browse previous revision link working fine");

		softAssert.assertTrue(token, "not able to acess revision");

		driver.findElement(editorModulePageObject.browsePreviousRivisions).click();
		Thread.sleep(4000);
		driver.findElement(editorModulePageObject.previousChap).click();
		ExtentTestManager.getTest().log(LogStatus.INFO, "asserting the restore button for previous revisions");

		token = driver.findElement(editorModulePageObject.restoreTheRevisionBtn).isEnabled();
		softAssert.assertTrue(token, "revision is not getting restored");
		driver.navigate().back();
		softAssert.assertAll();

	}
	
	public void saveCommentByEditor(WebDriver driver) throws InterruptedException{
		boolean token = false;
		EditorModulePageObject editorModulePageObject = new EditorModulePageObject(driver);
		driver.switchTo().frame(editorModulePageObject.iframeID);
		driver.findElement(editorModulePageObject.editor).click();
		Actions builder=new Actions(driver);
		builder.dragAndDrop(driver.findElement(editorModulePageObject.dragPointinEditor),driver.findElement(editorModulePageObject.dropPointinEditor));
		driver.switchTo().parentFrame();
		driver.findElement(editorModulePageObject.commentBtn).click();
		Thread.sleep(5000);
		
	}

}
