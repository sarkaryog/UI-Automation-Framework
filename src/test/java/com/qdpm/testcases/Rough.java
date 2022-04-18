package com.qdpm.testcases;

import com.qdpm.operations.base.TestBase;
import com.qdpm.operations.pageobjects.HomePage;
import com.qdpm.operations.pageobjects.LoginPage;
import com.qdpm.operations.pageobjects.TaskPage;
import com.qdpm.operations.utility.DataBaseDriver;
import com.qdpm.operations.utility.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Rough extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    TaskPage taskPage = new TaskPage();
    DataBaseDriver dataBaseDriver = new DataBaseDriver();
    ExcelReader excel = new ExcelReader("TaskCreationData");

    @Test(dataProvider = "taskCreationData")
    public void TaskCreationTest(Object obj1) throws Throwable {
        @SuppressWarnings("unchecked")
        HashMap<String, String> testData = (HashMap<String, String>) obj1;

        loginPage.login(testData.get("UserName"), testData.get("Password"));

        //check if dashboard page opens
        homePage.checkIfDashBoardPageIsOpened();
        homePage.clickOnSideSubMenu("Tasks", "Add Task");
        //add task
        taskPage.createTask(testData);
        //verify task on UI
        taskPage.verifyTaskCreation(testData);
        homePage.logout();

        //verify DB
        String sql = "SELECT * FROM `tasks` where name = '"+testData.get("TaskName")+"'";
        HashMap<String, String> dbData = dataBaseDriver.getSqlResultInMap(sql);
        String TaskName = dbData.get("name");
        assertEqualsString("taskFailureName", TaskName, "DB_Task_Name");

    }

    //Dataprovider method --> return object array
    @DataProvider(name = "taskCreationData")
    public Object[][] testDataSupplier() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount(); i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;

    }
}
