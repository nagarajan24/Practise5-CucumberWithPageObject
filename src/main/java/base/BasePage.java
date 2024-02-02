package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.SeleniumDriver;

public class BasePage {
	
	public static WebDriver driver;
	public static CarBase carBase;
	private WebElement mouseHoverElement;
	
	public BasePage()
	{
		driver = SeleniumDriver.getDriver();
		carBase = new CarBase();
	}
	

	//Keywords
	public void moveHover(String locator)
	{
		//System.out.println("Element:"+locator);
		if(locator.contains("_XPATH"))
		{
			mouseHoverElement = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		}
		else if(locator.contains("_ID"))
		{
			mouseHoverElement = driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
		}
		else if(locator.contains("_CSS"))
		{
			mouseHoverElement = driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
		}
		
		new Actions(driver).moveToElement(mouseHoverElement).perform();
	}

	
	public void click(String locator)
	{
		if(locator.contains("_XPATH"))
		{
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).click();
		}
		else if(locator.contains("_ID"))
		{
			driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).click();
		}
		else if(locator.contains("_CSS"))
		{
			driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).click();
		}
	}
	
	public void type(String locator, String value)
	{
		if(locator.contains("_XPATH"))
		{
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.contains("_ID"))
		{
			driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.contains("_CSS"))
		{
			driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}
	}
	
	
	public boolean isElementPresent(String locator)
	{
		try {
		if(locator.contains("_XPATH"))
		{
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		}
		else if(locator.contains("_ID"))
		{
			driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
		}
		else if(locator.contains("_CSS"))
		{
			driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
		}
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static String getElementText(String locator)
	{
		String text = "";
		if(locator.contains("_XPATH"))
		{
			text = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		}
		else if(locator.contains("_CSS"))
		{
			text = driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).getText();
		}
		else if(locator.contains("_ID"))
		{
			text = driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).getText();
		}
		
		return text;
	}
	
	
}
