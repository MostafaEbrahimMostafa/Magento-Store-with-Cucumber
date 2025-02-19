package testRunner;

import com.aventstack.extentreports.reporter.configuration.Theme;
import factory.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import utils.ConfigurationUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features/F0_Sorting.feature", "Features/F1_CostConsistency.feature",
        "Features/F2_ProductQuantity.feature",
        "Features/F3_ProductComparing.feature",
        "Features/F4_AccountCreationAndWishlist.feature",
        "Features/F5_ProductPurchase.feature",
        "Features/F6_OrderPrinting.feature",
        "Features/F7_ProductChange.feature",
        "Features/F8_VerifyDiscountCoupon.feature",
        "Features/F9_ExportOrders.feature"},// Path to feature files
        glue={"testcases","hooks"},
        plugin= {
                "pretty", "html:reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt",
        },
        monochrome = true,
        dryRun=false,    // checks mapping between scenario steps and step definition methods
        publish=true   // to publish report in cucumber server
        )
public class TestRunner {

    // Setup Extent Reports
    public static ExtentReports extent;


    @BeforeClass
    public static void setup() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
        sparkReporter.config().setDocumentTitle(ConfigurationUtils.getInstance().get_DocumentTitle());
        sparkReporter.config().setReportName(ConfigurationUtils.getInstance().get_ReportName());
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Computer Name", ConfigurationUtils.getInstance().get_ComputerName());
        extent.setSystemInfo("Environment" , ConfigurationUtils.getInstance().get_Environment());
        extent.setSystemInfo("OS",ConfigurationUtils.getInstance().get_OS());
        extent.setSystemInfo("Browser",ConfigurationUtils.getInstance().get_Browser());
        extent.setSystemInfo("Tester Name",ConfigurationUtils.getInstance().get_TesterName());
        extent.setSystemInfo("Review Name",ConfigurationUtils.getInstance().get_ReviewName());
        extent.setSystemInfo("Developer Name",ConfigurationUtils.getInstance().get_DeveloperName());
        extent.attachReporter(sparkReporter);
        System.out.println("Extent Report Initialized.");
    }

    @AfterClass
    public static void tearDown() {
        extent.flush();
        System.out.println("Extent Report Generated.");
    }

    public static ExtentReports getExtentReports() {
        return extent;
    }

}
