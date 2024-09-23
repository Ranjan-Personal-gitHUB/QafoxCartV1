package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Parent class of all test cases
// moved all common code like setup(), tearDown() , utility methods etc from individual test classes
// to here
public class BaseTestClass {
	
	public static WebDriver driver;
	public Logger logger; 
	public Properties prop;
	
	@BeforeClass(groups = {"Sanity","Regression","Datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException
	{
		
		// Loading config.properties	
		
		FileReader fileReader = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fileReader);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		// Below setup for Grid Setup in Remote- this will not change for Standalone or Multiple machines
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("Linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching OS found");
				return;
			}
			
			//Browser
			switch(browser.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge":   cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox":   cap.setBrowserName("firefox"); break;
			default:System.out.println("No matching Browser"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{	
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				logger.info("Invalid Browser: ");
				return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity","Regression","Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomPasswordGenerater() {
		String randomAlpha = RandomStringUtils.randomAlphabetic(5);
		System.out.println("Random alphabet is -"  + randomAlpha);
		return randomAlpha;
	}
	
	public String randomPhoneNbrGenerater() {
		String randomNbr = RandomStringUtils.randomNumeric(10);
		System.out.println("Random Phone Nbr is -"  + randomNbr);
		return randomNbr;
	}

	public String captureScreen(String tname) throws IOException 
	{
		SimpleDateFormat df =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentDttm = df.format(dt);
		
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePtah = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+currentDttm;
		File targetFile = new File(targetFilePtah);
		
		sourceFile.renameTo(targetFile);
	
		return targetFilePtah;
	}

}
