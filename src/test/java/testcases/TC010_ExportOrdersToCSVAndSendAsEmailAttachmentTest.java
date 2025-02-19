package testcases;

import io.cucumber.java.en.Given;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import testRunner.TestRunner;
import utils.DataReader;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
public class TC010_ExportOrdersToCSVAndSendAsEmailAttachmentTest {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    private String email, password;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    List<HashMap<String, String>> datamap7;
    @Given("the user is on the Magento {string} login page")
    public void the_user_is_on_the_magento_admin_login_page(String l) {
        test = extent.createTest("Verify That You Can Export Orders To CSV And Send As Email Attachment","User exports orders to CSV and sends as an email attachment");
        test.info("Navigating to Magento admin login page.");
        if(driver == null) {
            driver = TC009_VerifyDiscountCouponFunctionalityTest.getDriver();
            driver.get("https://live.techpanda.org/index.php/backendlogin/");
        }
    }

    @When("the user is logged with valid credentials")
    public void the_user_logs_in_with_valid_credentials() throws InterruptedException {
        test.info("Logging in with admin credentials.");
        try {
            datamap7= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "AdminLoginData");
            email = datamap7.getFirst().get("username");
            password = datamap7.getFirst().get("password");
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
            driver.findElement(By.xpath("//input[@id='login']")).sendKeys(password);
            test.info("User logged in with email: " + email);
            driver.findElement(By.xpath("//input[@title='Login']")).click();
            Thread.sleep(1000);
            test.info("User logged in successfully with email: " + email);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @When("the user navigates to the Sales -> {string} menu")
    public void the_user_navigates_to_the_menu(String submenu) {
        test.info("Navigating to '" + "order" + "' -> '" + submenu + "' menu.");
        driver.findElement(By.xpath("//span[normalize-space()='close']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
    }

    @When("the user selects {string} in the {string} dropdown and clicks the export button")
    public void the_user_selects_export_type_and_clicks_export(String exportType, String dropdownName) {
        test.info("Selecting '" + exportType + "' in '" + dropdownName + "' dropdown and exporting.");
        driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
    }

    @Then("the {string} should be downloaded successfully")
    public void the_exported_file_should_be_downloaded_successfully(String ex) throws IOException {
        test.info("Verifying if the export was successful.");
        test.fail("❌ Export failed - File might not be downloaded.");
        try {
            WebElement concole = driver.findElement(By.id("email"));
            Assert.assertTrue(concole.isDisplayed());
        } catch (Exception e) {
            driver.close();
            throw new RuntimeException("Exportation Funcation Isn't Working Correctlty Because Export Button Isn't Working");
        }

    }
}
