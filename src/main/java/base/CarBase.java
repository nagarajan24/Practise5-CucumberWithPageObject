package base;

public class CarBase {
	
	
	public String getCarTitle()
	{
		return BasePage.getElementText("carTitle_CSS");
	}

}
