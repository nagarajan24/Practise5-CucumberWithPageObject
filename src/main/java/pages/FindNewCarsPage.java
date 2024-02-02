package pages;

import base.BasePage;

public class FindNewCarsPage extends BasePage{
	
	public ToyotaCarPage goToToyota()
	{
		click("toyota_XPATH");
		return new ToyotaCarPage();
	}
	
	public void goToKia()
	{
		click("kia_XPATH");
	}
	
	public void goToHyundai()
	{
		click("hyundai_XPATH");
	}
	
	public void goToBmw()
	{
		click("bmw_XPATH");
	}

}
