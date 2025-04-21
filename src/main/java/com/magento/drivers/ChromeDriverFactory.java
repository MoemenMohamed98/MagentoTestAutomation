package com.magento.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-application-cache");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);



        // Initialize the ChromeDriver
        driver = new ChromeDriver(options);
        return driver;
    }


}
