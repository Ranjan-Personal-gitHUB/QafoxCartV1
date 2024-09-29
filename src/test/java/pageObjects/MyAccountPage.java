package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyAccountPage extends BasePage {

	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Web elements and their Actions List

	public boolean isAccountValid() 
	{
		boolean accountDisplayed = false;
		
		try {
			String accCreationMsg = driver
					.findElement(By.xpath("//h2[text()='My Account']")).getText();
			String isValidLogin = (String) js.executeScript("return arguments[0];", accCreationMsg);
			System.out.println("isValidLogin"+isValidLogin);
			if(isValidLogin!= null) {
				accountDisplayed = true;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			accountDisplayed = false;
		}
		return accountDisplayed;
	}
	
	// Used for Data Driven test , as logout is needed to go back to Login screen again
	public void clickLogout()
	{
		WebElement btnLogout = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']"));
		js.executeScript("arguments[0].click();",btnLogout);
	}
}
