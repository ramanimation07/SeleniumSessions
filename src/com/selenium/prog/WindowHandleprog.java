package com.selenium.prog;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleprog {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		
		String parent=driver.getWindowHandle();
		System.out.println("Parent Window ID: "+parent);
		driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		Set<String> st=driver.getWindowHandles();
		int count=st.size();
		System.out.println("Total Count id"+ count);
		for(String child:st)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.findElement(By.name("q")).sendKeys("Automation Testing Banglore");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		String str=driver.getTitle();
		System.out.println(str);
		
	
		
		
		

	}

}
