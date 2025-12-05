package com.amazon.test.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";

        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            FileHandler.copy(src, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    public static String captureAndReturnPath(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";

        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            FileHandler.copy(src, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        return screenshotPath;

    }


//    public static String takeScreenshot(WebDriver driver, String testName) {
//        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + dateName + ".png";
//        try {
//            FileUtils.copyFile(source, new File(destination));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return destination;
//    }
}
