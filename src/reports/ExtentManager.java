package reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {
	
	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = "/home/test/workspace/CPDAutomation_RC/src/reports/TestReport.html";
            extent = new ExtentReports(workingDir, true);
        }
        return extent;
    }



}