package com.qdpm.operations.base;

import org.openqa.selenium.WebDriver;

// To Make webdriver instance thread safe we implement this class
public class DriverFactory {

    // Design Patterns -- >
    // 1.Singleton design Pattern (Only one instance exist and provide global access to that instance by using getInstance method )
    // private constructor so that no one else can create object of this class
    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    // it will provide instance of current class
    public static DriverFactory getInstance() {
        return instance;
    }


    // 2.factory design pattern (define separate factory methods for creating objects and create objects by calling that methods)
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driverParm) {
        driver.set(driverParm);
    }

    public void closeBrowser() {
        driver.get().quit(); // Close current browser driver
        driver.remove(); // It will remove driver copy
    }
}
