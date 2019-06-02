package com.selenium.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstAutomationProg {

	public static void main(String[] args) {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe"); WebDriver
		 * driver=new FirefoxDriver(); driver.get("https://www.google.com/");
		 */
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}

}
