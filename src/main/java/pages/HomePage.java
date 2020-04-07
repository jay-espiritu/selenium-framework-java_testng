package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class HomePage {

  private WebDriver driver;
  private BasePage basePage;

  private By formAuthenticationLink = By.linkText("Form Authentication");

  public HomePage(WebDriver driver) {
    this.driver = driver;
    basePage = new BasePage(driver);
  }

  public LoginPage clickFormAuthentication() {
    basePage.clicked(formAuthenticationLink);
    return new LoginPage(driver);
  }

  public AlertsPage clickJavaScriptAlerts(String alertText) {
    clickLink(alertText);
    Reporter.Log("Clicked on JS alert");
    return new AlertsPage(driver);
  }

  private void clickLink(String linkText) {
    basePage.clicked(By.linkText(linkText));
    Reporter.Log("Clicked on link" + linkText);
  }
}
