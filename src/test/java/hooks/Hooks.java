package hooks;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testRunner.TestRunner;
import com.aventstack.extentreports.ExtentTest;
import testcases.TC008_VerifyUserCanChangeOrReorderPreviouslyAddedProductTest;
import testcases.TC009_VerifyDiscountCouponFunctionalityTest;

public class Hooks {
    public static WebDriver driver;
    private ExtentTest test; // Declare a test instance for Extent Reports


    @Before
    public void setup(Scenario scenario) {
        // Create a single test instance for the scenario
        test = TestRunner.extent.createTest(scenario.getName());
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("❌ Scenario failed: " + scenario.getName());
        } else {
            test.pass("✅ Scenario passed: " + scenario.getName());
        }
        if (driver != null) {
            driver.quit(); // Ensure only one WebDriver instance is closed
        }
    }
}
