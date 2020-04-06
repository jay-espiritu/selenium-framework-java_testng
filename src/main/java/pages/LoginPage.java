package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private BasePage basePage;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    @Step("Entered username as '{0}'")
    public void setUsername(String username) {
        basePage.enterText(username, usernameField);
    }

    @Step("Entered password as '{0}'")
    public void setPassword(String password) {
        basePage.enterText(password, passwordField);
    }

    public SecureAreaPage clickLoginButton() {
        basePage.clicked(loginButton);
        return new SecureAreaPage(driver);
    }
}
