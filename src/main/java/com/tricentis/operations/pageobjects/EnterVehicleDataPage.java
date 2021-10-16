package com.tricentis.operations.pageobjects;


import com.tricentis.operations.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterVehicleDataPage extends BaseClass {

    @FindBy(css = "#make")
    WebElement dd_Make;

    @FindBy(css = "#model")
    WebElement dd_Model;

    @FindBy(css = "#cylindercapacity")
    WebElement txt_CylinderCapacity;

    @FindBy(css = "#engineperformance")
    WebElement txt_EnginePerformance;

    @FindBy(css = "#listprice")
    WebElement txt_ListPrice;

    @FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
    WebElement errMsg_CylinderCapacity;

    @FindBy(css="#nextenterinsurantdata")
    WebElement btn_Next;

    @FindBy(css="#dateofmanufacture")
    WebElement datePicker_DateOfManufacture;

    @FindBy(css="#numberofseats")
    WebElement dd_NumberOfSeats;

    public EnterVehicleDataPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillDataOnEnterVehicleDataPage() {
        homePage.clickOnMotorCycleLink();
        commonMethods.selectDropDownOptions(dd_Make,"Audi");
        commonMethods.selectDropDownOptions(dd_Model,"Moped");
        txt_CylinderCapacity.sendKeys("1500");
        txt_EnginePerformance.sendKeys("10");
        txt_ListPrice.sendKeys("1000000");
        datePicker_DateOfManufacture.sendKeys("12/12/1996");
        commonMethods.selectDropDownOptions(dd_NumberOfSeats,"1");

    }

    public String getErrMsgOnCylinderCapacity(String cylinderCapacity){
        txt_CylinderCapacity.sendKeys(cylinderCapacity);
        return errMsg_CylinderCapacity.getText();
    }

    public void clickOnNext(){
        btn_Next.click();
    }
}
