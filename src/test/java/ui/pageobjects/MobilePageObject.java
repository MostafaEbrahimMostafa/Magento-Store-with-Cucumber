package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Page Object for the Mobile page in Magneto Store application.
 * This class encapsulates the elements and actions that can be performed on the Mobile page.
 */
public class MobilePageObject extends BasePage {

    // List to store product names (extracted from product elements)
    public List<String> productNames ;

    /**
     * Constructor that initializes the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance
     */
    public MobilePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    // Web element representing the Mobile category link
    @FindBy(xpath = "//a[normalize-space()='Mobile']")
    private WebElement mobile_category;

    // Web element representing the sort box dropdown
    @FindBy(xpath = "//div[@class='category-products']/div/div/div/select")
    private WebElement sort_box ;

    // List of Web elements representing the product links on the page
    @FindBy(xpath = "//div[@class='category-products']/ul/li/div/h2/a")
    private List<WebElement> productElements;

    // Web element representing a specific mobile product image
    @FindBy(xpath = "//img[@id='product-collection-image-1']")
    private WebElement mobile_product;

    // Web element representing the "Add to compare" button for the first product
    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
    private WebElement first_add_to_compare;

    // Web element representing the "Add to compare" button for the second product
    @FindBy(xpath = "//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]")
    private WebElement second_add_to_compare;

    // Web element representing the "Compare" button
    @FindBy(xpath = "//button[@title='Compare']//span//span[contains(text(),'Compare')]")
    private WebElement compare_button;

    // Web element representing the price of a product
    @FindBy(xpath = "//*[@id=\"product-price-1\"]/span")
    private WebElement product_price;

    // Methods to interact with elements

    // Getter method to return the price of the product
    public WebElement getProduct_price() {
        return product_price;
    }

    // Method to click on the "Compare" button
    public void click_on_compare_button()
    {
        clickElement(compare_button);
    }

    // Method to click on a specific mobile product
    public void click_on_mobile_product()
    {
        clickElement(mobile_product);
    }

    // Method to click on the "Add to compare" button for the first product
    public void click_on_first_compare()
    {
        clickElement(first_add_to_compare);
    }

    // Method to click on the "Add to compare" button for the second product
    public void click_on_second_compare()
    {
        clickElement(second_add_to_compare);
    }

    // Method to click on the "Mobile" category link
    public void click_on_mobile_category()
    {
        clickElement(mobile_category);
    }

    // Method to click on the sort box dropdown
    public void click_on_sort_box()
    {
        clickElement(sort_box);
    }

    // Method to select "Name" from the sort options in the dropdown
    public void select_name_sort()
    {
        selectOption(sort_box,"Name");
    }

    /**
     * Locates product names on the Mobile page and stores them in the productNames list.
     *
     * @return the list of WebElements representing product names
     */
    public List<WebElement> locateProductNameElements() {
        productNames = new ArrayList<>();
        return productElements; // Return the list of located elements
    }


}
