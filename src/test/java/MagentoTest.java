import com.magento.drivers.DriverManager;
import com.magento.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MagentoTest {
private DriverManager driver;

    @BeforeClass
    public void setUp() {

        new DriverManager();
    }


    @Test
    public void testUserRegistration() {
        // Create an instance of the RegisterPage class
        new RegisterPage(driver)
                .navigateToRegisterPage()
                .enterFirstName()
                .enterLastName()
                .enterEmail()
                .enterPassword()
                .enterConfirmPassword()
                .clickRegisterButton()
                .checkThatSignupPageIsLoadedSuccessfully()
                .isRegistrationSuccessful();
    }




    @AfterClass
    public void tearDown() {
        // Close the WebDriver and clean up resources here
        // driver.quit();
    }





}
