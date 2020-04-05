package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
  }

  public void triggerConfirm() {
    basePage.clicked(triggerConfirmButton);
  }

  public void triggerPrompt() {
    basePage.clicked(triggerPromptButton);
  }

  public void alert_clickToAccept() {
    driver.switchTo().alert().accept();
  }

  public void alert_clickToDismiss() {
    driver.switchTo().alert().dismiss();
  }

  public String alert_getText() {
    return driver.switchTo().alert().getText();
  }

  public void alert_setInput(String text) {
    driver.switchTo().alert().sendKeys(text);
  }

  public String getResult() {
    return basePage.getElementText(results);
  }
}
