/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
package com.qdpm.operations.base;

import com.qdpm.operations.utility.ActionDriver;
import com.qdpm.operations.utility.ApplicationConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase extends ActionDriver {

    BrowserFactory bf = new BrowserFactory();

    @BeforeClass
    public void launchBrowserAndNavigateToUrl() throws Exception {
        String browserName = ApplicationConfiguration.get("browser");
        String url = ApplicationConfiguration.get("url");
        long pageLoadTimeOut = Long.parseLong(ApplicationConfiguration.get("page.load.timeout"));
        long implicitWait = Long.parseLong(ApplicationConfiguration.get("implicit.wait"));

        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browserName));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));
        DriverFactory.getInstance().getDriver().navigate().to(url);

    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }
}
