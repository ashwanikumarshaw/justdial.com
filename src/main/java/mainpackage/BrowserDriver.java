package mainpackage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver {
	public static WebDriver driver;
  
  public  WebDriver LaunchBrowser() {
	
	Scanner s = new Scanner(System.in);
	
	System.out.println("Enter Browser to Launch :\n1.Chrome\n2.FireFox\nEnter Your Choice : ");
	int choice = s.nextInt();
			
	switch(choice)
	{
	   case 1 :  //Launch Chrome Browser
		   		
		   System.setProperty("webdriver.chrome.driver", "/Justdial.com/Webdrivers/chromedriver.exe");
		   
		   		driver = new ChromeDriver();
	   			 break;
	   			 
	   case 2 :  //Launch FireFox Browser
		   		System.setProperty("webdriver.gecko.driver","/Justdial.com/Webdrivers/geckodriver.exe");
		   		driver = new FirefoxDriver();
	   			 break;
	 
	   default : //Error for incorrect selection
		   System.out.println("The given browser:" + choice +"is invalid");
			System.exit(0);
			break;
	}
	s.close();
	//Maximize window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//Navigate to url
	//driver.get("https://www.justdial.com/Kolkata");
	return driver;
	
}
 
}

