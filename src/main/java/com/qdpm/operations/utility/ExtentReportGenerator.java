package com.qdpm.operations.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qdpm.operations.pageobjects.objectrepo.ObjectsRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportGenerator extends ObjectsRepo {

    public static ExtentReports generateReport() throws Exception {
        String projectName = ApplicationConfiguration.get("projectName");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String actualDate = simpleDateFormat.format(date);
        String reportPath = System.getProperty("user.dir") + "\\Reports\\AutomationTestReport" + actualDate + ".html";

        //creating a html report file
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Automation Execution Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName(projectName + " Automation Test Case Execution report ");

        extent.setSystemInfo("Author", "Yogesh Sondhiya");
        return extent;

    }
}
