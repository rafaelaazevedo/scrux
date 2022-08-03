package com.test.java.scrux.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.java.scrux.pages.HomePage;

public class HomeSteps {

    @Autowired
    private HomePage homePage;

    @Given("I am on Google page")
    public void i_am_on_google_page() {
        homePage.openURL("https://www.google.com");
    }

    @When("I search for {word}")
    public void i_search_for(String searchTerm) {
        homePage.searchFor(searchTerm);
        homePage.clickSearchButton();
    }

    @Then("I should load the results page")
    public void i_should_load_the_results_page() {
        homePage.waitForPageToLoad();
    }

}
