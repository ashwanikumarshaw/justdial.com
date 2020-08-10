package mainpackage;


import org.openqa.selenium.WebDriver;

import com.justdial.PageObject.PageObject;
import com.justdial.util.Wait30;


//click rating button and check top 5 names if they are not same as default
public class Rating{
	public Boolean setRating(WebDriver driver) {
		
		//driver.findElement(By.xpath("//a[@id='distdrop_rat']")).click();
		//PageObject ob = new PageObject(driver);

		String before1=PageObject.firstname.getText();
		String before2=PageObject.secoundname.getText();
		String before3=PageObject.thirdname.getText();
		String before4=PageObject.fourthname.getText();
		String before5=PageObject.fifthname.getText();
		
		PageObject.rattingbutton.click();	
		Wait30 a=new Wait30();
		a.sec(driver);

		GetTitle ob = new GetTitle();
		String homeTitle = ob.PageTitle(driver);
	
		if (homeTitle.contains("Error"))
		driver.navigate().to("https://www.justdial.com/Kolkata/Car-Washing-Services/");

		String after1=PageObject.firstname.getText();
		String after2=PageObject.secoundname.getText();
		String after3=PageObject.thirdname.getText();
		String after4=PageObject.fourthname.getText();
		String after5=PageObject.fifthname.getText();
		
//		driver.findElement(By.xpath("//*[@id='best_deal_div']/section]")).click();
		if(before1.equals(after1)&&
				before2.equals(after2)&&
				before3.equals(after3)&&
				before4.equals(after4)&&
				before5.equals(after5) ) {
			return false;
		}
		else {

			return true;
		}
		
		
		
	}
}
