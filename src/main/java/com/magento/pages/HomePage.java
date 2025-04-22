package com.magento.pages;

import com.magento.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {
    private final DriverManager driver;

    // Locators for the home page
    private final By homePageLogo = By.xpath("//a[@class='logo']");
    private final By hotSellersHeading = By.xpath("//h2[@class='title' and text()='Hot Sellers']");
    private final By productItems = By.xpath("//div[contains(@class, 'block-products-list')]");
    private final By firstProductItem = By.xpath("//div[@class='products-grid grid']//li[1]");
    private final By secondProductItem = By.xpath("//a[@title='Breathe-Easy Tank']");
    private final By addToCompareList = By.xpath("//a[@class='action tocompare']");
    private final By comparisonList = By.linkText("comparison list");
    private final By successMessage = By.xpath("//div[@class='message-success success message']");
    private final By productsQTY = By.xpath("//span[@class = 'counter qty']");
    private final By firstAddedProduct = By.xpath("(//td[@class='cell product info'])[1]");
    private final By secondAddedProduct = By.xpath("(//td[@class='cell product info'])[2]");


    // Constructor to initialize the WebDriver
    public HomePage(DriverManager driver) {
        this.driver = driver;
    }
                /*********************************Actions*****************************************************/
    // Navigate to the home page
    public HomePage navigateToHomePage() {
        driver.elementActions().click(homePageLogo);
        return this;
    }

    //Navigate to Hot sellers in Home page
    public HomePage navigateToHotSellers() {
        driver.waits().waitForElementToBeVisible(productItems);
        driver.elementActions().scrollToElement(productItems);
        return this;
    }

    // Click on the first product item
    public HomePage clickOnFirstProductItem() {
        driver.elementActions().click(firstProductItem);
        return this;
    }

    // Click on the second product item
    public HomePage clickOnSecondProductItem() {
        driver.elementActions().click(secondProductItem);
        return this;
    }

    // Click on the comparison list
    public HomePage clickOnComparisonList() {
        driver.elementActions().click(comparisonList);
        return this;
    }

    // Add an item to the compare list
    public HomePage addItemToCompareList() {
        driver.elementActions().click(addToCompareList);
        return this;
    }

    // Get the success message after registration
    public String getSuccessMessage() {
        return driver.elementActions().getText(successMessage);
    }

    // Get the Products QTY
    public String getProductsQTY() {
        return driver.elementActions().getText(productsQTY);
    }








                        /*********************Validations**********************/

    // Check if the home page is loaded successfully
    public HomePage checkThatHomePageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browserActions().getCurrentURL(), "https://magento.softwaretestingboard.com/");
        return this;
    }
    // Method to check if the item is added to the compare list
    public HomePage isTheFirstItemAddedToCompareList() {
        Assert.assertEquals(getSuccessMessage(), "You added product Radiant Tee to the comparison list.");
        return this;
    }

    // Method to check if the item is added to the compare list
    public HomePage isTheSecondItemAddedToCompareList() {
        Assert.assertEquals(getSuccessMessage(), "You added product Breathe-Easy Tank to the comparison list.");
        return this;
    }

    // Method to check if the hot sellers section is displayed
    public HomePage isHotSellersSectionDisplayed() {
        Assert.assertTrue(driver.elementActions().getText(hotSellersHeading).contains("Hot Sellers"));
        return this;
    }
    // Method to check if the hot sellers section is displayed
    public HomePage isProductItemsDisplayed() {
        Assert.assertTrue(driver.elementActions().isDisplayed(productItems), "Product items are not displayed");
        return this;
    }
    // Method to check if the products QTY is Correct
    public HomePage isProductsQTYCorrect() {
        Assert.assertEquals(getProductsQTY(), "2 items");
        return this;
    }

    // Method to check if the first product is added to the compare list successfully
    public HomePage isFirstProductAddedToCompareList() {
        Assert.assertTrue(driver.elementActions().isDisplayed(firstAddedProduct), "First Products is displayed Successfully");
        Assert.assertTrue(driver.elementActions().getText(firstAddedProduct).contains("Radiant Tee"));
        return this;
    }

    // Method to check if the second product is added to the compare list successfully
    public HomePage isSecondProductAddedToCompareList() {
        Assert.assertTrue(driver.elementActions().isDisplayed(secondAddedProduct), "Second Products is displayed Successfully");
        Assert.assertTrue(driver.elementActions().getText(secondAddedProduct).contains("Breathe-Easy Tank"));
        return this;
    }








}
