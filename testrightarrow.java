package com.datadriven.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testrightarrow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/slider/#colorpicker");
		
		
//	WebElement	Slider =	driver.findElement(By.xpath("//span[1]"));
//	System.out.println("location of the slider is :" + Slider.getLocation());	
//	System.out.println("height and width of the element: " + Slider.getSize());
//	Actions act = new Actions(driver);
//	act.dragAndDropBy(Slider, 100, 0).perform();
//	
//	System.out.println("location of the slider is :" + Slider.getLocation());	
//	System.out.println("height and width of the element: " + Slider.getSize());
//		
//	WebElement	Slider1=	driver.findElement(By.xpath("//span[2]"));
//	act.dragAndDropBy(Slider1, -100, 0).perform();
		
		
		WebElement frame = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		List<WebElement> greenslider = driver.findElements(By.xpath("//*[@class='ui-widget-content']//div//span"));
		System.out.println(greenslider.size());
		
		for(int i=0;i<greenslider.size();i++)
		{
			driver.findElements(By.xpath("//*[@class='ui-widget-content']//div//span"));
			Actions act = new Actions(driver);
			String text = greenslider.get(i).getText();
	//		System.out.println(text);
			if(greenslider!=null)
			{
				act.dragAndDrop( 100, 200);
			}
			
		
			
		}
		//WebElement greenslider = driver.findElement(By.xpath("//*[@id='green']/span"));
//		Actions act = new Actions(driver);
//		System.out.println("location of the slider is :" + greenslider.getLocation());	
//		System.out.println("height and width of the element: " + greenslider.getSize());
//		act.dragAndDropBy(greenslider, -100, 120).perform();
		
	}

}
