package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private BasePage basePage;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton     = By.cssSelector("button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public void setUsername(String username){
        basePage.enterText(username, usernameField);
    }

    public void setPassword(String password){
        basePage.enterText(password, passwordField);
    }

    public SecureAreaPage clickLoginButton(){
        basePage.clicked(loginButton);
        return new SecureAreaPage(driver);
    }
}