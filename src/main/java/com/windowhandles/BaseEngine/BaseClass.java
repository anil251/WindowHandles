package com.windowhandles.BaseEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@Parameters({"browser"})
	@BeforeSuite
	public  void openbrowser(@org.testng.annotations.Optional("chrome") String browser) {
		String currentdir=System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		if (browser.equals("chrome")) {
			driver= new ChromeDriver();
			
		}
		else if (browser.equals("Firefox")) {			
			driver= new FirefoxDriver();			
		}
		else if (browser.equals("ie")) {
			driver= new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/");
		
		
	}
	
}
