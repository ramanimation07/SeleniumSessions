package com.selenium.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddropprog {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/?gclid=CjwKCAjw8LTmBRBCEiwAbhh-6NPICI1cnybp06357aM1smO5OR7KEbKMQecgqET8hbpIERLfSfzfqRoCHbUQAvD_BwE");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"ctl00_HyperLinkLogin\"]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Travel Agent Login")).click();
	}

}
