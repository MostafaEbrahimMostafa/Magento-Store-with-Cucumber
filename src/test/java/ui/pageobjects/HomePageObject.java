package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Represents the Home Page of the Magneto Store Application.
 * Provides methods to interact with web elements on the Home Page.
 */

public class HomePageObject extends BasePage {


    /**
     * Constructor for the HomePageObject class.
     * Initializes the WebDriver instance and the WebElements.
     *
     * @param driver The WebDriver instance for interacting with the browser.
     */
    public HomePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    // WebElement locators

    // My Account link WebElement locator.
    @FindBy(xpath = "//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']")
    WebElement my_account;

    // Account label WebElement locator.
    @FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
    WebElement Account;

    // My Wishlist link WebElement locator.
    @FindBy(xpath = "//a[normalize-space()='My Wishlist (1 item)']")
    WebElement my_wishlist;

    // My Orders link WebElement locator.
    @FindBy(xpath = "//a[normalize-space()='My Orders']")
    private WebElement my_order;


    // Methods to interact with elements

    // Clicks on the "My Account" link located in the footer.
    public void click_on_my_account() {
        clickElement(my_account);
    }

    // Clicks on the "Account" label.
    public void click_on_account() {
        clickElement(Account);
    }

    // Clicks on the "My Wishlist" link.
    public void click_on_wishlist() {
        clickElement(my_wishlist);
    }

    // Clicks on the "My Orders" link.
    public void click_on_my_order()
    {
        clickElement(my_order);
    }








}
