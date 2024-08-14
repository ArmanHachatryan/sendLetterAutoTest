package org.tkbank.exercise.pages;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver _driver) {
        driver = _driver;
    }
}
