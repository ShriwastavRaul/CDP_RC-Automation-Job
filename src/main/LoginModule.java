package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModule {
	
	
	public static void waitForPagetoLoad(WebDriver driver, By locator){
		BaseClass.waitForPagetoLoad(driver, ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public String loginSuccessful(WebDriver driver,String userID,String pwd) throws InterruptedException{
		String userName=userID;
		String password=pwd;
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		
		String nextPageTitle= loginModulePageObject.loginSuccessFul(userName, password);
		return nextPageTitle;
		
	}
	
	public String loginFailiure(WebDriver driver, String userID,String pwd ) throws InterruptedException{
		String userName=userID;
		String password=pwd;
		
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		String errorText=loginModulePageObject.loginFailure(userName, password);
		return errorText;
		
	}
	
	public String loginFailiureWrongUserName(WebDriver driver, String userID,String pwd ) throws InterruptedException{
		String userName=userID;
		String password=pwd;
		
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		String errorText=loginModulePageObject.LoginFailureWrongUserName(userID, pwd);
		return errorText;
		
	}
	
	public String lostPwd(WebDriver driver,String userID){
		String userName= userID;
		
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		String lostPasswordPageTiltle=loginModulePageObject.lostPwd(userName);
		return lostPasswordPageTiltle;
	}
	
	public Boolean loginBtnDisabledCheck(WebDriver driver,String userID,String pwd) throws InterruptedException{
		String userName=userID;
		String password=pwd;
		LoginModulePageObject loginModulePageObject=new LoginModulePageObject(driver);
		Boolean loginBtnAttribute=loginModulePageObject.loginBtnDisabledCheck(userName, password);
		return loginBtnAttribute;
	}
	
	public String backToCDPLinkCheck(WebDriver driver) throws InterruptedException{
		LoginModulePageObject loginModuelPageObject=new LoginModulePageObject(driver);
		String landingPageTitle= loginModuelPageObject.backToCDPLinkCheck();
		return landingPageTitle;
		
	}
	
	public String passwordRecoveryMsg(WebDriver driver,String userID) throws InterruptedException{
		String userName=userID;
		LoginModulePageObject loginModuelPageObject=new LoginModulePageObject(driver);
		String checkEmailText=loginModuelPageObject.passwordRecovery(userName);
		return checkEmailText;
	}
	
	public String passwordRecoveryMsgNegative(WebDriver driver,String userID) throws InterruptedException{
		String userName=userID;
		LoginModulePageObject loginModuelPageObject=new LoginModulePageObject(driver);
		String checkEmailText=loginModuelPageObject.passwordRecoveryNegative(userName);
		return checkEmailText;
	}
	
	
	
	

}
