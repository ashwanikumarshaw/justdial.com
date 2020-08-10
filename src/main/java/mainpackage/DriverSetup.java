package mainpackage;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

//Setting up the necessary drivers for respective browsers 
public class DriverSetup {
	static WebDriver driver;
	static String baseUrl;
	public static WebDriver configreader()
	{	String chromeDriverpath;
		String firefoxDriverpath;
		
		
		Properties p=new Properties();
		try {
			InputStream inpt=new FileInputStream("F:\\java-2020-06\\Justdial.com\\src\\main\\java\\mainpackage\\configuartion.properties");
			p.load(inpt);
			baseUrl=p.getProperty("URL");
			if((p.getProperty("browser")).equalsIgnoreCase("chrome")) {
				chromeDriverpath=p.getProperty("chromeDriver");
				System.setProperty("webdriver.chrome.driver", chromeDriverpath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				//driver.get(baseUrl);
				return driver;
			}
			else if((p.getProperty("browser")).equalsIgnoreCase("firefox"))
			{
				firefoxDriverpath=p.getProperty("firefoxDriver");
				System.setProperty("webdriver.gecko.driver", firefoxDriverpath);
				WebDriver driver=new FirefoxDriver();
				driver.manage().window().maximize();
				//driver.get(baseUrl);
				return driver;
			}
			else
			{
				System.out.println("Un-supported broswer found");
				System.exit(0);
				return null;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	
	}
}
