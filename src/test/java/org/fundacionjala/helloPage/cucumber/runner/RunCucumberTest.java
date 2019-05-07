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

/** Class which runs all features. */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
