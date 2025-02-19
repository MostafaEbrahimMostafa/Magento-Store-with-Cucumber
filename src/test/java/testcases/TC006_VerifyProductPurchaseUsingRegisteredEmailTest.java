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
public class TC006_VerifyProductPurchaseUsingRegisteredEmailTest {

    // Fields to store user details for the purchase process
    public String fn , mn , ln , tp , fx , cit , count , stat , zi , ad1 , ad2 , co ;
    List<HashMap<String, String>> datamap4;
    public static WebDriver getDriver() {
        return driver;
    }
    private String email, password;
    double p , f;
    public static WebDriver driver;
    HomePageObject homePageObject;
    PurchasePageObject purchasePageObject;
    LoginPageObject loginPageObject;
    WishListPageObject wishListPageObject;
    CheckoutPageObject checkoutPageObject;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    List<HashMap<String, String>> datamap3;

    @Given("the user on the {string} page")
    public void user_is_on_home_page(String h) throws InterruptedException {
        test = extent.createTest("Checkout Process", "Verifies user can complete checkout process.");
        test.info("User is on the home page.");
        if(driver == null)
        {
            driver = TC005_VerifyAccountCreationAndWishlistSharingViaEmailTest.getDriver();
        }
        homePageObject = new HomePageObject(driver);
    }

    @When("the user clicks on the {string} Menu")
    public void click_on_account_menu(String m) {
        test.info("Clicking on the account menu.");
        homePageObject.click_on_account();
    }

    @And("the user selects {string}")
    public void select_my_account(String a) {
        test.info("Selecting 'My Account'.");
        homePageObject.click_on_my_account();
    }

    @And("the user {string} with valid credentials")
    public void user_logs_in(String l) throws InterruptedException {
        test.info("Logging in with valid credentials.");
        try {

            datamap3= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "RegisterData");
            loginPageObject = new LoginPageObject(driver);
            email = datamap3.getFirst().get("User Email");
            password = datamap3.getFirst().get("Password");
            loginPageObject.Login(email, password);
            test.info("User logged in with email: " + email);
            Thread.sleep(1000);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @And("the user navigates to the {string}")
    public void navigate_to_wishlist(String w) {
        test.info("Navigating to the wishlist.");
        homePageObject.click_on_account();
        homePageObject.click_on_wishlist();
        wishListPageObject = new WishListPageObject(driver);
    }

    @And("the user {string} to the cart and enters {string}")
    public void add_product_to_cart_and_enter_shipping_info(String add , String shipping_info) {
        test.info("Adding product to cart.");
        wishListPageObject.click_on_add_to_cart();
        test.info("Entering shipping information.");
        purchasePageObject = new PurchasePageObject(driver);
        purchasePageObject.select_country("United States");
        purchasePageObject.select_state("New York");
        purchasePageObject.enter_zibCode("542896");
    }

    @And("the user press on {string}")
    public void click_on_estimate(String button) throws InterruptedException {
        test.info("Clicking on estimate shipping cost.");
        purchasePageObject.click_on_estimate_button();
        Thread.sleep(2000);
    }

    @Then("the system generates a flat rate shipping cost of $5")
    public void verify_shipping_cost() throws InterruptedException {
        test.info("Verifying flat rate shipping cost.");
        String flat = purchasePageObject.getFlat_price().getText().replace("$", "").replace(",", "").trim();
        f = Double.parseDouble(flat);
    }

    @And("the user selects the {string} and {string}")
    public void select_shipping_cost(String cost , String total ) throws InterruptedException {
        test.info("Selecting shipping cost and updating total.");
        String price = driver.findElement(By.xpath("//td[@class='product-cart-total']//span[@class='price'][normalize-space()='$615.00']")).getText().replace("$", "").replace(",", "").trim();
        p = Double.parseDouble(price);
        driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']")).click();
        purchasePageObject.click_on_update_button();
        Thread.sleep(2000);
        test.pass("✅ Flat rate shipping cost verified.");
    }

    @Then("the {string} is added to the {string}")
    public void verify_total_cost(String sh_cost , String t_cost ) {
        test.info("Verifying total cost includes shipping.");
        String total = driver.findElement(By.xpath("//span[normalize-space()='$620.00']")).getText().replace("$", "").replace(",", "").trim();
        double t = Double.parseDouble(total);
        Assert.assertEquals(t,p+f);
        test.pass("✅ Total cost updated with shipping.");
    }

    @When("the user proceed to {string}")
    public void proceeds_to_checkout(String checkout) {
        test.info("Proceeding to checkout.");
        purchasePageObject.click_on_checkout_button();
    }

    @And("the user enters {string}")
    public void enter_billing_info(String billing_info) throws InterruptedException {
        test.info("Entering billing information.");
        checkoutPageObject = new CheckoutPageObject(driver);
        Thread.sleep(2000);
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
        checkoutPageObject.click_on_save_address_button();
        Thread.sleep(2000);
    }

    @And("the user continues with the {string}")
    public void continue_shipping_method(String sh_method) throws InterruptedException {
        test.info("Continuing with selected shipping method.");
        checkoutPageObject.click_on_continue_to_shipping();
        Thread.sleep(2000);
        checkoutPageObject.click_on_continue_to_billing();
        Thread.sleep(2000);
    }

    @And("the user selects {string} as the payment method")
    public void select_payment_method(String ch_order) throws InterruptedException {
        test.info("Selecting payment method: Check/Money Order.");
        checkoutPageObject.click_on_check_money_order();
        checkoutPageObject.click_on_continue_to_review();
        Thread.sleep(2000);
    }

    @And("the user {string}")
    public void place_order(String p) throws InterruptedException {
        test.info("Placing the order.");
        checkoutPageObject.click_on_place_order();
        Thread.sleep(2000);
    }

    @Then("the order should be generated successfully")
    public void verify_order_success() {
        test.info("Verifying order success message.");
        String s = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(s,"ORDER SUCCESS");
        test.pass("✅ Order placed successfully.");
    }

    @And("the order number should be displayed")
    public void verify_order_number() {
        test.info("Verifying order number is displayed.");
        String s2 = driver.findElement(By.xpath("//p[@data-role='order-numbers']")).getText();
        Assert.assertTrue(s2.contains("Your order number is"));
        test.pass("✅ Order number displayed.");
        driver.findElement(By.xpath("//span[contains(text(),'Continue Shopping')]")).click();
        checkoutPageObject.click_on_account();
        checkoutPageObject.click_on_logout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

}
