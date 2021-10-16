package com.tricentis.operations.pageobjects;

import com.tricentis.operations.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(css=".main-navigation #nav_automobile")
    WebElement lnk_AutoMobile;

    @FindBy(css=".main-navigation #nav_truck")
    WebElement lnk_Truck;

    @FindBy(css=".main-navigation #nav_motorcycle")
    WebElement lnk_motorCycle;

    @FindBy(css=".main-navigation #nav_camper")
    WebElement lnk_camper;

    @FindBy(css="#entervehicledata")
    WebElement lnk_EnterVehicleData;

    @FindBy(css="#enterinsurantdata")
    WebElement lnk_EnterInsurantData;

    @FindBy(css="#enterproductdata")
    WebElement lnk_EnterProductData;

    // Constructor to use init elements methods on current class
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnMotorCycleLink(){
        lnk_motorCycle.click();
    }


}
