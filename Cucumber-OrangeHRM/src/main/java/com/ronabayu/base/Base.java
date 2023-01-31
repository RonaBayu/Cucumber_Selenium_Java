package com.ronabayu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {
    public static WebDriver driver;
    public Base (WebDriver driver) {
        Base.driver = driver;
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void input(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

}