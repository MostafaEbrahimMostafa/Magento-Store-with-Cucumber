package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.DetailsPageObject;
import ui.pageobjects.MobilePageObject;

public class TC003_ValidateMaxQuantityRestrictionForCartItemsTest  {
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    private SoftAssert softAssert;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    MobilePageObject mobilePageObject;
    DetailsPageObject detailsPageObject;


    @Given("the user go to {string} page")
    public void the_user_navigates_to_MobilePage(String m) {
        test = extent.createTest("Validate Cart Quantity Limit", "Verifies that users cannot add more products to the cart than available.");
        test.info("Initializing WebDriver and opening the website.");
        if (driver == null) {
            driver = TC002_VerifyProductPriceConsistencyBetweenListAndDetailsPageTest.getDriver();
            detailsPageObject = new DetailsPageObject(driver);
        }
    }


    @When("the user clicks {string} for the {string} mobile")
    public void the_user_clicks_add_to_cart(String button, String productName) throws InterruptedException {
        detailsPageObject.click_on_add_to_cart_button();
        Thread.sleep(2000);
        test.info("Added " + "Sony Xperia" + " to the cart.");
    }

    @When("the user updates the quantity to {string} and clicks {string}")
    public void the_user_updates_the_quantity(String quantity, String button) throws InterruptedException {
        detailsPageObject.enter_quantity("1000");
        detailsPageObject.click_on_update_button();
        Thread.sleep(2000);
        test.info("Updated product quantity to " + quantity);
    }

    @Then("the user should see an error message: {string}")
    public void the_user_should_see_error_message(String expectedError) {
        // Validate Error Message
        String actualError = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
        Assert.assertEquals(actualError, expectedError);

        if (actualError.equals(expectedError)) {
            test.pass("✅ Error message displayed correctly: " + actualError);
        } else {
            test.fail("❌ Expected error message: " + expectedError + ", but found: " + actualError);
        }
    }

    @Then("the user should see  anther error message: {string}")
    public void the_user_should_see_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'Some of the products cannot be ordered in requeste')]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        if (actualMessage.equals(expectedMessage)) {
            test.pass("✅ Additional error message displayed correctly: " + actualMessage);
        } else {
            test.fail("❌ Expected: " + expectedMessage + ", but found: " + actualMessage);
        }
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on_empty_cart(String button) throws InterruptedException {
        detailsPageObject.click_on_emptyCart_button();
        Thread.sleep(2000);
        test.info("Clicked on the Empty Cart button.");
    }

    @Then("the user should see a confirmation message: {string}")
    public void the_user_should_see_cart_empty_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        if (actualMessage.equals(expectedMessage)) {
            test.pass("✅ Cart empty confirmation message displayed correctly: " + actualMessage);
        } else {
            test.fail("❌ Expected: " + expectedMessage + ", but found: " + actualMessage);
        }

    }
}
