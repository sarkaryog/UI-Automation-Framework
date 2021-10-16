package com.qdpm.operations.pageobjects;

import com.qdpm.operations.base.DriverFactory;
import com.qdpm.operations.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends TestBase {

    By sideBarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");

    /**
     * click on menu bar - by passing name of menu
     * @param menu
     */
    public void clickOnSideMenu(String menu) {
        String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
    }

    /**
     * click on sub menu bar - by passing name of menu
     * @param menu
     * @param submenu
     */
    public void clickOnSideSubMenu(String menu, String submenu) {
        String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
        String submenuXpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/ancestor::a/following-sibling::ul//span[text()='"+submenu+"']";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(submenuXpath)).click();
    }

    public void checkIfDashBoardPageIsOpened() {
        Assert.assertTrue(isElementPresent(DriverFactory.getInstance().getDriver().findElement(sideBarMenu_Dashboard), "DashBoard Menu"));
    }


}
