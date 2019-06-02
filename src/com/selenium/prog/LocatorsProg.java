package com.selenium.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F");
		driver.findElement(By.xpath("	//*[@id=\"userid\"]")).sendKeys("ram@gmail.com");
		
		
	}

}
