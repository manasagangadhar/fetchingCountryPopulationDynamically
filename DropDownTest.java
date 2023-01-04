package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

		driver.findElement(By.xpath("(//select)[1]")).click();

		WebElement Dp = driver.findElement(By.xpath("(//select)[1]"));

		Select s = new Select(Dp);
		// System.out.println(s.getOptions().size());

		int text = s.getOptions().size();

		List<WebElement> ele = driver.findElements(By.xpath("(//select)[1]"));

		for (int i = 0; i < ele.size(); i++) {

			String Country_Names = ele.get(i).getText();

			System.out.println(Country_Names);

		}

//	System.out.println(ele.size());	

		// System.out.println(Dp.size());

		for (int i = 0; i <= text; i++) {

			s.selectByIndex(i);
			
//			System.out.println(s.getFirstSelectedOption());
			//System.out.println(s.getClass());

		}

	}

}
