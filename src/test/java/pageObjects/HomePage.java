package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Web elements List
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	

	@FindBy(linkText = "Login")
	WebElement lnkLogin;
	

	// Corresponding Action methods for Web elments
	public void clickMyAccount() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lnkMyaccount.click();
	}

	public void clickRegister() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lnkLogin.click();
	}
}
