package mainpackage;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import com.justdial.PageObject.PageObject;
import com.justdial.util.*;

//passing the nearest or current City for service search
public class LocationSet {
	public void Location(WebDriver driver,String City) {

//		driver.findElement(By.id("city")).clear();
//		driver.findElement(By.id("city")).sendKeys("Kolkata ");

		PageObject ob = new PageObject(driver);
		ob.city.clear();
		ob.city.click();
		ob.city.sendKeys(City);

		
		Wait30 a=new Wait30();
		a.sec(driver);
		
		ob.kolkata.click();

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath()).click();
	}

	
}
