package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Web elements List
	WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@id='input-email']"));

	WebElement txtPassword = driver.findElement(By.xpath("//input[@id='input-password']"));
	
	WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']"));

	// Corresponding Action methods for Web elments
	public void setEmail(String emailID) {
		js.executeScript("arguments[0].value='" + emailID + "';", txtEmailAddress);
	}

	public void setPassword(String password) {
		js.executeScript("arguments[0].value='" + password + "';", txtPassword);
	}
	
	public void clickLogin() {
		js.executeScript("arguments[0].click();", btnLogin);
	}
}
