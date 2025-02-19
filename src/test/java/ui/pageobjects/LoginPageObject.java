package ui.pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Represents the Login Page of Magneto Store application.
 * Provides methods for user login functionality.
 */
public class LoginPageObject extends BasePage {

    /**
     * Constructor for the LoginPageObject class.
     * Initializes the WebDriver instance and the WebElements.
     *
     * @param driver The WebDriver instance for interacting with the browser.
     */
    public LoginPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // WebElement locators

    // E-mail WebElement locator.
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email ;

    // Password WebElement locator.
    @FindBy(xpath = "//input[@id='pass']")
    private WebElement password;

    // Login Button locator.
    @FindBy(xpath = "//button[@id='send2']")
    private WebElement login_button ;

    // Methods to interact with elements

    // Clicks on the "Login" button to submit the login form.
    public void click_on_login_btn()
    {
        clickElement(login_button);
    }

    /**
     * Performs the login operation by entering email, password, and clicking the login button.
     *
     * @param em    The email address of the user.
     * @param pass The password of the user.
     */
    public void Login(String em , String pass )
    {
        clearElement(email);
        sendText(email,em);
        clearElement(password);
        sendText(password,pass);
        click_on_login_btn();
    }
}
