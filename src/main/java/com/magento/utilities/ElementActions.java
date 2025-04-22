package com.magento.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {
    private WebDriver driver;
    private Waits waits;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    //Scroll to the element
    public void scrollToElement(By locator) {
        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
    }

    //send keys
    public void fillField(By locator, String text) {

        // Wait for the element to be present before sending keys
        waits.waitForElementToBeVisible(locator);
        // Scroll to the element before sending keys
        scrollToElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    //click
    public void click(By locator) {
        // Wait for the element to be clickable before clicking
        waits.waitForElementToBeClickable(locator);
        // Scroll to the element before clicking
        scrollToElement(locator);
        driver.findElement(locator).click();
    }

    //getText
    public String getText(By locator) {
        // Wait for the element to be visible before getting text
        waits.waitForElementToBeVisible(locator);
        // Scroll to the element before getting text
        scrollToElement(locator);
        return driver.findElement(locator).getText();
    }
    //isDisplayed
    public boolean isDisplayed(By locator) {
        // Wait for the element to be visible before checking if displayed
        waits.waitForElementToBeVisible(locator);
        // Scroll to the element before checking if displayed
        scrollToElement(locator);
        return driver.findElement(locator).isDisplayed();
    }

    //Hover
    public ElementActions hoverOnItem(By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
        return this;
    }


}
