package com.magento.drivers;

import com.magento.utilities.BrowserActions;
import com.magento.utilities.ElementActions;
import org.openqa.selenium.WebDriver;

import static com.magento.utilities.PropertiesManager.WebConfig;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager() {
        // Set the system property for the WebDriver executable
        String browserType= WebConfig.getProperty("BrowserType").toLowerCase();
        WebDriver driver = getDriver(browserType).startDriver();
        assert driver != null : "Driver is null";
        setDriver(driver);
    }




    private DriverAbstract getDriver(String browserName) {

        return switch (browserName) {
            case "CHROME" -> new ChromeDriverFactory();
            case "FIREFOX" -> new FireFoxDriverFactory();
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        };
    }

    public void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public WebDriver getDriverInstance() {
        return driver.get();
    }

    public void quit() {
        driver.get().quit();
    }

    public ElementActions elementActions() {
        return new ElementActions(getDriverInstance());
    }

    public BrowserActions browserActions() {
        return new BrowserActions(getDriverInstance());
    }





}
