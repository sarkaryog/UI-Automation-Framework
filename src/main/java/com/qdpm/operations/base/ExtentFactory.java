package com.qdpm.operations.base;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    // Design Patterns -- >
    // 1.Singleton design Pattern (Only one instance exist and provide global access to that instance by using getInstance method )
    // private constructor so that no one else can create object of this class
    private ExtentFactory() {

    }

    private static ExtentFactory instance = new ExtentFactory();

    // it will provide instance of current class
    public static ExtentFactory getInstance() {
        return instance;
    }

    // 2.factory design pattern (define separate factory methods for creating objects and create objects by calling that methods)
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public void removeExtentObject(){
        extent.remove();
    }

}
