package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTestClass;

public class TC01_JSE_AccountRegistrationTest extends BaseTestClass {

	@Test(groups = "Regression")
	public void verifyAccountRegistration() {
		try {
			logger.info("****** Starting TC01_JSE_AccountRegistrationTest ******");
			HomePage homePageObj = new HomePage(driver);
			homePageObj.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			homePageObj.clickRegister();
			logger.info("Clicked on Register Link");
			
			AccountRegistrationPage accRegPageObj = new AccountRegistrationPage(driver);
			accRegPageObj.setTxtFirstName();
			accRegPageObj.setTxtLastName();
			accRegPageObj.setTxtEmail();
			accRegPageObj.setTxtTelephone();
			accRegPageObj.setTxtPassword();
			accRegPageObj.setTxtConfirmPwd();
			accRegPageObj.setCheckPolicy();
			accRegPageObj.setBtnContinue();
			
			logger.info("Validating Final Message");
		    
			String confMsg = accRegPageObj.getMsgConfirmation();
		    
		    if ( confMsg.equals("Your Account Has Been Created!")) 
		    {
		    	logger.info("Account created");
		    	Assert.assertTrue(true);
		    }else {
				logger.info("Test Failed for Some Reason");
		    	Assert.assertTrue(false);
		    }

		Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

		logger.info("****** Finished TC01_JSE_AccountRegistrationTest ******");

	}

}
