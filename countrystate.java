package com.datadriven.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class countrystate {
	public static void main(String[] args) throws InterruptedException {
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://naveenautomationlabs.com/opencart");
		
	WebElement ele =	  driver.findElement(By.xpath("(//a[contains(text(), 'Desktops')])[1]"));
	WebElement ele1 = driver.findElement(By.xpath("(//a[contains(text(), 'Mac (1)')])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		ele1.click();
		
		
	driver.findElement(By.xpath("//div[@class='button-group']//i[@class='fa fa-shopping-cart']")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//span[contains(text(), 'item(s)')]")).click();
	Thread.sleep(3000);
	WebElement m = driver.findElement(By.xpath("//strong[contains(text(), ' View Cart')]"));
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].click();", m);
	
	driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
	Thread.sleep(3000);
 WebElement radio =  driver.findElement(By.xpath("//input[@value='guest']"));
 radio.click();
 driver.findElement(By.xpath("//input[@id='button-account']")).click();
 
 Thread.sleep(2000);
 
 
 List<WebElement> pageOptions = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']"))).getOptions();//Get all options in dropdown
	ArrayList<String> pageDd = new ArrayList<String>();
	for(WebElement eachPage:pageOptions){
	    pageDd.add(eachPage.getText());//Save text of each option
	    
	}
	
	int i=1;
	for(String eachVal:pageDd){
	    new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']"))).selectByVisibleText(eachVal);//Select page
	    //driver.findElement(By.xpath("//input[@value='Go']")).click();//Click on go
	   List<WebElement> names = driver.findElements(By.xpath("(//option[@value=''])[1]"));//Get all names on page
	    
	    
	    for(WebElement eachName:names){
	        String name = eachName.getText(); //Get each name's text
	        WebElement mean = eachName.findElement(By.xpath("//select[@id='input-payment-zone']"));//Get meaning for that name
	        String meaning = mean.getText();//Get text of meaning
	        Thread.sleep(2000);
	        System.out.println(i+") Name: " + name+ "state name"+ meaning );//Print the data
	        i++;
	    }	
	}
 
//	 	driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Manasa");
//	 	driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Manu");
	 	
// WebElement country =  driver.findElement(By.id("input-payment-country"));
// Select s = new Select(country);
// List<WebElement> options = s.getOptions();
// 
// for(int i=0;i<options.size();i++)
// {
//	  String dropdown_values= options.get(i).getText();
//	  
//	  //System.out.println("country name list :" + dropdown_values);
//	  
//	  if(dropdown_values.equals("India"))
//	  {
//		  Select state = new Select(driver.findElement(By.id("input-payment-zone")));
//		  state.selectByVisibleText("Goa");
//	  }
// }
 

 
 
 
// WebElement dropdwon_country = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
// Select s = new Select(dropdwon_country);
// String country = s.getFirstSelectedOption().getText();
// 
// String valueToSelect= null;
// List<WebElement> options = s.getOptions();
// for(WebElement option : options)
// {
//	 if(option.getText().equals(valueToSelect)){
//			if(country.equals("India"))
//			option.isSelected();
//		}
//		if(country.equals("music"))
//			option.isSelected();
// }
	 

// 	WebElement firstname = driver.findElement(By.xpath("(//div [@class='text-danger'])[1]"));
// 	String actual = firstname.getText();
// 	String expected = "First Name must be between 1 and 32 characters!";	
//	Assert.assertEquals(actual,expected);
//	System.out.println("actual and expected both are same 1");
//	
//	
//	WebElement lastname = driver.findElement(By.xpath("(//div [@class='text-danger'])[2]"));
// 	String actual1 = lastname.getText();
// 	String expected1 = "Last Name must be between 1 and 32 characters!";	
//	Assert.assertEquals(actual1,expected1);
//	System.out.println("actual and expected both are same 2");
//	
//	WebElement email = driver.findElement(By.xpath("(//div [@class='text-danger'])[3]"));
// 	String actual2 = email.getText();
// 	String expected2 = "E-Mail address does not appear to be valid!";	
//	Assert.assertEquals(actual2,expected2);
//	System.out.println("actual and expected both are same 3");
//	
//	WebElement phone = driver.findElement(By.xpath("(//div [@class='text-danger'])[4]"));
// 	String actual3 = phone.getText();
// 	String expected3 = "Telephone must be between 3 and 32 characters!";	
//	Assert.assertEquals(actual3,expected3);
//	System.out.println("actual and expected both are same 4");
//	
//	WebElement address = driver.findElement(By.xpath("(//div [@class='text-danger'])[5]"));
// 	String actual4 = address.getText();
// 	String expected4 = "Address 1 must be between 3 and 128 characters!";	
//	Assert.assertEquals(actual4,expected4);
//	System.out.println("actual and expected both are same 5");
//	
//	WebElement city = driver.findElement(By.xpath("(//div [@class='text-danger'])[6]"));
// 	String actual5 = city.getText();
// 	String expected5 = "City must be between 2 and 128 characters!";	
//	Assert.assertEquals(actual5,expected5);
//	System.out.println("actual and expected both are same 6");
//	
//	
//	WebElement postcode = driver.findElement(By.xpath("(//div [@class='text-danger'])[8]"));
// 	String actual6 = postcode.getText();
// 	String expected6 = "Please select a region / state!";	
//	Assert.assertEquals(actual6,expected6);
//	System.out.println("actual and expected both are same 7");
 
	
	
	
	}

}
