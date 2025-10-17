package com.bmv.stepdefinitions;

import com.bmv.pages.SerenityEquity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jxl.common.Assert;
import net.serenitybdd.annotations.Steps;

import java.util.Map;

public class ValidateOnIssuers {
    @Steps
    SerenityEquity equity;

    @Given("the user is on the Equity home page")
    public void validateEquityHomePage(){
        equity.goEquity();
    }

    @When("he clicks sort by {string}")
    public void clicksBy(String letter){
        equity.clickSortedBy(letter);
    }

    @Then("on column issuer all issuers should start with {string}")
    public void shouldStartWith(String letter){
        Map<String, String> table = equity.retrieveValues();
        Assert.verify(equity.validateTableSortedBy(table, letter));
    }

}
