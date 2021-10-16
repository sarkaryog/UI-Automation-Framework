package com.tricentis.operations.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tricentis.operations.pageobjects.EnterVehicleDataPage;
import com.tricentis.operations.pageobjects.HomePage;
import com.tricentis.operations.util.CommonMethods;
import org.openqa.selenium.WebDriver;

public class ObjectsRepo {

    public static WebDriver driver;
    public static HomePage homePage;
    public static EnterVehicleDataPage enterVehicleDataPage;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static CommonMethods commonMethods;



}
