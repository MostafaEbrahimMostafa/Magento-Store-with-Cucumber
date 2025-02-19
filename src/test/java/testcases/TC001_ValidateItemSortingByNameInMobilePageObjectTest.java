package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testRunner.TestRunner;
import ui.pageobjects.HomePageObject;
import ui.pageobjects.LoginPageObject;
import ui.pageobjects.MobilePageObject;
import utils.DataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TC001_ValidateItemSortingByNameInMobilePageObjectTest {
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver driver;
    public HomePageObject homePageObject;
    public LoginPageObject loginPageObject;
    public MobilePageObject mobilePageObject;
    private String email, password;
    private List<String> sortedNames;
    private SoftAssert softAssert;

    private ExtentReports extent = TestRunner.getExtentReports();
    private ExtentTest test;
    List<HashMap<String, String>> datamap1; //Data driven


    @Given("the user navigates magentoStore {string}")
    public void the_user_navigates_magentoStore(String url) throws InterruptedException {
        test = extent.createTest("Validate Item Sorting By Name", "Verifies that mobile items can be sorted alphabetically by name.");
        test.info("Initializing WebDriver and opening the website: " + url);
        if(driver == null)
        {
            driver = DriverFactory.initializeDriver();
        }
        homePageObject = new HomePageObject(driver);
        homePageObject.click_on_account();
        homePageObject.click_on_my_account();
        test.info("Navigated to My Account page.");
        try {
            datamap1= DataReader.data("C:\\Users\\M.ELHADAF\\IdeaProjects\\BDD\\src\\test\\java\\testData\\MagentoStoreData.xlsx", "LoginData");
            loginPageObject = new LoginPageObject(driver);
            email = datamap1.getFirst().get("username");
            password = datamap1.getFirst().get("password");

            double number = Double.parseDouble(password);
            long result = Math.round(number);
            loginPageObject.Login(email, String.valueOf(result));
            test.info("User logged in with email: " + email);
            Thread.sleep(1000);
            mobilePageObject = new MobilePageObject(driver);
            softAssert = new SoftAssert();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @When("the user clicks on the {string} category")
    public void the_user_clicks_on_the_mobile_category(String cat) {
        mobilePageObject.click_on_mobile_category();
        test.info("Clicked on the Mobile category.");
    }

    @And("the user selects {string} from the Sort By dropdown")
    public void the_user_selects_name_from_the_sort_by_dropdown(String s) {
        mobilePageObject.click_on_sort_box();
        mobilePageObject.select_name_sort();
        test.info("Selected 'Sort by Name' from dropdown.");
    }

    @Then("all products should be sorted alphabetically by name")
    public void all_products_should_be_sorted_alphabetically_by_name() throws IOException {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : mobilePageObject.locateProductNameElements()) {
            productNames.add(product.getText().trim());
        }

        sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);

        if (productNames.equals(sortedNames)) {
            test.pass("✅ Product list is correctly sorted alphabetically by name.");
        } else {
            test.fail("❌ Product list is NOT sorted correctly.");
        }
        Assert.assertEquals(productNames, sortedNames, "The products are not sorted by name correctly.");
    }

}
