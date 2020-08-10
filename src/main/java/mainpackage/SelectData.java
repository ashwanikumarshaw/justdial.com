package mainpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justdial.PageObject.PageObject;
import com.justdial.util.Wait30;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import java.lang.Double;
import java.util.ArrayList;

//used for retrieving required information from Web site & putting it into an excel file
public class SelectData {
	ArrayList<String> crwsname = new ArrayList<String>();

	ArrayList<String> crwsAddr = new ArrayList<String>();

	public boolean Counter(WebDriver driver) throws FileNotFoundException, IOException {

		// No.of Columns
		File src = new File("JustdialData.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook();

		Sheet sheet1 = wb.createSheet("TestCase");

		Row row1 = sheet1.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Car services names:");
		Cell cell2 = row1.createCell(1);
		cell2.setCellValue("Address:");
		int c = 0;
		int col = driver.findElements(By.xpath("//div[@id='tab-5']/ul/li")).size();

		// System.out.println(" No of selected cols are : " +col);
		for (int i = 1; i <= col; i++) {
			String Ratexpa = "//ul/li[" + i + "]/section/div[1]/section/div[1]/p[1]/a/span[1]";
			String Revxpa = "//ul/li[" + i + "]/section/div[1]/section/div[1]/p[1]/a/span[3]";

			String Rat = driver.findElement(By.xpath(Ratexpa)).getText();
			double rate = Double.parseDouble(Rat);

			String Rev = driver.findElement(By.xpath(Revxpa)).getText();
			int review = Integer.parseInt(Rev.replaceAll("[^0-9]", ""));

			if (Double.compare(rate, 4.0) >= 0 && review >= 20 && c < 5) {

				String namxpath = "//ul/li[" + i + "]/section/div[1]/section/div[1]/h2/span/a/span";
				String Name = driver.findElement(By.xpath(namxpath)).getText();
				Wait30 a = new Wait30();
				a.sec(driver);
				crwsname.add(Name);
				// System.out.println(" Rate ="+rate +" review "+review +" Name "+ Name);
				driver.manage().deleteAllCookies(); // Delete all cookies
				driver.findElement(By.xpath(namxpath)).click();
				String add = PageObject.address.getText();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
				}
				crwsAddr.add(add);
//	    		driver.manage().deleteAllCookies();  // Delete all cookies
//	    		driver.navigate().back(); 

				Row row2 = sheet1.createRow(c + 1);
				Cell cell3 = row2.createCell(0);
				cell3.setCellValue(crwsname.get(c));

				Cell cell4 = row2.createCell(1);
				cell4.setCellValue(crwsAddr.get(c));

				driver.navigate().to("https://www.justdial.com/Kolkata/Car-Washing-Services/");
				PageObject.rattingbutton.click();
				
				GetTitle ob = new GetTitle();
				String homeTitle = ob.PageTitle(driver);
				
				if (homeTitle.contains("Error"))
				driver.navigate().to("https://www.justdial.com/Kolkata/Car-Washing-Services/");
				c++;
			}
			if (c == 5)
				break;
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		fos.close();
		wb.close();
		if (c == 5) {
			return true;
		} else {
			return false;
		}

	}

}

//package driver;
//
//import java.lang.Double;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class SelectData {
//	public void Counter(WebDriver driver)  {       
//	        //No.of Columns
//	        int  col = driver.findElements(By.xpath("//div[@id='tab-5']/ul/li")).size();
//	        System.out.println("No of cols are : " +col); 
//	        for(int i=1;i<=col;i++) {
//	        	String Ratexpa="//ul/li["+i+"]/section/div[1]/section/div[1]/p[1]/a/span[1]";
//	        	String Revxpa="//ul/li["+i+"]/section/div[1]/section/div[1]/p[1]/a/span[3]";
//	        	
//	        	String Rat= driver.findElement(By.xpath(Ratexpa)).getText();
//	        	double rate=Double.parseDouble(Rat);  
//	        	
//
//	        	String Rev = driver.findElement(By.xpath(Revxpa)).getText();
//	        	int review=Integer.parseInt(Rev.replaceAll("[^0-9]", ""));
//	        	if(Double.compare(rate, 4.0) >= 0 && review>=20) {
//      		String namxpath="//ul/li["+i+"]/section/div[1]/section/div[1]/h2/span/a/span";
//	        	String Name = driver.findElement(By.xpath(namxpath)).getText();
//
//      		System.out.println(" Rate ="+rate +" review "+review +"Name "+ Name);
//	        	}
//	        }
//
//	  	  
//	}
//
//}