package com.selenium.prog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElementProg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.jio.com/JioWebApp/index.html?root=login");
		WebElement gobtn=driver.findElement(By.xpath("//input[contains(@class,'loginButtonCon')]"));
		flash(gobtn, driver);

	}
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String bgcolor=element.getCssValue("bkgcolor");
		for(int i=0;i<100;i++)
		{
			changecolor("rgb(0,2000,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}
	}
	
	public static void changecolor(String color,WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.bkgcolor = '"+color+"'",element);
		try
		{
			Thread.sleep(30);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	

}
