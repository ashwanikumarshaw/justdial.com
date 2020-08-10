package com.justdial.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//This class contain all the xpath and id with FindBy function used in the project 
public class PageObject {
	
	WebDriver driver;
	

	@FindBy(id = "city")
	public WebElement city;
	

	@FindBy(xpath = "//*[@id='Kolkata']/b/b")
	public WebElement kolkata; 
	

	@FindBy(id = "srchbx")
	public static WebElement srchbx;
	

	@FindBy(xpath = "//span[@id='srIconwpr']")
	public static WebElement searchbutton;
	

	@FindBy(xpath = "//a[@id='distdrop_rat']/span")
	public static WebElement rattingbutton;
	

	@FindBy(xpath ="//*[@id='fulladdress']/span/span")
	public static WebElement address;

	@FindBy(xpath = "//div[@id='tab-5']/ul/li")
	public static WebElement num;
	

	@FindBy(xpath = "//*[@id='bcard0']/div[1]/section/div[1]/h2/span/a/span")
	public static WebElement firstname;
	@FindBy(xpath = "//*[@id='bcard1']/div[1]/section/div[1]/h2/span/a/span")
	public static WebElement secoundname;
	@FindBy(xpath = "//*[@id='bcard2']/div[1]/section/div[1]/h2/span/a/span")
	public static WebElement thirdname;
	@FindBy(xpath = "//*[@id='bcard3']/div[1]/section/div[1]/h2/span/a/span")
	public static WebElement fourthname;
	@FindBy(xpath = "//*[@id='bcard4']/div[1]/section/div[1]/h2/span/a/span")
	public static WebElement fifthname;


public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
