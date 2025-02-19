package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the Registration page in Magneto Store application.
 * This class encapsulates the elements and actions related to user registration.
 */
public class RegisterPageObject extends BasePage {

    /**
     * Constructor that initializes the WebDriver and PageFactory.
     *
     * @param driver the WebDriver instance
     */
    public RegisterPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Web element for the first name input field
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement first_name;

    // Web element for the middle name input field
    @FindBy(xpath = "//input[@id='middlename']")
    private WebElement middle_name;

    // Web element for the last name input field
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement last_name;

    // Web element for the email address input field
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement email;

    // Web element for the password input field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    // Web element for the confirmation password input field
    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmPassword;

    // Web element for the newsletter subscription checkbox
    @FindBy(xpath = "//input[@id='is_subscribed']")
    private WebElement newsletter;

    // Web element for the register button
    @FindBy(xpath = "//button[@title='Register']")
    private WebElement register_button;

    // Web element for the create account button
    @FindBy(xpath = "//span[contains(text(),'Create an Account')]")
    private WebElement create_account_button;

    // Web element for the "TV" category link
    @FindBy(xpath = "//a[normalize-space()='TV']")
    private WebElement Tv_category;

    // Methods to interact with elements

    // Click on the "TV Category" link to navigate to the TV section.
    public void click_on_tv_category()
    {
        clickElement(Tv_category);
    }

    // Click on the "Create Account" button to navigate to the registration form.
    public void click_on_createAccount()
    {
        clickElement(create_account_button);
    }

    // Click on the "Register" button to submit the registration form.
    public void click_on_register()
    {
        clickElement(register_button);
    }

    /**
     * Fill in the registration form with the provided user data.
     *
     * @param fName    the first name of the user
     * @param mName    the middle name of the user
     * @param lName    the last name of the user
     * @param em       the email address of the user
     * @param pass     the password for the user
     * @param conPass  the confirmation password for the user
     */
    public void EnterNewUserInformation(String fName , String mName , String lName , String em , String pass , String conPass) {
        clearElement(first_name);
        sendText(first_name, fName);
        clearElement(middle_name);
        sendText(middle_name, mName);
        clearElement(last_name);
        sendText(last_name, lName);
        clearElement(email);
        sendText(email, em);
        clearElement(password);
        sendText(password, pass);
        clearElement(confirmPassword);
        sendText(confirmPassword, conPass);
        clickElement(newsletter);
    }







}
