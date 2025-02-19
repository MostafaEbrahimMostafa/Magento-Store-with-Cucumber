package testcases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.DetailsPageObject;
import ui.pageobjects.MobilePageObject;

public class TC002_VerifyProductPriceConsistencyBetweenListAndDetailsPageTest {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    MobilePageObject mobilePageObject;
    DetailsPageObject detailsPageObject;
    private SoftAssert softAssert;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    private String price;


    @Given("the user navigates {string} Page")
    public void the_user_navigates_MobilePage(String h) {
        test = extent.createTest("Validate Product Cost in List and Details Page", "Verifies that product price is consistent between list and details pages.");
        test.info("Initializing WebDriver and opening the website: ");
        if (driver ==null) {
            driver = TC001_ValidateItemSortingByNameInMobilePageObjectTest.getDriver();
            mobilePageObject = new MobilePageObject(driver);
        }
        softAssert = new SoftAssert();
    }

    @And("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String menu) {
        mobilePageObject.click_on_mobile_category();
        test.info("Clicked on the " + menu + " menu.");
    }

    @When("the user reads the cost of {string} mobile from the list page")
    public void the_user_reads_the_cost_of_mobile_from_the_list_page(String mobileName) {
        price = mobilePageObject.getProduct_price().getText();
        test.info("Captured product price for " + mobileName + " from list page: " + price);
    }

    @And("the user clicks on the {string} mobile")
    public void the_user_clicks_on_the_mobile(String mobileName) {
        mobilePageObject.click_on_mobile_product();
        test.info("Clicked on " + mobileName + " mobile.");
    }

    @Then("the user should see that the product price on the details page matches the price from the list page")
    public void the_user_should_see_that_the_product_price_matches() {
        detailsPageObject = new DetailsPageObject(driver);
        String actual_price =  detailsPageObject.getPrice().getText();
        Assert.assertEquals(actual_price,price);
        if (actual_price.equals(price)) {
            test.pass("✅ Product price on list and details pages are equal.");
        } else {
            test.fail("❌ Product price on list and details pages are not equal.");
        }
    }

}


