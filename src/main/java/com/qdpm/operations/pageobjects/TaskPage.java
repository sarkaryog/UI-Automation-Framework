package com.qdpm.operations.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

    public TaskPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
