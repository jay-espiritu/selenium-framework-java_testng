package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class SecureAreaPage {

    private WebDriver driver;
    private BasePage basePage;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public String getAlertText() {
        String text = basePage.getElementText(statusAlert);
        Reporter.Log("Alert text: "+text);
        return text;
    }
}
