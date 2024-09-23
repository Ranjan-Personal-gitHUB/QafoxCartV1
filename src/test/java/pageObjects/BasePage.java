package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// parent of all pageobject classes, includes all common code required in all page object classes
// instead of creating constr in every class , move the code here and extend this class 
public class BasePage {
	
	public WebDriver driver;
	
	public Logger logger;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
