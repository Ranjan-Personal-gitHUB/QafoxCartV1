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
	/*
	 * @FindBy(xpath = "//span[normalize-space()='My Account']") WebElement
	 * lnkMyaccount;
	 * 
	 * @FindBy(xpath = "//a[normalize-space()='Register']") WebElement lnkRegister;
	 * 
	 * 
	 * @FindBy(linkText = "Login") WebElement lnkLogin;
	 */
	
	WebElement lnkMyaccount =driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
	
	WebElement lnkRegister =driver.findElement(By.xpath("//a[normalize-space()='Register']"));
	
	WebElement lnkLogin =driver.findElement(By.linkText("Login"));
	

	// Corresponding Action methods for Web elments
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	// Below added for JavaScriptExecutor Framework to run in Jenkins
	public WebElement getMyAccountWebElmnt() {
		logger.info("lnkMyaccount"+lnkMyaccount);
		return lnkMyaccount;
	}
	
	public WebElement getRegisterWebElmnt() {
		return lnkRegister;
	}
	
	public WebElement getLoginWebElmnt() {
		return lnkLogin;
	}
}
