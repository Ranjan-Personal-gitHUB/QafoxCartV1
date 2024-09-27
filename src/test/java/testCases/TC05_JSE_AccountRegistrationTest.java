package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTestClass;

public class TC05_JSE_AccountRegistrationTest extends BaseTestClass {

	@Test(groups = "Regression")
	public void verifyAccountRegistration() {
		try {
			logger.info("****** Starting TC05_JSE_AccountRegistrationTest ******");
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement lnkMyaccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
			logger.info("MyAccountWebElmnt() is " + lnkMyaccount);
			js.executeScript("arguments[0].click();", lnkMyaccount);
			logger.info("Clicked on MyAccount Link");

			WebElement lnkRegister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
			js.executeScript("arguments[0].click();", lnkRegister);
			logger.info("Clicked on Register Link");

			js.executeScript("document.getElementById('input-firstname').setAttribute('value', '"
					+ randomFirstNameGenerator() + "')");

			js.executeScript("document.getElementById('input-lastname').setAttribute('value', '"
					+ randomLastNameGenerator() + "')");

			js.executeScript("document.getElementById('input-email').setAttribute('value', '"
					+ randomEmailGenerator() + "')");

			js.executeScript("document.getElementById('input-telephone').setAttribute('value', '"
					+ randomPhoneNbrGenerater() + "')");

			String password = randomPasswordGenerator();

			js.executeScript("document.getElementById('input-password').setAttribute('value', '" + password + "')");

			js.executeScript("document.getElementById('input-confirm').setAttribute('value', '" + password + "')");

			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='agree']")));

			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Continue']")));

			String accCreationMsg = driver
					.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
			String successCreationMsg = (String) js.executeScript("return arguments[0];", accCreationMsg);

			// driver.findElementBy.cssSelector(" tr>td[id='your td Id']").getText();
			logger.info("Account creation message is -> " + successCreationMsg);

			Thread.sleep(2000);

			if (successCreationMsg.equals("Your Account Has Been Created!")) {
				logger.info("Pass the Case ");
				Assert.assertTrue(true);
			} else {
				logger.info("Fail the Case ");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

		logger.info("****** Finished TC05_JSE_AccountRegistrationTest ******");

	}

	public String randomFirstNameGenerator() {
		int length = 7;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        logger.info("First name -> "+generatedString);
		return generatedString;
	}
	
	public String randomLastNameGenerator() {
		int length = 4;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        logger.info("Last name -> "+generatedString);
		return generatedString;
	}
	
	public String randomEmailGenerator() {
		int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers)+"@gmail.com";
        logger.info("Email id -> "+generatedString);
		return generatedString;
	}

	public String randomPhoneNbrGenerater() {
		String randomNbr = RandomStringUtils.randomNumeric(10);
		logger.info("Phone number -> "+randomNbr);
		return randomNbr;
	}
	
	public String randomPasswordGenerator() {
		int length = 7;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        logger.info("Password is -> "+generatedString);
		return generatedString;
	}

}
