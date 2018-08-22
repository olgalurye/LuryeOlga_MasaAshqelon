package com.telRan.automation.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super (wd);
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void login(String user, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
       wd.findElement(By.name("pass")).sendKeys(password);


       wd.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public String getUrl() {
        String url = wd.getCurrentUrl();
        return url;


    }


}
