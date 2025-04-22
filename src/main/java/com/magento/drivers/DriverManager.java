package com.magento.drivers;

import com.magento.utilities.BrowserActions;
import com.magento.utilities.ElementActions;
import com.magento.utilities.Waits;
import org.openqa.selenium.WebDriver;

import static com.magento.utilities.PropertiesManager.WebConfig;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverManager() {
        // Set the system property for the WebDriver executable
        String browserType= WebConfig.getProperty("BrowserType").toLowerCase();
        WebDriver driver = getDriver(browserType).startDriver();
        assert driver != null : "Driver is null";
        setDriver(driver);
        driver.manage().window().maximize();
        if (!WebConfig.getProperty("BaseURL").isEmpty()){
            driver.navigate().to(WebConfig.getProperty("BaseURL"));
        }
    }




    private DriverAbstract getDriver(String browserName) {

        return switch (browserName) {
            case "chrome" -> new ChromeDriverFactory();
            case "firefox" -> new FireFoxDriverFactory();
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        };
    }

    public void setDriver(WebDriver driver) {
        DriverManager.driverThreadLocal.set(driver);
    }

    public WebDriver getDriverInstance() {
        return driverThreadLocal.get();
    }

    public void quit() {
        driverThreadLocal.get().quit();
    }

    public ElementActions elementActions() {
        return new ElementActions(getDriverInstance());
    }

    public BrowserActions browserActions() {
        return new BrowserActions(getDriverInstance());
    }

    public Waits waits() {
        return new Waits(getDriverInstance());
    }






}
