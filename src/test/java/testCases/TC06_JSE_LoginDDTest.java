package testCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseTestClass;
import utilities.DataProviders;

public class TC06_JSE_LoginDDTest extends BaseTestClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "Datadriven")
	public void verifyLoginDDT(String email, String password, String result) 
	{
		try {
		logger.info("****** Starting TC04_JSE_LoginTest ******");
		logger.info("email->"+email+", password->"+password+", result->"+result);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement lnkMyaccount =driver.findElement(By.xpath("//span[normalize-space()='My Account']")); 
		js.executeScript("arguments[0].click();", lnkMyaccount);
		logger.info("Clicked on MyAccount Link");
		
		WebElement lnkLogin =driver.findElement(By.linkText("Login"));
		js.executeScript("arguments[0].click();",lnkLogin);
		logger.info("Clicked on Login Link");
	    
		WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@id='input-email']")) ;
		js.executeScript("arguments[0].value='"+email+"';",txtEmailAddress);
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='input-password']")) ;
		js.executeScript("arguments[0].value='"+password+"';",txtPassword);
		WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']")) ;
		js.executeScript("arguments[0].click();",btnLogin);
		
		boolean isValidLogin = true;
		
		try{
		
		List<WebElement> elems = driver.findElements(By.xpath("//h2[text()='My Account']"));
			
		if (elems.size() == 0) {
		        logger.info("My element was not found on the page");
		        if(result.equalsIgnoreCase("Valid")) 
		        {
		        	Assert.assertTrue(false);
		        }else
		        {
		        	logger.info("Even though wrong maild/password but result passed as InValid, hence PASS it");
		        	Assert.assertTrue(true);
		        	return;
		        }
		} else {
			    if(elems.get(0).isDisplayed()) {
			    	isValidLogin= true;
			    }
		        logger.info("My element was found on the page");
		      
		}
		}catch(NoSuchElementException ex) {
			logger.info("NoSuchElement Handled");
		}
				
		//js.executeScript("arguments[0].value='My Account';",isValidLogin);
		
		logger.info("isValidLogin is "+isValidLogin);

		WebElement btnLogout = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']"));
		
		if( result.equalsIgnoreCase("Valid"))
		{	
			if(isValidLogin)
			{			
				logger.info("Logging off as Valid user logged in..");
				js.executeScript("arguments[0].click();",btnLogout);
				Assert.assertTrue(true);				
			}
		}
		
		if( result.equalsIgnoreCase("Invalid"))
		{
			if(isValidLogin)
			{
				logger.error("With Invalid result passed it should not login ..Fail the case");
				js.executeScript("arguments[0].click();",btnLogout);
				Assert.assertTrue(false);
			}
		}
		
		//Thread.sleep(500);
		
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("****** Finished TC06_JSE_LoginDDTest ******");
		
	}

}
