package com.qdpm.operations.pageobjects;

import com.qdpm.operations.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy (css="input[placeholder='Email']")
    WebElement txt_UserName;

    @FindBy (css="input[placeholder='Password']")
    WebElement txt_PassWord;

    @FindBy (css="button[type='submit']")
    WebElement btn_Login;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is useful for login to the application
     * @param email
     * @param pw
     */
    public void login(String email, String pw){

        txt_PassWord.sendKeys(email);
        txt_PassWord.sendKeys(pw);
        btn_Login.click();

    }
}
