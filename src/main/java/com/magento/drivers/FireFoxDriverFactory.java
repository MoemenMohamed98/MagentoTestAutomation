package com.magento.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverFactory extends DriverAbstract {

    @Override
    public WebDriver startDriver() {

        // Set the Firefox options
        FirefoxOptions options=new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-application-cache");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);



        // Initialize the FirefoxDriver
         driver = new FirefoxDriver(options);
         return driver;
    }


}
