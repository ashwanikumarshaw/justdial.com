package com.justdial.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//This class can give implicitly Wait of 30 sec
public class Wait30 {
	
	public void sec(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		

}
