package com.windowhandles.TestScripts;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.windowhandles.BaseEngine.BaseClass;
import com.windowhandles.PageObjects.HomePage;

public class HomePageTest extends BaseClass {
	
	public String pahandles;
	@Test
	public  void homepage() throws InterruptedException {
		HomePage hp= new HomePage(driver);
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav1\"]/li[3]/a"))).build().perform();
		WebElement linElement= driver.findElement(By.xpath("//a[normalize-space()='Window Handles']"));
		linElement.click();
		pahandles=driver.getWindowHandle();
		
			
		
	}
	@Test(priority = 1)
	public void whandle() throws InterruptedException {
		driver.findElement(By.id("newTabBtn")).click();
		
		Set<String> handle =driver.getWindowHandles();
		for (String handles : handle) {
			System.out.println(handles);
			driver.manage().window().maximize();//https://github.com/anil251/WindowHandles.git
			if (!handles.equals(pahandles)) {
				driver.switchTo().window(handles);
				driver.findElement(By.id("promptBox")).click();
				Thread.sleep(5000);
				//String alertMessage= driver.switchTo().alert().getText();				
				//System.out.println(alertMessage);
				Alert alert =driver.switchTo().alert();
				alert.sendKeys("Anil Kumar");
				
				//System.out.println("The Text is :"+alert);
				driver.switchTo().alert().accept();
				WebElement text = driver.findElement(By.xpath("//*[@id=\"output\"]"));			
				//System.out.println("The enter Text Is :"+text);
				
				Thread.sleep(5000);
				driver.close();
				
			}
			
		}
		driver.switchTo().window(pahandles);
		driver.findElement(By.id("name")).sendKeys("Sunil kumar");		
		Thread.sleep(5000);
		driver.close();
		
	}
	

}
