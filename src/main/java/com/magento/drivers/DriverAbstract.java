package com.magento.drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverAbstract {
    protected WebDriver driver;

    // Constructor to initialize the WebDriver
    public abstract WebDriver startDriver();

}
