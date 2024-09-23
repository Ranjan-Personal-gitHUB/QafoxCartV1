package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class TC02_LoginTest extends BaseTestClass {
	
	@Test(groups = "Sanity")
	public void verifyLogin() 
	{
		try {
			logger.info("****** Starting TC02_LoginTest ******");
			HomePage homePageObj = new HomePage(driver);
			homePageObj.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			homePageObj.clickLogin();
			logger.info("Clicked on Login Link");

			LoginPage login = new LoginPage(driver);
			login.setEmail(prop.getProperty("email"));
			login.setPassword(prop.getProperty("password"));
			logger.info("Clicked on Login page Login Link");
			login.clickLogin();

			MyAccountPage myAccPage = new MyAccountPage(driver);
			boolean isValidLogin = myAccPage.isAccountValid();
			logger.info("isValidLogin is "+isValidLogin);

			if (isValidLogin) {
				Assert.assertTrue(true);
			} else {
				logger.error("Login Failed");
				Assert.assertTrue(false);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("****** Finished TC02_LoginTest ******");
		
	}

	
}
