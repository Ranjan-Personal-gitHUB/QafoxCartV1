package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTestClass;

public class TC05_JSE_AccountRegistrationTest extends BaseTestClass {
	
	@Test(groups = "Regression")
	public void verifyAccountRegistration() 
	{
		try {
		logger.info("****** Starting TC01_AccountRegistrationTest ******");
		HomePage homePageObj = new HomePage(driver);
		homePageObj.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		homePageObj.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage accRegPageObj = new AccountRegistrationPage(driver);
		accRegPageObj.setTxtFirstName(randomPasswordGenerater());
		accRegPageObj.setTxtLastName(randomPasswordGenerater());
		accRegPageObj.setTxtEmail(randomPasswordGenerater()+"@yahoo.com");
		accRegPageObj.setTxtTelephone(randomPhoneNbrGenerater());
		
		String password = randomPasswordGenerater();
		System.out.println("Random password is -"  + password);
		
		accRegPageObj.setTxtPassword(password);
		accRegPageObj.setTxtConfirmPwd(password);
		accRegPageObj.setCheckPolicy();
		accRegPageObj.setBtnContinue();
		logger.info("Validating Final Message");
	    
		String confMsg = accRegPageObj.getMsgConfirmation();
	    
	    if ( confMsg.equals("Your Account Has Been Created!")) 
	    {
	    	Assert.assertTrue(true);
	    }else {
			logger.error("Test Failed for Some Reason");
	    	Assert.assertTrue(false);
	    }

		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****** Finished TC01_AccountRegistrationTest ******");
		
	}

	
}
