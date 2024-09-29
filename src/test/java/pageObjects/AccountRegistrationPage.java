package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage extends BasePage {

	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void setTxtFirstName() {
		js.executeScript("document.getElementById('input-firstname').setAttribute('value', '"
				+ randomFirstNameGenerator() + "')");         
	}

	public void setTxtLastName() {
		js.executeScript("document.getElementById('input-lastname').setAttribute('value', '"
				+ randomLastNameGenerator() + "')");
	}


	public void setTxtEmail() {
		js.executeScript("document.getElementById('input-email').setAttribute('value', '"
				+ randomEmailGenerator() + "')");
	}


	public void setTxtTelephone() {
		js.executeScript("document.getElementById('input-telephone').setAttribute('value', '"
				+ randomPhoneNbrGenerater() + "')");
	}


	public void setTxtPassword() {
		js.executeScript(
				"document.getElementById('input-password').setAttribute('value', '" + randomPasswordGenerator() + "')");
	}


	public void setTxtConfirmPwd() {
		js.executeScript(
				"document.getElementById('input-confirm').setAttribute('value', '" + randomPasswordGenerator() + "')");
	}

	public void setCheckPolicy() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='agree']")));        
	}
	
	public void setBtnContinue() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Continue']")));        
	}


	public String getMsgConfirmation() {
		String accCreationMsg = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		String successCreationMsg = (String) js.executeScript("return arguments[0];", accCreationMsg);
		System.out.println("Account creation message is - "+successCreationMsg);
		return successCreationMsg;
		}
	
	public String randomFirstNameGenerator() {
		int length = 7;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println("First name -> "+generatedString);
		return generatedString;
	}
	
	public String randomLastNameGenerator() {
		int length = 4;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println("Last name -> "+generatedString);
		return generatedString;
	}
	
	public String randomEmailGenerator() {
		int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers)+"@gmail.com";
        System.out.println("Email id -> "+generatedString);
		return generatedString;
	}

	public String randomPhoneNbrGenerater() {
		String randomNbr = RandomStringUtils.randomNumeric(10);
		System.out.println("Phone number -> "+randomNbr);
		return randomNbr;
	}
	
	public String randomPasswordGenerator() {
		System.out.println("Random password is - randompwd123");
		return "randompwd123";
	}
}
