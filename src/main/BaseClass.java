package main;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseClass {

	public WebDriver browserToOpen(String browser) {
		String browserToUse = browser;
		WebDriver driver = null;
		switch (browserToUse) {
		case "chrome": {
			String location = "";
			System.setProperty("webdriver.chrome.driver", location);
			driver = new ChromeDriver();
			break;
		}

		case "firefox": {
			String location="/home/test/Desktop/geckodriver"; 
			System.setProperty("webdriver.gecko.driver", location);
			driver = new FirefoxDriver();
			break;
		}

		case "InternetExplore": {
			String location = "";
			System.setProperty("webdriver.IE.driver", location);
			driver = new InternetExplorerDriver();
			break;
		}
		default: {
			// do nothing
		}

		}
		
		return driver;
	}

	public static void waitForPagetoLoad(WebDriver driver, ExpectedCondition<WebElement> expectedCondition) {
		WebElement element = null;
		int timeToWait = 20;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeToWait, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).pollingEvery(2, TimeUnit.SECONDS);
		element = wait.until(expectedCondition);
		System.out.println(element);
		if (element.equals("")) {
			System.out.println("Element was null");
			
		
		}
	
	}
	public static boolean isClickable(WebElement element){
	return true;
	
}

	public void hitURL(WebDriver driver, String url) {

		driver.get(url);
		
		

	}

}


