package com.magento.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;

   public Waits(WebDriver driver) {
        this.driver = driver;
    }

    // Implement the wait strategies for the elements to be present - visible - clickable \\


    // wait for the element to be present
    public WebElement waitForElementToBePresent(By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(locator));
    }

    // wait for the element to be visible
    public  WebElement waitForElementToBeVisible( By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                        {
                            WebElement element = waitForElementToBePresent(locator);
                            return element.isDisplayed() ? element : null;
                        }
                        );
    }

    // wait for the element to be clickable
    public WebElement waitForElementToBeClickable(By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                        {
                            WebElement element = waitForElementToBeVisible(locator);
                            return element.isEnabled() ? element : null;
                        }
                        );
    }


}
