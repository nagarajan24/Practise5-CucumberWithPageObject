package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
	
	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	private static Properties config = new Properties();
	public static Properties OR = new Properties();
	private static WebDriverWait wait;
	private static FileInputStream fis;
	
	public SeleniumDriver()
	{
		try {
			fis = new FileInputStream(".//src//main//resources//properties//Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit_wait"))));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit_wait"))));
	}
	
	
	//return driver
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	//set up seleniumdriver obj
	public static void setupDriver()
	{
		if(seleniumDriver == null)
			seleniumDriver = new SeleniumDriver();
	}
	
	//tear down
	public static void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		seleniumDriver = null;
	}
	
	//get url
	public static void getUrl()
	{
		driver.get(config.getProperty("url"));
	}
}
