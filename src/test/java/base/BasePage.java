package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public  WebDriver driver ;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickElement(WebElement element)
    {
        element.click();
    }

    public void sendText(WebElement element , String text)
    {
        element.sendKeys(text);
    }

    public void selectOption(WebElement element , String selected_text)
    {
        Select select = new Select(element);
        select.selectByVisibleText(selected_text);
    }

    public void clearElement(WebElement element)
    {
        element.clear();
    }
}
