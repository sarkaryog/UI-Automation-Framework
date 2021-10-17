package com.qdpm.operations.pageobjects;

import com.qdpm.operations.base.DriverFactory;
import com.qdpm.operations.base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {

    By EMAIL = By.cssSelector("input[placeholder='Email']");
    By PASSWORD = By.cssSelector("input[placeholder='Password']");
    By LOGIN_BTN = By.cssSelector("button[type='submit']");

    public void login(String email, String password) {
        type(DriverFactory.getInstance().getDriver().findElement(EMAIL), "Email Field", email);
        type(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "Password Field", password);
        click(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN), "Login Button");

    }
}
