package com.telran.automation.tests.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ContactHelper contactHelper;
    GroupHelper groupHelper;
    SessionHelper sessionHelper;
    WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

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

