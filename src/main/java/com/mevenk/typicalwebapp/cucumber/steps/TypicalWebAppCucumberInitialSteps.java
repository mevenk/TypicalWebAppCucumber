/**
 * 
 */
package com.mevenk.typicalwebapp.cucumber.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Venkatesh
 *
 */
@CucumberOptions(dryRun = false, strict = true, monochrome = true, snippets = SnippetType.CAMELCASE)
public class TypicalWebAppCucumberInitialSteps {

	@Given("Initiate TypicalWebApp Controller")
	public void givenStep() {
		System.out.println("Given " + getClass());
	}

	@When("Send TestRequestResponse Request with valis parameter")
	public void whenStep() {
		System.out.println("When " + getClass());
	}

	@Then("Verify valid response received for TestRequestResponse")
	public void thenStep() {
		System.out.println("Then " + getClass());
	}
}
