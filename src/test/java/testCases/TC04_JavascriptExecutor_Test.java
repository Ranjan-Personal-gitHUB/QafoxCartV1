package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import testBase.BaseTestClass;

import org.openqa.selenium.JavascriptExecutor;

public class TC04_JavascriptExecutor_Test extends BaseTestClass{
	@Test

	public void login() {
		System.setProperty("webdriver.chrome.driver", "path");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/users/sign_in");
		js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
		js.executeScript("document.getElementById('user_password').value='password';");
		js.executeScript("document.getElementById('user_submit').click();");
		js.executeScript("alert('enter correct login credentials to continue');");
		sleep(200);
	}

	public static void sleep(int ms) {
		try

		{
			Thread.sleep(ms);
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}

	}
}