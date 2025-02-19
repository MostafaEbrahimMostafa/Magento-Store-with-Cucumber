package testcases;


import io.cucumber.java.en.Given;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.*;
import utils.DataReader;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class TC005_VerifyAccountCreationAndWishlistSharingViaEmailTest {

        public static WebDriver getDriver() {
            return driver;
        }

        public static WebDriver driver;

        RegisterPageObject registerPageObject;
        TvPageObject tvPageObject;
        WishListPageObject wishListPageObject;
        HomePageObject homePageObject;
        private ExtentReports extent = TestRunner.getExtentReports();
        private ExtentTest test;
        String Fn , Mn , Ln , Ue , Up , Ucp ;
        List<HashMap<String, String>> datamap;

        @Given("the user open the url {string}")
        public void the_user_open_the_url(String url) {
            test = extent.createTest("Account Creation and Wishlist Sharing", "Verifies user can register and share a wishlist.");
            test.info("Opening the website: " + url);

            if (driver == null) {
                driver = TC004_VerifyProductComparisonFunctionalityInMobilePageObjectTest.getDriver();
            }
            homePageObject = new HomePageObject(driver);
            homePageObject.click_on_account();
            driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            test.pass("✅ Website opened successfully.");

        }

        @When("the user clicks on the {string} link")
        public void the_user_clicks_on_the_link(String linkText) {
            test.info("Clicking on the link: " + linkText);
            homePageObject.click_on_account();
            homePageObject.click_on_my_account();
            registerPageObject = new RegisterPageObject(driver);
        }

        @And("the user clicks on the {string} link and fills in new user information except for the email ID")
        public void the_user_fills_in_new_user_information(String linkText) {
            test.info("Navigating to the registration page.");
            registerPageObject.click_on_createAccount();
            try {
                datamap = DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "RegisterData");
                Fn = datamap.getFirst().get("First Name");
                Mn = datamap.getFirst().get("Middle Name");
                Ln = datamap.getFirst().get("Last Name");
                Ue = datamap.getFirst().get("User Email");
                Up = datamap.getFirst().get("Password");
                Ucp = datamap.getFirst().get("Confirm Password");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            registerPageObject.EnterNewUserInformation(Fn,Mn,Ln,Ue,Up,Ucp);
            test.info("Filled in user registration details.");
        }

        @And("the user clicks on the {string} button")
        public void the_user_clicks_on_the_button(String buttonText) throws InterruptedException {
            test.info("Clicking on button: " + buttonText);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // انتظار حتى 10 ثوانٍ
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Register']")));
            registerButton.click();
            // Wait for the page to load with explicit wait
            Thread.sleep(2000);
        }

        @Then("the registration should be successful with a confirmation message")
        public void the_registration_should_be_successful() throws IOException {
            test.info("Verifying successful registration message.");
            String actual = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']")).getText();
            Assert.assertEquals(actual, "Thank you for registering with Main Website Store.");
            test.pass("✅ Registration successful.");
        }

        @When("the user navigates to the {string} menu")
        public void the_user_navigates_to_the_tv_menu(String tv) {
            test.info("Navigating to the TV menu.");
            registerPageObject.click_on_tv_category();
            tvPageObject = new TvPageObject(driver);
        }

        @And("the user adds a product to the wishlist")
        public void the_user_adds_a_product_to_the_wishlist() {
            test.info("Adding product to wishlist.");
            tvPageObject.click_on_add_to_wishlist();
            wishListPageObject = new WishListPageObject(driver);
        }

        @Then("the product should be successfully added to the wishlist")
        public void the_product_should_be_successfully_added_to_the_wishlist() {
            test.info("Verifying wishlist addition.");
            String act = driver.findElement(By.xpath("//span[contains(text(),'LG LCD has been added to your wishlist. Click')]")).getText();
            Assert.assertEquals(act, "LG LCD has been added to your wishlist. Click here to continue shopping.");
            test.pass("✅ Product successfully added to wishlist.");
        }

        @When("the user click on the {string} button")
        public void the_user_click_on_the_button(String buttonText) throws InterruptedException {
            test.info("Clicking button: " + buttonText);
            wishListPageObject.click_on_share();
            // Wait for the page to load with explicit wait
            Thread.sleep(2000);
        }

        @And("the user enters the recipient's email {string} and a message and click on the {string} button")
        public void the_user_enters_email_and_message(String email , String button) throws InterruptedException {
            test.info("Entering recipient's email: " + email);
            wishListPageObject.enterEmail("mostafakady@gmail.com");
            wishListPageObject.enterMessage("this product is very good with few price , so I recommend it for you");
            wishListPageObject.click_on_shareButton();
            // Wait for the page to load with explicit wait
            Thread.sleep(2000);
        }

        @Then("the wishlist should be shared successfully")
        public void the_wishlist_should_be_shared_successfully() throws IOException {
            test.info("Verifying wishlist sharing confirmation.");
            String str = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']")).getText();
            Assert.assertEquals(str, "Your Wishlist has been shared.");
            test.pass("✅ Wishlist shared successfully.");
            wishListPageObject.click_on_account();
            wishListPageObject.click_on_logout();
            driver.findElement(By.xpath("//img[@class='large']")).click();
        }

}




