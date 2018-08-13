package com.telran.automation.tests.manager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ContactHelper contactHelper;
    GroupHelper groupHelper;
    SessionHelper sessionHelper;
        ChromeDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
                        //wd.get("http://localhost/addressbook/") -  аналог navigate to
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }





    public void stop() throws InterruptedException {
        Thread.sleep(6000);
        ApplicationManager.this.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }


    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}

