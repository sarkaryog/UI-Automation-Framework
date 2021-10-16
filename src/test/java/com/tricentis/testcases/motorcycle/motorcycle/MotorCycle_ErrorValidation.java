package com.tricentis.testcases.motorcycle.motorcycle;

import com.tricentis.operations.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MotorCycle_ErrorValidation extends BaseClass {

    @Test
    public void errorMessage_EnterVehicleDataPage() {

        homePage.clickOnMotorCycleLink();
        String actualErrMsg = enterVehicleDataPage.getErrMsgOnCylinderCapacity("3333");
        String expectedErrMsg = "dummy";
        Assert.assertEquals(actualErrMsg, expectedErrMsg, "Error message is not as expected on Cylinder Capacity field");

    }
}
