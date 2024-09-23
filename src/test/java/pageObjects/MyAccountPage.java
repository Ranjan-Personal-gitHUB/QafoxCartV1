package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.sjavac.Log;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Web elements List
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	// Add logout for testing Excel utility as multiple users need to login one after another logout
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	

	public boolean isAccountValid() 
	{
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}		
	}
	

	/*
	 * @FindBy(xpath = "//input[@value='Login']") WebElement btnLogout;
	 */
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
