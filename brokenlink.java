package com.datadriven.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlink {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
			
			driver.get("https://www.amazon.com");
		List<WebElement>	links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links : " + links.size());
		
		List<String> urlList = new ArrayList<String>();
		for(WebElement e:links )
		{
			String url = e.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
		}
		long sttime = System.currentTimeMillis();
		
		urlList.parallelStream().forEach(e ->checkBrokenLink(e));
		long endtime = System.currentTimeMillis();
		System.out.println("total time taken:" +(endtime-sttime));
}

public static void checkBrokenLink(String linkUrl)
{
	try {
		URL url = new URL(linkUrl);
	 HttpURLConnection httpurlconnection = (HttpURLConnection)	url.openConnection();
	 httpurlconnection.setConnectTimeout(5000);
	 httpurlconnection.connect();
	 
	 
	 if(httpurlconnection.getResponseCode()>=400)
	 {
		 System.out.println(linkUrl + "--->" + httpurlconnection.getResponseMessage() + "is a broken link" );
	 }
	 else
	 {
		 System.out.println(linkUrl + "--->" + httpurlconnection.getResponseMessage()  );
	 }
		
	}
	
	catch(Exception e){
		
	}
}
}
