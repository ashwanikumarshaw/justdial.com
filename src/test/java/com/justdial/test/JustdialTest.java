package com.justdial.test;

import org.testng.annotations.Test;

import com.justdial.util.*;

import mainpackage.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;

//this is the main testng class containing all tests 
public class JustdialTest {
	static Logger log = LogManager.getLogger(JustdialTest.class.getName());
	public static WebDriver driver;
	static ExtentReports extent = ExtentReport.getReport();

	@BeforeClass
	public void LaunchBrowserTest() {
		driver = DriverSetup.configreader();
		log.info("Browser Invoked");
	}

	@Test(priority = 0)
	public void WeblinkTest() throws IOException {


		WeblinkOpen.configreader(driver);
		log.info("Web-link open");

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