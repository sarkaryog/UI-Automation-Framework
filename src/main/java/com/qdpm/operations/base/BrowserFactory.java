package com.qdpm.operations.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    //create webdriver object for given browser
    public WebDriver createBrowserInstance(String browser) throws Exception {

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            //System.setProperty("webdriver.chrome.silentOutput", "true");

        }else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().arch64().setup();
            FirefoxOptions foptions = new FirefoxOptions();
            foptions.addArguments("-private");
            driver = new FirefoxDriver(foptions);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            System.out.println("Please provide a valid browser");
        }
        return driver;
    }

}
