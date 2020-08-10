package mainpackage;

import org.openqa.selenium.WebDriver;

import com.justdial.PageObject.PageObject;


public class Search {
	public void Load(WebDriver driver) {

		PageObject.srchbx.sendKeys("Car Washing Services");
		PageObject.searchbutton.click();
		driver.navigate().to("https://www.justdial.com/Kolkata/Car-Washing-Services/");
		//driver.navigate().forward(); 
	
	}
}
