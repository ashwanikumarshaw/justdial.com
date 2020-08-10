package mainpackage;

import org.openqa.selenium.WebDriver;

//gets the title of the Webpage
public class GetTitle {
	public  String PageTitle(WebDriver driver) {
	
		return (driver.getTitle());
		
	}

}
