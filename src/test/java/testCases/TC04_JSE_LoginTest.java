package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TC04_JSE_LoginTest extends BaseTestClass{ 
	
	@Test
	public void login() {
		try {
		logger.info("****** Starting TC04_JSE_LoginTest ******");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement lnkMyaccount =driver.findElement(By.xpath("//span[normalize-space()='My Account']")); 
		logger.info("MyAccountWebElmnt() is "+ lnkMyaccount);
		js.executeScript("arguments[0].click();", lnkMyaccount);
		logger.info("Clicked on MyAccount Link");
		
		WebElement lnkLogin =driver.findElement(By.linkText("Login"));
		js.executeScript("arguments[0].click();",lnkLogin);
		logger.info("Clicked on Login Link");
		
	    String emailID = prop.getProperty("email");
	    String password = prop.getProperty("password");
	    
		WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@id='input-email']")) ;
		js.executeScript("arguments[0].value='"+emailID+"';",txtEmailAddress);
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='input-password']")) ;
		js.executeScript("arguments[0].value='"+password+"';",txtPassword);
		WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']")) ;
		js.executeScript("arguments[0].click();",btnLogin);
		
		WebElement isValidLogin = driver.findElement(By.xpath("//h2[text()='My Account']")) ;
		js.executeScript("arguments[0].value='My Account';",isValidLogin);
		logger.info("isValidLogin is "+isValidLogin);

		if (isValidLogin.isDisplayed()) {
			logger.info("ValidLogin - "+isValidLogin.isDisplayed());
			Assert.assertTrue(true);
		} else {
			logger.error("Login Failed");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("****** Finished TC04_JSE_LoginTest ******");
		
	}

}