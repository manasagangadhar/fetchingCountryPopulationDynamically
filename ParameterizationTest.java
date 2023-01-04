package com.datadriven.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utility.Xls_Reader;

public class ParameterizationTest {
	
	
	static WebDriver driver;
	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\RegTestDataLoginmanas\\eclipse-workspace\\"
	+ "DataDrivenProject\\src\\com\\testdata\\RegTest.xlsx");
		
		
		
		int rowCount = reader.getRowCount("RegTestDataLogin");
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			String username = reader.getCellData("RegTestDataLogin", "username" , rowNum);
			System.out.println(username);
			
			
			String password = reader.getCellData("RegTestDataLogin", "password", rowNum);
			System.out.println(password);
			
			
			
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://practicetestautomation.com/practice-test-login/");

			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@id='submit']")).click();
		}
	}
 
}
