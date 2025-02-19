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
import java.util.Set;

public class TC007_VerifySavingPreviouslyPlacedOrderAsPDFTest {


    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriver driver;
    private String email, password;
    HomePageObject homePageObject;
    OrderPageObject orderPageObject;
    LoginPageObject loginPageObject;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    List<HashMap<String, String>> datamap3;


    @Given("the user is already on the {string} page")
    public void user_is_on_home_page(String h) {
        test = extent.createTest("Order Verification and Printing", "User verifies and prints the order details");
        test.info("Initializing WebDriver and opening the Magento home page.");
        if(driver == null)
        {
            driver = TC006_VerifyProductPurchaseUsingRegisteredEmailTest.getDriver();
        }
        homePageObject = new HomePageObject(driver);

    }

    @When("the user press on the {string} Menu")
    public void user_clicks_account_menu(String m) {
        homePageObject.click_on_account();
        test.info("Clicked on the account menu.");
    }

    @And("the user select {string}")
    public void user_select_my_account(String option) {
        homePageObject.click_on_my_account();
        test.info("Navigated to My Account page.");
    }

    @And("the user login with valid credentials")
    public void user_logs_in() throws InterruptedException {
        try {
            datamap3= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "RegisterData");
            loginPageObject = new LoginPageObject(driver);
            email = datamap3.getFirst().get("User Email");
            password = datamap3.getFirst().get("Password");
            loginPageObject.Login(email, password);
            test.info("User logged in with email: " + email);
            Thread.sleep(1000);
            test.info("User logged in successfully with email: " + email);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @And("the user navigates to the recent {string}")
    public void go_to_recent_orders(String r) {
        homePageObject.click_on_my_order();
        test.info("Navigated to Recent Orders page.");
        orderPageObject = new OrderPageObject(driver);
    }

    @And("the user views the {string}")
    public void view_order_details(String v) {
        orderPageObject.click_on_view_order();
        test.info("Verified order details.");
    }

    @Then("the {string} should match the {string}")
    public void verify_order_details(String d , String i) {
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
        test.pass("✅ Order details match the expected information.");
    }

    @When("the user prints {string}")
    public void print_order(String p) {
        orderPageObject.click_on_print_order();
        test.pass("✅ Order placed successfully.");
    }

    @Then("the order should be printed successfully")
    public void verify_print_success() {
        // Step 4: Handle the new tab
        String originalWindow = driver.getWindowHandle(); // Store the original window
        Set<String> allWindows = driver.getWindowHandles(); // Get all open windows/tabs

        // Switch to the new tab
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window); // Switch to the new tab
                break;
            }
        }
        // Step 5: Close the new tab and switch back to the original tab
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.close(); // Close the current tab (new tab)
        driver.switchTo().window(originalWindow); // Switch back to the original window
        test.pass("✅ Order printing process completed successfully.");
        orderPageObject.click_on_account();
        orderPageObject.click_on_logout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }


}


