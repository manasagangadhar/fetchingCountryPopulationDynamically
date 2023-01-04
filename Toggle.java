package com.datadriven.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Toggle {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://www.prajavani.net/");
		
	List<WebElement> ele= driver.findElements(By.xpath("//ul[@class='navbar-nav mr-auto']//following::li"));
		
	int size = ele.size();
	
	
		for(int i=0; i<size; i++) {
			
			
			System.out.println(ele.get(i).getText());
			
		}
//		
		
		
		
		
	}

}
