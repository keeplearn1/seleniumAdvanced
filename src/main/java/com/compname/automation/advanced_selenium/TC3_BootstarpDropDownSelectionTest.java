/**
 * 
 */
package com.compname.automation.advanced_selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author balaji
 * @Creation_Date: Oct 9, 2019
 * @ClassName: testClass.java
 * @LastModified_Date: Oct 9, 2019
 */
public class TC3_BootstarpDropDownSelectionTest {

	static String URL = "http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";

	public static void main(String[] args) throws IOException {

		String driverLoc = System.getProperty("user.dir")
				+ "/src/main/resources/drivers/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverLoc);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);

		driver.findElement(By.xpath("//*[@id='menu1']")).click();
		List<WebElement> listElements = driver.findElements(By
				.xpath("//ul[@class='dropdown-menu']/li/a"));
		for (WebElement ele : listElements) {
			String eleValue = ele.getText();//("innnerHTML");
			if (eleValue.trim().contentEquals("JavaScript")) {
				ele.click();
				break;
			}

			driver.close();

		}

	}
}
