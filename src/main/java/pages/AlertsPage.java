package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class AlertsPage {

  private WebDriver driver;
  private BasePage basePage;

  private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
  private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
  private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

  private By results = By.id("result");

  public AlertsPage(WebDriver driver) {
    this.driver = driver;
    basePage = new BasePage(driver);
  }

  public void triggerAlert() {
    basePage.clicked(triggerAlertButton);
    Reporter.LogInfo("Clicked trigger alert button");
  }

  public void triggerConfirm() {
    basePage.clicked(triggerConfirmButton);
    Reporter.LogInfo("Confirmed trigger alert");
  }

  public void triggerPrompt() {
    basePage.clicked(triggerPromptButton);
    Reporter.LogInfo("Clicked trigger prompt button");
  }

  public void alert_clickToAccept() {
    driver.switchTo().alert().accept();
    Reporter.LogInfo("Accepted alert pop up");
  }

  public void alert_clickToDismiss() {
    driver.switchTo().alert().dismiss();
    Reporter.LogInfo("Dismissed alert pop up");
  }

  public String alert_getText() {
    var alertText = driver.switchTo().alert().getText();
    Reporter.LogDebug("Alert text: '" + alertText + "'");
    return alertText;
  }

  public void alert_setInput(String text) {
    driver.switchTo().alert().sendKeys(text);
    Reporter.LogInfo("Entered text in alert text field");
  }

  public String getResult() {
    var text = basePage.getElementText(results);
    Reporter.LogDebug("Alert text: '" + text + "'");
    return text;
  }
}
