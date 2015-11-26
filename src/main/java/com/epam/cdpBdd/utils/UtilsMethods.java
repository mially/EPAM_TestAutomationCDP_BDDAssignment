package com.epam.cdpBdd.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsMethods {

    private static WebDriverWait wait;

    public UtilsMethods(WebDriver driver){
        this.wait = new WebDriverWait(driver, 10);
    }
    public static WebDriverWait getWait(){
        return wait;
    }

    public static void clear(WebElement element){
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }
}
