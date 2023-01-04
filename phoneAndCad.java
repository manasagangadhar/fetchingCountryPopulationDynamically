package com.datadriven.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class phoneAndCad {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart");
		driver.navigate().refresh();
		WebElement phone = driver.findElement(By.xpath("//a[contains(text(),'Phones & PDAs')]"));
		Actions act = new Actions(driver);
		act.moveToElement(phone).perform();
		phone.click();
		
		
		

		

		WebElement Dp = driver.findElement(By.xpath("(//select)[1]"));

		Select s = new Select(Dp);
		// System.out.println(s.getOptions().size());
		Thread.sleep(2000);
		int text = s.getOptions().size();

		List<WebElement> ele = driver.findElements(By.xpath("(//select)[1]"));

		for (int i = 0; i < ele.size(); i++) {

			String Country_Names = ele.get(i).getText();

			System.out.println(Country_Names);

		}

		try {
			for (int i = 0; i <=text ; i++) {
				//driver.navigate().refresh();
				s.selectByIndex(i);
				//System.out.println(s.getClass());

			}
		}
		catch(StaleElementReferenceException e)
		{
			
		}
		
		
	}

}
