package com.datadriven.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtility;

public class TestDriven {

	WebDriver driver;

	@BeforeMethod

	public void Setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(20, Du)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = TestUtility.getDataFromExcel();
		return testdata.iterator();
	}

	@Test(enabled = false)
	public void logo() {
		WebElement logo = driver.findElement(By.xpath("//img[@class='custom-logo']"));

		if (logo.equals(logo)) {

			System.out.println("The Logo is displayed");
		} else {

			System.out.println("logo is not displayed");

		}

	}

	@Test(enabled = false)
	public void TitleTestPage() {

		String WebSiteTitle = driver.getTitle();
		String ActualTitle = "Test Login | Practice Test Automation";
		System.out.println(WebSiteTitle);
		Assert.assertEquals(ActualTitle, WebSiteTitle);
	}

	@Test(enabled = false)
	public void getUrl() {

		String curUrl = driver.getCurrentUrl();
		String actUrl = "https://practicetestautomation.com/practice-test-login/";
		System.out.println(curUrl);
		Assert.assertEquals(actUrl, curUrl);
	}

	@Test(enabled = false)
	public void subButCheck() {

		WebElement subBut = driver.findElement(By.xpath("//button[@id='submit']"));
		if (subBut.equals(subBut)) {

			System.out.println("The submit button is Enabled");
		} else {

			System.out.println("The submit button is not Enabled");

		}

	}

	@Test(enabled = false)
	public void logincheck() {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password124");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]"));
		System.out.println(ele.getText());

	}

	
	@Test(dataProvider = "getTestData", enabled = false)
	public void LoginTest(String username, String password) {
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

	}

	@AfterMethod
	public void TearDown() {

		driver.quit();

	}

}
