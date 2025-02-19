package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the TV page in Magneto Store application.
 * This class encapsulates the elements and actions related to the TV section.
 */
public class TvPageObject extends BasePage {

    /**
     * Constructor that initializes the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance
     */
    public TvPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Web element for the "Add to Wishlist" button for a specific TV item
    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
    private WebElement add_to_wishlist;

    // Click on the "Add to Wishlist" button for the TV item.
    public void click_on_add_to_wishlist()
    {
        clickElement(add_to_wishlist);
    }


}
