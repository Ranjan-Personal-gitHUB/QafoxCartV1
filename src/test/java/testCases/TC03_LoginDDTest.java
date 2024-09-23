 	package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;
import utilities.DataProviders;

public class TC03_LoginDDTest extends BaseTestClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "Datadriven")
	public void verifyLoginDDT(String email, String password, String result) 
	{
		try {
			logger.info("****** Starting TC03_LoginDDTest ******");
			logger.info("email->"+email+", password->"+password+", result->"+result);
			HomePage homePageObj = new HomePage(driver);
			homePageObj.clickMyAccount();
			homePageObj.clickLogin();

			LoginPage login = new LoginPage(driver);
			login.setEmail(email);
			login.setPassword(password);
			login.clickLogin();

			MyAccountPage myAccPage = new MyAccountPage(driver);
			boolean isValidLogin = myAccPage.isAccountValid();
			logger.info("isValidLogin is "+isValidLogin);

			if( result.equalsIgnoreCase("Valid"))
			{
				if(isValidLogin)
				{			
					logger.info("Logging off as Valid user logged in");
					myAccPage.clickLogout();
					Assert.assertTrue(true);				
				}
				else
				{
					logger.error("Login Failed");
					Assert.assertTrue(false);
				}
			}
			
			if( result.equalsIgnoreCase("Invalid"))
			{
				if(isValidLogin)
				{
					logger.error("With Invalid Login it should not login ..Fail the case");
					myAccPage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("Invalid User not allowed to Login..PASS the case");
					Assert.assertTrue(true);
				}
			}
			

		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****** Finished TC03_LoginDDTest ******");
		
	}

	
}
