package com.datadriven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream fp = new FileInputStream(
				"C:\\Users\\manas\\" + "eclipse-workspace\\DataDrivenProject\\src\\com\\config\\config.properties");
		prop.load(fp);

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\manas\\eclipse-workspace\\" + "DataDrivenProject\\src\\com\\testdata\\RegTest.xlsx");

		String username = reader.getCellData("RegTestDataLogin", "username", 2);
		System.out.println(username);

		String password = reader.getCellData("RegTestDataLogin", "password", 2);
		System.out.println(password);

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} 
		else {
			System.out.println("no browser is given ");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(prop.getProperty("url"));

		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(username);

		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(password);
		driver.findElement(By.xpath(prop.getProperty("submit_xpath"))).click();

	}

}
