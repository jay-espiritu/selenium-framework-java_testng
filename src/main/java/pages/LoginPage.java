package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

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

  public void setUsername(String username) {
    basePage.enterText(username, usernameField);
    Reporter.Log("Entered username with " + username);
  }

  public void setPassword(String password) {
    basePage.enterText(password, passwordField);
    Reporter.Log("Entered password with " + password);
  }

  public SecureAreaPage clickLoginButton() {
    basePage.clicked(loginButton);
    Reporter.Log("Clicked on login button");
    return new SecureAreaPage(driver);
  }
}
