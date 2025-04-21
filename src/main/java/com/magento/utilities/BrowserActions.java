package com.magento.utilities;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    //Maximize the browser window
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    //Close the browser
    public void closeBrowser() {
        driver.close();
    }
    //Quit the browser
    public void quitBrowser() {
        driver.quit();
    }

    //Navigate to a URL
    public void navigateToURL(String url) {
        driver.get(url);
    }

    //Get the current URL
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


}
