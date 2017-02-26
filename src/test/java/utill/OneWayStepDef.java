package utill;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OneWayStepDef extends AllPages {

	@Given("^user navigate to url\"([^\"]*)\"$")
	public void user_navigate_to_url(String arg1, DataTable arg2)
			throws Throwable {
		
		System.out.println("hello");

		gotoHomePage().enterUrl(arg1);

		Thread.sleep(10000);

		gotoHomePage().popup();
		gotoHomePage().fromTOCitySelection(arg2);

	}

	@Given("^user has choosen one way$")
	public void user_has_choosen_one_way() throws Throwable {
		gotoHomePage().selectOneWayTrip();

	}

	@Given("^city details$")
	public void city_details() throws Throwable {
		System.out.println("done");

	}

	@Given("^date is coosen by user$")
	public void date_is_coosen_by_user() throws Throwable {

		// gotoHomePage().setDepartTime(9,22,2017);

		gotoHomePage().setNumberOfTravellers();
		gotoHomePage().setclass();
	}

	@When("^user search flight$")
	public void user_search_flight() throws Throwable {
		gotoHomePage().searchFlight();

	}

	@Then("^flight list should be displayed$")
	public void flight_list_should_be_displayed() throws Throwable {

		// gotoHomePage().closeBrowser();

	}

}
