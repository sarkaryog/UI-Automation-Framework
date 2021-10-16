package com.qdpm.testcases;

import com.qdpm.operations.base.TestBase;
import com.qdpm.operations.pageobjects.HomePage;
import com.qdpm.operations.pageobjects.LoginPage;
import com.qdpm.operations.pageobjects.TaskPage;
import org.testng.annotations.Test;

public class Rough extends TestBase {

    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();
    TaskPage tp = new TaskPage();

    @Test
    public void demoTestCase(){

        lp.login("admin@admin.com","admin@123");
        hp.checkIfDashBoardPageIsOpened();
        hp.clickOnSideSubMenu("Tasks","Add Task");
        //tp.createTask();
       // tp.verifyTaskCreation();

    }
}
