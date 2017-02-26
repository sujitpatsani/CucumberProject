package utill;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ThreeWayStepDef {
	@Given("^the cow weighs (\\d+) kg$")
	public void the_cow_weighs_kg(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^we calculate the feeding requirements$")
	public void we_calculate_the_feeding_requirements() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^the energy should be (\\d+) MJ$")
	public void the_energy_should_be_MJ(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
