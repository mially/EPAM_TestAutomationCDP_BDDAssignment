package com.epam.cdpBdd.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver {

    protected WebDriver driver;

    //Decorator to extent WebDriver functionality
    public WebDriverDecorator(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    //decorating findElements
    @Override
    public List<WebElement> findElements(By by) {
    //    System.out.println("Finding elements by: " + by.toString()); - turning off for bdd task
        return driver.findElements(by);
    }

    //decorating findElement
    @Override
    public WebElement findElement(By by) {
    //    System.out.println("Finding element by: " + by.toString()); - turning off for bdd task
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
