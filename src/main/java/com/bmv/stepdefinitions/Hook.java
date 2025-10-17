package com.bmv.stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.pages.PageObject;

public class Hook extends PageObject {
    @Before
    public void setUp() {

        getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
