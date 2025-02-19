package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the Order page in Magneto Store application.
 * This class encapsulates the elements and actions that can be performed on the Order page.
 */
public class OrderPageObject extends BasePage {

    /**
     * Constructor that initializes the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance
     */
    public OrderPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Web element representing the "View Order" link
    @FindBy(xpath = "//a[normalize-space()='View Order']")
    private WebElement view_order;

    // Web element representing the "Print Order" link
    @FindBy(xpath = "//a[normalize-space()='Print Order']")
    private WebElement print_order;

    // Web element representing the "Reorder" link
    @FindBy(xpath = "//a[normalize-space()='Reorder']")
    private WebElement reorder;

    // Web element representing the quantity input field
    @FindBy(xpath = "//input[@title='Qty']")
    private WebElement quantity;

    // Web element representing the "Update" button to update the quantity
    @FindBy(xpath = "//button[@title='Update']//span//span[contains(text(),'Update')]")
    private WebElement update_qty;

    // Web element representing the "Account" section link
    @FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
    WebElement Account;

    // Web element representing the "Log Out" link
    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement logout;

    // Methods to interact with elements

    // Clicks on the "Account" section.
    public void click_on_account() {
        clickElement(Account);
    }

    // Clicks on the "Log Out" link to log out of the account.
    public void click_on_logout()
    {
        clickElement(logout);
    }

    /**
     * Enters the desired quantity into the quantity input field.
     *
     * @param q the quantity to enter
     */
    public void enter_quantity(String q)
    {
        clearElement(quantity);
        sendText(quantity,q);
    }

    // Clicks the "Update" button to update the quantity.
    public void click_on_update()
    {
        clickElement(update_qty);
    }

    // Clicks on the "Reorder" link to initiate a reorder process.
    public void click_on_reorder()
    {
        clickElement(reorder);
    }

    // Clicks on the "View Order" link to view the current order details.
    public void click_on_view_order()
    {
        clickElement(view_order);
    }

    // Clicks on the "Print Order" link to print the current order.
    public void click_on_print_order()
    {
        clickElement(print_order);
    }

}
