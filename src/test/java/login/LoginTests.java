package login;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {

  @Test(description = "Verify successful login")
  @Description("Test Description: Login test with valid username and password.")
  @Story("Login Functionality")
  public void testSuccessfulLogin() {
    LoginPage loginPage = homePage.clickFormAuthentication();
    loginPage.setUsername("tomsmith");
    loginPage.setPassword("SuperSecretPassword!");
    SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
    secureAreaPage.getAlertText();
    Assert.assertTrue(
        secureAreaPage.getAlertText().contains("You logged into a secure area!"),
        "Alert text does not match");
  }
}
