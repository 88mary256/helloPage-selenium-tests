package org.fundacionjala.helloPage.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.fundacionjala.core.Environment;
import org.fundacionjala.helloPage.cucumber.steps.ui.HelloPageSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.fundacionjala.core.ui.driver.DriverManager;

import static org.testng.Assert.assertTrue;

/** Class which runs all features. */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    private static final Logger LOGGER =
            Logger.getLogger(RunCucumberTest.class.getName());

    /** This method execute before the tests. */
    @BeforeTest
    public void open() {
        DriverManager.getInstance().getDriver().get(Environment
                .getInstance().getValue("url.tomcat"));
        assertTrue(true);
    }

    /** This method close the browser after the features finish. */
    @AfterTest
    public void close() {
        DriverManager.getInstance().getDriver().quit();
    }
}
