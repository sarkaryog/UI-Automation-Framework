package com.qdpm.operations.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    public UsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
