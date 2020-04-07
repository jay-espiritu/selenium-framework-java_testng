package utils;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class Reporter {
  private static Logger log = Logger.getLogger(Reporter.class.getName());

  @Step("{0}")
  public static void Log(String message) {
    log.info(message);
  }
}
