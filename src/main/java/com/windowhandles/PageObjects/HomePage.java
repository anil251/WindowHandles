package com.windowhandles.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver rdriver;
	
	public HomePage(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	
	

}
