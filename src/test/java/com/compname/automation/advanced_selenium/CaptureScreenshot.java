/**
 * 
 */
package com.compname.automation.advanced_selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author balaji
 * @Creation_Date:  Oct 9, 2019 
 * @ClassName: CaptureScreenshot.java
 * @LastModified_Date:  Oct 9, 2019 
 */
public class CaptureScreenshot {
	
	WebDriver driver;

	@Test
	public void takescreenshot(){
		
		String driverLoc = System.getProperty("user.dir")
				+ "/src/main/resources/drivers/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverLoc);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		getScreenshot(driver, "b4enterusername");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sampleuser");
		getScreenshot(driver, "typingUname");
		
		
	}
	
	public void getScreenshot(WebDriver driver, String screenshotName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./screenshots/"+screenshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Execption in taking screenshot "+e.getMessage());
		}
		
		
		
	}

	
}
