package com.justdial.util;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
//This class helps to tack ScreenShot after any success or failure result and can be added into extent report
public class ScreenShot {
	WebDriver driver;
	public String screenshotPath;
	public void captureSS(WebDriver driver) throws Exception{
		TakesScreenshot ss=(TakesScreenshot)driver;
		File capture=ss.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date());
		screenshotPath="Screenshots/img"+timeStamp+".jpg";
		FileUtils.copyFile(capture, new File(screenshotPath));
		screenshotPath="../"+screenshotPath;
		
	}
}