package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countryPopulation {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		String xpath_current_pop ="//div[@class='maincounter-number']/span[@class='rts-counter']";
		String xpath_today_pop = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		String xpath_thisyear_pop = "//div[text()='This year']//parent::div//span[@class='rts-counter']";
		String xpath_today_year = "//div[text()='This year' or text()='Today']//parent::div//span[@class='rts-counter']";
		String text  ="//div[text()='This year' or text()='Today']//parent::div//div[@class='sec-box' or @class='sec-box-last']";
		//String textmsg= text + xpath_today_year;
		driver = new ChromeDriver();
		
		driver.get("https://www.worldometers.info/world-population/");
		
		
//		while(true)
//		{
//		List<WebElement> popList = driver.findElements(By.xpath("//div[@class='maincounter-number']//span/span"));
//		
//		for(WebElement e:popList )
//		{
//			System.out.println(e.getText());
//		}
//		
//		popList = driver.findElements(By.xpath("//div[@class='maincounter-number']//span/span"));
//		}
		
		
//		while(true)
//			{
//			List<WebElement> popList = driver.findElements(By.xpath(""));
//			
//			for(WebElement e:popList )
//			{
//				System.out.println(e.getText());
//			}
//			
//			
//			}
		
int count =1;
		
		while(count<=20)
		{
			System.out.println(count + " sec");
			if (count==21)
				break;
			System.out.println("------- current population count ----------");
			printPopulationData(xpath_current_pop);
			//printPopulationData(xpath_today_pop);
//			printPopulationData(xpath_thisyear_pop);
			
			System.out.println("------- Today and this year  population count ----------");
			printPopulationData(text);
			//printPopulationData(xpath_today_year);
			System.out.println("=============================");
			
			Thread.sleep(1000);
			count++;
		}
		
		
		
	}

	public static void printPopulationData(String locator) throws InterruptedException
	{
		List<WebElement> popList = driver.findElements(By.xpath(locator)) ;
		//List<WebElement> text = driver.findElements(By.xpath("//div[@class='sec-text']"));
		
		
			for(WebElement e:popList )
			{
				//System.out.println(ele.getText());
				System.out.println(e.getText());
			}
		
		
		
//		driver.findElements(By.xpath(locator))
//		.stream()
//		.forEach(e-> System.out.println(e.getText()));
		
	}
}
