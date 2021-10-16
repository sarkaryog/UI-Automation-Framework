package com.tricentis.operations.pageobjects;


import com.tricentis.operations.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EnterProductDataPage extends BaseClass {

    @FindBy(css="#startdate")
    WebElement txtStartDate;

    @FindBy(css="input[name='Optional Products[]']")
    List<WebElement> rdoBtn_OptionalProducts;

    @FindBy(css="#insurancesum")
    WebElement dd_InsuranceSum;

    @FindBy (css="#meritrating")
    WebElement dd_MeritRating;

    @FindBy (css="#damageinsurance")
    WebElement dd_DamageInsurance;

    @FindBy(css="#courtesycar")
    WebElement dd_CourtesyCar;

    public EnterProductDataPage() {
        PageFactory.initElements(driver,this);

    }
}
