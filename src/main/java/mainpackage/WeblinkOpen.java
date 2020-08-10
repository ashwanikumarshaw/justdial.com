package mainpackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

//url retrieval from .properties file
public class WeblinkOpen {

	static String baseUrl;

	public static void configreader(WebDriver driver) {
		Properties p = new Properties();
		try {
			InputStream inpt = new FileInputStream(
					"src/main/java/mainpackage/configuartion.properties");
			p.load(inpt);
			baseUrl = p.getProperty("URL");
			driver.get(baseUrl);
		} catch (Exception e) {
			e.printStackTrace();
		} // driver.get(baseUrl);
		
	}
}






//package mainpackage;
//
//import org.openqa.selenium.WebDriver;
//
//
//public class WeblinkOpen {
//	public void Weblink(WebDriver driver) {
//
//		driver.get("https://www.justdial.com/");
//		
//	}
//
//}
