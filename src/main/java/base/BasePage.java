package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        WebElement element = null;
        try
        {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e)
        {
            Assert.fail("Element cannot be found.");
        }
        return element;
    }

    public void clicked(By locator) {
        find(locator).click();
    }

    public void enterText(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public String getElementText(By locator){
        return find(locator).getText();
    }
}