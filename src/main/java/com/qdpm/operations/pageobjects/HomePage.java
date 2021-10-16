package com.qdpm.operations.pageobjects;

import com.qdpm.operations.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    WebDriver driver=null;

    /**
     * click on menu bar - by passing name of menu
     * @param menu
     */
    public void clickOnSideMenu(String menu) {
        String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        driver.findElement(By.xpath(menuXpath)).click();
    }

    /**
     * click on sub menu bar - by passing name of menu
     * @param menu
     * @param submenu
     */
    public void clickOnSideSubMenu(String menu, String submenu) {
        String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        driver.findElement(By.xpath(menuXpath)).click();
        String submenuXpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/ancestor::a/following-sibling::ul//span[text()='"+submenu+"']";
        driver.findElement(By.xpath(submenuXpath)).click();
    }

    // Constructor to use init elements methods on current class
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }




}
