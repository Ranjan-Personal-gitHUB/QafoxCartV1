package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class TC02_JSE_LoginTest extends BaseTestClass {

	@Test
	public void login() {
		try {
			logger.info("****** Starting TC02_JSE_LoginTest ******");

			HomePage homePageObj = new HomePage(driver);
			homePageObj.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			homePageObj.clickLogin();
			logger.info("Clicked on Login Link");

			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(prop.getProperty("email"));
			loginPage.setPassword(prop.getProperty("password"));
			loginPage.clickLogin();

			MyAccountPage myAccPage = new MyAccountPage(driver);
			boolean isValidLogin = myAccPage.isAccountValid();

			logger.info("isValidAccount is " + isValidLogin);

			if (isValidLogin) {
				logger.info("Success Login as My Account Msg is displayed");
				Assert.assertTrue(true);
			} else {
				logger.info("Login Failed as My Account Msg is not Displayed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("****** Finished TC02_JSE_LoginTest ******");

	}

}