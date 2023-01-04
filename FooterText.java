package com.datadriven.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class FooterText {
	
	public static void main(String[] args) {
		
		

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		//String footerText=driver.findElement(By.xpath("//div[@class='news-list-homepage']")).getText();
		 
		List<WebElement> tagname =  driver.findElements(By.tagName("a"));
		
		System.out.println("total a tag size is :" + tagname.size());
		for (int i = 0; i < tagname.size(); i++) {
			String textname = tagname.get(i).getText();
			String getAttr = tagname.get(i).getAttribute("href");
			System.out.println(getAttr);
			System.out.println(textname);
			
		}
		
		
		
		
	

		
	}

}
