package com.justdial.Grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.justdial.util.*;

import mainpackage.*;


//this is the main class containing all tests and  can be run using Grid.xml 
public class GridJustdialTest {
	String nodeURL;
	DesiredCapabilities cap = null;
	public static RemoteWebDriver driver = null;
	static Logger log = LogManager.getLogger(GridJustdialTest.class.getName());
	
	static ExtentReports extent = ExtentReport.getReport();

	
	
	@Parameters({"browser","baseURL"})
	@BeforeClass
	//Invoke Grid Browsers
	
	public void setup(String browser,String baseURL) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			//Set Desired Capabilities
			cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			//Set Desired Capabilities
			cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");		
		}
		
		//Setting WebDriver
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://192.168.43.183:4444/wd/hub"),cap);
	
		//Launch website
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);	
	}
	
	@Test(priority = 1)
	public void CheckTitel() throws Exception {

		ExtentTest test = extent.createTest("Homepage Title");
		log.info("Homepage title ");
		log.warn("Program may fail if homepage title does not contain 'Justdial'");
		GetTitle ob = new GetTitle();
		String homeTitle = ob.PageTitle(driver);
		boolean a = false;
		if (homeTitle.contains("Justdial")) {
			a = true;
			test.log(Status.PASS, "Homepage title contains - 'Justdial'");
			log.info("Homepage title matched");
		} else {
			test.log(Status.FAIL, "Homepage title DOES NOT contain - 'Justdial'");
			ScreenShot ss = new ScreenShot();
			ss.captureSS(driver);
			test.fail("Check screenshot for failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ss.screenshotPath).build());
			log.error("Wrong webpage! Please set correct baseUrl in configuartion.properties");
		}
		Assert.assertTrue(a);

	}

	@Test(priority = 2)
	public void LocationSetTest() throws Exception {

		ExtentTest test = extent.createTest("Set Location");
		LocationSet n = new LocationSet();
		n.Location(driver,"Kolkata ");

		test.log(Status.PASS, "Location Set to 'Kolkata'");

		log.info("Location Set");

	}

	@Test(priority = 3)
	public void SearchTest() throws Exception {

		log.info("Search Test");

		ExtentTest test = extent.createTest("Search Test");
		Search n = new Search();
		n.Load(driver);
		GetTitle ob = new GetTitle();
		String homeTitle = ob.PageTitle(driver);
		boolean a = false;
		if (homeTitle.contains("Car Washing Services")) {
			a = true;
			test.log(Status.PASS, "Title contains - 'Car Washing Services'");
			log.info("Title matched");
		} else {
			test.log(Status.FAIL, "Title DOES NOT contain - 'Car Washing Services' Wrong Webpage");
			ScreenShot ss = new ScreenShot();
			ss.captureSS(driver);
			test.fail("Check screenshot for failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ss.screenshotPath).build());
			log.error("Wrong webpage! Please set correct baseUrl in configuartion.properties");
		}
		Assert.assertTrue(a);

	}

	@Test(priority = 4)
	public void RattingTest() throws Exception {
		log.info("Rating Test");

		ExtentTest test = extent.createTest("Rating Click");
		Rating n = new Rating();
		boolean check = n.setRating(driver);
		boolean a = false;

		ScreenShot ss = new ScreenShot();
		if (check) {
			a = true;
			test.log(Status.PASS, "Rating button clicked in 'Car Washing Services' Webpage");
			ss.captureSS(driver);
			test.pass("Check screenshot for Sucess ",
					MediaEntityBuilder.createScreenCaptureFromPath(ss.screenshotPath).build());
			log.info("Rating button clicked");

		} else {
			test.log(Status.FAIL, "Rating button NOT clicked in 'Car Washing Services' Webpage");
			ss.captureSS(driver);
			test.fail("Check screenshot for failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ss.screenshotPath).build());
			log.error("Rating button NOT clicked");
		}
		Assert.assertTrue(a);

	}

	@Test(priority = 5)
	public void SelectDataTest() throws Exception {

		ExtentTest test = extent.createTest("Select Data");
		SelectData n = new SelectData();
		boolean a = false;
		if (n.Counter(driver)) {
			a = true;
			log.info("5 Data Selected ");
			test.log(Status.PASS, "5 Data Selected");
		} else {
			test.log(Status.FAIL, " Data NOT Selected");
			ScreenShot ss = new ScreenShot();
			ss.captureSS(driver);
			test.fail("Check screenshot for failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ss.screenshotPath).build());
			log.error(" Data not Selected ");

		}
		Assert.assertTrue(a);

	}

	@BeforeMethod
	public void beforeMethod() {
		// log.info("before Method");
	}

	@AfterMethod
	public void extentWrite() {

		extent.flush();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		log.info("Closing the Driver");
	}
}
