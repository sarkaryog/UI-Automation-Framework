package com.tricentis.operations.base;

import com.tricentis.operations.pageobjects.EnterVehicleDataPage;
import com.tricentis.operations.pageobjects.HomePage;
import com.tricentis.operations.util.ApplicationConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseClass extends ObjectsRepo{



    public void setUp() throws Exception {

        // Read browser,timeout and url from properties file
        String browserName = ApplicationConfiguration.get("browser");
        String url = ApplicationConfiguration.get("url");
        long pageLoadTimeOut = Long.parseLong(ApplicationConfiguration.get("page.load.timeout"));
        long implicitWait = Long.parseLong(ApplicationConfiguration.get("implicit.wait"));

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("ff")) {
            WebDriverManager.firefoxdriver().arch64().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            System.out.println("Please provide a valid browser");
        }

        driver.manage().window().maximize(); // Maximize the window
        driver.manage().deleteAllCookies(); // Delete all cookies
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.get(url);

    }

    @BeforeClass
    public void launchBrowserAndNavigateToUrl() throws Exception {
        setUp();
        homePage = new HomePage();
        enterVehicleDataPage = new EnterVehicleDataPage();

    }



    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();

    }
}
