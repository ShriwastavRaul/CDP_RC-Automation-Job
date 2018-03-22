package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import main.BaseClass;
import reports.ExtentTestManager;

public class Retry implements IRetryAnalyzer {
	
	
	private int retryCount=0;
	private int maxRetryCOunt=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		if(retryCount<maxRetryCOunt){
			System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
			
			
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName=null;
		
		if(status==1)
			resultName="SUCCESS";
		if(status==2)
			resultName="FAILURE";
		if(status==3)
			resultName="SKIP";
		return resultName;
	}
	
	 public void extendReportsFailOperations (ITestResult iTestResult) {
	        Object testClass = iTestResult.getInstance();
	        WebDriver webDriver = ((BaseClass) testClass).browserToOpen("firefox");
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
	        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
	                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	    }

}
