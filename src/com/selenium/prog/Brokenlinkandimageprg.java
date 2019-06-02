package com.selenium.prog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinkandimageprg {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		//get all the links and image in website
		
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("href")));
		
		System.out.println("Size of all Link and images "+linklist);
		
		//get the active links by using Arraylist in run time
		
		List<WebElement> activelinks=new ArrayList<WebElement>();
		
		for(int i=0;i<linklist.size();i++)
		{
			if(linklist.get(i).getAttribute("href")!=null && (! linklist.get(i).getAttribute("href").contains("javascript")))
			{
				activelinks.add(linklist.get(i));
			}
				
		}
		System.out.println("The Active Linkes are"+activelinks.size());
		
		//200 -> Ok
		//404 -> FIle not found
		//500 -> Internal Error
		//400 -> Bad Req
		
		for(int j=0;j<activelinks.size();j++)
		{
			HttpURLConnection conn=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			conn.connect();
			String res=conn.getResponseMessage();
			conn.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+" ------>"+res);
			
		}
		
		

	}

}
