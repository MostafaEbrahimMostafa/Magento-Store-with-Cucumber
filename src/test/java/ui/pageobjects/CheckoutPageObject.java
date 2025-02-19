package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Checkout Page of the application.
 * Provides methods to interact with various elements during the checkout process.
 */
public class CheckoutPageObject extends BasePage {

    /**
     * Constructor for the CheckoutPageObject class.
     * Initializes the WebDriver instance and the WebElements.
     *
     * @param driver The WebDriver instance for interacting with the browser.
     */
    public CheckoutPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // WebElement locators

    // First Name WebElement locator.
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement first_name;

    // Middle Name WebElement locator.
    @FindBy(xpath = "//input[@id='middlename']")
    private WebElement middle_name;

    // Last Name WebElement locator.
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement last_name;

    // Company WebElement locator.
    @FindBy(xpath = "//input[@id='company']")
    private WebElement company;

    // Telephone Number WebElement locator.
    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement telephone;

    // Fax WebElement locator.
    @FindBy(xpath = "//input[@id='fax']")
    private WebElement fax;

    // address 1 WebElement locator.
    @FindBy(xpath = "//input[@id='street_1']")
    private WebElement address1;

    // address 2 WebElement locator.
    @FindBy(xpath = "//input[@id='street_2']")
    private WebElement address2;

    // City WebElement locator.
    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    // State WebElement locator.
    @FindBy(xpath = "//select[@id='region_id']")
    private WebElement state;

    // Zip Code WebElement locator.
    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zipCode;

    // Country WebElement locator.
    @FindBy(xpath = "//select[@id='country']")
    private WebElement country;

    // Save Address Button WebElement locator.
    @FindBy(xpath = "//button[@title='Save Address']")
    private WebElement save_address_button;

    // Continue To Shipping Button WebElement locator.
    @FindBy(xpath = "//span[contains(text(),'Continue to Shipping Information')]")
    private WebElement continue_to_shipping_information;

    // Continue To Billing Button WebElement locator.
    @FindBy(xpath = "//span[contains(text(),'Continue to Billing Information')]")
    private WebElement continue_to_billing_information;

    // Check/Money Order option WebElement locator.
    @FindBy(xpath = "//input[@id='p_method_checkmo']")
    private WebElement check_money_order;

    // Continue To Review Button WebElement locator.
    @FindBy(xpath = "//span[contains(text(),'Continue to Review Your Order')]")
    private WebElement continue_to_review_your_order;

    // Continue To Place Order Button WebElement locator.
    @FindBy(xpath = "//button[@id='review-button']")
    private WebElement place_order;

    // Continue To Account Link WebElement locator.
    @FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
    WebElement Account;

    // Continue To Logout Link WebElement locator.
    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement logout;

    // Methods to interact with elements

    // Clicks on the logout button
    public void click_on_logout()
    {
        clickElement(logout);
    }

    // Clicks on the account label.
    public void click_on_account() {
        clickElement(Account);
    }

    // Clicks on the place order button.
    public void click_on_place_order()
    {
        clickElement(place_order);
    }

    // Clicks on the "Continue to Review Your Order" button.
    public void click_on_continue_to_review()
    {
        clickElement(continue_to_review_your_order);
    }

    // Clicks on the "Check/Money Order" option.
    public void click_on_check_money_order()
    {
        clickElement(check_money_order);
    }

    // Clicks on the "Continue to Billing Information" button.
    public void click_on_continue_to_billing()
    {
        clickElement(continue_to_billing_information);
    }

    // Clicks on the "Continue to Shipping Information" button.
    public void click_on_continue_to_shipping()
    {
        clickElement(continue_to_shipping_information);
    }

    //Clicks on the "Save Address" button.
    public void click_on_save_address_button()
    {
        clickElement(save_address_button);
    }

    /**
     * Enters shipping address details.
     * @param fn    First Name
     * @param mn    Middle Name
     * @param ln    Last Name
     * @param comp  Company Name
     * @param tp    Telephone Number
     * @param f     Fax Number
     * @param add1  Address Line 1
     * @param add2  Address Line 2
     * @param c     City
     * @param st    State
     * @param z     Zip Code
     * @param cont  Country
     */
    public void enterShippingAddress(String fn , String mn , String ln , String comp , String tp ,
                                     String f , String add1 ,String add2 , String c , String st , String z ,
                                     String cont)
    {
        clearElement(first_name);
        sendText(first_name,fn);
        clearElement(middle_name);
        sendText(middle_name,mn);
        clearElement(last_name);
        sendText(last_name,ln);
        clearElement(first_name);
        sendText(first_name,fn);
        clearElement(company);
        sendText(company,comp);
        clearElement(telephone);
        sendText(telephone,tp);
        clearElement(fax);
        sendText(fax,f);
        clearElement(address1);
        sendText(address1,add1);
        clearElement(address2);
        sendText(address2,add2);
        clearElement(city);
        sendText(city,c);
        selectOption(state,st);
        clearElement(zipCode);
        sendText(zipCode,z);
        selectOption(country,cont);
    }


}
