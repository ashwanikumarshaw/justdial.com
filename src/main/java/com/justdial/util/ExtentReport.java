package com.justdial.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//This class helps to create Extent Report for Test class
public class ExtentReport {

	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		String name = "report "+date;
		
		String reportPath = "ExtentReports/"+name+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Digitech Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TestBot","Digitech");
		
		return extent;
	}
	
	
}