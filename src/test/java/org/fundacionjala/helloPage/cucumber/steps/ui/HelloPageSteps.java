package org.fundacionjala.helloPage.cucumber.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.fundacionjala.calculator.pages.HelloPage;
import org.fundacionjala.calculator.pages.ResponsePage;
import org.fundacionjala.core.ui.driver.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;

import static org.testng.AssertJUnit.assertEquals;

public class HelloPageSteps {
    private static final Logger LOGGER =
            Logger.getLogger(HelloPageSteps.class.getName());


    @Autowired
    private HelloPage helloPage;

    @Autowired
    private ResponsePage responsePage;

    {
        BasicConfigurator.configure();
    }

    /**
     * This method ensure that the project is running.
     */
    @Given("has helloPage running")
    public void hasHelloPageRunning() {

        if (!helloPage.isInputNamePresent()) {
            DriverManager.switchToGrettyUrl();
        }
    }

    /**
     * This step set the name to say hello.
     *
     * @param name string.
     */
    @When("sets {string} in the input field")
    public void setsNameInTheInputField(String name) {
        LOGGER.debug(name.concat(" : name"));
        helloPage.setName(name);
    }

    /** This step clicks on sey hello button. */
    @And("clicks say hello button")
    public void clicksSayHelloButton() {
        helloPage.clickSayHelloButton();
    }

    /**
     * This step verifies response.
     *
     * @param expectedResponse string.
     */
    @Then("verifies that response is {string}")
    public void responseWillBe(String expectedResponse) {
        LOGGER.info(responsePage.getTextHello().concat(" : actual response"));
        LOGGER.debug(expectedResponse.concat(" : expectedResponse"));
        LOGGER.debug(expectedResponse.equals(responsePage.getTextHello()));
        assertEquals(responsePage.getTextHello(), expectedResponse);
    }
}
