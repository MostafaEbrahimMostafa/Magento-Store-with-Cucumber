package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.DetailsPageObject;
import ui.pageobjects.MobilePageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TC004_VerifyProductComparisonFunctionalityInMobilePageObjectTest  {

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    private SoftAssert softAssert;
    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    MobilePageObject mobilePageObject;
    DetailsPageObject detailsPageObject;

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_mobile_page(String mi) {
        test = extent.createTest("Validate Product Comparison", "Verifies that users can compare two products successfully.");
        test.info("Initializing WebDriver and opening the website.");

        if (driver == null) {
            driver = TC003_ValidateMaxQuantityRestrictionForCartItemsTest.getDriver();
            mobilePageObject = new MobilePageObject(driver);
        }
        mobilePageObject.click_on_mobile_category();
        test.info("Navigated to the Mobile page.");
        softAssert = new SoftAssert();
    }

    @When("the user add {string} to the comparison list")
    public void the_user_adds_firstItem_to_the_comparison_list(String productName) {

        mobilePageObject.click_on_first_compare();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String message = driver.findElement(By.xpath("//li[@class='success-msg']//ul//li")).getText();
        test.info(productName + " added to comparison list. Message: " + message);
    }

    @And("the user adds {string} to the comparison list")
    public void the_user_adds_secondItem_to_comparison_list(String productName) {
        mobilePageObject.click_on_second_compare();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String message = driver.findElement(By.xpath("//li[@class='success-msg']//ul//li")).getText();
        test.info(productName + " added to comparison list. Message: " + message);
    }

    @And("the user clicks  {string} button")
    public void the_user_clicks_on_the_compare_button(String co) {
        mobilePageObject.click_on_compare_button();
        test.info("Clicked on the Compare button.");
    }

    @Then("a comparison pop-up should appear with the selected products")
    public void a_comparison_pop_up_should_appear_with_the_selected_products() {
        // Switch to new tab
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindow = iterator.next();
        String newTab = iterator.next();
        driver.switchTo().window(newTab);
        driver.manage().window().maximize();

        // Validate the content in the new tab (example)
        String actual_value = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[1]/h1")).getText();
        driver.manage().window().maximize();
        softAssert.assertEquals(actual_value,"COMPARE PRODUCTS");
        test.pass("✅ Comparison pop-up appeared successfully with correct title.");
        // Locate and click the "Close Window" button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton =driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div[2]/button/span/span"));
        closeButton.click();
        test.pass("✅ Pop-up window closed successfully.");
        // Switch back to the main tab
        driver.switchTo().window(mainWindow); // Return to the main tab
        driver.findElement(By.xpath("//img[@class='large']")).click();
        softAssert.assertAll();
    }


}
