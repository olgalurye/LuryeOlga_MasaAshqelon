package com.telRan.automation.tests.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper ;
    WebDriver wd;
    private String browser;
    private static String URL="https://s-labs.ru/";
    HeaderPage headerPage;


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

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite(URL);
        //wd.get("http://localhost/addressbook/") -  аналог navigate to
         headerPage = new HeaderPage(wd);

    }


    public void stop() throws InterruptedException {
        Thread.sleep(6000);
        ApplicationManager.this.wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public HeaderPage getHeaderPage(){
        return headerPage;
    }
}

