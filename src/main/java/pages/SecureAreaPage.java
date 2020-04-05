package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private BasePage basePage;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public String getAlertText() {
        return basePage.getElementText(statusAlert);
    }
}
