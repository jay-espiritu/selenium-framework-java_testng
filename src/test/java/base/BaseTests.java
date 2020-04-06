package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventListener;
import utils.Reporter;
import utils.VideoRecorder;

import java.io.File;
import java.io.IOException;

public class BaseTests {

  protected HomePage homePage;
  public EventFiringWebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    Reporter.LogInfo("---- START OF TEST ----");
    VideoRecorder.startRecording();
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
    driver.register(new EventListener());

    driver.get("https://the-internet.herokuapp.com/");
    homePage = new HomePage(driver);
  }

  @AfterMethod
  public void tearDown(ITestResult result) throws Exception {
    recordFailure(result);
    driver.quit();
    VideoRecorder.stopRecording();
    Reporter.LogInfo("---- FINISH OF TEST ----");

  }

  private ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-infobars");
    options.addArguments("start-maximized");
    options.addArguments("disable-extensions");
    options.setHeadless(true);
    return options;
  }

  private void recordFailure(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      TakesScreenshot camera = (TakesScreenshot) driver;
      File screenshot = camera.getScreenshotAs(OutputType.FILE);
      try {
        Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
        Reporter.LogInfo("Screenshot taken!");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
