package com.selenium.prog;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Numberoflinksprog {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
		
		for(int i=0;i<linklist.size();i++)
		{
			String st=linklist.get(i).getText();
			System.out.println(st);
		}

	}

}
