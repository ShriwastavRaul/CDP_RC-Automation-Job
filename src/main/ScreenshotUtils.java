package main;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public class Screeshots {

		public void captureScreens(WebDriver driver, String location) {
			try {
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File(location));

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}

}
