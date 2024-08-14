package org.tkbank.exercise.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instance;
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getInstance(Browser browser) {
        if (instance == null) {
            instance = new Driver();
        }
        return instance.createDriver(browser);
    }

    private WebDriver createDriver(Browser browser) {
        if (driver == null) {
            switch (browser) {
                case Chrome:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--user-data-dir=C:/Users/winne/AppData/Local/Google/Chrome/User Data");
                    options.addArguments("Profile 1");
                    driver = new ChromeDriver(options);
                    break;
                case Firefox:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case Edge:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    Assertions.fail("Incorrect browser name: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Config.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }
}
