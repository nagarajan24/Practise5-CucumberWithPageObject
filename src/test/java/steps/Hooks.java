package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.SeleniumDriver;

public class Hooks {
	public WebDriver driver = SeleniumDriver.getDriver();
	
	@Before
	public void setUp()
	{
		SeleniumDriver.setupDriver();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(s, "image/png", scenario.getName());
			
		}
		if(driver != null) {
		SeleniumDriver.tearDown();
		}
	}

}
