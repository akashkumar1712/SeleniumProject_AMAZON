package com.amazon.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
//            spark.config().setDocumentTitle("Automation Report");
//            spark.config().setReportName("Amazon Automation Testing");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}