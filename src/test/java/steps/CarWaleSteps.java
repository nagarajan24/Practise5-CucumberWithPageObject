package steps;

import org.testng.Assert;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindNewCarsPage;
import pages.HomePage;
import pages.ToyotaCarPage;
import util.SeleniumDriver;

public class CarWaleSteps {
	HomePage home = new HomePage();
	FindNewCarsPage fncp;
	ToyotaCarPage tcp;

	@Given("When user navigates to carwale website")
	public void when_user_navigates_to_carwale_website() {

		SeleniumDriver.getUrl();

	}

	@When("user mousehovers on new cars option")
	public void user_mousehovers_on_new_cars_option() {

		home.mouseHoverOnNewCars();
	}

	@Then("user clicks on find new cars")
	public void user_clicks_on_find_new_cars() {
		fncp = home.clickFindNewCars();

	}

	@And("user clicks on {string}")
	public void user_clicks_on_toyota_car_logo(String carBrand) {
		if (carBrand.equalsIgnoreCase("Toyota")) {
			tcp = fncp.goToToyota();
		} else if (carBrand.equalsIgnoreCase("Kia")) {
			fncp.goToKia();
		} else if (carBrand.equalsIgnoreCase("Hyundai")) {
			fncp.goToHyundai();
		} else if (carBrand.equalsIgnoreCase("BMW")) {
			fncp.goToBmw();
		}
	}

	@And("user verifies the title as {string}")
	public void user_verifies_the_title_as_toyota_cars(String carTitle) {
		System.out.println(carTitle);
		System.out.println(BasePage.carBase.getCarTitle());
		Assert.assertTrue(BasePage.carBase.getCarTitle().equalsIgnoreCase(carTitle));

	}

}
