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
    VideoRecorder.startRecording();

    /** Local machine execution */
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventListener());

    /** Selenium Grid in docker execution */
//    String nodeUrl = "http://localhost:4444/wd/hub";
//    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//    driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(nodeUrl), capabilities));

    driver.get("https://the-internet.herokuapp.com/");
    homePage = new HomePage(driver);
  }

  @AfterMethod
  public void tearDown(ITestResult result) throws Exception {
    recordFailure(result);
    driver.quit();
    VideoRecorder.stopRecording();
  }

  private ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-infobars");
    options.addArguments("start-maximized");
    options.addArguments("disable-extensions");
    options.setHeadless(false);
    return options;
  }

  private void recordFailure(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      TakesScreenshot camera = (TakesScreenshot) driver;
      File screenshot = camera.getScreenshotAs(OutputType.FILE);
      try {
        Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
        Reporter.Log("Screenshot taken!");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
