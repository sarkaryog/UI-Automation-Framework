package com.qdpm.operations.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qdpm.operations.base.DriverFactory;
import com.qdpm.operations.base.ExtentFactory;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners implements ITestListener {

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        // 2. Before each test case start report
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // 3. then log the message on success or failure
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is PASSED");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public String screenShot() {
        return ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {

        File file = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String actualDate = simpleDateFormat.format(date);
        String screenShotPath = System.getProperty("user.dir") + "/Reports/screenshot/image " + actualDate + ".jpeg";
        File screenShotDestination = new File(screenShotPath);
        FileUtils.copyFile(file, screenShotDestination);

        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is FAILED");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
        ExtentFactory.getInstance().getExtent().log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
        // ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenShotPath, "Test case failure screenshot");
        ExtentFactory.getInstance().removeExtentObject();

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + " is SKIPPED");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @SneakyThrows
    @Override
    public void onStart(ITestContext context) {
        // 1. Setup extent report
        extentReports = ExtentReportGenerator.generateReport();

    }

    @Override
    public void onFinish(ITestContext context) {
        // Close extent report and save
        extentReports.flush();

    }
}
