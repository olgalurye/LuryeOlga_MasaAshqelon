package com.telran.automation.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd=wd;
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean areElementsPresent(By locator){    // работает также, как и isElementPresent
        return wd.findElements(locator).size()>0;
    }

    public void confirmAlert() throws InterruptedException {
        wd.switchTo().alert().accept();
        Thread.sleep(2000);
    }
}
