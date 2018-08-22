package com.telRan.automation.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends HelperBase {
    public HeaderPage(WebDriver wd) {
        super(wd);
    }

    public boolean isLogoPresent(){
        return isElementPresent(By.cssSelector("img.logo-img"));
    }

}
