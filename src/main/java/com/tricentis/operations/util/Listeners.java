package com.tricentis.operations.util;

import com.aventstack.extentreports.Status;
import com.tricentis.operations.base.ObjectsRepo;
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

public class Listeners extends ObjectsRepo implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        // Before each test case start report
        extentTest=extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Case: " +result.getMethod().getMethodName()+ " is PASSED");

    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String actualDate = simpleDateFormat.format(date);
        String screenShotPath = System.getProperty("user.dir") + "/Reports/screenshot/image " + actualDate + ".png";
        File screenShotDestination = new File(screenShotPath);
        FileUtils.copyFile(src,screenShotDestination);

        extentTest.log(Status.FAIL, "Test Case: " +result.getMethod().getMethodName()+ " is FAILED");
        extentTest.log(Status.FAIL, result.getThrowable());
        extentTest.addScreenCaptureFromPath(screenShotPath,"Test case failure screenshot");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @SneakyThrows
    @Override
    public void onStart(ITestContext context) {
        // Setup extent report
        extent =ExtentReportGenerator.generateReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Close extent report and save
        extent.flush();

    }
}
