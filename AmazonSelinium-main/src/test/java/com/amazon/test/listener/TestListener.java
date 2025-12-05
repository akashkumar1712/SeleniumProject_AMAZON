package com.amazon.test.listener;


import com.amazon.test.base.BaseClass;
import com.amazon.test.utility.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ScreenshotUtil.captureScreenshot(webDriver, testName);
    }
}
