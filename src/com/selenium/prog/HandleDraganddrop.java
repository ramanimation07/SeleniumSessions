package com.selenium.prog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleDraganddrop {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Actions act=new Actions(driver);
		act.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
		.moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]")))
		.release().build().perform();

	}

}
