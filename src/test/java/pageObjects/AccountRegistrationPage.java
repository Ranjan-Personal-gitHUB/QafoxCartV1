package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void setTxtFirstName(String txtFirstName) {
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(txtFirstName);         
	}

	public void setTxtLastName(String txtLastName) {
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(txtLastName);
	}


	public void setTxtEmail(String txtEmail) {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(txtEmail);
	}


	public void setTxtTelephone(String txtTelephone) {
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(txtTelephone);
	}


	public void setTxtPassword(String txtPassword) {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(txtPassword);
	}


	public void setTxtConfirmPwd(String txtConfirmPwd) {
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(txtConfirmPwd);
	}

	public void setCheckPolicy() {
		driver.findElement(By.xpath("//input[@name='agree']")).click();         
	}
	
	public void setBtnContinue() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();         
	}


	public String getMsgConfirmation() {
		return driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
	}
	

}
