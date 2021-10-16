package com.tricentis.operations.pageobjects;

import com.tricentis.operations.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EnterInsurantDataPage extends BaseClass {

    @FindBy(css="#firstname")
    WebElement txt_FirstName;

    @FindBy(css="#lastname")
    WebElement txt_LastName;

    @FindBy(css="label>input[name='Gender']")
    List<WebElement> rdoBtn_Gender;

    @FindBy(css="label>input[name='Hobbies']")
    List<WebElement> chkBx_Hobbies;

    @FindBy(css="#streetaddress")
    WebElement txt_StreetAddress;

    @FindBy(css="##country")
    WebElement dd_Country;

    @FindBy(css="#zipcode")
    WebElement txt_ZipCode;

    @FindBy(css="#occupation")
    WebElement txt_Occupation;

    public EnterInsurantDataPage() {
        PageFactory.initElements(driver,this);

    }


}
