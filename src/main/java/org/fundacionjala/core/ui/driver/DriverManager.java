package org.fundacionjala.core.ui.driver;

import org.apache.log4j.Logger;
import org.fundacionjala.core.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Webdriver singleton pattern.
 */
public final class DriverManager {
    private static final Logger LOGGER =
            Logger.getLogger(DriverManager.class.getName());
    private static DriverManager ourInstance = new DriverManager();
    private static final int TIME_OUT_IN_SECONDS = 30;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Getter of singleton instance.
     *
     * @return DriverManager object .
     */
    public static DriverManager getInstance() {
        // Implement.
        try {
            ourInstance.getDriver().get(Environment
                    .getInstance().getValue("url.tomcat"));
        } catch (Exception e) {
            ourInstance.getDriver().get(Environment
                    .getInstance().getValue("url.gretty"));
            LOGGER.warn("Tomcat didn't have the hello app deployed. Using "
                    .concat("gretty url."));
        }
        return ourInstance;
    }

    /**
     * Constructor of class.
     */
    private DriverManager() {
        String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
        driver = DriverFactory.getDriverManager(DriverType.valueOf(browser));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    public static void switchToGrettyUrl() {
        ourInstance.getDriver().get(Environment
                .getInstance().getValue("url.gretty"));
        LOGGER.info("Switched to gretty url.");
    }

    /**
     * Gets of WebDriver.
     *
     * @return WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets of WebDriverWait.
     *
     * @return WebDriverWait object
     */
    public WebDriverWait getWait() {
        return wait;
    }

}
