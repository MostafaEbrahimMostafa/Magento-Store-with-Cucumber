package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the Wishlist page in Magneto Store application.
 * This class encapsulates the elements and actions related to managing the wishlist.
 */
public class WishListPageObject extends BasePage {

    /**
     * Constructor that initializes the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance
     */
    public WishListPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Web element for the "Share Wishlist" button
    @FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
    private WebElement share_button;

    // Web element for the email input field in the "Share Wishlist" section
    @FindBy(xpath = "//textarea[@id='email_address']")
    private WebElement email_text;

    // Web element for the message input field in the "Share Wishlist" section
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement massage_text;

    // Web element for the "Share" button in the wishlist
    @FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
    private WebElement share;

    // Web element for the "Add to Cart" button
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement add_to_cart;

    // Web element for the "Account" section
    @FindBy(xpath = " //span[@class='label'][normalize-space()='Account']")
    WebElement Account;

    // Web element for the "Log Out" link
    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement logout;

    // Click on the "Add to Cart" button.
    public void click_on_add_to_cart()
    {
        clickElement(add_to_cart);
    }

    // Click on the "Account" section to navigate to the account page.
    public void click_on_account()
    {
        clickElement(Account);
    }

    // Click on the "Log Out" link to log out from the application.
    public void click_on_logout()
    {
        clickElement(logout);
    }

    /**
     * Enter an email address in the "Share Wishlist" email field.
     *
     * @param email the email address to share the wishlist with
     */
    public void enterEmail(String email)
    {
        clearElement(email_text);
        sendText(email_text,email);
    }

    /**
     * Enter a message in the "Share Wishlist" message field.
     *
     * @param m the message to include in the wishlist share
     */
    public void enterMessage(String m)
    {
        clearElement(massage_text);
        sendText(massage_text,m);
    }

    // Click on the "Share Wishlist" button to initiate sharing the wishlist.
    public void click_on_share()
    {
        clickElement(share_button);
    }

    // Click on the "Share" button to submit the shared wishlist.
    public void click_on_shareButton()
    {
        clickElement(share);
    }
}
