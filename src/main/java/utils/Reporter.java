package utils;

import org.apache.log4j.Logger;

public class Reporter {
  private static Logger log = Logger.getLogger(Reporter.class.getName());

  public static void LogInfo(String message) {
    log.info(message);
  }

  public static void LogDebug(String message) {
    log.debug(message);
  }

  public static void LogError(String message) {
    log.error(message);
  }

  public static void LogFatal(String message) {
    log.fatal(message);
  }
}
