package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the Details Page of the application.
 * Provides methods to interact with various elements like price, quantity, and cart operations.
 */
public class DetailsPageObject extends BasePage {

    /**
     * Constructor for the DetailsPageObject class.
     * Initializes the WebDriver instance and the WebElements.
     *
     * @param driver The WebDriver instance for interacting with the browser.
     */
    public DetailsPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // WebElement locators

    // Price WebElement locator.
    @FindBy(xpath = "//span[@class='price']")
    private WebElement price ;

    // Add to Cart Button WebElement locator.
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement add_to_cart_button;

    // Quantity WebElement locator.
    @FindBy(xpath = "//input[@title='Qty']")
    private WebElement quantity;

    // update Button WebElement locator.
    @FindBy(xpath = "//button[@title='Update']//span//span[contains(text(),'Update')]")
    private WebElement update_button;

    // Empty cart link WebElement locator.
    @FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
    private WebElement empty_cart;

    // Methods to interact with elements

    // Clicks on the "Empty Cart" button.
    public void click_on_emptyCart_button()
    {
        clickElement(empty_cart);
    }

    // Clicks on the "Update" button to update the cart.
    public void click_on_update_button()
    {
        clickElement(update_button);
    }

    /**
     * Enters the specified quantity in the quantity input field.
     *
     * @param q The quantity to set.
     */
    public void enter_quantity(String q)
    {
        clearElement(quantity);
        sendText(quantity,q);
    }

    // Clicks on the "Add to Cart" button.
    public void click_on_add_to_cart_button()
    {
        clickElement(add_to_cart_button);
    }

    /**
     * Gets the price displayed on the product details page.
     *
     * @return The WebElement representing the price.
     */
    public WebElement getPrice() {
        return price;
    }

}
