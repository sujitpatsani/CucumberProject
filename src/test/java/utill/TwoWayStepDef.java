package utill;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TwoWayStepDef {
	@Given("^Jeff has bought a microwave for \\$(\\d+)$")
	public void Jeff_has_bought_a_microwave_for_$(int arg1) throws Throwable {
		System.out.println("Hello");
	    throw new PendingException();
	}

	@Given("^he has a receipt$")
	public void he_has_a_receipt() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^he returns the microwave$")
	public void he_returns_the_microwave() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Jeff should be refunded \\$(\\d+)$")
	public void Jeff_should_be_refunded_$(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}


}
