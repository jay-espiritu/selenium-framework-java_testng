package alert;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertTests extends BaseTests {

  @Test
  public void testAcceptAlert() {
    AlertsPage alertsPage = homePage.clickJavaScriptAlerts("JavaScript Alerts");
    alertsPage.triggerAlert();
    alertsPage.alert_clickToAccept();
    Assert.assertEquals(
        alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
  }

  @Test
  public void testGetTextFromAlert() {
    AlertsPage alertsPage = homePage.clickJavaScriptAlerts("JavaScript Alerts");
    alertsPage.triggerConfirm();
    String text = alertsPage.alert_getText();
    alertsPage.alert_clickToDismiss();
    Assert.assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
  }

  @Test
  public void testSetInputInAlert() {
    AlertsPage alertsPage = homePage.clickJavaScriptAlerts("JavaScript Alerts");
    alertsPage.triggerPrompt();

    String text = "TAU rocks!";
    alertsPage.alert_setInput(text);
    alertsPage.alert_clickToAccept();
    Assert.assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect");
  }
}
