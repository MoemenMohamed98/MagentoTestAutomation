import com.magento.drivers.DriverManager;
import com.magento.pages.HomePage;
import com.magento.pages.RegisterPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MagentoTest {
private DriverManager driver;

    @BeforeClass
    public void setUp() {
        driver = new DriverManager();
    }


    @Test (priority = 1)
    public void userRegistration() {
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


    @Test (priority = 2, dependsOnMethods = "userRegistration")
    public void addFirstProductsToCompareList() {
        new HomePage(driver)
                .navigateToHomePage()
                .checkThatHomePageIsLoadedSuccessfully()
                .navigateToHotSellers()
                .isHotSellersSectionDisplayed()
                .clickOnFirstProductItem()
                .addItemToCompareList()
                .isTheFirstItemAddedToCompareList();
    }

    @Test (priority = 3, dependsOnMethods = "addFirstProductsToCompareList")
    public void addSecondProductsToCompareList() {
        new HomePage(driver)
                .navigateToHomePage()
                .navigateToHotSellers()
                .isHotSellersSectionDisplayed()
                .isProductItemsDisplayed()
                .clickOnSecondProductItem()
                .addItemToCompareList()
                .isTheSecondItemAddedToCompareList()
                .clickOnComparisonList();
    }



    @Test (priority = 4, dependsOnMethods = "addSecondProductsToCompareList")
    public void compareProducts() {
        new HomePage(driver)
                .isProductsQTYCorrect()
                .isFirstProductAddedToCompareList()
                .isSecondProductAddedToCompareList();
    }





    @AfterClass
    public void tearDown() {
        driver.quit();
    }





}
