package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utils.Reporter.Log;

public class BaseListener extends BaseTests implements ITestListener {
  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {
    Log("Starting test method: " + getTestMethodName(iTestResult));
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {}

  @Override
  public void onTestFailure(ITestResult iTestResult) {}

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    Log("Skipped test: " + getTestMethodName(iTestResult));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

  @Override
  public void onStart(ITestContext iTestContext) {}

  @Override
  public void onFinish(ITestContext iTestContext) {}
}
