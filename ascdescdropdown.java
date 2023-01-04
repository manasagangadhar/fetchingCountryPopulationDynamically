package com.datadriven.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ascdescdropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele=  driver.findElement(By.id("animals"));
		Select s = new Select(ele);
		
		List originalList = new ArrayList();
		
		List<WebElement> options =  s.getOptions();
		
		for( WebElement e: options )
		{
			originalList.add(e.getText());
		}
		
System.out.println(originalList);


List tempList = new ArrayList();
tempList=originalList;

System.out.println("Before sorting temp list: " + tempList);

Collections.sort(tempList);

System.out.println("After sorting temp list: " + tempList);

	}

}
