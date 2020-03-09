package com.junit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(value = Parameterized.class)
public class SignInUser {

	static WebDriver driver;
	String nameUser;
	String passwordUSer;

	public SignInUser(String u, String p) {
		this.nameUser = u;
		this.passwordUSer = p;
	}

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://es-la.facebook.com/");
	}

	@Parameters
	public static Collection<Object[]> dataLogIn() {
		final List<Object[]> dataUser = new ArrayList<Object[]>();
		dataUser.add(new Object[] { "nikoonu@gmail.com", "12345" });
		return dataUser;
	}

	@Test
	public void signIn() {
		driver.findElement(By.name("email")).sendKeys(nameUser);
		driver.findElement(By.name("pass")).sendKeys(passwordUSer);
		driver.findElement(By.id("u_0_b")).click();

		assertEquals("nikoonu@gmail.com", nameUser);
		assertEquals("12345", passwordUSer);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}

}
