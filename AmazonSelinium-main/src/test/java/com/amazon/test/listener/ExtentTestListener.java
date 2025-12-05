package com.amazon.test.listener;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.amazon.test.utility.ExtentManager;
import com.amazon.test.utility.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReporter();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        Object testClass = result.getInstance();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("webDriver").get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String screenshotPath = ScreenshotUtil.captureAndReturnPath(driver, result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
