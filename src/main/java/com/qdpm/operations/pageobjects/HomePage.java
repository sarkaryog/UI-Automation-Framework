package com.qdpm.operations.pageobjects;

import com.qdpm.operations.base.DriverFactory;
import com.qdpm.operations.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends TestBase {

    By sideBarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");
    By link_ProfileUserName = By.cssSelector(".username");
    By link_logout = By.cssSelector("a[href='/index.php/login/logoff']");

    /**
     * click on menu bar - by passing name of menu
     * @param menu
     */
    public void clickOnSideMenu(String menu) {
        String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
    }

    public void logout(){
        click(DriverFactory.getInstance().getDriver().findElement(link_ProfileUserName), "Username Link");
        click(DriverFactory.getInstance().getDriver().findElement(link_logout), "Logout link");
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
