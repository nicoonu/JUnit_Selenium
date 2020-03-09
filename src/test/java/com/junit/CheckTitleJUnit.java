package com.junit;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTitleJUnit {

	static WebDriver driver;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/");
	}

	@Test
	public void checkCorrectTitle() {
		String titulo = driver.getTitle();
		String expectedTitleString = "Welcome: Mercury Tours";
		if (expectedTitleString.equalsIgnoreCase(titulo))
			System.out.println("El titulo es correcto");
		else
			System.out.println("No coinciden los elementos");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}
}
