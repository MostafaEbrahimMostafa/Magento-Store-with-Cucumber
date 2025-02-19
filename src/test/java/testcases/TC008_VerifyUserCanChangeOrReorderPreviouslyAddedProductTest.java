package testcases;

import io.cucumber.java.en.Given;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testRunner.TestRunner;
import ui.pageobjects.*;
import utils.DataReader;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
public class TC008_VerifyUserCanChangeOrReorderPreviouslyAddedProductTest {

    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriver driver;
    private String email, password;
    HomePageObject homePageObject;
    OrderPageObject orderPageObject;
    PurchasePageObject purchasePageObject;
    CheckoutPageObject checkoutPageObject;
    LoginPageObject loginPageObject;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    // Fields to store user details for the purchase process
    public String fn , mn , ln , tp , fx , cit , count , stat , zi , ad1 , ad2 , co ;
    List<HashMap<String, String>> datamap4;
    List<HashMap<String, String>> datamap5;

        @Given("the user is logged into {string}")
        public void the_user_is_logged_into_magento_store(String s) throws InterruptedException {
            test = extent.createTest("Verify That You Are Able To Change Or Reorder A Previously Added Product", "User reorders a previously added product and verifies order details");
            test.info("Initializing WebDriver and navigating to Magento Store.");
            if(driver == null)
            {
                driver = TC007_VerifySavingPreviouslyPlacedOrderAsPDFTest.getDriver();
            }
            homePageObject = new HomePageObject(driver);
            homePageObject.click_on_account();
            homePageObject.click_on_my_account();
            try {
                datamap5= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "RegisterData");
                loginPageObject = new LoginPageObject(driver);
                email = datamap5.getFirst().get("User Email");
                password = datamap5.getFirst().get("Password");
                loginPageObject.Login(email, password);
                test.info("User logged in with email: " + email);
                Thread.sleep(1000);
                test.info("User logged in successfully with email: " + email);
                homePageObject.click_on_my_order();
                orderPageObject = new OrderPageObject(driver);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        @When("the user clicking on the {string} button")
        public void the_user_clicking_on_the_reorder_button(String button) {
            test.info("Clicking on 'Reorder' button.");
            orderPageObject.click_on_reorder();
        }

        @And("the user changes the quantity to {string} and updates the cart")
        public void the_user_changes_the_quantity_and_updates_the_cart(String qty) throws InterruptedException {
            test.info("Changing product quantity to: " + qty);
            orderPageObject.enter_quantity("10");
            orderPageObject.click_on_update();
            Thread.sleep(1000);
            test.info("Cart updated successfully.");
        }

        @Then("the grand total should be updated to {string}")
        public void the_grand_total_should_be_updated_to(String expectedTotal) throws IOException {
            test.info("Verifying that the grand total is updated.");
            String str1= driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$6,150.00']")).getText();
            Assert.assertEquals(str1,"$6,150.00");
            test.info("Expected Total: " + expectedTotal + " | Actual Total: " + str1);
            purchasePageObject = new PurchasePageObject(driver);
        }

        @When("the user clicking on {string}")
        public void the_user_proceeds_to_checkout(String ch) {
            test.info("Proceeding to checkout.");
            purchasePageObject.click_on_checkout_button();
            checkoutPageObject = new CheckoutPageObject(driver);
        }

        @And("the user enters new {string} and {string} information")
        public void the_user_enters_new_billing_and_shipping_information(String b , String sh) throws InterruptedException {
            test.info("Entering new billing and shipping information.");
            driver.findElement(By.xpath("//span[contains(text(),'Enter a New Address')]")).click();
            Thread.sleep(1000);
            try {
                datamap4= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "BillingInformation");
                fn = datamap4.getFirst().get("First Name");
                mn = datamap4.getFirst().get("Middle Name");
                ln = datamap4.getFirst().get("Last Name");
                co = datamap4.getFirst().get("Company");
                String str1 = datamap4.getFirst().get("Telephone Number");
                double number1 = Double.parseDouble(str1);
                long result1 = Math.round(number1);
                tp = String.valueOf(result1);
                tp = "0" + tp ;
                fx = datamap4.getFirst().get("Fax");
                double number3 = Double.parseDouble(fx);
                long result3 = Math.round(number3);
                fx = String.valueOf(result3);
                ad1 = datamap4.getFirst().get("Address1");
                ad2 = datamap4.getFirst().get("Address2");
                cit = datamap4.getFirst().get("State");
                stat = datamap4.getFirst().get("State");
                String str = datamap4.getFirst().get("Zip Code");
                double number = Double.parseDouble(str);
                long result = Math.round(number);
                zi = String.valueOf(result);
                count = datamap4.getFirst().get("Country");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            checkoutPageObject.enterShippingAddress(fn, mn, ln, co, tp,
                    fx, ad1, ad2, cit, stat
                    , zi,count);

            test.info("Billing and shipping information saved successfully.");
            checkoutPageObject.click_on_save_address_button();
            Thread.sleep(1000);

            checkoutPageObject.click_on_continue_to_shipping();
            Thread.sleep(1000);
            test.info("Verifying shipping address.");
            String act = driver.findElement(By.xpath("//div[@class='box-content']/address")).getText();
            String str = "Mostafa Ebrahim Mostafa\n" +
                    "ASU\n" +
                    "abc7895\n" +
                    "def7895\n" +
                    "New York, New York, 542896\n" +
                    "United States\n" +
                    "T: 01005747258\n" +
                    "F: 7895";

            Assert.assertEquals(act,str);
            Thread.sleep(1000);

            checkoutPageObject.click_on_continue_to_billing();
            Thread.sleep(1000);
            checkoutPageObject.click_on_check_money_order();
            checkoutPageObject.click_on_continue_to_review();
            Thread.sleep(1000);
        }

        @And("the user place this {string}")
        public void the_user_places_the_order(String pl) throws InterruptedException {
            test.info("Placing the order.");
            checkoutPageObject.click_on_place_order();
            Thread.sleep(1000);
        }

        @Then("the order confirmation message should be {string}")
        public void the_order_confirmation_message_should_be(String expectedMessage) {
            test.info("Verifying order confirmation message.");
            String s = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
            Assert.assertEquals(s,"ORDER SUCCESS");
            test.info("Expected Message: " + expectedMessage + " | Actual Message: " + s);
            test.pass("✅ Order placed successfully.");
        }

        @And("the order number should be generated")
        public void the_order_number_should_be_generated() {
            test.info("Checking if the order number is generated.");
            String s2 = driver.findElement(By.xpath("//p[@data-role='order-numbers']")).getText();
            Assert.assertTrue(s2.contains("Your order number is"));
            test.pass("✅ Order number displayed.");

            driver.findElement(By.xpath("//span[contains(text(),'Continue Shopping')]")).click();
            checkoutPageObject.click_on_account();
            checkoutPageObject.click_on_logout();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        }
}







