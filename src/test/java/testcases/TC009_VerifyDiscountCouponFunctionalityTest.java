package testcases;

import io.cucumber.java.en.Given;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.*;
import utils.DataReader;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
public class TC009_VerifyDiscountCouponFunctionalityTest {

    public static WebDriver getDriver() {
        return driver;
    }
    SoftAssert softAssert;
    public static WebDriver driver;
    private String email, password;
    HomePageObject homePageObject;
    OrderPageObject orderPageObject;
    PurchasePageObject purchasePageObject;

    LoginPageObject loginPageObject;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    List<HashMap<String, String>> datamap6;
    @Given("the user is at the {string} homepage")
    public void the_user_is_on_the_magento_store_homepage(String h) throws InterruptedException {
        test = extent.createTest("Verify That The Discount Coupon Works Correctly", "User applies a discount coupon and verifies the discount");
        test.info("Navigating to Magento Store homepage.");
        if(driver == null)
        {
            driver = TC008_VerifyUserCanChangeOrReorderPreviouslyAddedProductTest.getDriver();
        }
        homePageObject = new HomePageObject(driver);
        homePageObject.click_on_account();
        homePageObject.click_on_my_account();
        try {
            datamap6= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "RegisterData");
            loginPageObject = new LoginPageObject(driver);
            email = datamap6.getFirst().get("User Email");
            password = datamap6.getFirst().get("Password");
            loginPageObject.Login(email, password);
            test.info("User logged in with email: " + email);
            Thread.sleep(1000);
            test.info("User logged in successfully with email: " + email);
            purchasePageObject = new PurchasePageObject(driver);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @When("the user go to {string} category")
    public void the_user_navigates_to_the_category(String category) {
        test.info("Navigating to '" + category + "' category.");
        driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_product_to_the_cart(String product) {
        test.info("Adding '" + product + "' to the cart.");
        driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]")).click();
    }

    @When("the user applies the coupon code {string}")
    public void the_user_applies_the_coupon_code(String couponCode) throws InterruptedException {
        test.info("Applying coupon code: " + couponCode);
        // GURU50 make 5% discount
        purchasePageObject.enter_couponCode("GURU50");
        purchasePageObject.click_on_apply_btn();
        Thread.sleep(2000);
        purchasePageObject.select_country("United States");
        purchasePageObject.select_state("New York");
        purchasePageObject.enter_zibCode("542896");
        purchasePageObject.click_on_estimate_button();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']")).click();

        purchasePageObject.click_on_update_button();
        Thread.sleep(2000);
    }

    @Then("the total price should be discounted by {string} and updated to {string}")
    public void the_total_price_should_be_discounted(String x , String expectedTotal) throws IOException {
        softAssert = new SoftAssert();
        test.info("Verifying the total price after applying discount.");
        String total = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']")).getText();
        test.fail("❌ Discount functionality isn't working correctly. Expected: " + expectedTotal + ", but found: " + total);
        Assert.assertEquals(total, "$475.00", "Discount verification passed!");
    }

}
