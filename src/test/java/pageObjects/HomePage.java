package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Web elements Listand the Action methods for Web elments
	
	public void clickMyAccount() {
		WebElement lnkMyaccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
		js.executeScript("arguments[0].click();", lnkMyaccount);
	}

	public void clickRegister() {
		WebElement lnkRegister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		js.executeScript("arguments[0].click();", lnkRegister);
	}

	public void clickLogin() {
		WebElement lnkLogin = driver.findElement(By.linkText("Login"));
		js.executeScript("arguments[0].click();", lnkLogin);
	}

}
