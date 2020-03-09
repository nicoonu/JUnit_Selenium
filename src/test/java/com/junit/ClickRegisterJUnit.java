package com.junit;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickRegisterJUnit {

	static WebDriver driver;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/");
	}

	@Test
	public void checkCorrectClick() {
		WebElement clickElement = driver.findElement(By.linkText("REGISTER"));
		if (clickElement.isEnabled())
			clickElement.click();
		else
			System.out.println("Este elemento no existe");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}
}
