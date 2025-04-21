package com.magento.pages;

import com.magento.drivers.DriverManager;
import com.magento.utilities.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage {

    private final DriverManager driver;

    // Locators for the registration page
    private final By createAccountText = By.xpath("//h1[@class='page-title']");
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("password-confirmation");
    private final By registerButton = By.xpath("//button[@title='Create an Account' and @type='submit']");
    private final By successMessage = By.xpath("//div[@class='message-success success message']");


    // Constructor to initialize the WebDriver
    public RegisterPage(DriverManager driver) {
        this.driver = driver;
    }

                /*********************************Actions*****************************************************/

         //Navigate to the home page
    public void navigateToHomePage(String url) {
        driver.browserActions().navigateToURL(url);
    }

        //Navigate to the registration page
    public RegisterPage navigateToRegisterPage() {
        // Click on the "Create an Account" link
        driver.elementActions().click(createAccountText);
        return this;
    }


        // Fill in the first name
    public RegisterPage enterFirstName() {
        driver.elementActions().fillField(firstNameField, TestData.FAKE_FIRST_NAME);
        return this;
    }

    // Fill in the last name
    public RegisterPage enterLastName() {
        driver.elementActions().fillField(lastNameField, TestData.FAKE_LAST_NAME);
        return this;
    }

    // Fill in the email address
    public RegisterPage enterEmail() {
        driver.elementActions().fillField(emailField, TestData.FAKE_EMAIL);
        return this;
    }

    // Fill in the password
    public RegisterPage enterPassword() {
        driver.elementActions().fillField(passwordField, TestData.FAKE_PASSWORD);
        return this;
    }

    // Fill in the Confirm password
    public RegisterPage enterConfirmPassword() {
        driver.elementActions().fillField(confirmPasswordField, TestData.FAKE_CONFIRM_PASSWORD);
        return this;
    }
    // Click the register button
    public RegisterPage clickRegisterButton() {
        driver.elementActions().click(registerButton);
        return this;
    }

    // Get the success message after registration
    public String getSuccessMessage() {
        return driver.elementActions().getText(successMessage);
    }



//    // Method to register a new user
//    public void registerNewUser() {
//        enterFirstName();
//        enterLastName();
//        enterEmail();
//        enterPassword();
//        enterConfirmPassword();
//        clickRegisterButton();
//    }

                            /*********************Validations**********************/

    //check That SignupPage Is Loaded Successfully
    public RegisterPage checkThatSignupPageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browserActions().getCurrentURL(), "https://magento.softwaretestingboard.com/customer/account/create/");
        return this;
     }

    // Method to check if the registration was successful
    public RegisterPage isRegistrationSuccessful() {
        // Verify the success message
        Assert.assertEquals(getSuccessMessage(), "Thank you for registering with Main Website Store.");
        return this;
    }










}
