package com.magento.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.magento.utilities.PropertiesManager.WebConfig;

public class ChromeDriverFactory extends DriverAbstract {



    @Override
    public WebDriver startDriver() {

        //set the chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (WebConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }



        // Initialize the ChromeDriver
        driver = new ChromeDriver(options);
        return driver;
    }


}
