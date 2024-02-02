package pages;

import base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage mouseHoverOnNewCars()
	{
		click("lang_XPATH");
		moveHover("newCars_XPATH");
		return this;
	}
	
	public FindNewCarsPage clickFindNewCars()
	{
		click("findNewCars_XPATH");
		return new FindNewCarsPage();
	}
	

}
